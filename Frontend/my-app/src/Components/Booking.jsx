import React, { useState,useEffect } from 'react';
import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBRow } from 'mdb-react-ui-kit';
import { bookTableApi, sendMailApi } from '../Services/BookTableApi';
import { toast, ToastContainer } from 'react-toastify';

import 'react-toastify/dist/ReactToastify.css';
import { useNavigate } from 'react-router-dom';
import { loadUserDataApi } from '../Services/EditUserApi';
import Header from './Header';

function Booking() {
  const [email,setEmail]=useState('');
  const [userId,setUserId]=useState('');

  useEffect(()=>{
    loadUser()
  },[]);

  const today=new Date();
  const currentDate = new Date().toISOString().split('T')[0];
  const maxDate = new Date(today);
  maxDate.setDate(maxDate.getDate() + 7);
  
  const [startTime, setStartTime] = useState({
    "hour": 0,
    "minute": 0,
    "second": 0,
    "nano": 0
  });
  const [endTime, setEndTime] = useState('');
  const [tableType, setTableType] = useState('');
  const [reservationDate, setreservationDate] = useState('');

  const loadUser=async()=>{
    const response=await loadUserDataApi();
    if(response.status == 200)
     {
       setEmail(response.data.userEmail);
      setUserId(response.data.userId);
      
     }
  }

  const handleHourChange = event => {
    const { name, value } = event.target;
    setStartTime(prevState => ({
      ...prevState,
      [name]: value
    }));
  };


  const navigate=useNavigate()
  const bookTable = async () => {
    
   
    
    const responseData = await bookTableApi(startTime , endTime, tableType, reservationDate)
    if (responseData != null) {
      if(email!='')
      {
        const mailSend=await sendMailApi(email,reservationDate,reservationDate.startTime,tableType,responseData.endTime);
        console.log(mailSend.endTime);
        if(mailSend == 'success')
        {
          toast.success("Your slot reservation is successful & Details Sent on Mail")
          // toast.success("Mail Send Successfully")
          navigate('/orderdetails')
        }
        else{
          toast.success("Your slot reserved  successfully!!!")
          navigate('/bookingdetails')
        }
      }
     
   
      
    }
    else
    {
      toast.success("Table Not Available")
    }
  }

  return (<>
    <Header />
    <MDBContainer fluid style={{ backgroundColor: '#FFBD33' }}>

      <MDBRow className='d-flex justify-content-center align-items-center h-100'>
        <MDBCol col='12'>

          <MDBCard className='bg-white my-5 mx-auto' style={{ borderRadius: '1rem', maxWidth: '500px' }}>
            <MDBCardBody className='p-5 w-100 d-flex flex-column'>
              <h2 className="fw-bold mb-2 text-center">Book Table</h2>
              <MDBRow>
                <MDBCol col='6'>
                  <select className="form-select mb-4" aria-label="Default select example" onChange={(e)=>{setTableType(e.target.value)}}>
                    <option selected>Number of Persons</option>
                    <option value="TABLE_FOR_TWO">Two</option>
                    <option value="TABLE_FOR_FOUR">Four</option>
                    <option value="TABLE_FOR_SIX">Six</option>
                  
                  </select>
                </MDBCol>

              </MDBRow>

              <input type='date' className='mb-4 p-1' min={currentDate} max={maxDate} onChange={(e)=>{setreservationDate(e.target.value)}}/>
              <input type='number' className='mb-4 p-1' placeholder='Enter Start Time' min={0} max={23} name="hour"
        value={startTime.hour}
        onChange={handleHourChange}></input>

              <select className="form-select mb-4" aria-label="Default select example" onChange={(e)=>{setEndTime(e.target.value)}} >
              <option  selected> For how many hours</option>
                  <option  value={1}> 1 </option>
                  <option  value={2}> 2 </option>
                  <option  value={3}> 3 </option>
                  <option  value={4}> 4 </option>
                  <option  value={5}> 5 </option>
                
              </select>
              <MDBBtn size='md' onClick={bookTable}>
                Book Table
              </MDBBtn>
            </MDBCardBody>
          </MDBCard>

        </MDBCol>
      </MDBRow>

    </MDBContainer>
    <ToastContainer position='top-center' />

  </>);
}

export default Booking;