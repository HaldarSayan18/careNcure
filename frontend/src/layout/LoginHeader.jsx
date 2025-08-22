import React from 'react'
import '../App.css';
import logo from '../assets/logo.png';

const Header = () => {
    return (
        <div className='root-container'>
            <div className='navbar-container'>
                <img src={logo} alt='logo' className='logo' />
                {/* <div className='navbar-items'>
                    <Link to="/" className={getNavItem('/')} style={{ textDecoration: "none", color: "inherit" }}><span>Home</span></Link>
                </div> */}
            </div>
        </div>
    )
}

export default Header