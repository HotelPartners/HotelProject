import axios from 'axios';
import { createUrl } from '../utils/utils';

export async function registerUserApi(firstName,lastName,email,mobileNumber,password)
{
    const url =createUrl('/auth/register');
    const body={firstName,lastName,email,mobileNumber,password};
    try{
        const response=axios.post(url,body);
        return "success";

    }
    catch(ex)
    {
        return "error";
    }

}

