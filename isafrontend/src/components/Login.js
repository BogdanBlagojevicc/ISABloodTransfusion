import React, { useEffect, useState, useRef } from 'react'
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import './styles/Contact.scss'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'

export default function Login() {
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}
  var [username, setUse] = useState('')
  var [password, setPas]  = useState('')
  var [token1, setToken1] = useState([])

  const handleClick = (e) =>{
    e.preventDefault()
    let admin = {username, password}
    console.log(admin)
    fetch("http://localhost:8081/auth/login",{
      headers : { 
        'Content-Type': 'application/json',
        'Accept': 'application/json',
       },
    method:"POST",
    body:JSON.stringify(admin),


  }).then(res =>res.json())
  .then((result)=>
  {
    setToken1(result);
    // console.log(token1);
    // console.log(token1.accessToken);
    // console.log(token1.expiresIn);

    let testToken = {
      accessToken : "",
      expiresIn : 0
    }

    testToken.accessToken = result.accessToken;
    testToken.expiresIn = result.expiresIn;


    localStorage.setItem('testToken', JSON.stringify(testToken));


    let test = localStorage.getItem('testToken')
    console.log(JSON.parse(test));

  }
  )

    
};


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
        <h1>Log in</h1>
        <Paper elevation={3} style={paperStyle}>

        <TextField id="standard-basic" variant="standard" label="username" fullWidth 
        placeholder="username"
        onChange = {(e) => setUse(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="password" fullWidth 
        placeholder="password"
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