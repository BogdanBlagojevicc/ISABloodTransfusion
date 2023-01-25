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
import AllCenters from './components/AllCenters';
import ShowRegUsers from './components/ShowRegUsers';
import AvailableTerms from './components/AvailableTerms';
import ShowRegUserTerms from './components/ShowRegUserTerms';
import TermDetails from './components/TermDetails';
import Careers from './components/Careers';
import NewTerm from './components/NewTerm';
import StartTerm from './components/StartTerm';
import RegularUserTerms from './components/RegularUserTerms';
import TermHistory from './components/TermHistory';
import ScheduledTerms from './components/ScheduledTerms';
import QRCodesTerms from './components/QRCodesTerms';
import ViewProfile from './components/ViewProfile';
import CenterComplaintList from './components/CenterComplaintList';
import CenterComplaint from './components/CenterComplaint';
import AdministratorComplaintList from './components/AdministratorComplaintList';
import AdministratorComplaint from './components/AdministratorComplaint';

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
        <Route path='/allCenters' element={<AllCenters/>}/>
        <Route path='/NewTerm' element={<NewTerm/>}/>
        <Route path='/Careers/:id' element={<Careers/>}/>
        <Route path='/RegularUserTerms/:id' element={<RegularUserTerms/>}/>
        <Route path='/showRegUsers' element={<ShowRegUsers/>}/>
        <Route path='/availableTerms' element={<AvailableTerms/>}/>
        <Route path='/showRegUsers/showRegUserTerms:regUserId' element={<ShowRegUserTerms/>}/>
        <Route path='/showRegUsers/showRegUserTerms:regUserId/termDetails:termId' element={<TermDetails/>}/>
        <Route path='/showRegUsers/showRegUserTerms:regUserId/termDetails:termId/startTerm' element={<StartTerm/>}/>

        <Route path='/termHistory' element = {<TermHistory/>}/>
        <Route path='/scheduledTerms' element = {<ScheduledTerms/>}/>
        <Route path='/qrCodesTerms' element = {<QRCodesTerms/>} />
        <Route path='/viewProfile' element = {<ViewProfile/>} />
        <Route path='/centerComplaintList' element ={<CenterComplaintList/>} />
        <Route path='/CenterComplaint/:id' element={<CenterComplaint/>}/>
        <Route path='/administratorComplaintList' element={<AdministratorComplaintList/>}/>
        <Route path='/AdministratorComplaint/:id' element={<AdministratorComplaint/>}/>
    </Routes>
  </Router>,
 document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
//reportWebVitals();
