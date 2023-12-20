import axios from "axios";
import { createUrl } from "../utils/utils";

export async function loadUserDataApi()
{
    const token=sessionStorage.getItem("token");

    const url=createUrl('/users/'+token);
    try{
        const response= await axios(url,{
            headers: {
                Authorization: `Bearer ${token}`,
            },
        });
        console.log(response.data.userEmail+"_____________________________++++++++")
        return response;
    }
    catch(ex)
    {
        return "error";
    }
}

export async function updateProfileApi(firstName,lastName,mobileNumber,password,userEmail)
{
    const token=sessionStorage.getItem("token");
    const url=createUrl('/users/update-user/'+token);
    const body={firstName,lastName,userEmail,mobileNumber,password};

    try{
        const response=await axios.put(url,body,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        return response;
    }
    catch(ex)
    {
        return "error";
    }
}

export async function getUserByIDApi()
{
    const token=sessionStorage.getItem("token");
    const url=createUrl('/users/'+token);

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
        return "error";
    }
}