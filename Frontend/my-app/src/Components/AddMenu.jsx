import { MDBBtn, MDBCard, MDBCardBody, MDBCol, MDBContainer, MDBInput, MDBRow } from "mdb-react-ui-kit";
import Footer from "./Footer";
import Header from "./Header";
import { useState } from "react";
import { AddMenuApi, uploadImageApi } from "../Services/addMenuApi";
import { ToastContainer, toast } from "react-toastify";
import AdminHeader from "./AdminHeader";

function AddMenu() {

    const [itemname,setItemName]=useState('');
    const [category,setCategory]=useState('');
    const [itemtype,setItemType]=useState('');
    const [itemprice,setItemPrice]=useState('');
    const [Image,setImage]=useState(null);

    const AddMenu=async()=>
    {
        if(itemname==='')
        {
            toast.error("Item Name Cannot Be Blank")
        }
        else if(category ==='Select Item Category')
        {
            toast.error("Please Select Category")
        }
        else if(itemtype ==='Select Item Type')
        {
            toast.error("Please Select Item Type")
        }
        else if(itemprice ==='')
        {
            toast.error("Please Enter Item Price")
        }
        else if (!Image) {
            toast.error("Please select an image");
            return;
        }
        else{

            const responseDatafromMenu=await AddMenuApi(itemname,itemprice,itemtype,category);
            
            if(responseDatafromMenu.itemId >0)
            {
                const responseDatafromImage=await uploadImageApi(responseDatafromMenu.itemId,Image);
                if(responseDatafromImage!=null)
                {
                    toast.success("Image Uploaded Successfully");
                }
            }
            else
            {
                toast.error("Image Upload Failed")
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
                            <h2 className="fw-bold mb-2 text-center">Add Item</h2>
                            <MDBInput wrapperClass='mb-4' label='Item Name' id='form1' type='text' onChange={(e)=>{setItemName(e.target.value)}} />
                            <MDBCol col='6'>
                                <select className="form-select mb-4" aria-label="Default select example" onChange={(e)=>{setCategory(e.target.value)}}>
                                    <option selected>Select Item Category</option>
                                    {/* BREAKFAST,SOUP,STARTER,MAIN_COURSE,RICE,DESSERT,HOT_DRINK,COLD_DRINK */}
                                    <option value="BREAKFAST">BREAKFAST</option>
                                    <option value="SOUP">SOUP</option>
                                    <option value="STARTER">STARTER</option>
                                    <option value="MAIN_COURSE">MAIN_COURSE</option>
                                    <option value="RICE">RICE</option>
                                    <option value="ROTI">ROTI</option>
                                    <option value="DESSERT">DESSERT</option>
                                    <option value="HOT_DRINK">HOT_DRINK</option>
                                    <option value="COLD_DRINK">COLD_DRINK</option>
                                </select>
                            </MDBCol>
                            <MDBCol col='6'>
                                <select className="form-select mb-4" aria-label="Default select example" onChange={(e)=>{setItemType(e.target.value)}}>
                                    <option selected>Select Item Type</option>
                                    <option value="veg">Veg</option>
                                    <option value="nonveg">Non-Veg</option>
                                </select>
                            </MDBCol>
                            <MDBInput wrapperClass='mb-4' label='Item Price' id='form1' type='number' onChange={(e)=>{setItemPrice(e.target.value)}}/>
                            <MDBInput wrapperClass='mb-4' id='form1' type='file' onChange={(e)=>{setImage(e.target.files[0])}}/>
                            
                            <br />
                            <br />
                            <MDBBtn size='md' onClick={AddMenu}>
                                Add Item
                            </MDBBtn>
                        </MDBCardBody>
                    </MDBCard>

                </MDBCol>
            </MDBRow>

        </MDBContainer>
       <ToastContainer position="top-center"/>
    </>);
}

export default AddMenu;