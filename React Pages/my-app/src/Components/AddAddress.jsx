import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBInput, MDBRow } from "mdb-react-ui-kit";

function AddAddress() {
    return (<>
        <MDBContainer fluid style={{ backgroundColor: '#FFBD33' }}>

            <MDBRow className='d-flex justify-content-center align-items-center h-100'>
                <MDBCol col='12'>

                    <MDBCard className='bg-white my-5 mx-auto' style={{ borderRadius: '1rem', maxWidth: '500px' }}>
                        <MDBCardBody className='p-5 w-100 d-flex flex-column'>
                            <h2 className="fw-bold mb-2 text-center">Add Address</h2>
                            <MDBInput wrapperClass='mb-4' label='Address' id='form1' type='text' />
                            <MDBInput wrapperClass='mb-4' label='Landmark' id='form1' type='email' />
                            <MDBInput wrapperClass='mb-4' label='City' id='form1' type='City' />
                            <MDBInput wrapperClass='mb-4' label='State' id='form1' type='State' />
                            <MDBInput wrapperClass='mb-4' label='Pincode' id='form1' type='number' />
                            <MDBBtn size='md'>Add Address</MDBBtn>
                        </MDBCardBody>
                    </MDBCard>

                </MDBCol>
            </MDBRow>

        </MDBContainer>
    </>);
}

export default AddAddress;