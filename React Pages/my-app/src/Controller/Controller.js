import { BrowserRouter, Route, Routes } from "react-router-dom";
import EditProfile from "../Components/EditProfile";
import Home from "../Components/Home";
import Booking from "../Components/Booking";
import Cart from "../Components/Cart";
import About from "../Components/About";
import Contact from "../Components/Contact";
import Login from "../Components/Login";
import SignUp from "../Components/SignUp";
import Header from "../Components/Header";
import Footer from "../Components/Footer";
import AdminFoodMenu from "../Components/AdminFoodMenu";
import AddAddress from "../Components/AddAddress";
import UserORecords from "../Components/UserORecords";
import Facebook from "../Components/Facebook";
import Twitter from "../Components/Twitter";
import Instagram from "../Components/Instagram";
import Admin from "../Components/Admin";

function Controller() {
    return (<>
        <BrowserRouter>
            <Header />
            <Routes>
                <Route exact path="/" element={<Home />} />
                <Route exact path="/booking" element={<Booking />} />
                <Route exact path="/menu" element={<AdminFoodMenu />} />
                <Route exact path="/editprofile" element={<EditProfile />} />
                <Route exact path="/orders" element={<UserORecords />} />
                <Route exact path="/cart" element={<Cart />} />
                <Route exact path="/about" element={<About />} />
                <Route exact path="/contact" element={<Contact />} />
                <Route exact path="/login" element={<Login />} />
                <Route exact path="/signup" element={<SignUp />} />
                <Route exact path="/add_address" element={<AddAddress />} />
                <Route exact path="/facebook" element={<Facebook/>} />
                <Route exact path="/twitter" element={<Twitter/>} />
                <Route exact path="/instagram" element={<Instagram/>} />
                <Route exact path="/admin_home" element={<Admin/>} />
            </Routes>
            <Footer />
        </BrowserRouter>
    </>);
}

export default Controller;