import React from 'react'
import '../App.css';
import logo from '../assets/logo.png';
import { Link, Outlet } from 'react-router-dom';

const Header = () => {
    return (
        <div className='root-container'>
            <div className='navbar-container bg-gray-800'>
                <img src={logo} alt='logo' className='logo' />
                <div className='navbar-items'>
                    <Link to="/" style={{textDecoration:"none", color:"inherit"}}><span>Home</span></Link>
                    <Link to="/doctors" style={{textDecoration:"none", color:"inherit"}}><span>Doctor</span></Link>
                    {/* <span>Doctor</span> */}
                    <Link to="/appointment" style={{textDecoration:"none", color:"inherit"}}><span>Appointment</span></Link>
                    <Link to="/bed" style={{textDecoration:"none", color:"inherit"}}><span>Bed</span></Link>
                    <Link to="/about-us" style={{textDecoration:"none", color:"inherit"}}><span>About Us</span></Link>
                </div>
            </div>
            <div className='other-containers'>
                <Outlet/>
            </div>
        </div>
    )
}

export default Header