import { BrowserRouter, Route, Routes } from "react-router-dom";
import EditProfile from "../Components/EditProfile";
import Home from "../Components/Home";
import Booking from "../Components/Booking";
import Cart from "../Components/Cart";
import About from "../Components/About";
import Contact from "../Components/Contact";
import Login from "../Components/Login";
import SignUp from "../Components/SignUp";
import AdminHeader from "../Components/AdminHeader";
import Header from "../Components/Header";
import Footer from "../Components/Footer";
import AdminFoodMenu from "../Components/AdminFoodMenu";
import AddAddress from "../Components/AddAddress";
import UserORecords from "../Components/UserORecords";
import Facebook from "../Components/Facebook";
import Twitter from "../Components/Twitter";
import Instagram from "../Components/Instagram";
import Employee from "../Components/Employee";
import AddEmployee from "../Components/AddEmployee";
import EditEmployee from "../Components/EditEmployee";
import { useEffect, useState } from "react";
import CustomerDetails from "../Components/CustomerDetails";
import CustomerMenu from "../Components/CustomerMenu";
import AddSupplier from "../Components/AddSupplier";
import Inventory from "../Components/Inventory";
import AddInventory from "../Components/AddInventory";
import Supplier from "../Components/Supplier"
import EditSupplier from "../Components/EditSupplier"
import EditInventory from "../Components/EditInventory"
import CustomerAddress from "../Components/CustomerAddress";
import AddMenu from "../Components/AddMenu";
import BookingDetails from "../Components/BookingDetails";
import CustomerDileveryAddress from "../Components/DileveryAddress";
import OrderList from "../Components/OrderList";
import ViewOrder from "../Components/ViewOrder";
import AdminOrderDetails from "../Components/AdminOrderDetails";
import AdminTableDetails from "../Components/AdminTableDetails";
import ProtectedRoute from "./ProtectedRoute";
import CustomerHome from "../Components/CustomerHome";
import AdminHome from "../Components/AdminHome";


function Controller() {



    return (<>
        <BrowserRouter>
            
            <Routes>
                <Route />
                <Route exact path="/login" element={<Login />} />
                <Route exact path="/signup" element={<SignUp />} />
                <Route exact path="/" element={<Home />} />

                {/* Admin protected route */}
                <Route element={<ProtectedRoute allowedRoles={['ADMIN']} />}
                >
                    <Route exact path="/adminhome" element={<AdminHome/>}/>
                    <Route exact path="/menu" element={<AdminFoodMenu />} />
                    <Route exact path="/bills" element={<AdminOrderDetails />} />
                    <Route exact path="/addsupplier" element={<AddSupplier />} />
                    <Route exact path="/addmenu" element={<AddMenu />} />
                    <Route exact path="/inventory" element={<Inventory />} />
                    <Route exact path="/addinventory" element={<AddInventory />} />
                    <Route exact path="/supplier" element={<Supplier />} />
                    <Route exact path="/editsupplier" element={<EditSupplier />} />
                    <Route exact path="/editinventory" element={<EditInventory />} />
                    <Route path="/admintabledetails" element={<AdminTableDetails />} />
                    <Route exact path="/employee" element={<Employee />} />
                    <Route exact path="/customer" element={<CustomerDetails />} />
                    <Route exact path="/addemployee" element={<AddEmployee />} />
                    <Route exact path="/editemployee" element={<EditEmployee />} />
                </Route>

                {/* Customer protected route */}
                <Route element={<ProtectedRoute allowedRoles={['CUSTOMER']} />}
                >
                    <Route exact path="/customerhome" element={<CustomerHome/>}/>
                    <Route exact path="/booking" element={<Booking />} />
                    <Route exact path="/editprofile" element={<EditProfile />} />
                    <Route exact path="/orders" element={<UserORecords />} />
                    <Route exact path="/cart" element={<Cart />} />
                    <Route exact path="/add_address" element={<AddAddress />} />
                    <Route exact path="/dileveryaddress" element={<CustomerDileveryAddress />} />
                    <Route exact path="/customeraddress" element={<CustomerAddress />} />
                   
                    <Route exact path="/customermenu" element={<CustomerMenu />} />
                    <Route exact path="/bookingdetails" element={<BookingDetails />} />
                </Route>


                <Route exact path="/about" element={<About />} />
                <Route exact path="/contact" element={<Contact />} />
                <Route exact path="/facebook" element={<Facebook />} />
                <Route exact path="/twitter" element={<Twitter />} />
                <Route exact path="/instagram" element={<Instagram />} />







                <Route exact path="/orderdetails" element={<OrderList />} />
                <Route path="/vieworderdetails/:orderId" element={<ViewOrder />} />
            </Routes>
            <Footer />
        </BrowserRouter>
    </>);
}

export default Controller;