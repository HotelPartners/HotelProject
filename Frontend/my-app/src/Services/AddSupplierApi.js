import axios from "axios";
import { createUrl } from "../utils/utils";

export async function addSupplierApi(supplierName,supplierContact,supplierAddress,shopType)
{
  const token=sessionStorage.getItem("token");
    const url =createUrl('/supplier/addsupplier');
    const body={supplierName,supplierContact,supplierAddress,shopType};
    try{
        const response = axios.post(url,body,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        return "success";

    }
    catch(ex)
    {
        return "error";
    }

}

export async function showSupplierApi(){
  const token=sessionStorage.getItem("token");
    const url = createUrl('/supplier/allsuppliers');
    try{
        const response = await axios.get(url,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        return response.data;
    }catch(ex){
        return null;
    }
}

export async function deleteSupplierApi(supplierId)
{
  const token=sessionStorage.getItem("token");
    const url=createUrl('/supplier/deletesupplier/'+supplierId);
    try{
        const response=await axios.delete(url,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        return "success";
    }
    catch(ex){
        return "error";
    }
}


export async function fetchSupplierDataApi(supplierId)
{
  const token=sessionStorage.getItem("token");
    const url=createUrl('/supplier/edit/'+supplierId);
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




export async function updateSupplierApi(supplierName,supplierContact,supplierAddress,shopType,supplierId)
{
  const token=sessionStorage.getItem("token");
  
    const url=createUrl('/supplier/update/'+supplierId);
    const body={supplierName,supplierContact,supplierAddress,shopType};
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
