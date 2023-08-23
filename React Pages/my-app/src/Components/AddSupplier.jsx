import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBInput, MDBRow } from "mdb-react-ui-kit";

function AddSupplier() {
    return (<>
        <MDBContainer fluid style={{ backgroundColor: '#FFBD33' }}>

            <MDBRow className='d-flex justify-content-center align-items-center h-100'>
                <MDBCol col='12'>

                    <MDBCard className='bg-white my-5 mx-auto' style={{ borderRadius: '1rem', maxWidth: '500px' }}>
                        <MDBCardBody className='p-5 w-100 d-flex flex-column'>
                            <h2 className="fw-bold mb-2 text-center">Add Employee</h2>
                            <MDBInput wrapperClass='mb-4' label='Name' id='form1' type='text' />
                            <MDBInput wrapperClass='mb-4' label='Address' id='form1' type='text' />
                            <MDBInput wrapperClass='mb-4' label='Phone no.' id='form1' type='number' />
                            <MDBBtn size='md'>Add Supplier</MDBBtn>
                        </MDBCardBody>
                    </MDBCard>

                </MDBCol>
            </MDBRow>

        </MDBContainer>
    </>);
}

export default AddSupplier;