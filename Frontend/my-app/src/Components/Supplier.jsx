import { useEffect, useState } from "react";
import { deleteSupplierApi, editSupplierApi, showSupplierApi } from "../Services/AddSupplierApi";
import { MDBBtn, MDBBtnGroup } from "mdb-react-ui-kit";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useNavigate } from "react-router-dom";
import AdminHeader from "./AdminHeader";



function Supplier() {

    const [suppliers, setSupplier] = useState([]);
    const [searchQuery, setSearchQuery] = useState("");
    const [filteredSuppliers, setFilteredSuppliers] = useState([]);
    const navigate = useNavigate();
    // useEffect(() => { showSupplier() },[])
    useEffect(()=>{showSupplier()},[])

    const showSupplier = async () => {
        const responseData = await showSupplierApi();
        if (responseData != null) {
            setSupplier(responseData);
        }
    }

    const deleteSupplier = async (supplierId) => {
        const responseData = await deleteSupplierApi(supplierId);
        if (responseData === 'success') {
            toast.success("Supplier Deleted Successfully!!")
            setTimeout(()=>{window.location.reload();},5000)
        }
    }



    const editSupplier = async (supplierId) =>{
        

        sessionStorage.setItem('supplierId',supplierId);
            navigate('/editsupplier')
        }
    
        const redirectToAddSupplier=()=>
        {
            navigate('/addsupplier');
        }

        const handleSearch = () => {
            if (searchQuery.trim() === "") {
                setFilteredSuppliers(suppliers); // Show all employees when search is empty
            } else {
                const filteredSuppliers = suppliers.filter((supplier) =>
                    Object.values(supplier).some((value) =>
                        value.toString().toLowerCase().includes(searchQuery.toLowerCase())
                    )
                );
                setSupplier(filteredSuppliers);
            }
        };
        const handleKeyDown = (e) => {
            if (e.key === "Backspace" && searchQuery.trim() === "") {
                showSupplier();}
        };

    return (<><AdminHeader/>
        <center>
            <div className="container">
            <br/>
            
        
                <h2>Supplier Details</h2>
                <br/>
                    
                <div className="table-responsive">
                   
                   <center>   
                <input
                    type="text"
                    placeholder="Search..."
                    value={searchQuery}
                    onChange={(e) => setSearchQuery(e.target.value)}
                    onKeyDown={handleKeyDown}
                />
                <MDBBtn link='primary' size="sm" onClick={handleSearch}>Search</MDBBtn>
            </center>
            <br/>
            <br/>
            <center>
                       
                       <MDBBtn link='primary' size="sm" onClick={redirectToAddSupplier} style={{float:"right"}}>Add Supplier</MDBBtn>
                    <table className="table table-bordered">
                        <thead>
                            <tr>
                                <th>Supplier Name</th>
                                <th>Address</th>
                                <th>Contact No.</th>
                                <th>Shop Type</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {suppliers.map((supplier) => (
                                <tr>
                                    <td>{supplier.supplierName}</td>
                                    <td>{supplier.supplierAddress}</td>
                                    <td>{supplier.supplierContact}</td>
                                    <td>{supplier.shopType}</td>
                                    <td>
                                        <MDBBtnGroup aria-label='Basic example'>
                                            <MDBBtn color="warning" size='sm' onClick={()=>{editSupplier(supplier.supplierId)}}>Edit</MDBBtn>
                                            <MDBBtn color="danger" size='sm' onClick={()=>{deleteSupplier(supplier.supplierId)}}>Delete</MDBBtn>
                                        </MDBBtnGroup>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                            </center>
                </div>
            </div>
        </center>
        <ToastContainer position="top-center"/>
    </>);
}

export default Supplier;