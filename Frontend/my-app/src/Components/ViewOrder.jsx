import { MDBBtn } from "mdb-react-ui-kit";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { toast,ToastContainer } from "react-toastify";
import { loadUserDataApi } from "../Services/EditUserApi";
import { placeOrderApi, vieworderApi } from "../Services/OrderService";


function ViewOrder() {
  const [itemdetails, setItemdetails] = useState([]);
  const { orderId } = useParams();
  
  const navigate=useNavigate();
  useEffect(() => {
    fetchAllorderDetails();
  }, []);

  const fetchAllorderDetails = async() => {
    
    
      const responseData=await vieworderApi(orderId);
      if(responseData.status==200)
      {
        setItemdetails(responseData.data);
      }
      else{
        toast.error("Something went wrong");
      }

  };



  const onClickback= async () => {

    
    const responseData=await loadUserDataApi();
    if(responseData.data.role==='ADMIN')
      navigate('/bills');
    else
      navigate('/orders');
     
  }
  const calculateTotalAmount = () => {
    return itemdetails.reduce((total, item) => total + item.price * item.quantity, 0);
  };

  const calculateTotalQuantity = () => {
    return itemdetails.reduce((total, item) => total + item.quantity, 0);
  };

  return (<>
    <center>
      <div className="container">
        <br />
        <br />
        <h2> Order Details</h2>
        <br />
        <br/>

        {/* Display user profile */}
       

        {/* Display selected address here */}
      
        {/* Display cart items here */}
        <div className="table-responsive">
          <table className="table table-bordered">
            <thead>
              <tr>
                <th>Items</th>
                <th>Quantity</th>
                <th>Amount</th>
              </tr>
            </thead>
            <tbody>
              {itemdetails.map((item, index) => (
                <tr key={index}>
                  <td>{item.itemName}</td>
                  <td>{item.quantity}</td>
                  <td>{item.price * item.quantity}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>

        {/* Display total quantity and total amount */}
        <div className="table-responsive">
          <table className="table table-bordered">
            <tbody>
              <tr>
                <td className="align-middle"><strong>Total Quantity:</strong></td>
                <td className="align-middle">{calculateTotalQuantity()}</td>
                <td className="align-middle"><strong>Total Amount:</strong></td>
                <td className="align-middle">{calculateTotalAmount()}</td>
              </tr>
            </tbody>
          </table>
        </div>
       
        {/* Place order button */}
        <MDBBtn link='primary' style={{ margin: '10px' }} onClick={onClickback}>
          Back
        </MDBBtn>
      
      </div>
    </center>
      <ToastContainer position="top-center"/>
      </>
  );
}

export default ViewOrder;
