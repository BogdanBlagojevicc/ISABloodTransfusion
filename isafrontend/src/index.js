import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Careers from './components/Careers';
import About from './components/About';
import Contact from './components/Contact'
import Projects from './components/Projects'

ReactDOM.render(
  <Router>
    <Routes>
      <Route path='/' element={<App/>} />
      <Route path='/careers' element={<Careers/>}/>
      <Route path='/about' element={<About/>}/>
      <Route path='contact' element={<Contact/>}/>
      <Route path='projects' element={<Projects/>}/>
    </Routes>
  </Router>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
//reportWebVitals();
