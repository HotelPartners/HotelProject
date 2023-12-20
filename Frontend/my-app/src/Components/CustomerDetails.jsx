import React, { useEffect, useState } from "react";
import { fetchCustomersApi } from "../Services/CustomersApi";
import { MDBBtn } from "mdb-react-ui-kit";
import Header from "./Header";
import AdminHeader from "./AdminHeader";

function CustomerDetails() {
    const [allCustomers, setAllCustomers] = useState([]);
    const [searchQuery, setSearchQuery] = useState("");
    const [filteredCustomers, setFilteredCustomers] = useState([]);

    useEffect(() => {
        fetchCustomers();
    }, []);

    useEffect(() => {
        handleSearch();
    }, [allCustomers]);

    const fetchCustomers = async () => {
        const responseData = await fetchCustomersApi();
        if(responseData!=null)
        setAllCustomers(responseData);
        
    };

    const handleSearch = () => {
        if (searchQuery.trim() === "") {
            setFilteredCustomers(allCustomers);
        } else {
            const filteredCustomers = allCustomers.filter((customer) =>
                Object.values(customer).some((value) =>
                    value.toString().toLowerCase().includes(searchQuery.toLowerCase())
                )
            );
            setFilteredCustomers(filteredCustomers);
        }
    };

    const handleKeyDown = (e) => {
        if (e.key === "Backspace" && searchQuery.trim() === "") {
            setFilteredCustomers(allCustomers);
        }
    };

    return (
        <>
        <AdminHeader />
            <center>
                <div className="container">
                <br/>
                    
                    <h2>Customer Details</h2>
                    <br/>
                    
                    <div className="table-responsive">
                        <input
                            type="text"
                            placeholder="Search..."
                            value={searchQuery}
                            onChange={(e) => setSearchQuery(e.target.value)}
                            onKeyDown={handleKeyDown}
                        />
                        <MDBBtn link='primary' size="sm" onClick={handleSearch} >Search</MDBBtn>
                   <br />
                   <br />
                        <table className="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Customer Id</th>
                                    <th>Customer Name</th>
                                    <th>Email</th>
                                    <th>Contact No.</th>
                                </tr>
                            </thead>
                            <tbody>
                                {filteredCustomers.map((customer) => (
                                    <tr key={customer.userId}>
                                        <td>{customer.userId}</td>
                                        <td>{customer.firstName + " " + customer.lastName}</td>
                                        <td>{customer.userEmail}</td>
                                        <td>{customer.mobileNumber}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </center>
        </>
    );
}

export default CustomerDetails;
