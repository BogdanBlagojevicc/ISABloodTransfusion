import * as React from 'react';
import {useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import './styles/Contact.scss'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'

export default function CenterAdministratorNew() {
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}
  const[email, setEmail] = useState('')
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


  const handleClick = (e) =>{
    e.preventDefault()
    const centerAdministrator = {email, password, firstName, lastName, address, city, country, phoneNumber, jmbg, gender, profession, education}
    console.log(centerAdministrator);
    fetch("http://localhost:8081/api/centerAdministrators/createNewCenterAdmin/1",{
    method:"POST",
    headers:{"Content-Type":"application/json"},
    body:JSON.stringify(centerAdministrator)

  }).then(() =>{
    console.log("New center administrator added")
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
        <h1>Add center administrator</h1>
        <Paper elevation={3} style={paperStyle}>

          <TextField id="standard-basic" label="email" variant="standard" fullWidth 
          value={email}
          onChange = {(e) =>setEmail(e.target.value)}
          />
            <TextField id="standard-basic" label="password" variant="standard" fullWidth 
          value={password}
          onChange = {(e) =>setPassword(e.target.value)}
          />
            <TextField id="standard-basic" label="firstname" variant="standard" fullWidth 
          value={firstName}
          onChange = {(e) =>setFirstName(e.target.value)}
          />

          <TextField id="standard-basic" label="firstname" variant="standard" fullWidth 
                value={lastName}
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
