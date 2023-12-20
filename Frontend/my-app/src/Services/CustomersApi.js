import axios from "axios";
import { createUrl } from "../utils/utils";

export async function fetchCustomersApi()
{
  const token=sessionStorage.getItem("token");
    const url=createUrl("/users/all-customers");

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