import { MDBBtn } from "mdb-react-ui-kit";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast,ToastContainer } from "react-toastify";
import { getAllOrdersDetailsApi, updateStatus } from "../Services/OrderService";
import AdminHeader from "./AdminHeader";

function AdminOrderDetails() {
  const [processingOrders, setProcessingOrders] = useState([]);
  const [completedOrders, setCompletedOrders] = useState([]);
  const [cancelledOrders, setCancelledOrders] = useState([]);
  const [confirmedOrders, setConfirmedOrders] = useState([]);
  const [coockingOrders, setCoockingOrders] = useState([]);
  const [out_deliveryOrders, setOutDeliveryOrders] = useState([]);
  const [status,setStatus]=useState();

  const navigate = useNavigate();

  const formatdate = (d) => {
    const newdate = new Date(d);
    return newdate.toLocaleString();
  };

  const getallorders = async () => {
    try {
      const responsedata = await getAllOrdersDetailsApi();
      console.log(responsedata);
      if (responsedata.status === 200) {
        const allOrders = responsedata.data;
        const processing = allOrders.filter((order) => order.orderstatus === 'PROCESSING');
        const completed = allOrders.filter((order) => order.orderstatus === 'COMPLETED');
        const cancelled = allOrders.filter((order) => order.orderstatus === 'CANCELLED');
        const confirmed = allOrders.filter((order) => order.orderstatus === 'CONFIRMED');
        const coocking = allOrders.filter((order) => order.orderstatus === 'COOCKING');
        const out_for_delivery = allOrders.filter((order) => order.orderstatus === 'OUT_FOR_DELIVERY');

        setProcessingOrders(processing);
        setCompletedOrders(completed);
        setCancelledOrders(cancelled);
        setConfirmedOrders(confirmed);
        setCoockingOrders(coocking);
        setOutDeliveryOrders(out_for_delivery);
      } else {
        toast.error("Something went wrong");
      }
    } catch (error) {
      console.error("Error fetching orders:", error);
      toast.error("Error fetching orders");
    }
  };

  const vieworder = (orderId) => {
    navigate(`/vieworderdetails/${orderId}`);
  };

  const savechanges=async (orderId)=>{
        await updateStatus(orderId,status);
       getallorders();
  
  }

  useEffect(() => {
    getallorders();
  }, []);

  const renderOrder = (orders) => (
    <table className="table table-bordered">
    <thead>
      <tr>
        <th>Customer Id</th>
        <th>Date</th>
        <th>Address</th>
        <th>Total Quantity</th>
        <th>Total Price</th>
        <th>Payment Method</th>
        <th>Change Status</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      {orders.map((order) => (
        <tr key={order.orderId} style={{ border: '1px solid #ddd' }}>
          <td>{order.userId}</td>
          <td>{formatdate(order.date)}</td>
          <td>
            {order.addressDto.addressLine}, {order.addressDto.landmark},{" "}
            {order.addressDto.city}, {order.addressDto.pincode}
          </td>
          <td>{order.totalqty}</td>
          <td>{order.totalprice}</td>
          <td>{order.paymentType}</td>
          <td>
            <select
                  onChange={(e) => {
                setStatus(e.target.value);
              }}
            >
              <option  selected>Select Status</option>
              <option value={"CONFIRMED"}>CONFIRMED</option>
              <option value={"CANCELLED"}>CANCELLED</option>
            </select>
          </td>
          <td>
            <MDBBtn size="sm" onClick={() => vieworder(order.orderId)}>
              View Order
            </MDBBtn>{" "}
            
            <MDBBtn size="sm" onClick={() => savechanges(order.orderId)}>
              Save Changes
            </MDBBtn>
          </td>
        </tr>
      ))}
    </tbody>
  </table>
  
  );

  const renderOrder1 = (orders) => (
    <table className="table table-bordered">
    <thead>
      <tr>
        <th>Customer Id</th>
        <th>Date</th>
        <th>Address</th>
        <th>Total Quantity</th>
        <th>Total Price</th>
        <th>Payment Method</th>
        <th>Change Status</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      {orders.map((order) => (
        <tr key={order.orderId} style={{ border: '1px solid #ddd' }}>
          <td>{order.userId}</td>
          <td>{formatdate(order.date)}</td>
          <td>
            {order.addressDto.addressLine}, {order.addressDto.landmark},{" "}
            {order.addressDto.city}, {order.addressDto.pincode}
          </td>
          <td>{order.totalqty}</td>
          <td>{order.totalprice}</td>
          <td>{order.paymentType}</td>
          <td>
            <select
                  onChange={(e) => {
                setStatus(e.target.value);
              }}
            >
              <option  selected>Select Status</option>
              <option value={"COOCKING"}>COOCKING</option>
            </select>
          </td>
          <td>
            <MDBBtn size="sm" onClick={() => vieworder(order.orderId)}>
              View Order
            </MDBBtn>{" "}
            <MDBBtn size="sm" onClick={() => savechanges(order.orderId)}>
              Save Changes
            </MDBBtn>
          </td>
        </tr>
      ))}
    </tbody>
  </table>
  
  );

  const renderOrder2 = (orders) => (
    <table className="table table-bordered">
    <thead>
      <tr>
        <th>Customer Id</th>
        <th>Date</th>
        <th>Address</th>
        <th>Total Quantity</th>
        <th>Total Price</th>
        <th>Payment Method</th>
        <th>Change Status</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      {orders.map((order) => (
        <tr key={order.orderId} style={{ border: '1px solid #ddd' }}>
          <td>{order.userId}</td>
          <td>{formatdate(order.date)}</td>
          <td>
            {order.addressDto.addressLine}, {order.addressDto.landmark},{" "}
            {order.addressDto.city}, {order.addressDto.pincode}
          </td>
          <td>{order.totalqty}</td>
          <td>{order.totalprice}</td>
          <td>{order.paymentType}</td>
          <td>
            <select
                  onChange={(e) => {
                setStatus(e.target.value);
              }}
            >
             <option  selected>Select Status</option>
              <option value={"OUT_FOR_DELIVERY"}>OUT FOR DELIVERY</option>
            </select>
          </td>
          <td>
            <MDBBtn size="sm" onClick={() => vieworder(order.orderId)}>
              View Order
            </MDBBtn>{" "}
            {/* Space between buttons */}
            <MDBBtn size="sm" onClick={() => savechanges(order.orderId)}>
              Save Changes
            </MDBBtn>
          </td>
        </tr>
      ))}
    </tbody>
  </table>
  
  );
  const renderOrder4 = (orders) => (
    <table className="table table-bordered">
    <thead>
      <tr>
        <th>Customer Id</th>
        <th>Date</th>
        <th>Address</th>
        <th>Total Quantity</th>
        <th>Total Price</th>
        <th>Payment Method</th>
        <th>Change Status</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      {orders.map((order) => (
        <tr key={order.orderId} style={{ border: '1px solid #ddd' }}>
          <td>{order.userId}</td>
          <td>{formatdate(order.date)}</td>
          <td>
            {order.addressDto.addressLine}, {order.addressDto.landmark},{" "}
            {order.addressDto.city}, {order.addressDto.pincode}
          </td>
          <td>{order.totalqty}</td>
          <td>{order.totalprice}</td>
          <td>{order.paymentType}</td>
          <td>
            <select
                  onChange={(e) => {
                setStatus(e.target.value);
              }}
            >
              <option  selected>Select Status</option>
              <option value={"COMPLETED"}>COMPLETED</option>
              <option value={"CANCELLED"}>CANCELLED</option>
            </select>
          </td>
          <td>
            <MDBBtn size="sm" onClick={() => vieworder(order.orderId)}>
              View Order
            </MDBBtn>{" "}
            {/* Space between buttons */}
            <MDBBtn size="sm" onClick={() => savechanges(order.orderId)}>
              Save Changes
            </MDBBtn>
          </td>
        </tr>
      ))}
    </tbody>
  </table>
  
  );
  const renderOrderTable = (orders) => (
    <table className="table table-bordered">
      <thead>
        <tr>
          <th>Customer Id</th>
          <th>Date</th>
          <th>Address</th>
          <th>Total Quantity</th>
          <th>Total Price</th>
          <th>Payment Method</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {orders.map((order) => (
          <tr key={order.orderId} style={{ border: '1px solid #ddd' }}>
            <td>{order.userId}</td>
            <td>{formatdate(order.date)}</td>
            <td>
              {order.addressDto.addressLine}, {order.addressDto.landmark},{" "}
              {order.addressDto.city}, {order.addressDto.pincode}
            </td>
            <td>{order.totalqty}</td>
            <td>{order.totalprice}</td>
            <td>{order.paymentType}</td>
              <td>{order.orderstatus}</td>
         <td>
              <MDBBtn size="sm" onClick={() => vieworder(order.orderId)}>
                View Order
              </MDBBtn>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );

  return (
    <><AdminHeader/>
    <center>
      <div className="container">
      <br/>
        <h2>Order Records</h2>
        <br/>
        <br/>
       
        <div className="table-responsive">
          <div>
          <table className="table table-bordered">
      <thead>
        <tr>
            <h5>Processing Orders</h5>
            </tr>
            </thead>
            {renderOrder(processingOrders)}
            </table>
          </div>
          <div>
          <table className="table table-bordered">
      <thead>
        <tr>
            <h5>Confirmed Orders</h5>
            </tr>
            </thead>
            {renderOrder1(confirmedOrders)}
            </table>
          </div>
          <div>
          <table className="table table-bordered">
      <thead>
        <tr>
            <h5>Cooking</h5>
            </tr>
            </thead>
            {renderOrder2(coockingOrders)}
            </table>
          </div>
         
          <div>
          <table className="table table-bordered">
      <thead>
        <tr>
            <h5>Out for delivery</h5>
            </tr>
            </thead>
            {renderOrder4(out_deliveryOrders)}
            </table>
          </div>
          
          <div>
          <table className="table table-bordered">
      <thead>
        <tr>
            <h5>Completed Orders</h5>
            </tr>
            </thead>
            {renderOrderTable(completedOrders)}
            </table>
            <table className="table table-bordered">
      <thead>
        <tr>
            <h5>Cancelled Orders</h5>
            </tr>
            </thead>
            {renderOrderTable(cancelledOrders)}
            </table>
            
            
          </div>
        </div>
      </div>
      <ToastContainer/>
    </center>
    </>
  );
}

export default AdminOrderDetails;
