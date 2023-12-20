import { MDBBtn } from 'mdb-react-ui-kit';
import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import Header from './Header';

function Cart() {
    const [cartItems, setCartItems] = useState([]);
    const [totalQty, setTotalQty] = useState(0);
    const [totalAmount, setTotalAmount] = useState(0);
    const navigate=useNavigate();
    useEffect(() => {
        const existingCart = JSON.parse(localStorage.getItem('cart')) || [];
        setCartItems(existingCart);
        calculateTotal(existingCart);
    }, []);

    const calculateTotal = (items) => {
        const qty = items.reduce((total, item) => total + item.quantity, 0);
        const amount = items.reduce((total, item) => total + item.price * item.quantity, 0);
        setTotalQty(qty);
        setTotalAmount(amount);
    };

    const updateQuantity = (index, newQuantity) => {
        const updatedCart = [...cartItems];
    
        if (newQuantity <= 0) {
            // Remove the item from the cart
            updatedCart.splice(index, 1);
        } else {
            updatedCart[index].quantity = newQuantity;
        }
    
        setCartItems(updatedCart);
        localStorage.setItem('cart', JSON.stringify(updatedCart));
        calculateTotal(updatedCart); // Pass the updatedCart to calculateTotal
    };
    
    

    const toSelectAddress=()=>
    {
        if(totalQty==0)
        toast.error("Please Add Items in Cart");
        else
        navigate("/dileveryaddress")
    }

    return (<>
    <Header />
        <center>
            <h1>Cart</h1>
            <div className="container table-bordered">
                <table className="table table-responsive">
                    <thead>
                        <tr className="table-warning">
                            <th scope="col">Item</th>
                            <th scope="col">Qty</th>
                            <th scope="col">Price</th>
                            <th scope="col">Total</th>
                        </tr>
                    </thead>
                    <tbody>
          
{cartItems.map((item, index) => (
    <tr key={index}>
        <th scope="row">{item.itemName}</th>
        <td>
            <div className="quantity-input">
                <MDBBtn 
                    className="quantity-button"
                    onClick={() => updateQuantity(index, item.quantity - 1)}
                >
                    -
                </MDBBtn>
                <input
                    type="number"
                    style={{ height: "35px" }}
                    value={item.quantity}
                    readOnly
                    min={0}
                />
                <MDBBtn 
                    className="quantity-button"
                    onClick={() => updateQuantity(index, item.quantity + 1)}
                >
                    +
                </MDBBtn >
            </div>
        </td>
        <td>{item.price}</td>
        <td>{item.price * item.quantity}</td>
    </tr>
))}


                        <tr>
                            <th>Total Qty :</th>
                            <th>{totalQty}</th>
                            <th>Total :</th>
                            <th>{totalAmount}</th>
                        </tr>
                        {/* Other rows for delivery method, payment method, and place order button */}
                    </tbody>
                </table>
        <MDBBtn className='' color='primary' onClick={toSelectAddress}>Continue</MDBBtn>
            </div>
        </center>
        
        </>
    );
}

export default Cart;
