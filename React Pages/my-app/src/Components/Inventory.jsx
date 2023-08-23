import Footer from "./Footer";
import Header from "./Header";

function Inventory() {
    return ( <>
        <center>

            <div className="container">
                <h2>Inventory</h2>
                <div className="table-responsive">
                    <table className="table table-bordered">
                        <thead>
                        <tr>
                            <th>Item Id</th>
                            <th>Item Name</th>
                            <th>Quantity</th>
                            <th>Total Amount</th>
                            <th colSpan={2}>Date</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Item Name</td>
                            <td>Item Id</td>
                            <td>Quantity</td>
                            <td>Total Amount</td>
                            <td>Date</td>
                            <td><button className="btn btn-primary">Edit</button></td>
                        </tr>
                        <tr>
                            <td>Item Name</td>
                            <td>Item Id</td>
                            <td>Quantity</td>
                            <td>Total Amount</td>
                            <td>Date</td>
                            <td><button className="btn btn-primary">Edit</button></td>
                        </tr>
                        <tr>
                            <td>Item Name</td>
                            <td>Item Id</td>
                            <td>Quantity</td>
                            <td>Total Amount</td>
                            <td>Date</td>
                            <td><button className="btn btn-primary">Edit</button></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </center>
    </> );
}

export default Inventory;