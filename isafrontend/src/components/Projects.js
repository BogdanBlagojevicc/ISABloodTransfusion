import React, { useEffect, useState, useRef } from 'react'
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import './styles/Projects.scss'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'

export default function RegularUser() {
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}
  var [regularUser, setRegularUser] = useState([])
  var [pas, setPas]  = useState('')

  useEffect(() =>{
    fetch("http://localhost:8081/api/regularUsers/1")
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
    admin.password = pas;
    console.log(admin);
    fetch("http://localhost:8081/api/regularUsers/1",{
    method:"PUT",
    headers:{"Content-Type":"application/json"},
    body:JSON.stringify(admin)

  }).then(() =>{
    console.log("User changed")
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
        <h1>Your profile</h1>
        <Paper elevation={3} style={paperStyle}>

      
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
        />
        <Button variant="contained" color="secondary" onClick={handleClick}>
          Submit
        </Button>
        </Paper>

      </Container>
    </Box>
  );
}