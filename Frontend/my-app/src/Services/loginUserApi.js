import axios from "axios";
import { createUrl } from "../utils/utils";

export async function loginUserApi(email, password) {
    const url = createUrl('/auth/authenticate');
    const body = { email, password };
    try {
        const response = await axios.post(url, body);
        console.log(response+"---");
        return response;
    }
    catch (ex) {
        return null;
    }

}