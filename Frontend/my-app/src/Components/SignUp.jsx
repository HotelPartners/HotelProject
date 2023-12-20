import React from 'react';
import { useState } from 'react';

//Toastify
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

import {registerUserApi} from '../Services/RegisterUserApi';
import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBInput, MDBRow } from 'mdb-react-ui-kit';
import { useNavigate } from 'react-router-dom';

function SignUp() {

  const [firstName,setFirstName]=useState('');
  const [lastName,setLastName]=useState('');
  const [email,setEmail]=useState('');
  const [mobile,setMobile]=useState('');
  const [password,setPassword]=useState('');
  const [confirmPassword,setConfirmPassword]=useState('');
  const navigate=useNavigate();

    const registerUser= async ()=>
    {
      if(firstName === '')
      {
        toast.error("Please Enter First Name");
      }
      else if(lastName === '')
      {
        toast.error("Please Enter Last Name");
      }
      else if(email === '')
      {
        toast.error("Please Enter Email");
      }
      else if (!email.includes('@gmail.com')) {
        toast.error("Please Enter a valid Gmail address");
      }      
      else if(mobile === '')
      {
        toast.error("Please Enter Mobile");
      }
      else if(password === '')
      {
        toast.error("Please Enter Password");
      }
      else if(confirmPassword === '')
      {
        toast.error("Please Enter Confirm Password");
      }
      else if(password !== confirmPassword)
      {

        toast.error("Password Not Matching");
      }
      else
      {
        const response=await registerUserApi(firstName,lastName,email,mobile,password);
        if(response === 'success')
        {
          toast.success("Registered user successfully");
         setTimeout(()=>{navigate('/login')},3000);
        }
      }
    }
  
  return (<>
    <MDBContainer fluid style={{backgroundColor : '#FFBD33'}}>

      <MDBRow className='d-flex justify-content-center align-items-center h-100'>
        <MDBCol col='12'>

          <MDBCard className='bg-white my-5 mx-auto' style={{ borderRadius: '1rem', maxWidth: '500px' }}>
            <MDBCardBody className='p-5 w-100 d-flex flex-column'>

              <h2 className="fw-bold mb-2 text-center">Sign Up</h2>

              <MDBRow>
            <MDBCol col='6'>
              <MDBInput wrapperClass='mb-4' label='First name' id='form1' type='text' onChange={(e)=>{setFirstName(e.target.value)}}/>
            </MDBCol>

            <MDBCol col='6'>
              <MDBInput wrapperClass='mb-4' label='Last name' id='form1' type='text' onChange={(e)=>{setLastName(e.target.value)}}/>
            </MDBCol>
          </MDBRow>

          <MDBInput wrapperClass='mb-4' label='Email' id='form1' type='email' onChange={(e)=>{setEmail(e.target.value)}}/>
          <MDBInput wrapperClass='mb-4' label='Phone no.' id='form1' type='number' onChange={(e)=>{setMobile(e.target.value)}}/>
          <MDBInput wrapperClass='mb-4' label='Password' id='form1' type='password' onChange={(e)=>{setPassword(e.target.value)}}/>
          <MDBInput wrapperClass='mb-4' label='Confirm Password' id='form1' type='password' onChange={(e)=>{setConfirmPassword(e.target.value)}}/>

              <MDBBtn size='md' onClick={registerUser}>
                Sign Up
              </MDBBtn>
            </MDBCardBody>
          </MDBCard>

        </MDBCol>
      </MDBRow>

    </MDBContainer>
    <ToastContainer position='top-center'/>
  </>);
}

export default SignUp;