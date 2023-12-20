import axios from "axios";
import { createUrl } from "../utils/utils";

export async function fetchCategoryApi()
{
  const token=sessionStorage.getItem("token");
    const url = createUrl('/category');

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

export async function removeItemApi(itemId)
{
  const token=sessionStorage.getItem("token");
    const url = createUrl(`/menu/deletemenu/${itemId}`);
    try{
        const response=await axios.delete(url,{
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

export async function fetchMenuApi(categoryName)
{
  const token=sessionStorage.getItem("token");
    const url =createUrl("/menu/"+categoryName);
    
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

export async function fetchImage()
{

}

export async function sendCategoryNameApi(categoryName)
{
  const token=sessionStorage.getItem("token");
    const url=createUrl('/menu-item/'+categoryName);
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