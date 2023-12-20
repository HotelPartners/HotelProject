import React, { useEffect, useState } from "react";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useNavigate } from "react-router-dom";
import { MDBBtn, MDBBtnGroup } from "mdb-react-ui-kit";
import { showInventoryApi, deleteInventoryApi } from "../Services/addInventoryApi";
import AdminHeader from "./AdminHeader";

function Inventory() {
    const [inventory, setInventory] = useState([]);
    const [searchQuery, setSearchQuery] = useState('');
    const navigate = useNavigate();

    useEffect(() => {
        showInventory();
    }, []);

    const showInventory = async () => {
        const responseData = await showInventoryApi();
        if (responseData != null) {
            setInventory(responseData);
        }
    }

    const handleSearch = (e) => {
    const isBackspace = e.keyCode === 8 || e.key === 'Backspace';
    
    if (searchQuery.trim() === '' && isBackspace) {
        // If the search query is empty and Backspace is pressed, show the entire inventory
        showInventory();
    } else if (!isBackspace) {
        // Filter the inventory based on the search query when any key other than Backspace is pressed
        const filteredInventory = inventory.filter(item => {
            const lowerSearchQuery = searchQuery.toLowerCase();

            // Check if any property of the item contains the search query
            return Object.values(item).some(value =>
                value.toString().toLowerCase().includes(lowerSearchQuery)
            );
        });
        setInventory(filteredInventory);
    }
};


    const editInventory = async (inventoryId) => {
        sessionStorage.setItem('inventoryId', inventoryId);
        navigate('/editinventory');
    }

    const deleteInventory = async (inventoryId) => {
        const responseData = await deleteInventoryApi(inventoryId);
        toast.success("Inventory deleted successfully");
        setTimeout(() => {
            window.location.reload();
        }, 3000);
    }

    const redirectToAddInventory = () => {
        navigate('/addinventory');
    }

    return (
        <>
        <AdminHeader/>
            <center>
                <div className="container">
                <br/>
                    <h2>Inventory</h2>
                    <div className="table-responsive">
                        <br />
                     
                        <input
                            type="text"
                            placeholder="Search..."
                            value={searchQuery}
                            onChange={(e) => setSearchQuery(e.target.value)}
                            onKeyDown={handleSearch} // Add this line
                        />
                        <MDBBtn link='primary' size="sm" onClick={handleSearch}>Search</MDBBtn>
                        <br />
                        <br />
                        <MDBBtn link='primary' size="sm" onClick={redirectToAddInventory} style={{ float: "right" }}>Add Inventory</MDBBtn>
                        <table className="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Item Name</th>
                                    <th>Quantity</th>
                                    <th>Supplier Name</th>
                                    <th>Date</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {inventory.map((item) => (
                                    <tr key={item.ingredientId}>
                                        <td>{item.ingredientName}</td>
                                        <td>{item.ingredientCapacity}</td>
                                        <td>{item.supplierName}</td>
                                        <td>{item.dateOfIngredientAdded}</td>
                                        <td>
                                            <MDBBtnGroup aria-label='Basic example'>
                                                <MDBBtn color="warning" size='sm' onClick={() => { editInventory(item.ingredientId) }}>Edit</MDBBtn>
                                                <MDBBtn color="danger" size='sm' onClick={() => { deleteInventory(item.ingredientId) }}>Delete</MDBBtn>
                                            </MDBBtnGroup>
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </center>
            <ToastContainer position="top-center" />
        </>
    );
}

export default Inventory;
