import { MDBBtn, MDBTable, MDBTableBody, MDBTableHead } from "mdb-react-ui-kit";

function Employee() {
    return (<>
        <MDBTable align='middle'>
            <MDBTableHead>
                <tr>
                    <th scope='col'>Name</th>
                    <th scope='col'>Address</th>
                    <th scope='col'>Phone No.</th>
                    <th scope='col'>Salary</th>
                    <th scope='col'>Role</th>
                    <th scope='col'>Joining Date</th>
                    <th scope='col'>Actions</th>
                </tr>
            </MDBTableHead>
            <MDBTableBody>
                <tr>
                    <td>
                        <div className='d-flex align-items-center'>
                            <div className='ms-3'>
                                <p className='fw-bold mb-1'>Employee Name</p>
                                <p className='text-muted mb-0'>Employee Id</p>
                            </div>
                        </div>
                    </td>
                    <td>
                    <div className='d-flex align-items-center'>
                            <div className='ms-3'>
                                <p className='fw-bold mb-1'>Pune</p>
                                <p className='text-muted mb-0'>Maharashtra</p>
                            </div>
                        </div>
                    </td>
                    <td>
                        <p className='fw-normal mb-1'>123456789</p>
                    </td>
                    <td>1235456</td>
                    <td>
                        <p className='fw-normal mb-1'>Manager</p>
                    </td>
                    <td>
                        <p className='fw-normal mb-1'>10-02-2000</p>
                    </td>
                    <td>
                        <MDBBtn color='link' rounded size='sm'>
                            Edit
                        </MDBBtn>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div className='d-flex align-items-center'>
                            <div className='ms-3'>
                                <p className='fw-bold mb-1'>Employee Name</p>
                                <p className='text-muted mb-0'>Employee Id</p>
                            </div>
                        </div>
                    </td>
                    <td>
                    <div className='d-flex align-items-center'>
                            <div className='ms-3'>
                                <p className='fw-bold mb-1'>Pune</p>
                                <p className='text-muted mb-0'>Maharashtra</p>
                            </div>
                        </div>
                    </td>
                    <td>
                        <p className='fw-normal mb-1'>123456789</p>
                    </td>
                    <td>1235456</td>
                    <td>
                        <p className='fw-normal mb-1'>Manager</p>
                    </td>
                    <td>
                        <p className='fw-normal mb-1'>10-02-2000</p>
                    </td>
                    <td>
                        <MDBBtn color='link' rounded size='sm'>
                            Edit
                        </MDBBtn>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div className='d-flex align-items-center'>
                            <div className='ms-3'>
                                <p className='fw-bold mb-1'>Employee Name</p>
                                <p className='text-muted mb-0'>Employee Id</p>
                            </div>
                        </div>
                    </td>
                    <td>
                    <div className='d-flex align-items-center'>
                            <div className='ms-3'>
                                <p className='fw-bold mb-1'>Pune</p>
                                <p className='text-muted mb-0'>Maharashtra</p>
                            </div>
                        </div>
                    </td>
                    <td>
                        <p className='fw-normal mb-1'>123456789</p>
                    </td>
                    <td>1235456</td>
                    <td>
                        <p className='fw-normal mb-1'>Manager</p>
                    </td>
                    <td>
                        <p className='fw-normal mb-1'>10-02-2000</p>
                    </td>
                    <td>
                        <MDBBtn color='link' rounded size='sm'>
                            Edit
                        </MDBBtn>
                    </td>
                </tr>
            </MDBTableBody>
        </MDBTable>
    </>);
}

export default Employee;