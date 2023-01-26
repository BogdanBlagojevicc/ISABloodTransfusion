import React, { useEffect, useState, useRef } from 'react'
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import './styles/Projects.scss'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'
import jwt_decoder from 'jwt-decode'

export default function RegularUser() {
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
    let username=getUsernameFromToken()
    fetch("http://localhost:8081/api/regularUsers/" + username,{
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

  const handleClick = (e) =>{
    e.preventDefault()
    var admin = regularUser;
    admin.password = password;
    admin.firstName = firstName;
    admin.lastName = lastName;
    admin.city = city;
    admin.country = country;
    admin.phoneNumber = phoneNumber;
    admin.jmbg = jmbg;
    admin.gender = gender;
    admin.profession = profession;
    admin.education = education;

    console.log(admin);
    var test = JSON.parse(localStorage.getItem('testToken'))
   let username=test.accessToken.getUsernameFromToken()
    fetch("http://localhost:8081/api/regularUsers/"+username,{
    method:"PUT",
    headers : { 
      'Content-Type': 'application/json',
       Authorization: `Bearer ${test.accessToken}`,
     },
    body:JSON.stringify(admin)

  }).then(() =>{
    console.log("User changed")
  })
}
function getUsernameFromToken() {
  console.log(decodeToken())
  return decodeToken()?.sub;
}

function decodeToken() {
const token = localStorage.getItem('testToken');
return token ? jwt_decoder(token) : null;
}

  return (
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <Container>
        <h1>Your profile</h1>
        <Paper elevation={3} style={paperStyle}>

{/*       
        <TextField id="standard-basic" variant="standard" label="password" fullWidth 
        placeholder={regularUser.password}
        onChange = {(e) => setPas(e.target.value)}
        />
        <TextField id="standard-basic" variant="standard" label="First name" fullWidth 
        placeholder={regularUser.firstName}
        onChange = {(e) => setPas(e.target.value)}
        />
        <TextField id="standard-basic" variant="standard" label="Last name" fullWidth 
        placeholder={regularUser.lastName}
        onChange = {(e) => setPas(e.target.value)}
        />
        <TextField id="standard-basic" variant="standard" label="Address" fullWidth 
        placeholder={regularUser.address}
        onChange = {(e) => setPas(e.target.value)}
        />
        <TextField id="standard-basic" variant="standard" label="City" fullWidth 
        placeholder={regularUser.city}
        onChange = {(e) => setPas(e.target.value)}
        />
             <TextField id="standard-basic" variant="standard" label="Country" fullWidth 
        placeholder={regularUser.country}
        onChange = {(e) => setPas(e.target.value)}
        />
             <TextField id="standard-basic" variant="standard" label="Phone number" fullWidth 
        placeholder={regularUser.phoneNumber}
        onChange = {(e) => setPas(e.target.value)}
        />
             <TextField id="standard-basic" variant="standard" label="JMBG" fullWidth 
        placeholder={regularUser.jmbg}
        onChange = {(e) => setPas(e.target.value)}
        />
       <TextField id="standard-basic" variant="standard" label="Gender" fullWidth 
        placeholder={regularUser.gender}
        onChange = {(e) => setPas(e.target.value)}
        />
             <TextField id="standard-basic" variant="standard" label="Profession" fullWidth 
        placeholder={regularUser.profession}
        onChange = {(e) => setPas(e.target.value)}
        />
             <TextField id="standard-basic" variant="standard" label="Education" fullWidth 
        placeholder={regularUser.education}
        onChange = {(e) => setPas(e.target.value)}
        />
             <TextField id="standard-basic" variant="standard" label="Loyalty" fullWidth 
        placeholder={regularUser.loyalty}
        onChange = {(e) => setPas(e.target.value)}
        />
             <TextField id="standard-basic" variant="standard" label="Points" fullWidth 
        placeholder={regularUser.points}
        onChange = {(e) => setPas(e.target.value)}
        />
             <TextField id="standard-basic" variant="standard" label="Penalties" fullWidth 
        placeholder={regularUser.penalties}
        onChange = {(e) => setPas(e.target.value)}
        /> */}

            <TextField id="standard-basic" label="password" variant="standard" fullWidth 
          placeholder={regularUser.password}
          onChange = {(e) =>setPassword(e.target.value)}
          />
            <TextField id="standard-basic" label="firstname" variant="standard" fullWidth 
          placeholder={regularUser.firstName}
          onChange = {(e) =>setFirstName(e.target.value)}
          />

          <TextField id="standard-basic" label="lastName" variant="standard" fullWidth 
           placeholder={regularUser.lastName}
                onChange = {(e) =>setLastName(e.target.value)}
          />

            <TextField id="standard-basic" label="address" variant="standard" fullWidth 
          placeholder={regularUser.address}
          onChange = {(e) =>setAddress(e.target.value)}
          />
            <TextField id="standard-basic" label="city" variant="standard" fullWidth 
          placeholder={regularUser.city}
          onChange = {(e) =>setCity(e.target.value)}
          />
            <TextField id="standard-basic" label="country" variant="standard" fullWidth 
          placeholder={regularUser.country}
          onChange = {(e) =>setCountry(e.target.value)}
          />
            <TextField id="standard-basic" label="phoneNumber" variant="standard" fullWidth 
          placeholder={regularUser.phoneNumber}
          onChange = {(e) =>setPhoneNumber(e.target.value)}
          />
            <TextField id="standard-basic" label="jmbg" variant="standard" fullWidth 
          placeholder={regularUser.jmbg}
          onChange = {(e) =>setJmbg(e.target.value)}
          />
            <TextField id="standard-basic" label="gender" variant="standard" fullWidth 
          placeholder={regularUser.gender}
          onChange = {(e) =>setGender(e.target.value)}
          />
            <TextField id="standard-basic" label="profession" variant="standard" fullWidth 
          placeholder={regularUser.profession}
          onChange = {(e) =>setProfession(e.target.value)}
          />
            <TextField id="standard-basic" label="education" variant="standard" fullWidth 
          placeholder={regularUser.education}
          onChange = {(e) =>setEducation(e.target.value)}
          />


        <Button variant="contained" color="secondary" onClick={handleClick}>
          Submit
        </Button>
        </Paper>

      </Container>
    </Box>
  );
}