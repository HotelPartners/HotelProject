import { MDBBtn } from "mdb-react-ui-kit";
import { useEffect, useState } from "react";
import { getAddressApi } from "../Services/addAddressApi";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import Header from "./Header";

function CustomerDileveryAddress() {
    const [allAddress, setAllAddress] = useState([]);
    const [selectedAddress, setSelectedAddress] = useState(null);
    const navigate=useNavigate();
    useEffect(() => {
        fetchAddress();
    }, []);

    const fetchAddress = async () => {
        const response = await getAddressApi();
        sessionStorage.removeItem("gotodileveryaddress");
        console.log(response);
        if (response != '') {
            setAllAddress(response);
        } else {
            navigate('/add_address')
        }
    };

    const handleAddressSelect = (address) => {
        setSelectedAddress(address);
    };

    const handleSubmit = () => {
        if (selectedAddress) {
            sessionStorage.setItem("selectedAddress",JSON.stringify(selectedAddress));
            navigate('/orderdetails')
        } else {
            toast.error("Please Select Address")
        }
    };
  

    return (
        <>
        <Header />
            <center>
                <div className="container">
                    <br />
                    <h2>Delivery Address</h2>
                    <br />
                   <br />
                   <br />
                    <div className="table-responsive">
                        <table className="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Address</th>
                                    <th>Landmark</th>
                                    <th>City</th>
                                    <th>Pincode</th>
                                    <th>Select</th>
                                </tr>
                            </thead>
                            <tbody>
                                {allAddress.map((customer) => (
                                    <tr key={customer.addressId}>
                                        <td>{customer.addressLine}</td>
                                        <td>{customer.landmark}</td>
                                        <td>{customer.city}</td>
                                        <td>{customer.pincode}</td>
                                        <td>
                                            <input
                                                type="radio"
                                                name="address"
                                                onChange={() => handleAddressSelect(customer)}
                                                checked={selectedAddress === customer}
                                            />
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                        <MDBBtn className="" color="primary" onClick={handleSubmit}>
                            Continue
                        </MDBBtn>
                    </div>
                </div>
            </center>
        </>
    );
}

export default CustomerDileveryAddress;
