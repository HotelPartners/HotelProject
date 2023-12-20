import React, { useEffect, useState } from "react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useNavigate } from "react-router-dom";
import { MDBBtn, MDBBtnGroup } from "mdb-react-ui-kit";
import { DeleteEmployeeApi, ShowEmployeesApi } from "../Services/AddEmployeeApi";
import AdminHeader from "./AdminHeader";

function Employee() {
    const navigate = useNavigate();
    const [employees, setEmployees] = useState([]);
    const [searchQuery, setSearchQuery] = useState("");
    const [filteredEmployees, setFilteredEmployees] = useState([]);

    useEffect(() => {
        showEmployees();
    }, []);

    useEffect(() => {
        handleSearch();
    }, [employees]);

    const showEmployees = async () => {
        const responseData = await ShowEmployeesApi();
        if (responseData != null) {
            setEmployees(responseData);
            setFilteredEmployees(responseData); // Initialize filtered employees with all employees
        }
    };

    const deleteEmployee = async (empId) => {
        const responseData = await DeleteEmployeeApi(empId);
        if (responseData === "success") {
            toast.success("Employee Deleted Successfully");
            setTimeout(() => {
                window.location.reload();
            }, 5000);
        } else {
            // Handle error case
        }
    };

    const editemployee = async (empId) => {
        sessionStorage.setItem("empId", empId);
        navigate("/editemployee");
    };

    const redirectToAddEmployee = () => {
        navigate("/addemployee");
    };

    const handleSearch = () => {
        if (searchQuery.trim() === "") {
            setFilteredEmployees(employees); // Show all employees when search is empty
        } else {
            const filteredEmployees = employees.filter((employee) =>
                Object.values(employee).some((value) =>
                    value.toString().toLowerCase().includes(searchQuery.toLowerCase())
                )
            );
            setFilteredEmployees(filteredEmployees);
        }
    };
    const handleKeyDown = (e) => {
        if (e.key === "Backspace" && searchQuery.trim() === "") {
            setFilteredEmployees(employees); // Show all employees when Backspace is pressed in an empty search bar
        }
    };

    return (
        <>
        <AdminHeader/>
        <div className="table-responsive">
            <center>
                <br />
               
                <h2>Employee Details</h2>
                <br />
                <input
                    type="text"
                    placeholder="Search..."
                    value={searchQuery}
                    onChange={(e) => setSearchQuery(e.target.value)}
                    onKeyDown={handleKeyDown}
                />
                <MDBBtn link='primary' size="sm" onClick={handleSearch}>Search</MDBBtn>
            </center>
            <br />
            <br />
            <div className="container mx-auto">
                <div className="table-responsive">
            <MDBBtn link="primary" size="sm" onClick={redirectToAddEmployee} style={{ float: "right" }}>
                Add Employee
            </MDBBtn>
            
                    <table className="table table-bordered">
                        <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Address</th>
                                <th scope="col">Phone No.</th>
                                <th scope="col">Salary</th>
                                <th scope="col">Role</th>
                                <th scope="col">Joining Date</th>
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {filteredEmployees.map((employee) => (
                                <tr key={employee.empid}>
                                    <td>{employee.firstName} {employee.lastName}</td>
                                    <td>{employee.address}</td>
                                    <td>{employee.mobileNumber}</td>
                                    <td>{employee.salary}</td>
                                    <td>{employee.department}</td>
                                    <td>{employee.joiningDate}</td>
                                    <td>
                                        <MDBBtnGroup aria-label='Basic example'>
                                            <MDBBtn color="warning" size='sm' onClick={() => editemployee(employee.empid)}>Edit</MDBBtn>
                                            <MDBBtn color="danger" size='sm' onClick={() => deleteEmployee(employee.empid)}>Delete</MDBBtn>
                                        </MDBBtnGroup>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
            </div>
            <ToastContainer position="top-center" />
        </>
    );
}

export default Employee;
