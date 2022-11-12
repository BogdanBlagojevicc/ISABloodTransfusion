import React, { useEffect, useState, useRef } from 'react'
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import './styles/Contact.scss'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'

export default function Center() {
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}
  var [center, setCenter] = useState([])
  var [nam, setNam] = useState('')
  var [add, setAdd]  = useState('')
  var [des, setDes]  = useState('')
  var [cou, setCou]  = useState('')
  var [sta, setSta]  = useState('')
  var [end, setEnd]  = useState('')


  useEffect(() =>{
    fetch("http://localhost:8081/api/centers/getOneByCentersAdministratorId/1")
    .then(res => res.json())
    .then((result) =>
    {
      setCenter(result);
    }
    )
  },[])

  const handleClick = (e) =>{
    e.preventDefault()
    var admin = center;
    var br = center.id;
    admin.name = nam;
    admin.address = add;
    admin.description = des;
    admin.country = cou;
    admin.startTime = sta;
    admin.endTime = end;
    console.log(admin);
    fetch("http://localhost:8081/api/centers/1/" + center.id,{
    method:"PUT",
    headers:{"Content-Type":"application/json"},
    body:JSON.stringify(admin)

  }).then(() =>{
    console.log("Center changed")
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
        <h1>Change center</h1>
        <Paper elevation={3} style={paperStyle}>

      
        <TextField id="standard-basic" variant="standard" label="name" fullWidth 
        placeholder={center.name}
        onChange = {(e) => setNam(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="address" fullWidth 
        placeholder={center.address}
        onChange = {(e) => setAdd(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="description" fullWidth 
        placeholder={center.description}
        onChange = {(e) => setDes(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="country" fullWidth 
        placeholder={center.country}
        onChange = {(e) => setCou(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="startTime" fullWidth 
        placeholder={center.startTime}
        onChange = {(e) => setSta(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="endTime" fullWidth 
        placeholder={center.endTime}
        onChange = {(e) => setEnd(e.target.value)}
        />

        <Button variant="contained" color="secondary" onClick={handleClick}>
          Submit
        </Button>
        </Paper>

      </Container>
    </Box>
  );
}
