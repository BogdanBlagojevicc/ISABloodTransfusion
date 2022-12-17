import * as React from 'react';
import {useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import './styles/Contact.scss'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'

export default function SignUp() {
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}
  const[username, setUsername] = useState('')
  const[password, setPassword] = useState('')
  const[repeat, setRepeat] = useState('')
  const[firstname, setFirstName] = useState('')
  const[lastname, setLastName] = useState('')
  const[address, setAddress] = useState('')
  const[city, setCity] = useState('')
  const[country, setCountry] = useState('')
  const[phoneNumber, setPhoneNumber] = useState('')
  const[jmbg, setJmbg] = useState('')
  const[gender, setGender] = useState('')
  const[profession, setProfession] = useState('')
  const[education, setEducation] = useState('')

  const handleClick = (e) =>{
    e.preventDefault()
    const new_user = {password, firstname, lastname, username, address, city, country, phoneNumber, jmbg, gender, profession, education}
    console.log(new_user);
    console.log(password);
    console.log(repeat);
    if(!(password === repeat)){
      window.alert("Passwords must match")
      return;
    }
    fetch("http://localhost:8081/auth/regularUser/signup",{
    method:"POST",
    headers:{"Content-Type":"application/json"},
    body:JSON.stringify(new_user)

  }).then(() =>{
    console.log("New user added")
    window.location.href = '/';
  })
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
        <h1>Add user</h1>
        <Paper elevation={3} style={paperStyle}>

          <TextField id="standard-basic" label="username" variant="standard" fullWidth 
          value={username}
          onChange = {(e) =>setUsername(e.target.value)}
          />
          
            <TextField id="standard-basic" label="password" variant="standard" fullWidth 
          value={password}
          onChange = {(e) =>setPassword(e.target.value)}
          />

          <TextField id="standard-basic" label="repeat" variant="standard" fullWidth 
          value={repeat}
          onChange = {(e) =>setRepeat(e.target.value)}
          />

            <TextField id="standard-basic" label="firstname" variant="standard" fullWidth 
          value={firstname}
          onChange = {(e) =>setFirstName(e.target.value)}
          />

          <TextField id="standard-basic" label="lastName" variant="standard" fullWidth 
                value={lastname}
                onChange = {(e) =>setLastName(e.target.value)}
          />

            <TextField id="standard-basic" label="address" variant="standard" fullWidth 
                value={address}
                onChange = {(e) =>setAddress(e.target.value)}
            />

            <TextField id="standard-basic" label="city" variant="standard" fullWidth 
                value={city}
                onChange = {(e) =>setCity(e.target.value)}
            />

            <TextField id="standard-basic" label="country" variant="standard" fullWidth 
                value={country}
                onChange = {(e) =>setCountry(e.target.value)}
            />

            <TextField id="standard-basic" label="phoneNumber" variant="standard" fullWidth 
                value={phoneNumber}
                onChange = {(e) =>setPhoneNumber(e.target.value)}
            />

            <TextField id="standard-basic" label="jmbg" variant="standard" fullWidth 
                value={jmbg}
                onChange = {(e) =>setJmbg(e.target.value)}
            />

            <TextField id="standard-basic" label="gender" variant="standard" fullWidth 
                value={gender}
                onChange = {(e) =>setGender(e.target.value)}
            />

            <TextField id="standard-basic" label="profession" variant="standard" fullWidth 
                value={profession}
                onChange = {(e) =>setProfession(e.target.value)}
            />

            <TextField id="standard-basic" label="education" variant="standard" fullWidth 
                value={education}
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
