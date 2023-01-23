import React, { useEffect, useState, useRef } from 'react'
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import './styles/Projects.scss'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'

const ViewProfile = () => {
    const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}
    var [regularUser, setRegularUser] = useState([])
    const[password, setPassword] = useState('')
    const[firstName, setFirstName] = useState('')
    const[lastName, setLastName] = useState('')
    const[address, setAddress] = useState('')
    const[city, setCity] = useState('')
    const[country, setCountry] = useState('')
    const[phoneNumber, setPhoneNumber] = useState('')
    const[jmbg, setJmbg] = useState('')
    const[gender, setGender] = useState('')
    const[profession, setProfession] = useState('')
    const[education, setEducation] = useState('')
  
    useEffect(() =>{
      var test = JSON.parse(localStorage.getItem('testToken'))
      fetch("http://localhost:8081/api/regularUsers/" + localStorage.getItem('reg_user_username'),{
        headers : { 
          'Content-Type': 'application/json',
           Authorization: `Bearer ${test.accessToken}`,
         },
      })
      .then(res => res.json())
      .then((result) =>
      {
          setRegularUser(result);
      }
      )
    },[])
  return (
    <div>
        <h1>Your profile</h1><br/>
        <p>Username:<b>{regularUser.username}</b></p><br/>
        <p>Name: <b>{regularUser.firstName}</b></p><br/>
        <p>Lastname: <b>{regularUser.lastName}</b></p><br/>
        <p>Address: <b>{regularUser.address}</b></p><br/>
        <p>City: <b>{regularUser.city}</b></p><br/>
        <p>Country: <b>{regularUser.country}</b></p><br/>
        <p>PhoneNumber: <b>{regularUser.phoneNumber}</b></p><br/>
        <p>Gender: <b>{regularUser.gender}</b></p><br/>
        <p>Education:<b> {regularUser.education}</b></p><br/>
        <p>Profession:<b> {regularUser.profession}</b></p><br/>
        <p>Loyalty: <b>{regularUser.loyalty}</b></p><br/>
        <p>Points:<b> {regularUser.points}</b></p><br/>
        <p>Penalties: <b>{regularUser.penalties}</b></p><br/>
    </div>
  )
}

export default ViewProfile