import { MDBBtn, MDBCard, MDBCardBody, MDBCardImage, MDBCardText, MDBCardTitle, MDBCol, MDBRow } from "mdb-react-ui-kit";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { ToastContainer,toast } from "react-toastify";
import { fetchCategoryApi, fetchMenuApi, removeItemApi } from "../Services/Menu";
import AdminHeader from "./AdminHeader";


function AdminFoodMenu() {
    const [category, setCategory] = useState([]);
    const [menu, setMenu] = useState([]);

    const navigate=useNavigate();
    const AddFoodItem=async()=>
    {
        navigate('/addmenu');
    }
    useEffect(() => {
        FetchCategory();
    }, []);

    const FetchCategory = async () => {
        const responseData = await fetchCategoryApi();
        // console.log(responseData);
        if (responseData != null) {
            setCategory(responseData);
            FetchMenu("BREAKFAST")
        } else {
            setCategory([]);
        }
    }

    const deleteMenu=async(itemId)=>{
        console.log(itemId);
        const responseData=await removeItemApi(itemId);
        if(responseData!=null)
        {
            toast.success("Menu deleted successfully");
             FetchCategory();
        }
    }

    const FetchMenu = async (categoryName) => {
        const responseData = await fetchMenuApi(categoryName);
        // console.log(responseData);
        if (responseData != null) {
            setMenu(responseData);
        } else {
            setMenu([]);
        }
    }

    return (<>
    <AdminHeader/>
        <div className="container">
            <center>
            <br/>
                <h2>Menu</h2>
                <div className="d-grid gap-2 d-md-flex justify-content-md-end">
                    <button className="btn btn-primary m-2" onClick={AddFoodItem}>Add Item</button>
                </div>
                <div className="table-responsive">
                    <table className="table table-bordered">
                        <tbody>
                            <tr>
                                <td rowSpan={8} style={{ "width": "10%" }}>
                                    {category.map((cat) => (
                                        <tr style={{ 'border': '2px' }}>
                                            <td className='btn btn-light' style={{ "width": "150px" }} onClick={() => FetchMenu(cat.categoryName)}>{cat.categoryName}</td>
                                        </tr>
                                    ))}
                                </td>
                                <td className='md'>
                                    <MDBRow className='g-0'>
                                        {menu.map((me) => (
                                            <MDBCard style={{ maxWidth: '425px' }} className='m-2' key={me.itemId}>
                                                <MDBRow className='g-0'>
                                                    <MDBCol md='4'>
                                                        <MDBCardImage src={`data:image/jpeg;base64,${me.itemImage}`} style={{ height: '150px' }} alt='...' fluid />
                                                    </MDBCol>
                                                    <MDBCol md='8'>
                                                        <MDBCardBody>
                                                            <MDBCardTitle>{me.itemName}</MDBCardTitle>
                                                            <MDBCardText>
                                                                ₹ {me.price}
                                                            </MDBCardText>
                                                    <MDBCol>
                                                    <button className="btn btn-primary m-2"  onClick={()=>{deleteMenu(me.itemId)}}>Remove Item</button>
                                                    </MDBCol>
                                                        </MDBCardBody>
                                                    </MDBCol>
                                                </MDBRow>
                                            </MDBCard>
                                        ))}
                                    </MDBRow>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
           
            </center>
        </div>
        <ToastContainer  position="top-center"/>
    </>);
}

export default AdminFoodMenu;