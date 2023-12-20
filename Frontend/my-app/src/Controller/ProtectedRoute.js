import React, { useState, useEffect } from "react";
import axios from "axios";
import { Navigate, Outlet } from "react-router-dom";
import { createUrl } from "../utils/utils";

async function checkUserValidity(token) {
  try {
    const url = createUrl("/users/is-user-valid/" + token);
    const response = await axios.get(url, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
    if (response.status === 200) {
      return response.data;
    } else {
      return null;
    }
  } catch (ex) {
    console.error("Error fetching user role:", ex);
    return null;
  }
}

function ProtectedRoute({ allowedRoles }) {
  const [isUserValid, setIsUserValid] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      const token = sessionStorage.getItem("token");
      if (token) {
        const role = await checkUserValidity(token);
        setIsUserValid(role === allowedRoles[0]);
      } else {
        setIsUserValid(false);
      }
    };

    fetchData();
  }, [allowedRoles]);

  if (isUserValid === null) {
    return <div>Loading...</div>;
  }

  return isUserValid ? <Outlet /> : <Navigate to="/login" />;
}

export default ProtectedRoute;
