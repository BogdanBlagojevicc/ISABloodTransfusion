import logo from './logo.svg';
import './App.scss';
import Appbar from './components/Appbar';
import Navbar from './components/Navbar';
import Login from './components/Login';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Login/>
    </div>
  );
}

export default App;
