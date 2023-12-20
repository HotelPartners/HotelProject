import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBInput, MDBRow } from "mdb-react-ui-kit";
import { useEffect,useState } from "react";
import { useNavigate } from "react-router-dom";
import { fetchSupplierDataApi,updateSupplierApi } from "../Services/AddSupplierApi";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import AdminHeader from "./AdminHeader";

function EditSupplier() {
    const [name,setName]=useState('');
    const [contact,setContact]=useState('');
    const [address,setAddress]=useState('');
    const [shopType,setShopType]=useState('');
    const navigate=useNavigate();

    useEffect(()=>{fetchdata()},[])

    const fetchdata=async()=>
    {
        const supplierId=sessionStorage.getItem('supplierId');
        console.log(supplierId);
        const responseData= await fetchSupplierDataApi(supplierId);
      
        if(responseData!=null)
        {
            setName(responseData.supplierName);
            setContact(responseData.supplierContact);
            setAddress(responseData.supplierAddress);
            setShopType(responseData.shopType);
        }
        
    }

    const updateSupplier =async ()=>
    {
        const supplierId=sessionStorage.getItem('supplierId');
        const responseData=await updateSupplierApi(name,contact,address,shopType,supplierId);
        if(responseData=='success')
        {
            toast.success("Supplier Updated Successfully");
            navigate('/supplier');
        }
    }


   

    return (<>
   <AdminHeader/> 
        <MDBContainer fluid style={{ backgroundColor: '#FFBD33' }}>

            <MDBRow className='d-flex justify-content-center align-items-center h-100'>
                <MDBCol col='12'>

                    <MDBCard className='bg-white my-5 mx-auto' style={{ borderRadius: '1rem', maxWidth: '500px' }}>
                        <MDBCardBody className='p-5 w-100 d-flex flex-column'>
                            <h2 className="fw-bold mb-2 text-center">Edit Supplier</h2>
                            <MDBInput wrapperClass='mb-4' label='Name' id='form1' type='text' value={name} onChange={(e)=>{setName(e.target.value)}} />
                            <MDBInput wrapperClass='mb-4' label='Address' id='form1' type='text' value={address} onChange={(e)=>{setAddress(e.target.value)}}/>
                            <MDBInput wrapperClass='mb-4' label='Shop Type' id='form1' type='text' value={shopType} onChange={(e)=>{setShopType(e.target.value)}}/>
                            <MDBInput wrapperClass='mb-4' label='Phone no.' id='form1' type='number' value={contact} onChange={(e)=>{setContact(e.target.value)}}/>
                            <MDBBtn size='md' onClick={updateSupplier}>Update Details</MDBBtn>
                        </MDBCardBody>
                    </MDBCard>

                </MDBCol>
            </MDBRow>

        </MDBContainer>
        <ToastContainer/>
    </>);
}

export default EditSupplier;