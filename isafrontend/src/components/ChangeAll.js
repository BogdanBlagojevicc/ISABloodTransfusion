import React, { useEffect, useState, useRef } from 'react'
import Box from '@mui/material/Box';
import './styles/Contact.scss'
import TextField from '@mui/material/TextField'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'

export default function CenterAdministrator() {
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}
  var [centerAdministrator, setCenterAdministrator] = useState([])

  const emailRegex = /[a-zA-Z0-9._%+-]+@[a-z0-9*-]+\.[a-z]{2,8}(.[a-z{2,8}])?/g;

  var [ema, setEma] = useState('')
  var [fir, setFir]  = useState('')
  var [las, setLas]  = useState('')
  var [add, setAdd]  = useState('')
  var [cit, setCit]  = useState('')
  var [cou, setCou]  = useState('')
  var [pnu, setPnu]  = useState('')
  var [pro, setPro]  = useState('')
  var [edu, setEdu]  = useState('')


  useEffect(() =>{
    fetch("http://localhost:8081/api/centerAdministrators/getOne/1")
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
    if(!emailRegex.test(ema)){
      alert('Wrong email');
    }else{
      admin.email = ema;
      admin.firstName = fir;
      admin.lastName = las;
      admin.address = add;
      admin.city = cit;
      admin.country = cou;
      admin.phoneNumber = pnu;
      admin.profession = pro;
      admin.education = edu;
    }

    console.log(admin);
    fetch("http://localhost:8081/api/centerAdministrators/1",{
    method:"PUT",
    headers:{"Content-Type":"application/json"},
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
        <h1>Change all</h1>
        <Paper elevation={3} style={paperStyle}>

      
        <TextField id="standard-basic" variant="standard" label="email" fullWidth 
        placeholder={centerAdministrator.email}
        onChange = {(e) => setEma(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="firstName" fullWidth 
        placeholder={centerAdministrator.firstName}
        onChange = {(e) => setFir(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="lastName" fullWidth 
        placeholder={centerAdministrator.lastName}
        onChange = {(e) => setLas(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="address" fullWidth 
        placeholder={centerAdministrator.address}
        onChange = {(e) => setAdd(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="city" fullWidth 
        placeholder={centerAdministrator.city}
        onChange = {(e) => setCit(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="country" fullWidth 
        placeholder={centerAdministrator.country}
        onChange = {(e) => setCou(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="phoneNumber" fullWidth 
        placeholder={centerAdministrator.phoneNumber}
        onChange = {(e) => setPnu(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="profession" fullWidth 
        placeholder={centerAdministrator.profession}
        onChange = {(e) => setPro(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="education" fullWidth 
        placeholder={centerAdministrator.education}
        onChange = {(e) => setEdu(e.target.value)}
        />
  
        <Button variant="contained" color="secondary" onClick={handleClick}>
          Submit
        </Button>
        </Paper>

      </Container>
    </Box>
  );
}
