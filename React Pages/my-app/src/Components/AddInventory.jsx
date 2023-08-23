import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBInput, MDBRow } from "mdb-react-ui-kit";
import Footer from "./Footer";
import Header from "./Header";

function AddInventory() {
    return (<>
        <Header />
        <MDBContainer fluid style={{ backgroundColor: '#FFBD33' }}>

            <MDBRow className='d-flex justify-content-center align-items-center h-100'>
                <MDBCol col='12'>

                    <MDBCard className='bg-white my-5 mx-auto' style={{ borderRadius: '1rem', maxWidth: '500px' }}>
                        <MDBCardBody className='p-5 w-100 d-flex flex-column'>
                            <h2 className="fw-bold mb-2 text-center">Add Inventory Item</h2>
                            <MDBInput wrapperClass='mb-4' label='Item Name' id='form1' type='text' />
                            <MDBInput wrapperClass='mb-4' label='Item Quantity' id='form1' type='number' />
                            <MDBInput wrapperClass='mb-4' label='Supplier Name' id='form1' type='text' />
                            <MDBBtn size='md'>Add Record</MDBBtn>
                        </MDBCardBody>
                    </MDBCard>
                </MDBCol>
            </MDBRow>
        </MDBContainer>
        <Footer />
    </>);
}

export default AddInventory;