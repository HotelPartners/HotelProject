import { useNavigate } from 'react-router-dom';
import '../../node_modules/bootstrap/dist/css/bootstrap.css'
import { MDBBtn, MDBCard, MDBCardBody, MDBCheckbox, MDBCol, MDBContainer,  MDBInput, MDBRow } from 'mdb-react-ui-kit'
import { useState } from 'react';
import { ToastContainer,toast } from 'react-toastify';
import { loginUserApi } from '../Services/loginUserApi';

function Login() {

  const[email, setEmail]= useState('');
  const[password, setPassword] = useState('');
  const navigate = useNavigate();

  const loginUser = async ()=>{
    if(email.length == ''){
      toast.error("Please enter email")
    } else if(password.length == ''){
      toast.error("Please enter password")
    } else{
      const responseData = await loginUserApi(email, password)
      // console.log(responseData);
      if(responseData!== ''){
        sessionStorage['firstName']=responseData.firstName;
        sessionStorage['lastName']=responseData.lastName;
        sessionStorage['userEmail']=responseData.userEmail;
        sessionStorage['mobileNumber']=responseData.mobileNumber;
       sessionStorage['role']=responseData.role;

       if(responseData.role == "ADMIN"){
        navigate('/admin_home')
       } else
        // toast.success(`Welcome user`)
        navigate('/')
      } else{
        toast.error('Invalid Username or Password')
      }
    }
  }
  return (<>
    <MDBContainer fluid style={{backgroundColor : '#FFBD33'}}>

      <MDBRow className='d-flex justify-content-center align-items-center h-100'>
        <MDBCol col='12'>

          <MDBCard className='bg-white my-5 mx-auto' style={{ borderRadius: '1rem', maxWidth: '500px' }}>
            <MDBCardBody className='p-5 w-100 d-flex flex-column'>

              <h2 className="fw-bold mb-2 text-center">Log In</h2>
              <p className="text-white-50 mb-3">Please enter your login and password!</p>

              <MDBInput wrapperClass='mb-4 w-100' label='Email address' id='formControlLg' type='email' size="lg" onChange={(e) => {setEmail(e.target.value)}}/>
              <MDBInput wrapperClass='mb-4 w-100' label='Password' id='formControlLg' type='password' size="lg" onChange={(e) => {setPassword(e.target.value)}} />

              <MDBCheckbox name='flexCheck' id='flexCheckDefault' className='mb-4' label='Remember password' />

              <MDBBtn size='lg' onClick={loginUser}>
                Login
              </MDBBtn>
            </MDBCardBody>
          </MDBCard>

        </MDBCol>
      </MDBRow>

    </MDBContainer>
    <ToastContainer/>
  </>
  )
}

export default Login




