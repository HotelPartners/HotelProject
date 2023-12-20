import axios from 'axios';
import { createUrl } from '../utils/utils';

export async function AddMenuApi(itemName,price,mealchoice,category)
{
  const token=sessionStorage.getItem("token");
    const url=createUrl("/menu/additem/"+category)
    const body ={itemName,price,mealchoice};

    try{

        const response=await axios.post(url,body,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        
        return response.data;
    }
    catch(ex)
    {
        return 0;
    }
}

export async function uploadImageApi(itemId,Image)
{
  const token=sessionStorage.getItem("token");
    const url=createUrl(`/menu/${itemId}/image`);
    let formData=new FormData();
    formData.append('imageFile',Image)
    try{
        const response =await axios.post(url,formData,{
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