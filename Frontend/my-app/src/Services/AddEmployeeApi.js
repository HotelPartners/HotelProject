import axios from "axios";
import { createUrl } from "../utils/utils";

export async function AddEmployeeApi(firstName,lastName,address,mobileNumber,salary,role,joiningDate)
{
  const token=sessionStorage.getItem("token");

    const url=createUrl('/employee/add-employee/'+role);
    const body={firstName,lastName,address,mobileNumber,salary,joiningDate};
    try{
        const response= await axios.post(url,body,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        return 'success';
    }
    catch(ex)
    {
        return 'error';
    }
}

export async function ShowEmployeesApi()
{
  const token=sessionStorage.getItem("token");
    const url=createUrl('/employee/show-employees');
    try{
        const response=await axios.get(url,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        return response.data;
    }
    catch(ex)
    {
        return null;
    }
}

export async function DeleteEmployeeApi(empid)
{
  const token=sessionStorage.getItem("token");
    const url=createUrl('/employee/delete-employee/'+empid);
    try{
        const response=await axios.delete(url,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        console.log(response.data);
        return "success";
    }
    catch(ex){
        return "error";
    }
}

export async function fetchDataApi(empId)
{
  const token=sessionStorage.getItem("token");
    const url=createUrl("/employee/getEmployee/"+empId);
    try{
        const response=await axios.get(url,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        return response.data;
    }
    catch(ex)
    {
        return null;    
    }
}

export async function updateEmployeeApi(firstName,lastName,mobileNumber,address,salary,department,joiningDate,empId)
{
  const token=sessionStorage.getItem("token");
  
    const url=createUrl('/employee/update-employee/'+empId);
    const body={firstName,lastName,mobileNumber,address,salary,department,joiningDate};
    try{
        const response =await axios.put(url,body,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          }); 
        return response.data;
    }
    catch(ex)
    {
        return "error";
    }
}