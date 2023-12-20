import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBInput, MDBRow } from "mdb-react-ui-kit";
import { useEffect,useState } from "react";
import { useNavigate } from "react-router-dom";
import { fetchInventoryDataApi,updateInventoryApi } from "../Services/addInventoryApi";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import AdminHeader from "./AdminHeader";


function EditInventory() {

    const [inventoryName,setInventoryName]=useState('');
    const [inventoryCapacity,setinventoryCapacity]=useState('');
   
    const [supplierName,setsupplierName]=useState('');
    const [dateOfIngredientAdded,setdateOfIngredientAdded]=useState('');

    const navigate=useNavigate();


    useEffect(()=>{fetchdata()},[])

    const fetchdata=async()=>
    {
        const ingredientId=sessionStorage.getItem('inventoryId');
      
        const responseData= await fetchInventoryDataApi(ingredientId);
        
      
        if(responseData!=null)
        {
           setInventoryName(responseData.ingredientName);
           setinventoryCapacity(responseData.ingredientCapacity);
           setdateOfIngredientAdded(responseData.dateOfIngredientAdded);
           setsupplierName(responseData.supplierName);
        }
      

    }
    const updateInventory =async ()=>
    {
        const ingredientId=sessionStorage.getItem('inventoryId');
        const responseData=await updateInventoryApi(inventoryName,inventoryCapacity,supplierName,dateOfIngredientAdded,ingredientId);
        if(responseData=='success')
        {
            toast.success("Inventory Updated Successfully");
            navigate('/inventory');
        }
    }



    return ( <>
    <AdminHeader/>
        <MDBContainer fluid style={{ backgroundColor: '#FFBD33' }}>

            <MDBRow className='d-flex justify-content-center align-items-center h-100'>
                <MDBCol col='12'>

                    <MDBCard className='bg-white my-5 mx-auto' style={{ borderRadius: '1rem', maxWidth: '500px' }}>
                        <MDBCardBody className='p-5 w-100 d-flex flex-column'>
                            <h2 className="fw-bold mb-2 text-center">Update Inventory Item</h2>
                            <MDBInput wrapperClass='mb-4' label='Item Name' id='form1' type='text' value={inventoryName} onChange={(e)=>{setInventoryName(e.target.value)}} />
                            <MDBInput wrapperClass='mb-4' label='Item Quantity' id='form1' type='number' value={inventoryCapacity} onChange={(e)=>{setinventoryCapacity(e.target.value)}}/>
                            <MDBInput wrapperClass='mb-4' label='Supplier Name' id='form1' type='text'value={supplierName} onChange={(e)=>{setsupplierName(e.target.value)}} />
                            <MDBInput wrapperClass='mb-4' label='Date' id='form1' type='date' value={dateOfIngredientAdded} onChange={(e)=>{setdateOfIngredientAdded(e.target.value)}}/>
                            <MDBBtn size='md'  onClick={updateInventory}>Update Record</MDBBtn>
                        </MDBCardBody>
                    </MDBCard>
                </MDBCol>
            </MDBRow>
        </MDBContainer>
        <ToastContainer/>
    </>);
}

export default EditInventory;