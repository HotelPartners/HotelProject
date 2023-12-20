import React from 'react';
import { useState } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBInput, MDBRow } from 'mdb-react-ui-kit';
import { useNavigate } from 'react-router-dom';
import { addAddressApi } from "../Services/addAddressApi";
import Header from './Header';

function AddAddress() {

const [address,setAddress]=useState('');
const[landmark,setLandmark]=useState('');
const[selectCity,setSelectCity]=useState('');
const [pincode,setPincode]=useState('');
const navigate=useNavigate();

const addingAddress=async()=>
{
    if(address === '')
    {
      toast.error("Please Enter Address");
    }
    else if(landmark === '')
    {
      toast.error("Please Enter Landmark");
    }
    else if(selectCity === '')
    {
      toast.error("Please Select City");
    }
    else if(pincode === '')
    {
      toast.error("Please Enter Pincode");
    }
    else{
        const response=await addAddressApi(address,landmark,selectCity,pincode);
        if(response === 'success')
        {
          toast.success("Address added successfully");
          const condition=sessionStorage.getItem("gotodileveryaddress");
          console.log(condition);
          if(condition=='true')
          navigate('/dileveryaddress');
          else
          setTimeout(()=>navigate('/customeraddress'),2000);
        }
    }
}

    return (<>
    <Header />
        <MDBContainer fluid style={{ backgroundColor: '#FFBD33' }}>

            <MDBRow className='d-flex justify-content-center align-items-center h-100'>
                <MDBCol col='12'>

                    <MDBCard className='bg-white my-5 mx-auto' style={{ borderRadius: '1rem', maxWidth: '500px' }}>
                        <MDBCardBody className='p-5 w-100 d-flex flex-column'>
                            <h2 className="fw-bold mb-2 text-center">Add Address</h2>
                            <MDBInput wrapperClass='mb-4' label='Address' id='form1' type='text' onChange={(e)=>{setAddress(e.target.value)}}/>
                            <MDBInput wrapperClass='mb-4' label='Landmark' id='form1' type='text' onChange={(e)=>{setLandmark(e.target.value)}} />

                            <MDBRow>
                  <MDBCol col='6'>
                  <select className="form-select mb-4" aria-label="Default select example" onChange={(e)=>{setSelectCity(e.target.value)}} >
                    <option selected>Select City</option>
                    <option value="hinjewadi">Hinjewadi</option>
                    <option value="baner">Baner</option>
                    <option value="kothrud">Kothrud</option>
                    <option value="balewadi">Balewadi</option>
                 </select>
                </MDBCol>
                 </MDBRow>
                 <MDBInput wrapperClass='mb-4' label='Pincode' id='form1' type='number' onChange={(e)=>{setPincode(e.target.value)}}/>
                 <MDBBtn size='md' onClick={addingAddress}>Add Address</MDBBtn>
                </MDBCardBody>
                    </MDBCard>

                </MDBCol>
            </MDBRow>
        </MDBContainer>
        <ToastContainer position='top-center'/>
    </>);
}

export default AddAddress;