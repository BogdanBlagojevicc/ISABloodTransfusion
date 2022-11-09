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
                        <Link to='/careers'>Careers</Link>
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
                </ul>
            </nav>
        </div>
    )
}

export default Navbar