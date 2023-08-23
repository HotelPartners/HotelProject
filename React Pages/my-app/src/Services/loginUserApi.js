import axios from "axios";
import { createUrl } from "../utils/utils";

export async function loginUserApi(userEmail, password) {
    const url = createUrl('/users/login');
    const body = { userEmail, password };
    try {
        const response = await axios.post(url, body);
        return response.data;
    }
    catch (ex) {
        return "error";
    }

}