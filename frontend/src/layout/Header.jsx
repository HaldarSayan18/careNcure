import React from 'react'
import '../App.css';
import logo from '../assets/logo.png';
import { Link, Outlet, useLocation } from 'react-router-dom';

const Header = () => {
    const location = useLocation();
    const getNavItem = (path) => {
        return location.pathname === path ? 'active-navbar-item' : '';
    };
    return (
        <div className='root-container'>
            <div className='navbar-container'>
                <img src={logo} alt='logo' className='logo' />
                <div className='navbar-items'>
                    <Link to="/" className={getNavItem('/')} style={{ textDecoration: "none", color: "inherit" }}><span>Home</span></Link>
                    <Link to="/doctors" className={getNavItem('/doctors')} style={{ textDecoration: "none", color: "inherit" }}><span>Doctor</span></Link>
                    {/* <span>Doctor</span> */}
                    <Link to="/appointment" className={getNavItem('/appointment')} style={{ textDecoration: "none", color: "inherit" }}><span>Appointment</span></Link>
                    <Link to="/bed" className={getNavItem('/bed')} style={{ textDecoration: "none", color: "inherit" }}><span>Bed</span></Link>
                    <Link to="/about-us" className={getNavItem('/about-us')} style={{ textDecoration: "none", color: "inherit" }}><span>About Us</span></Link>
                </div>
            </div>
            <div className='other-containers'>
                <Outlet />
            </div>
        </div>
    )
}

export default Header