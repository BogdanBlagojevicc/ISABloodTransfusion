import React from 'react'
import {Link } from 'react-router-dom'
import './styles/Navbar.scss'

const NavbarCA = () => {
    return (
        <div>
        <div  className='sum'>
            <div className="logo">
                Blood
            </div>
            <nav className = 'item'>
                <ul className='ul'>
                    <li>
                        <Link to='/'>Home</Link>
                    </li>
                    <li>
                        <Link to='/regUsersBloodDonated'>Users blood donated</Link>
                    </li>

                </ul>
            </nav>
   
        </div>
        <br/>
        </div>
        
    )
}

export default NavbarCA