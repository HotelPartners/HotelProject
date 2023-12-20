import { MDBBtn } from "mdb-react-ui-kit";
import { useEffect } from "react";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { deleteOrderRecordApi, getOrdersByIdApi } from "../Services/OrderService";
import Header from "./Header";

function UserORecords() {

    const [orders, setorders] = useState([]);
    const navigate=useNavigate();

const formatdate=(d)=>{
    const newdate =new Date(d);
    return newdate.toLocaleString();
}
    const getorders = async () => {
        
        const responsedata = await getOrdersByIdApi();
        if (responsedata!==null) {
            setorders(responsedata.data);
        }
        else {
            toast.error("Something went wrong");
        }
    }

    const deleteorderrecord=async(orderId)=>{
        const responseData=await deleteOrderRecordApi(orderId);
        if(responseData.status==200)
        {
            toast.success("Order record deleted successfully");
            setorders(prevOrders => prevOrders.filter(order => order.orderId !== orderId));
        }
        else
        {
            toast.error("Something went wrong");
        }

    }


    const vieworder = async (orderId) => {
        navigate(`/vieworderdetails/${orderId}`);
      };
   

    


    useEffect(()=>{getorders()}, []);
    return (<>
    <Header />
        <center>
            <div className="container">
                <h2>Order Records</h2>
                <div className="table-responsive">
                    <table className="table table-bordered">
                        <thead>
                            <tr>
                                <th>Order Id</th>
                                <th>Date</th>
                                <th>Address</th>
                                <th>Total Quntity</th>
                                <th>Total Price</th>
                                <th>Payment Method</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                        {orders.map((order, index) => (
    <tr key={index}>
        <td>{index + 1}</td>
        <td>{formatdate(order.date)}</td>
        <td>{order.addressDto.addressLine}, {order.addressDto.landmark}, {order.addressDto.city}, {order.addressDto.pincode}</td>
        <td>{order.totalqty}</td>
        <td>{order.totalprice}</td>
        <td>{order.paymentType}</td>
        <td>{order.orderstatus}</td>
        <td>
            <MDBBtn size="sm" onClick={() => { vieworder(order.orderId) }}>View Order</MDBBtn>
            {order.orderstatus !== 'PROCESSING' ? (
                <MDBBtn disabled size="sm" color="danger">Cancel Order</MDBBtn>) : 
                (<MDBBtn size="sm" color="danger" onClick={()=>{deleteorderrecord(order.orderId)}}>Cancel Order</MDBBtn>
            )}
        </td>
    </tr>
))}

                            

                        </tbody>
                    </table>
                </div>
            </div>
        </center>
    </>);
}

export default UserORecords;