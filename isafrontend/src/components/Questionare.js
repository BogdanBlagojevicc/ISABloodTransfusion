//import React from 'react'
import * as React from 'react';
import {useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import './styles/Contact.scss'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'
import Switch from '@mui/material/Switch'

import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';

const label = { inputProps: { 'aria-label': 'Switch demo' } };

const Questionare = () => {
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}

  const [age, setAge] = React.useState('');
  const handleChange = (event) => {
    setAge(event.target.value);
  };
  const handleClick = (e) =>{

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
      <h1>Questionare</h1>
      <Paper elevation={3} style={paperStyle}>

      <TextField id="standard-basic" label="name" variant="standard" fullWidth 
        />

        <TextField id="standard-basic" label="lastname" variant="standard" fullWidth 
        />
          <TextField id="standard-basic" label="jmbg" variant="standard" fullWidth 

        />
          <TextField id="standard-basic" label="address" variant="standard" fullWidth 

        />

        <TextField id="standard-basic" label="phone number" variant="standard" fullWidth 

        />

          <TextField id="standard-basic" label="profession" variant="standard" fullWidth 

        />
                      <br></br>
                      <br></br>

      <FormControl fullWidth>

              <InputLabel id="demo-simple-select-label">Blood</InputLabel>
              <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                value={age}
                label="Age"
                onChange={handleChange}
              >

                <MenuItem value={0}>A</MenuItem>
                <MenuItem value={1}>B</MenuItem>
                <MenuItem value={2}>AB</MenuItem>
                <MenuItem value={3}>0</MenuItem>
              </Select>
      </FormControl>

        <br></br>
        <br></br>
        <br></br>
        <b>Did you in past 6 months?</b>
        <br></br>
        Have a surgery?
        <Switch {...label} defaultChecked />

        <br></br>
        Done a tattoo?
        <Switch {...label} defaultChecked />

        <br></br>
        Had sexual intercourse without protection?
        <Switch {...label} defaultChecked />

        <br></br>
        <b>Forms of risky behaviours</b>

        <br></br>
        Did you ever have hepatitis A, B or C?
        <Switch {...label} defaultChecked />

        <br></br>
        Did you consume any kind of psychoactive substances?
        <Switch {...label} defaultChecked />
        
        <br></br>
        Did you offer sexual service for money or drugs?
        <Switch {...label} defaultChecked />
        


        <br></br>
        <br></br>
        
      <Button variant="contained" color="secondary" onClick={handleClick}>
        Submit
      </Button>

      </Paper>

    </Container>
  </Box>
  )
}

export default Questionare