import axios from "axios";
import { createUrl } from "../utils/utils";

export async function  placeOrderApi(userId,addressId,paymentType,totalprice,totalqty,itemsDTOs)
{
  const token=sessionStorage.getItem("token");
    const url = createUrl('/order/add-Order');
    const body={userId,addressId,totalprice,totalqty,paymentType,itemsDTOs};
    try{
        const response=await axios.post(url,body,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        return response.status;
    }
    catch(ex)
    {
        return null;
    }
}

export async function getOrdersByIdApi()
{
  const token=sessionStorage.getItem("token");
    const url=createUrl("/order/get-orders-by-userid/"+token);
    try{
        const response=await axios.get(url,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        return response;
    }catch(ex)
    {
        return null;
    }
}

export async function vieworderApi(orderId)
{
  const token=sessionStorage.getItem("token");
    const url =createUrl("/order/get-order-by-orderId/"+orderId);
    try{
        const response=await axios.get(url,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        return response;
    }
    catch(ex)
    {
        return null;
    }
}

export async function deleteOrderRecordApi(orderId)
{
  const token=sessionStorage.getItem("token");
    const url=createUrl("/order/delete-order-record/"+orderId);
    try{
        const response=await axios.delete(url,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        return response;

    }catch(ex)
    {
        return null;
    }
}

export async function getAllOrdersDetailsApi()
{
  const token=sessionStorage.getItem("token");
    const url=createUrl("/order/get-all-orders");
    try{
        const response=await axios.get(url,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        return response;
    }catch(ex)
    {
        return null;
    }
}

export async function updateStatus(orderId,orderstatus)
{
  const token=sessionStorage.getItem("token");
    const url=createUrl("/order/update-status/"+orderId+"/"+orderstatus);
    try{
    const response=await axios.put(url,{},{
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      return response;
    }
    catch(ex){
    return null;
    }
}