import React, {useState, useEffect} from 'react'
import {Link} from 'react-router-dom'
import {MdFingerprint} from 'react-icons/md'
import {FaBars, FaTimes} from 'react-icons/fa'
import {Button } from './ButtonComponent';
import '../css/Navbar.css';
import {IconContext} from 'react-icons/lib'



function Navbar() {
    const [click, setClick] = useState(false);
    const [button, setButton]= useState(true);

    const handleClick = () => setClick (!click);
    const closeMobileMenu = () => setClick(false);

    const showButton = () => {
        if (window.innerWidth <= 960) {
            setButton(false)
        }else{
            setButton(true)
        }
        };

        useEffect( () => {
            showButton()

        }, []);

        window.addEventListener('resize', showButton);
    return (
        <> 
        <IconContext.Provider value = {{color:'#fff'}}>

        <div className="navbar">
            <div className='navbar-container container'>
                <Link to= '/'className='navbar-logo' onClick={closeMobileMenu}>

                    <MdFingerprint className='navabar-icon' />
                MERIT BANK
                </Link>
                <div className='menu-icon'onClick={handleClick}>
                    {click ? <FaTimes/> : <FaBars />}
                    </div>
                
                <ul className= {click ? 'nav-menu active' : 'nav-menu'}
                >
                
                <li className= 'nav-item'>
                    <Link to='/home'className= 'nav-links' onClick={closeMobileMenu}>
                        Home
                        </Link>
                        </li> 
                        <li className='nav-item'>
                            <Link to= '/dashboard' className= 'nav-links' onClick={closeMobileMenu}>
                                Dashboard
                            </Link>
                        </li>
                        <li className='nav-item'>
                            <Link to= '/services' className= 'nav-links' onClick={closeMobileMenu}>
                                Accounts
                            </Link>
                        </li>

                        <li className='nav-item'>
                            <Link to= '/register' className= 'nav-links' onClick={closeMobileMenu}>
                                Register
                            </Link>
                        </li>
                        
                        <li className="nav-btn">
                            {button ? (
                                <Link to= '/signin' className= "btn-link" >
                                   <Button  buttonStyle= 'btn--outline'>Login</Button> 
                                </Link>
                            ): (
                                <Link to= '/signIn' className="btn-link" onClick={closeMobileMenu}>
                                    <Button buttonStyle='btn--outline'
                                    buttonSize= 'btn--mobile'>

                                        SIGN IN
                                        </Button>
                                </Link>
                                 
 
                            )}
                  </li>
                </ul>
            </div>
            </div>
            </IconContext.Provider>/
        </>
    );
}

export default Navbar;