import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBInput, MDBRow } from "mdb-react-ui-kit";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { fetchDataApi, updateEmployeeApi } from "../Services/AddEmployeeApi";
import { toast,ToastContainer } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import AdminHeader from "./AdminHeader";

function EditEmployee() {
    const [firstName,setFirstName]=useState('');
    const [lastName,setLastName]=useState('');
    const [contact,setContact]=useState('');
    const [address,setAddress]=useState('');
    const [salary,setSalary]=useState('');
    const [role,setRole]=useState('');
    const [joinDate,setJoinDate]=useState('');
    const navigate=useNavigate();

    useEffect(()=>{fetchdata()},[])

    const fetchdata=async()=>
    {
        const empId=sessionStorage.getItem('empId');
        const responseData= await fetchDataApi(empId);
        if(responseData!=null)
        {
            setFirstName(responseData.firstName);
            setLastName(responseData.lastName);
            setContact(responseData.mobileNumber);
            setAddress(responseData.address);
            setSalary(responseData.salary);
            setRole(responseData.department);
            setJoinDate(responseData.joiningDate);   
        }
    }

    const updateEmployee =async ()=>
    {

        if(firstName ==='')
        {
            toast.error("Please Enter First Name");
        }
        else if(lastName === '')
        {
            toast.error("Please Enter Last Name");
        }
        else if(address === '')
        {
            toast.error("Please Enter Address");
        }
        else if(contact === '')
        {
            toast.error("Please Enter Contact Number");
        }
        else if(salary === '')
        {
            toast.error("Please Enter Salary");
        }
        else if(role === "Select Role")
        {
            toast.error("Please Enter Role");
        }
        else if(joinDate === '')
        {
            toast.error("Please Enter Join Date");
        }
        else{
        const empId=sessionStorage.getItem('empId');
        const responseData=await updateEmployeeApi(firstName,lastName,contact,address,salary,role,joinDate,empId);
        if(responseData=='success')
        {
            toast.success("Employee Updated Successfully");
            sessionStorage.removeItem('empId');
            setTimeout(()=>navigate('/employee'),5000)
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
                            <h2 className="fw-bold mb-2 text-center">Edit Employee</h2>
                            <MDBInput wrapperClass='mb-4' label='First Name' id='form1' type='text' value={firstName} onChange={(e)=>{setFirstName(e.target.value)}}  />
                            <MDBInput wrapperClass='mb-4' label='Last Name' id='form1' type='text' value={lastName} onChange={(e)=>{setLastName(e.target.value)}}  />
                            <MDBInput wrapperClass='mb-4' label='Address' id='form1' type='text' value={address} onChange={(e)=>{setAddress(e.target.value)}} />
                            <MDBInput wrapperClass='mb-4' label='Phone no.' id='form1' type='number' value={contact} onChange={(e)=>{setContact(e.target.value)}}/>
                            <MDBInput wrapperClass='mb-4' label='Salary' id='form1' type='number' value={salary} onChange={(e)=>{setSalary(e.target.value)}}/>
                            <MDBCol col='6'>
                                <select className="form-select mb-4" aria-label="Default select example" value={role} onChange={(e)=>{setRole(e.target.value)}}>
                                <option value="Select Role" selected>Select Role</option>
                                    <option value="Manager">Manager</option>
                                    <option value="Employee">Employee</option>
                                    <option value="Chef">Chef</option>
                                    <option value="Waiter">Waiter</option>
                                    <option value="Cleaner">Cleaner</option>
                                </select>
                            </MDBCol>
                            <MDBInput wrapperClass='mb-4' label='Joining Date' id='form1' type='date' value={joinDate} onChange={(e)=>{setJoinDate(e.target.value)}}/>
                            <MDBBtn size='md' onClick={updateEmployee}>Update Details</MDBBtn>
                        </MDBCardBody>
                    </MDBCard>
                </MDBCol>
            </MDBRow>

        </MDBContainer>
        <ToastContainer position="top-center"/>
    </>);
}

export default EditEmployee;