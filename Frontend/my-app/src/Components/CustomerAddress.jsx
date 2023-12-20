import { useEffect, useState } from "react";
import { getAddressApi } from "../Services/addAddressApi";
import { useNavigate } from "react-router-dom";
import { MDBBtn } from "mdb-react-ui-kit";
import Header from "./Header";

function CustomerAddress() {

    const navigate=useNavigate() ;
    const [allAddress, setAllAddress] = useState([]);
    var index=1;
    useEffect(()=>{fetchAddress()},[])

    const fetchAddress=async()=>
    {
        const response=await getAddressApi();
        console.log(response);
        if(response!=null)
        {
            console.log(allAddress);
            setAllAddress(response);
        }
        else
        {
            console.log("unable to fetch address")
        }
    }

    const redirectToAddAddress=()=>
    {
        navigate('/add_address')
    }
    return (<>
    <Header />
        <center>

            <div className="container">
                <br></br>
                <h2>Address</h2>
                <MDBBtn link='primary' size="sm" onClick={redirectToAddAddress} style={{float:"right"}}>Add Address</MDBBtn>
                    <br/>
                    <br/>
                <div className="table-responsive">
                    <table className="table table-bordered">
                        <thead>
                            <tr>
                                <th>Address Id</th>
                                <th>Address</th>
                                <th>Landmark</th>
                                <th>City</th>
                                <th>Pincode</th>
                            </tr>
                        </thead>
                        <tbody>
                          {allAddress.map((customer)=>(  <tr>
                                    <td>{index++}</td>
                                    <td>{customer.addressLine}</td>
                                    <td>{customer.landmark}</td>
                                    <td>{customer.city}</td>
                                    <td>{customer.pincode}</td>
                                </tr>))}
                              
                       
                        </tbody>
                    </table>
                </div>
            </div>
        </center>
    </>);
}

export default CustomerAddress;