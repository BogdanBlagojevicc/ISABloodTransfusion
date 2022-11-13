import React from 'react'
import {Link } from 'react-router-dom'
import './styles/Navbar.scss'

const Navbar = () => {
    return (
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
                        <Link to='/changePassword'>Change password</Link>
                    </li>
                    <li>
                        <Link to='/about'>About</Link>
                    </li>
                    <li>
                        <Link to='/projects'>Projects</Link>
                    </li>
                    <li>
                        <Link to='/contact'>Contact</Link>
                    </li>
                    <li>
                        <Link to='/changeAll'>Change all</Link>
                    </li>
                    <li>
                        <Link to='/centerUpdate'>Center Update</Link>
                    </li>
                    <li>
                        <Link to='/showAdminCenters'>Show admin centers</Link>
                    </li>
                </ul>
            </nav>
        </div>
    )
}

export default Navbar