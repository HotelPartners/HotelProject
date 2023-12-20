  import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBInput, MDBRow } from "mdb-react-ui-kit";
  import { useState } from "react";

  import { ToastContainer, toast } from 'react-toastify';
  import 'react-toastify/dist/ReactToastify.css';
  import { AddEmployeeApi } from "../Services/AddEmployeeApi";
  import { useNavigate } from "react-router-dom";
import AdminHeader from "./AdminHeader";

  function AddEmployee() {
      const navigate=useNavigate();
      const [firstName,setFirstName]=useState('');
      const [lastName,setLastName]=useState('');
      const [address,setAddress]=useState('');
      const [mobile,setMobile]=useState('');
      const [salary,setSalary]=useState('');
      const [role,setRole]=useState('');
      const [joiningDate,setJoiningDate]=useState('');

      const addEmployee=async ()=>
      {
          
        if(firstName === '')
        {
          toast.error("Please Enter First Name");
        }
        else if(lastName === '')
        {
          toast.error("Please Enter Last Name");
        }
        else if(address === '')
        {
          toast.error("Please Enter Email");
        }
        else if(mobile === '')
        {
          toast.error("Please Enter Mobile");
        }
        else if(salary === '')
        {
          toast.error("Please Enter Email");
        }
        else if(role === '')
        {
          toast.error("Please Enter Mobile");
        }
        else if(joiningDate === '')
        {
          toast.error("Please Enter Mobile");
        }
        else
        {
          console.log(role);
          const responseData=await AddEmployeeApi(firstName,lastName,address,mobile,salary,role,joiningDate);
          if(responseData ==='success')
          {
              toast.success("Employee Added Successfully");
              setTimeout(()=>{navigate('/employee')},5000)
          }
      }
      }

      return (<>
      <AdminHeader/>
          <MDBContainer fluid style={{ backgroundColor: '#FFBD33' }}>

              <MDBRow className='d-flex justify-content-center align-items-center h-100'>
                  <MDBCol col='12'>

                      <MDBCard className='bg-white my-5 mx-auto' style={{ borderRadius: '1rem', maxWidth: '500px' }}>
                          <MDBCardBody className='p-5 w-100 d-flex flex-column'>
                              <h2 className="fw-bold mb-2 text-center">Add Employee</h2>
                              <MDBInput wrapperClass='mb-4' label='First Name' id='form1' type='text' onChange={(e)=>{setFirstName(e.target.value)}}/>
                              <MDBInput wrapperClass='mb-4' label='Last Name' id='form1' type='text' onChange={(e)=>{setLastName(e.target.value)}}/>
                              <MDBInput wrapperClass='mb-4' label='Address' id='form1' type='text' onChange={(e)=>{setAddress(e.target.value)}}/>
                              <MDBInput wrapperClass='mb-4' label='Phone no.' id='form1' type='number' onChange={(e)=>{setMobile(e.target.value)}}/>
                              <MDBInput wrapperClass='mb-4' label='Salary' id='form1' type='number' onChange={(e)=>{setSalary(e.target.value)}}/>
                              <MDBCol col='6'>
                                  <select className="form-select mb-4" aria-label="Default select example" onChange={(e)=>{setRole(e.target.value)}}>
                                      <option selected>Select Role</option>
                                      <option value="1">MANAGER</option>
                                      <option value="2">EMPLOYEE</option>
                                      <option value="3">CHEF</option>
                                      <option value="4">WAITER</option>
                                      <option value="5">CLEANER</option>
                                  </select>
                              </MDBCol>
                              <MDBInput wrapperClass='mb-4' label='Joining Date' id='form1' type='date' onChange={(e)=>{setJoiningDate(e.target.value)}}/>
                              <MDBBtn size='md' onClick={addEmployee}>Add Employee</MDBBtn>
                          </MDBCardBody>
                      </MDBCard>

                  </MDBCol>
              </MDBRow>

          </MDBContainer>
          <ToastContainer position='top-center'/>
      </>);
  }

  export default AddEmployee;