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
                        <Link to='/about'>Centers</Link>
                    </li>
                    <li>
                        <Link to='/projects'>Your profile</Link>
                    </li>
                    <li>
                        <Link to='/contact'>Add regular user</Link>
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
                    <li>
                        <Link to='/questionaire'>Questionare</Link>
                    </li>

                    <li>
                        <Link to='/newCenter'>NewCenter</Link>
                    </li>

                    <li>
                        <Link to='/centerAdministrator'>Add centerAdmin</Link>
                    </li>

                    <li>
                        <Link to='/regularUsers'>Regular users</Link>
                    </li>
                    
                    <li>
                        <Link to='/logIn'>Log In</Link>
                    </li>

                    <li>
                        <Link to='/showRegUsers'>All regular users</Link>
                    </li>

                </ul>
            </nav>
        </div>
    )
}

export default Navbar