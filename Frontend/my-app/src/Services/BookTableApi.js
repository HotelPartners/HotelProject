import axios from "axios";
import { createUrl } from "../utils/utils";


export async function bookTableApi(startTime, endTime, tableType, reservationDate){
  const token=sessionStorage.getItem("token");
    const url = createUrl(`/reservation/add-reservation/${token}/${tableType}`);
    const body = {
        startTime,
        endTime,
        reservationDate
    }
    try {
        const response = await axios.post(url, body,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        return response.data;
    } catch (error) {
      console.log("****************235")
        return null;
    }
}


export async function sendMailApi(userEmail,reservationDate,startTime,tableType,endTime)
{
  const token=sessionStorage.getItem("token");
    const url="http://127.0.0.1:5000/send-mail";
    const details={
       email:userEmail,
       reservationDate:reservationDate,
       startTime:startTime,
       tableType:tableType,
       endTime:endTime
    }

    try{
        const response=await axios.post(url,details,{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
        return "success"
    }
    catch(ex)
    {
        return "fail"
    }
}

export async function FetchBookingDetailsApi()
{
  const token=sessionStorage.getItem("token");
    const url=createUrl("/reservation/"+token);
    
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
        console.log(ex);
        return null;
    }
}

export async function CancelBookingApi(userId,tableNo,reservationDate,startTime,endTime,tableType)
{
  const token=sessionStorage.getItem("token");
    const url=createUrl("/reservation/cancel-reservation");
    const body={userId,tableNo,reservationDate,startTime,endTime,tableType};
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
        return null;
    }
    
}

export async function fetchAllTableDetailsApi()
{
  const token=sessionStorage.getItem("token");
   const url=createUrl("/reservation/table-details");
   try{
   const response=await axios.get(url,{
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
   return response.data;
   }catch(ex)
   {
    return null;
   }

}

export async function updateTableStatusApi(orderId)
{
  const token=sessionStorage.getItem("token");
    const url=createUrl(`/reservation/update-status/${orderId}`);
    try{
        const response=await axios.put(url,{},{
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
  
        return response.data;
    }catch(ex)
    {
      console.log(ex);
        return null;
    }
}