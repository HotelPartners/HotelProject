import { MDBBtn } from "mdb-react-ui-kit";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { CancelBookingApi, fetchAllTableDetailsApi } from "../Services/BookTableApi";
import { loadUserDataApi } from "../Services/EditUserApi";
import AdminHeader from "./AdminHeader";

function AdminTableDetails() {
  const [bookingdetails, setBookingDetails] = useState([]);
  const [userId,setUserId]=useState('');
  useEffect(() => {
    FetchBookingDetails();
  }, []);

  const FetchBookingDetails = async () => {
    const responseData = await fetchAllTableDetailsApi();
    console.log(responseData);
    if (responseData != null) setBookingDetails(responseData);
    else console.log("failed to fetch");
  };
  const navigate=useNavigate();
  const cancelBooking = async (tableNo, reservationDate, startTime, endTime, tableType) => {
    const response1=loadUserDataApi();
  if(response1.status == 200)
  {
    setUserId(response1.data.userId);
  }

    // Assuming startTime and endTime are in "HH:mm:ss" format
    console.log(startTime);
    console.log(endTime);
    const formattedStartTime = startTime || "00:00:00";
    const formattedEndTime = endTime || "00:00:00";

    const response = await CancelBookingApi(userId, tableNo, reservationDate, formattedStartTime, formattedEndTime, tableType);
    if (response != null) {
      FetchBookingDetails();
    }
  };

  const redirectToBooktable = () => {
    navigate('/booking');
  };



  return (
    <><AdminHeader/>
    <center>
      <div className="container">
        <br/>
        
        <h2>Table Booking Details</h2>
        <div className="table-responsive">
          <br />
          <br />
        
          <table className="table table-bordered">
          <thead> <tr> <h5>Confirmed Bookings</h5></tr></thead>
            <thead>
              <tr>
                <th>Customer Id</th>
                <th>Table no.</th>
                <th>Table Type</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Date</th>
                <th>Price</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody>
              {bookingdetails.map((book) => (
                <tr key={book.bookingId}>
                  <td>{book.userId}</td>
                  <td>{book.tableNo}</td>
                  <td>{book.tableType}</td>
                  <td>{book.startTime}</td>
                  <td>{book.endTime}</td>
                  <td>{book.reservationDate}</td>
                  <td>{book.price}</td>
                  <td>{book.status}</td>
                </tr>
              ))}
            </tbody>
          </table>

          <br />
          <br />

    
        </div>
      </div>
    </center>
    </>
  );
}

export default AdminTableDetails;
