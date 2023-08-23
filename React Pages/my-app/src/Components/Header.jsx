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


function Header() {

  const navigate = useNavigate();
  const [showBasic, setShowBasic] = useState(false);

  const gotoHome =()=>{
    navigate(`/`)
  }

  const gotoMenu = ()=>{
    navigate(`/menu`)
  }

  const gotoBooking = ()=>{
    navigate(`/booking`)
  }

  const gotoOrders = ()=>{
    navigate(`/orders`)
  }

  const gotoCart = ()=>{
    navigate(`/cart`)
  }

  const gotoAbout = ()=>{
    navigate(`/about`)
  }

  const gotoContact =()=>{
    navigate(`/contact`)
  }

  const gotoEditProfile = ()=>{
    navigate(`/editprofile`)
  }

  const gotoLogin = ()=>{
    navigate(`/login`)
  }

  const gotoSignup = ()=>{
    navigate(`/signup`)
  }
  
  const gotoAddAddress = ()=>{
    navigate(`/add_address`)
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
              <MDBNavbarLink onClick={gotoBooking}>Book Table</MDBNavbarLink>
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
              <MDBNavbarLink onClick={gotoAddAddress}>Add Address</MDBNavbarLink>
            </MDBNavbarItem>
            <MDBNavbarItem>
              <MDBNavbarLink onClick={gotoAbout}>About Us</MDBNavbarLink>
            </MDBNavbarItem>
            <MDBNavbarItem>
              <MDBNavbarLink onClick={gotoContact}>Contact Us</MDBNavbarLink>
            </MDBNavbarItem>
          </MDBNavbarNav>
          <MDBBtn className='mx-2' color='warning' onClick={gotoLogin}>LogIn</MDBBtn>
          <MDBBtn className='mx-2' color='warning' onClick={gotoSignup}>SignUp</MDBBtn>
        </MDBCollapse>
      </MDBContainer>
    </MDBNavbar>
  </>);
}

export default Header;