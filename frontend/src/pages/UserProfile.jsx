import React, { useEffect, useState } from 'react';
import {jwtDecode} from 'jwt-decode';
import { baseURL } from '../assets/API/API';

const UserProfile = () => {
    const [user, setUser] = useState(null);
    const token = localStorage.getItem("accessToken");

    useEffect(() => {
        if (token) {
            const decoded = jwtDecode(token);

            // If token expired, remove it
            if (decoded.exp * 1000 < Date.now()) {
                localStorage.removeItem("accessToken");
                return;
            }

            // Fetch user data using token
            fetch(`${baseURL}/patient/registration`, {
                headers: {
                    "Authorization": `Bearer ${token}`
                }
            })
                .then(res => res.json())
                .then(data => setUser(data))
                .catch(err => console.error(err));
        }
    }, [token]);

    return (
        <div>
            <h2>User Profile</h2>
            {user ? (
                <>
                    <p><strong>Name:</strong> {user.firstname} {user.lastname}</p>
                    <p><strong>Email:</strong> {user.email}</p>
                    <p><strong>Role:</strong> {user.role}</p>
                </>
            ) : (
                <p>Login first</p>
            )}
        </div>
    );
};

export default UserProfile;
