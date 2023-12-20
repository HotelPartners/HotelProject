import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBInput, MDBRow } from "mdb-react-ui-kit";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { addSupplierApi } from "../Services/AddSupplierApi";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import AdminHeader from "./AdminHeader";

function AddSupplier() {
    const [name,setName]=useState('');
    const [contact,setContact]=useState('');
    const [address,setAddress]=useState('');
    const [shopType,setShopType]=useState('');
    const navigate=useNavigate();

    const addSupplier = async ()=>{
        if(name === ''){
            toast.error("Please Enter Name");
        }else if(contact === ''){
            toast.error("Please Enter Contact No.")
        }else if(address === ''){
            toast.error("Please Enter address");
        }else if(shopType === ''){
            toast.error("Please Enter Shop type");
        }
        else{
            const response=await addSupplierApi(name,contact,address,shopType);
        if(response === 'success')
        {
          toast.success("Registered Supplier successfully");
          setTimeout(()=>navigate('/supplier'),3000);
        }
        }
    }

    return (<>
    
    <AdminHeader/>
        <MDBContainer fluid style={{ backgroundColor: '#FFBD33' }}>

            <MDBRow className='d-flex justify-content-center align-items-center h-100'>
                <MDBCol col='12'>

                    <MDBCard className='bg-white my-5 mx-auto' style={{ borderRadius: '1rem', maxWidth: '500px' }}>
                        <MDBCardBody className='p-5 w-100 d-flex flex-column'>
                            <h2 className="fw-bold mb-2 text-center">Add Supplier</h2>
                            <MDBInput wrapperClass='mb-4' label='Name' id='form1' type='text' onChange={(e)=>{setName(e.target.value)}} />
                            <MDBInput wrapperClass='mb-4' label='Address' id='form1' type='text' onChange={(e)=>{setAddress(e.target.value)}}/>
                            <MDBInput wrapperClass='mb-4' label='Shop Type' id='form1' type='text' onChange={(e)=>{setShopType(e.target.value)}}/>
                            <MDBInput wrapperClass='mb-4' label='Phone no.' id='form1' type='number' onChange={(e)=>{setContact(e.target.value)}}/>
                            <MDBBtn size='md' onClick={addSupplier}>Add Supplier</MDBBtn>
                        </MDBCardBody>
                    </MDBCard>

                </MDBCol>
            </MDBRow>

        </MDBContainer>
        <ToastContainer position="top-center"/>
    </>);
}

export default AddSupplier;