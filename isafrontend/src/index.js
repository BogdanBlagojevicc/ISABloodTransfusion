import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ChangePassword from './components/ChangePassword';
import About from './components/About';
import Contact from './components/Contact'
import Projects from './components/Projects'
import ChangeAll from './components/ChangeAll'
import Questionare from './components/Questionare'
import CenterUpdate from './components/CenterUpdate'
import ShowAdminCenters from './components/ShowAdminCenters'
import NewCenter from './components/NewCenter'
import CenterAdministratorNew from './components/CenterAdministratorNew'
import RegularUsers from './components/RegularUsers'
import Login from './components/Login';
import Navbar from './components/Navbar';
import SignUp  from './components/SignUp';
import ShowCenters from './components/ShowCenters';
import ShowRegUsers from './components/ShowRegUsers';
import ShowRegUserTerms from './components/ShowRegUserTerms';
import TermDetails from './components/TermDetails';
import Careers from './components/Careers';
import NewTerm from './components/NewTerm';
import StartTerm from './components/StartTerm';

ReactDOM.render(
  <Router>
    <Routes>
        <Route path='/' element={<Login/>}/>
        <Route path='/changePassword' element={<ChangePassword/>}/>
        <Route path='/about' element={<About/>}/>
        <Route path='/contact' element={<Contact/>}/>
        <Route path='/projects' element={<Projects/>}/>
        <Route path='/changeAll' element={<ChangeAll/>}/>
        <Route path='/centerUpdate' element={<CenterUpdate/>}/>
        <Route path='/showAdminCenters' element={<ShowAdminCenters/>}/>
        <Route path='/questionaire' element={<Questionare/>}/>
        <Route path='/newCenter' element={<NewCenter/>}/>
        <Route path='/centerAdministrator' element={<CenterAdministratorNew/>}/>
        <Route path='/regularUsers' element={<RegularUsers/>}/>
        <Route path='/navbar' element={<Navbar/>}/>
        <Route path='/signUp' element={<SignUp/>}/>
        <Route path='/showCenters' element={<ShowCenters/>}/>
        <Route path='/NewTerm' element={<NewTerm/>}/>
        <Route path='/Careers/:id' element={<Careers/>}/>
        <Route path='/showRegUsers' element={<ShowRegUsers/>}/>
        <Route path='/showRegUsers/showRegUserTerms:regUserId' element={<ShowRegUserTerms/>}/>
        <Route path='/showRegUsers/showRegUserTerms:regUserId/termDetails:termId' element={<TermDetails/>}/>
        <Route path='/showRegUsers/showRegUserTerms:regUserId/termDetails:termId/startTerm' element={<StartTerm/>}/>
    </Routes>
  </Router>,
 document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
//reportWebVitals();
