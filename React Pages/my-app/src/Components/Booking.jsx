import React from 'react';
import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBRow } from 'mdb-react-ui-kit';

function Booking() {
  return (<>
    <MDBContainer fluid style={{ backgroundColor: '#FFBD33' }}>

      <MDBRow className='d-flex justify-content-center align-items-center h-100'>
        <MDBCol col='12'>

          <MDBCard className='bg-white my-5 mx-auto' style={{ borderRadius: '1rem', maxWidth: '500px' }}>
            <MDBCardBody className='p-5 w-100 d-flex flex-column'>
              <h2 className="fw-bold mb-2 text-center">Book Table</h2>
              <MDBRow>
                <MDBCol col='6'>
                  <select className="form-select mb-4" aria-label="Default select example">
                    <option selected>Select Persons</option>
                    <option value="2">Two</option>
                    <option value="4">Four</option>
                    <option value="6">Six</option>
                    <option value="8">Eight</option>
                    <option value="10">Ten</option>
                  </select>
                </MDBCol>

              </MDBRow>

              <input type='date' className='mb-4 p-1'/>
              <input type='time' className='mb-4 p-1'/>
              <MDBBtn size='md'>
                Book Table
              </MDBBtn>
            </MDBCardBody>
          </MDBCard>

        </MDBCol>
      </MDBRow>

    </MDBContainer>
  </>);
}

export default Booking;