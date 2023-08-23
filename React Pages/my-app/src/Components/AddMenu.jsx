import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBInput, MDBRow } from "mdb-react-ui-kit";
import Footer from "./Footer";
import Header from "./Header";

function AddMenu() {
    return (<>
        <Header />
        <MDBContainer fluid style={{ backgroundColor: '#FFBD33' }}>

            <MDBRow className='d-flex justify-content-center align-items-center h-100'>
                <MDBCol col='12'>

                    <MDBCard className='bg-white my-5 mx-auto' style={{ borderRadius: '1rem', maxWidth: '500px' }}>
                        <MDBCardBody className='p-5 w-100 d-flex flex-column'>
                            <h2 className="fw-bold mb-2 text-center">Add Item</h2>
                            <MDBInput wrapperClass='mb-4' label='Item Name' id='form1' type='text' />
                            <MDBCol col='6'>
                                <select className="form-select mb-4" aria-label="Default select example">
                                    <option selected>Select Item Category</option>
                                    <option value="roti">Roti</option>
                                    <option value="rice">Rice</option>
                                    <option value="handi">Handi</option>
                                </select>
                            </MDBCol>
                            <MDBCol col='6'>
                                <select className="form-select mb-4" aria-label="Default select example">
                                    <option selected>Select Item Type</option>
                                    <option value="veg">Veg</option>
                                    <option value="nonveg">Non-Veg</option>
                                </select>
                            </MDBCol>
                            <MDBInput wrapperClass='mb-4' label='Item Price' id='form1' type='number' />
                            <MDBBtn size='md'>
                                Add Item
                            </MDBBtn>
                        </MDBCardBody>
                    </MDBCard>

                </MDBCol>
            </MDBRow>

        </MDBContainer>
        <Footer />
    </>);
}

export default AddMenu;