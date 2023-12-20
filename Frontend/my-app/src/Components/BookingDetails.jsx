import React, { useEffect, useState } from "react";
import { MDBBtn } from "mdb-react-ui-kit";
import { useNavigate } from "react-router-dom";
import { FetchBookingDetailsApi, CancelBookingApi, updateTableStatusApi } from "../Services/BookTableApi";
import Header from "./Header";

function BookingDetails() {
  const [status, setStatus] = useState(null);
  const [bookingdetails, setBookingDetails] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    FetchBookingDetails();
  }, []);

  useEffect(() => {
    // Update status when bookingdetails change
    if (bookingdetails.length > 0) {
      updateStatus(bookingdetails[0].id).then((data) => setStatus(data));
    }
  }, [bookingdetails]);

  const FetchBookingDetails = async () => {
    const responseData = await FetchBookingDetailsApi();
    console.log(responseData);
    if (responseData != null) setBookingDetails(responseData);
    else console.log("failed to fetch");
  };

  const cancelBooking = async (userId,tableNo, reservationDate, startTime, endTime, tableType) => {
    const formattedStartTime = startTime || "00:00:00";
    const formattedEndTime = endTime || "00:00:00";

    const response = await CancelBookingApi(
      userId,
      tableNo,
      reservationDate,
      formattedStartTime,
      formattedEndTime,
      tableType
    );
    if (response != null) {
      FetchBookingDetails();
    }
  };

  async function updateStatus(orderId) {
    const responseData = await updateTableStatusApi(orderId);
    return responseData;
  }

  const redirectToBooktable = () => {
    navigate("/booking");
  };

  return (
    <><Header />
    <center>
      <div className="container">
        <h2>Table Booking Details</h2>
        <div className="table-responsive">
          <MDBBtn link="primary" size="sm" onClick={redirectToBooktable} style={{ float: "right" }}>
            Book Table
          </MDBBtn>
          <br />
          <br />
          <table className="table table-bordered">
            <thead>
              <tr>
                <th>Table no.</th>
                <th>Table Type</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Date</th>
                <th>Price</th>
                <th>Status</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {bookingdetails.map((book) => (
                <tr key={book.id}>
                  <td>{book.tableNo}</td>
                  <td>{book.tableType}</td>
                  <td>{book.startTime}</td>
                  <td>{book.endTime}</td>
                  <td>{book.reservationDate}</td>
                  <td>{book.price}</td>
                  <td>
            {new Date(book.reservationDate + " " + book.startTime) < new Date()
              ? status !== null
                ? status
                : "TIMEOUT"
              : book.status}
          </td>

                  <td>
                    <MDBBtn
                      link="danger"
                      size="sm"
                      onClick={() =>
                        cancelBooking(book.userId,book.tableNo, book.reservationDate, book.startTime, book.endTime, book.tableType)
                      }
                      disabled={new Date(book.reservationDate + " " + book.startTime) < new Date()}
                    >
                      Cancel Booking
                    </MDBBtn>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </center>
    </>
  );
}

export default BookingDetails;
