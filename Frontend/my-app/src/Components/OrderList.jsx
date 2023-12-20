import { MDBBtn } from "mdb-react-ui-kit";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast,ToastContainer } from "react-toastify";
import { loadUserDataApi } from "../Services/EditUserApi";
import { placeOrderApi } from "../Services/OrderService";

function OrderList() {
  const [itemdetails, setItemdetails] = useState([]);
  const [addressdetails, setAddressDetails] = useState({});
  const [paymentType,setPaymentType]=useState(0);
  const [firstName,setFirstName]=useState('');
  const [lastName,setLastName]=useState('');
  const [email,setEmail]=useState('');
  const [mobile,setMobile]=useState('');
  const [userId,setUserId]=useState('');
  const navigate=useNavigate();
  useEffect(() => {
    fetchAllorderDetails();
  }, []);
  useEffect(() => {
    loaduserData();
  }, []);

  const fetchAllorderDetails = () => {
    if (addressdetails == null)
      return;
    const address = JSON.parse(sessionStorage.getItem('selectedAddress'));
    const items = JSON.parse(localStorage.getItem('cart'));
    setAddressDetails(address);
    setItemdetails(items);
  };

  const calculateTotalAmount = () => {
    return itemdetails.reduce((total, item) => total + item.price * item.quantity, 0);
  };

  const calculateTotalQuantity = () => {
    return itemdetails.reduce((total, item) => total + item.quantity, 0);
  };

  const loaduserData=async()=>{
  const response=await loadUserDataApi();
  if(response.status == 200)
  {
    setFirstName(response.data.firstName);
    setLastName(response.data.lastName);
    setEmail(response.data.userEmail);
    setMobile(response.data.mobileNumber);
    setUserId(response.data.userId);
  }
};


  const onClickPlaceOrder= async () => {
    if(paymentType==0)
    toast.error("Please Select Payment Method")
    else
    {
      // toast.success("Order placed successfully");

      const totalquantity=calculateTotalQuantity();
      const totalamount=calculateTotalAmount();
      const responseData=await placeOrderApi(userId,addressdetails.addressId,paymentType,totalamount,totalquantity,itemdetails);
    console.log(itemdetails, addressdetails.addressId,paymentType,calculateTotalAmount());
     if(responseData==200)
     {
      localStorage.clear();
      navigate('/orders');
     }
     else{
      navigate('/');
     }
    }
  }

  return (<>
    <center>
      <div className="container">
        <br />
        <h2>Confirm Order Details</h2>
        <br />

        {/* Display user profile */}
        <div className="table-responsive">
          <table className="table table-bordered">
            <thead>
              <tr>
                <th colSpan="2">User Details</th>

              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Full Name</td>
                <td>{firstName} {lastName}</td>
              </tr>
              <tr>
                <td>Email</td>
                <td>{email}</td>
              </tr>
              <tr>
                <td>Mobile Number</td>
                <td>{mobile}</td>
              </tr>
            </tbody>
          </table>
        </div>

        {/* Display selected address here */}
        <div className="table-responsive">
          <table className="table table-bordered">
            <thead>
              <tr>
                <th>Address</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{addressdetails.addressLine}, {addressdetails.landmark}, {addressdetails.city}, {addressdetails.pincode}</td>
              </tr>
            </tbody>
          </table>
        </div>

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
        <div>
          <select className="form-select mb-4" aria-label="Default select example" onChange={(e) => { setPaymentType(e.target.value) }}>
            <option value="0" selected>Select Payment Option</option>
            <option value="CASH">By Cash</option>
            <option value="CARD">By Card</option>
            <option value="UPI">By UPI</option>

          </select>
        </div>
        {/* Place order button */}
        <MDBBtn link='primary' style={{ margin: '10px' }} onClick={onClickPlaceOrder}>
          Place order
        </MDBBtn>
      </div>
    </center>
      <ToastContainer position="top-center"/>
      </>
  );
}

export default OrderList;
