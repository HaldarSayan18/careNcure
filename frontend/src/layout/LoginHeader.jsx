import React from 'react'
import '../App.css';
import logo from '../assets/logo.png';
import { Link, useLocation } from 'react-router-dom';

const Header = () => {
    const location = useLocation();
    const getNavItem = (path) => {
        return location.pathname === path ? 'active-navbar-item' : '';
    };
    return (
        <div className='root-container'>
            <div className='navbar-container'>
                <Link to="/" className={getNavItem('/')} style={{ textDecoration: "none", color: "inherit" }}>
                    <img src={logo} alt='logo' className='logo' />
                </Link>
                {/* <div className='navbar-items'>
                    <span>Home</span></Link>
                </div> */}
            </div>
        </div>
    )
}

export default Header