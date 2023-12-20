import axios from 'axios';
import { createUrl } from '../utils/utils';


export async function addAddressApi(addressLine,landmark,city,pincode)
{
  const token=sessionStorage.getItem("token");
    const url =createUrl(`/address/${token}`);
    const body={addressLine,landmark,city,pincode};
 
    try{
        const response=await axios.post(url,body, {
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

export async function getAddressApi()
{
  const token=sessionStorage.getItem("token");
    const url=createUrl(`/address/get-address/${token}`)

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


