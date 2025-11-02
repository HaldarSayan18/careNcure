import React, { useState } from 'react'
import '../App.css';
import logo from '../assets/logo.png';
import { Link, Outlet, useLocation } from 'react-router-dom';
import { TbUserSquareRounded } from "react-icons/tb";

const Header = () => {
    const location = useLocation();
    const [menuOpen, setMenuOpen] = useState(false);
    const getNavItem = (path) => {
        return location.pathname === path ? 'active-navbar-item' : '';
    };
    return (
        <div className='root-container'>
            <div className='navbar-container'>
                <img src={logo} alt='logo' className='logo' />
                {/* Hamburger Icon */}
                <div
                    className={`hamburger ${menuOpen ? 'open' : ''}`}
                    onClick={() => setMenuOpen(!menuOpen)}
                >
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
                {/* Navbar links */}
                <div className={`navbar-items ${menuOpen ? 'active' : ''}`}>
                    <Link to="/" className={getNavItem('/')} style={{ textDecoration: "none", color: "inherit" }} onClick={() => setMenuOpen(false)}><span>Home</span></Link>
                    <Link to="/doctors" className={getNavItem('/doctors')} style={{ textDecoration: "none", color: "inherit" }} onClick={() => setMenuOpen(false)}><span>Doctor</span></Link>
                    {/* <span>Doctor</span> */}
                    <Link to="/appointment" className={getNavItem('/appointment')} style={{ textDecoration: "none", color: "inherit" }} onClick={() => setMenuOpen(false)}><span>Appointment</span></Link>
                    <Link to="/bed-availability" className={getNavItem('/bed')} style={{ textDecoration: "none", color: "inherit" }} onClick={() => setMenuOpen(false)}><span>Bed</span></Link>
                    <Link to="/about-us" className={getNavItem('/about-us')} style={{ textDecoration: "none", color: "inherit" }} onClick={() => setMenuOpen(false)}><span>About Us</span></Link>
                    <Link to="/my-profile" className={getNavItem('/my-profile')} style={{ textDecoration: "none", color: "inherit" }} onClick={() => setMenuOpen(false)}><TbUserSquareRounded style={{ height: "1.7rem", width: "1.7rem" }} /></Link>
                </div>
            </div>
            <div className='other-containers'>
                <Outlet />
            </div>
        </div>
    )
}

export default Header