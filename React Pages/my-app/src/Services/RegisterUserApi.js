import axios from 'axios';
import { createUrl } from '../utils/utils';

export async function registerUserApi(firstName,lastName,userEmail,mobileNumber,password)
{
    const url =createUrl('/users/addUser');
    const body={firstName,lastName,userEmail,mobileNumber,password};
    try{
        const response=axios.post(url,body);
        return "success";

    }
    catch(ex)
    {
        return "error";
    }

}

