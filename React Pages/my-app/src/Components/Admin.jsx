import { MDBBtn, MDBCard, MDBCardBody, MDBCardImage, MDBCol, MDBRow } from "mdb-react-ui-kit";

function Admin() {
  return (<>
     <MDBRow className='row-cols-1 row-cols-md-5 g-6 m-3'>
      <MDBCol className="hover-shadow my-3">
        <MDBCard alignment="center">
          <MDBCardImage
            src='./img/burger.png'
            alt='...'
            position='top' style={{height:"250px"}}
          />
          <MDBCardBody>
          <MDBBtn href='#'>Menu</MDBBtn>
            
          </MDBCardBody>
        </MDBCard>
      </MDBCol>
      <MDBCol className="hover-shadow my-3">
        <MDBCard alignment="center">
          <MDBCardImage
            src='./img/restaurant.png'
            alt='...'
            position='top' style={{height:"250px"}}
          />
          <MDBCardBody className="hover-shadow">
          <MDBBtn href='#'>Table Manager</MDBBtn>
            
          </MDBCardBody>
        </MDBCard>
      </MDBCol>
      <MDBCol className="hover-shadow my-3">
        <MDBCard alignment="center">
          <MDBCardImage
            src='./img/inventory.png'
            alt='...'
            position='top' style={{height:"250px"}}
          />
          <MDBCardBody>
          <MDBBtn href='#'>Inventory</MDBBtn>
           
          </MDBCardBody>
        </MDBCard>
      </MDBCol>
      <MDBCol className="hover-shadow my-3">
        <MDBCard alignment="center">
          <MDBCardImage
            src='./img/invoice.png'
            alt='...'
            position='top' style={{height:"250px"}}
          />
          <MDBCardBody>
          <MDBBtn href='#'>Bill Records</MDBBtn>
           
          </MDBCardBody>
        </MDBCard>
      </MDBCol>
      <MDBCol className="hover-shadow my-3">
        <MDBCard alignment="center">
          <MDBCardImage
            src='./img/supplier.png'
            alt='...'
            position='top' style={{height:"250px"}}
          />
          <MDBCardBody>
          <MDBBtn href='#'>Supplier Details</MDBBtn>
            
          </MDBCardBody>
        </MDBCard>
      </MDBCol>
      <MDBCol className="hover-shadow my-3">
        <MDBCard alignment="center">
          <MDBCardImage
            src='./img/service.png'
            alt='...'
            position='top' style={{height:"250px"}}
          />
          <MDBCardBody>
          <MDBBtn href='#'>Customer Details</MDBBtn>
            
          </MDBCardBody>
        </MDBCard>
      </MDBCol>
      <MDBCol className="hover-shadow my-3">
        <MDBCard alignment="center">
          <MDBCardImage
            src='./img/employee.png'
            alt='...'
            position='top' style={{height:"250px"}}
          />
          <MDBCardBody>
            <MDBBtn href='#'>Employee Details</MDBBtn>
          </MDBCardBody>
        </MDBCard>
      </MDBCol>
    </MDBRow>
    
  </>);
}

export default Admin;