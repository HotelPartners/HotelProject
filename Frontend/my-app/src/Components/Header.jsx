import { useState } from 'react';
import '../myApp.css';
import {
  MDBContainer,
  MDBNavbar,
  MDBNavbarBrand,
  MDBNavbarToggler,
  MDBIcon,
  MDBNavbarNav,
  MDBNavbarItem,
  MDBNavbarLink,
  MDBBtn,
  MDBCollapse,
} from 'mdb-react-ui-kit';
import { useNavigate } from 'react-router-dom';
import { ToastContainer,toast } from 'react-toastify';
import { loadUserDataApi } from '../Services/EditUserApi';
import { useEffect } from 'react';


function Header() {
  const [firstName,setFirstName]=useState('');
   const [lastName,setLastName]=useState('');

   
   var isLoggedin=false;
   
 
  const loginStatus=sessionStorage.getItem("token");
  if(loginStatus !=null)
  {
    console.log("inside header")
    isLoggedin=true;
   }
 
   const userName=sessionStorage.getItem("firstName")+" "+sessionStorage.getItem("lastName")



  const navigate = useNavigate();
const [showBasic, setShowBasic] = useState(false);

  const gotoHome =()=>{
    
    navigate(`/`)
   
    
  }

  const gotoMenu = ()=>{
    if(isLoggedin===true)
    navigate(`/customermenu`)
    else
    navigate(`/login`)
  }

  const gotoBookingDetails = ()=>{
    if(isLoggedin===true)
    navigate(`/bookingdetails`)
    else
    navigate(`/login`)
  }

  const gotoOrders = ()=>{
    if(isLoggedin===true)
    navigate(`/orders`)
    else
    navigate(`/login`)
  }

  const gotoCart = ()=>{
    if(isLoggedin===true)
    navigate(`/cart`)
    else
    navigate(`/login`)
  }

  const gotoAbout = ()=>{
    if(isLoggedin===true)
    navigate(`/about`)
  }

  const gotoContact =()=>{
    
    navigate(`/contact`)
  }

  const gotoEditProfile = ()=>{
    if(isLoggedin===true)
    navigate(`/editprofile`)
    else
    navigate(`/login`)
  }

  const gotoLogin = ()=>{
    
    navigate(`/login`)
  }

  const gotoSignup = ()=>{
    navigate(`/signup`)
  }
  
  const gotoAddAddress = ()=>{
    if(isLoggedin===true)
    navigate(`/customeraddress`)
    else
    navigate(`/login`)
  }

  const Logout=()=>
  {
    sessionStorage.removeItem('qwert')
    sessionStorage.removeItem("trewq");
    localStorage.clear();
    sessionStorage.clear();
    navigate(`/login`)
  }

  return (<>

    <MDBNavbar expand='lg' light bgColor='light'>
      <MDBContainer fluid>
        <MDBNavbarBrand onClick={gotoHome}>
          <img
            src='./img/logo.png'
            height='50'
            alt=''
            loading='lazy'
          />
        </MDBNavbarBrand>
        <MDBNavbarBrand onClick={gotoHome}>FOOD-E-STHAAN</MDBNavbarBrand>

        <MDBNavbarToggler
          aria-controls='navbarSupportedContent'
          aria-expanded='false'
          aria-label='Toggle navigation'
          onClick={() => setShowBasic(!showBasic)}
        >
          <MDBIcon icon='bars' fas />
        </MDBNavbarToggler>

        <MDBCollapse navbar show={showBasic}>
          <MDBNavbarNav className='mr-auto mb-2 mb-lg-0'>
            <MDBNavbarItem>
              <MDBNavbarLink active aria-current='page' onClick={gotoHome}>
                Home
              </MDBNavbarLink>
            </MDBNavbarItem>
            <MDBNavbarItem>
              <MDBNavbarLink onClick={gotoMenu}>Menu</MDBNavbarLink>
            </MDBNavbarItem>
            <MDBNavbarItem>
              <MDBNavbarLink onClick={gotoBookingDetails}>Book Table</MDBNavbarLink>
            </MDBNavbarItem>
            <MDBNavbarItem>
              <MDBNavbarLink onClick={gotoOrders}>Orders</MDBNavbarLink>
            </MDBNavbarItem>
            <MDBNavbarItem>
              <MDBNavbarLink onClick={gotoCart}>Cart</MDBNavbarLink>
            </MDBNavbarItem>
            <MDBNavbarItem>
              <MDBNavbarLink onClick={gotoEditProfile}>Edit Profile</MDBNavbarLink>
            </MDBNavbarItem>
            <MDBNavbarItem>
              <MDBNavbarLink onClick={gotoAddAddress}>Address</MDBNavbarLink>
            </MDBNavbarItem>
            <MDBNavbarItem>
              <MDBNavbarLink onClick={gotoAbout}>About Us</MDBNavbarLink>
            </MDBNavbarItem>
            <MDBNavbarItem>
              <MDBNavbarLink onClick={gotoContact}>Contact Us</MDBNavbarLink>
            </MDBNavbarItem>
          </MDBNavbarNav>
          <div style={{ display: 'flex', alignItems: 'center' }}>
          {isLoggedin?(<> <h5 style={{ whiteSpace: 'nowrap' }}>Welcome {userName}</h5>
          <MDBBtn className='mx-2' color='danger' onClick={Logout}>Logout</MDBBtn></>):(<>
          <MDBBtn className='mx-2' color='warning' onClick={gotoLogin}>LogIn</MDBBtn>
          <MDBBtn className='mx-2' color='warning' onClick={gotoSignup}>SignUp</MDBBtn></>)}
          </div>
        </MDBCollapse>
      </MDBContainer>
    </MDBNavbar>
    <ToastContainer position='top-center'/>
  </>);
}

export default Header;