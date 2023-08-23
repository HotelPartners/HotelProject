
function Cart() {

    return (<>
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
                        <tr>
                            <th scope="row">Pizza</th>
                            <td><button className="btn btn-primary">+</button><input type="number" value={2} disabled style={{height : "35px"}}/><button className="btn btn-primary">-</button></td>
                            <td>50</td>
                            <td>100</td>
                        </tr>
                        <tr>
                            <th scope="row">Pizza</th>
                            <td><button className="btn btn-primary">+</button><input type="number" value={2} disabled style={{height : "35px"}}/><button className="btn btn-primary">-</button></td>
                            <td>50</td>
                            <td>100</td>
                        </tr>
                        <tr>
                            <th scope="row">Pizza</th>
                            <td><button className="btn btn-primary">+</button><input type="number" value={2} disabled style={{height : "35px"}}/><button className="btn btn-primary">-</button></td>
                            <td>50</td>
                            <td>100</td>
                        </tr>
                        <tr>
                            <th>Total Qty :</th>
                            <th>8</th>
                            <th>Total :</th>
                            <th>400</th>
                        </tr>
                        <tr>
                            <td>Choose Delivery Method : </td>
                            <td><select class="form-select" aria-label="Default select example">
                                <option selected>Delivery Method</option>
                                <option value="Home Delivery">Home Delivery</option>
                                <option value="Pick Up">Pick Up</option>
                            </select></td>
                        </tr>
                        <tr>
                            <td>Choose Payment Method : </td>
                            <td><select class="form-select" aria-label="Default select example">
                                <option selected>Payment Method</option>
                                <option value="Cash">Cash</option>
                                <option value="UPI">UPI</option>
                            </select></td>
                        </tr>
                        <tr>
                            <td colSpan={4}><button className="btn btn-primary">Place Order</button></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </center>
    </>);
}

export default Cart;