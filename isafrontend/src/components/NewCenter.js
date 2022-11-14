import * as React from 'react';
import {useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import './styles/Contact.scss'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'

export default function NewCenter() {
    const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}
    const[name, setName] = useState('')
    const[address, setAddress] = useState('')
    const[description, setDescription] = useState('')
    const[country, setCountry] = useState('')
    const[averageGrade, setAverageGrade] = useState('')
    const[startTime, setStartTime] = useState('')
    const[endTime, setEndTime] = useState('')
    
  
  
    const handleClick = (e) =>{
      e.preventDefault()
      const center = {name, address, description, country, averageGrade, startTime, endTime}
      console.log(center);
      fetch("http://localhost:8081/api/centers/createNewCenter/1",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(center)
  
    }).then(() =>{
      console.log("New center added")
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
          <h1>Add center</h1>
          <Paper elevation={3} style={paperStyle}>
  
          <TextField id="standard-basic" label="name" variant="standard" fullWidth 
            value={name}
            onChange = {(e) =>setName(e.target.value)}
            />
  
            <TextField id="standard-basic" label="address" variant="standard" fullWidth 
            value={address}
            onChange = {(e) =>setAddress(e.target.value)}
            />
              <TextField id="standard-basic" label="description" variant="standard" fullWidth 
            value={description}
            onChange = {(e) =>setDescription(e.target.value)}
            />
              <TextField id="standard-basic" label="country" variant="standard" fullWidth 
            value={country}
            onChange = {(e) =>setCountry(e.target.value)}
            />
  
            <TextField id="standard-basic" label="averageGrade" variant="standard" fullWidth 
                  value={averageGrade}
                  onChange = {(e) =>setAverageGrade(e.target.value)}
            />
  
              <TextField id="standard-basic" label="startTime" variant="standard" fullWidth 
            value={startTime}
            onChange = {(e) =>setStartTime(e.target.value)}
            />
              <TextField id="standard-basic" label="endTime" variant="standard" fullWidth 
            value={endTime}
            onChange = {(e) =>setEndTime(e.target.value)}
            />
              

            
            
          <Button variant="contained" color="secondary" onClick={handleClick}>
            Submit
          </Button>
  
          </Paper>
  
        </Container>
      </Box>
    );
  }