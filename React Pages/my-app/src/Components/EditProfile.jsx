import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBInput, MDBRow } from "mdb-react-ui-kit";

function EditProfile() {
  return (<>
    <MDBContainer fluid style={{ backgroundColor: '#FFBD33' }}>

      <MDBRow className='d-flex justify-content-center align-items-center h-100'>
        <MDBCol col='12'>

          <MDBCard className='bg-white my-5 mx-auto' style={{ borderRadius: '1rem', maxWidth: '500px' }}>
            <MDBCardBody className='p-5 w-100 d-flex flex-column'>

              <h2 className="fw-bold mb-2 text-center">Edit Profile</h2>

              <MDBRow>
                <MDBCol col='6'>
                  <MDBInput wrapperClass='mb-4' label='First name' id='form1' type='text' />
                </MDBCol>

                <MDBCol col='6'>
                  <MDBInput wrapperClass='mb-4' label='Last name' id='form1' type='text' />
                </MDBCol>
              </MDBRow>

              <MDBInput wrapperClass='mb-4' label='Email' id='form1' type='email' />
              <MDBInput wrapperClass='mb-4' label='Phone no.' id='form1' type='number' />
              <MDBInput wrapperClass='mb-4' label='Password' id='form1' type='password' />
              <MDBInput wrapperClass='mb-4' label='Confirm Password' id='form1' type='password' />

              <MDBBtn size='md'>
                Save Changes
              </MDBBtn>
            </MDBCardBody>
          </MDBCard>

        </MDBCol>
      </MDBRow>

    </MDBContainer>
  </>);
}

export default EditProfile;