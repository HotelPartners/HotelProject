import {
  MDBFooter,
  MDBContainer,
  MDBIcon,
  MDBCol,
  MDBRow,
} from 'mdb-react-ui-kit';
import { useNavigate } from 'react-router-dom';

function Footer() {

  const navigate = useNavigate();
  const gotoAbout = ()=>{
    navigate(`/about`)
  }

  const gotoContact = ()=>{
    navigate(`/contact`)
  }

  const gotoFacebook = ()=>{
    navigate(`/facebook`)
  }

  const gotoInstagram = ()=>{
    navigate(`/instagram`)
  }

  const gotoTwitter = ()=>{
    navigate(`/twitter`)
  }
  return (
    <MDBFooter bgColor='light' className='text-center text-lg-start text-muted position-bottom'>
      <section className='d-flex justify-content-center justify-content-lg-between p-4 border-bottom'>
        <div className='me-5 d-none d-lg-block'>
          <span>Get connected with us on social networks:</span>
        </div>

        <div>
          <a onClick={gotoFacebook} className='me-4 text-reset'>
            <MDBIcon fab icon="facebook-f" />
          </a>
          <a onClick={gotoTwitter} className='me-4 text-reset'>
            <MDBIcon fab icon="twitter" />
          </a>
          <a onClick={gotoInstagram} className='me-4 text-reset'>
            <MDBIcon fab icon="instagram" />
          </a>
        </div>
      </section>

      <section className=''>
        <MDBContainer className='text-center text-md-start mt-5'>
          <MDBRow className='mt-3'>
            <MDBCol md="3" lg="4" xl="3" className='mx-auto mb-4'>
              <h6 className='text-uppercase fw-bold mb-4'>
                <MDBIcon icon="gem" className="me-3" />
                FOOD-E-STHAAN
              </h6>
              <p>
              Welcome to Food-E-Sthaan – a culinary haven where flavors, aromas, and cultures unite to create unforgettable dining experiences. At Food-E-Sthaan, we're passionate about crafting exceptional moments for our guests through exquisite cuisine, impeccable service, and a warm, inviting ambiance.
              </p>
            </MDBCol>

            <MDBCol md="2" lg="2" xl="2" className='mx-auto mb-4'>
              <h6 className='text-uppercase fw-bold mb-4'>MORE</h6>
              <p>
                <a onClick={gotoAbout} className='text-reset'>
                  About Us
                </a>
              </p>
              <p>
                <a onClick={gotoContact} className='text-reset'>
                  Contact Us
                </a>
              </p>
            </MDBCol>

            <MDBCol md="4" lg="3" xl="3" className='mx-auto mb-md-0 mb-4'>
              <h6 className='text-uppercase fw-bold mb-4'>Contact</h6>
              <p>
                <MDBIcon icon="home" className="me-3" />
                New York, NY 10012, US
              </p>
              <p>
                <MDBIcon icon="envelope" className="me-3" />
                foodesthaan@example.com
              </p>
              <p>
                <MDBIcon icon="phone" className="me-3" />
                + 01 234 567 88
              </p>
            </MDBCol>
          </MDBRow>
        </MDBContainer>
      </section>
    </MDBFooter>
  );
}

export default Footer;