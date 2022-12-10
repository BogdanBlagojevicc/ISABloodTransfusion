import React, { useEffect, useState, useRef } from 'react'
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import './styles/Contact.scss'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'

export default function CenterAdministrator() {
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}
  var [centerAdministrator, setCenterAdministrator] = useState([])
  var [pas, setPas]  = useState('')

  useEffect(() =>{
    var test = JSON.parse(localStorage.getItem('testToken'))
    fetch("http://localhost:8081/api/centerAdministrators/getOne/3", {
      method:"GET",
      headers : { 
        'Content-Type': 'application/json',
         Authorization: `Bearer ${test.accessToken}`,
       },
    })
    .then(res => res.json())
    .then((result) =>
    {
      setCenterAdministrator(result);
    }
    )
  },[])

  const handleClick = (e) =>{
    e.preventDefault()
    var admin = centerAdministrator;
    admin.password = pas;
    console.log(admin);
    fetch("http://localhost:8081/api/centerAdministrators/updatePassword/1",{
    method:"PUT",
    headers:{"Content-Type":"application/json"
    },
    
    body:JSON.stringify(admin)

  }).then(() =>{
    console.log("Admin changed")
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
        <h1>Change administrator's password</h1>
        <Paper elevation={3} style={paperStyle}>

      
        <TextField id="standard-basic" variant="standard" label="password" fullWidth 
        placeholder={centerAdministrator.password}
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
