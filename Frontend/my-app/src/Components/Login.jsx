import { useNavigate } from 'react-router-dom';
import '../../node_modules/bootstrap/dist/css/bootstrap.css'
import { MDBBtn, MDBCard, MDBCardBody, MDBCheckbox, MDBCol, MDBContainer,  MDBInput, MDBRow } from 'mdb-react-ui-kit'
import { useState } from 'react';
import { ToastContainer,toast } from 'react-toastify';
import { loginUserApi } from '../Services/loginUserApi';
import Header from './Header';

function Login() {

  sessionStorage.clear();
  const[email, setEmail]= useState('');
  const[password, setPassword] = useState('');
  const navigate = useNavigate();

  

  const loginUser = async ()=>{
    if(email.length == ''){
      toast.error("Please enter email")
    } else if(password.length == ''){
      toast.error("Please enter password")
    } else{
      const responseData = await loginUserApi(email, password);
      if(responseData!==null)
      {
        sessionStorage.setItem('firstName', responseData.data.user.firstName);
        sessionStorage.setItem('lastName', responseData.data.user.lastName);
        sessionStorage.setItem('token', responseData.data.token);
        console.log(responseData.data.user.role)
        if(responseData.data.user.role=='CUSTOMER')
        navigate('/customerhome')
        else if(responseData.data.user.role=='ADMIN')
        navigate('/adminhome')
      // else
      // navigate('/')

      } else{
        toast.error('Invalid Username or Password')
      }
    }
  }
  return (<>
  <Header/>
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
    <ToastContainer position='top-center'/>
  </>
  )
}

export default Login




