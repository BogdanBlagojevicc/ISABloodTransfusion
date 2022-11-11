//import React from 'react'
import * as React from 'react';
import {useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import './styles/Contact.scss'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'
import Switch from '@mui/material/Switch'

const label = { inputProps: { 'aria-label': 'Switch demo' } };

const Questionare = () => {
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}
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
      <h1>Add user</h1>
      <Paper elevation={3} style={paperStyle}>

      <TextField id="standard-basic" label="loyalty" variant="standard" fullWidth 
        />

        <TextField id="standard-basic" label="email" variant="standard" fullWidth 
        />
          <TextField id="standard-basic" label="password" variant="standard" fullWidth 

        />
          <TextField id="standard-basic" label="firstname" variant="standard" fullWidth 

        />

        <TextField id="standard-basic" label="firstname" variant="standard" fullWidth 

        />

          <TextField id="standard-basic" label="address" variant="standard" fullWidth 

        />
          <TextField id="standard-basic" label="city" variant="standard" fullWidth 

        />
          <TextField id="standard-basic" label="country" variant="standard" fullWidth 

        />
          <TextField id="standard-basic" label="phoneNumber" variant="standard" fullWidth 

        />
          <TextField id="standard-basic" label="jmbg" variant="standard" fullWidth 

        />
          <TextField id="standard-basic" label="gender" variant="standard" fullWidth 

        />
          <TextField id="standard-basic" label="profession" variant="standard" fullWidth 

        />
          <TextField id="standard-basic" label="education" variant="standard" fullWidth 

        />
          <TextField id="standard-basic" label="points" variant="standard" fullWidth 

        />
          <TextField id="standard-basic" label="penalties" variant="standard" fullWidth 
        />

        Have you donated blood before? 
        <Switch {...label} defaultChecked />

        <br></br>
        Did you have unprotecte sexual intercourse within past 6 months?
        <Switch {...label} defaultChecked />

        <br></br>
        Have you donated blood before? 
        <Switch {...label} defaultChecked />

        <br></br>
        Have you donated blood before? 
        <Switch {...label} defaultChecked />

        <br></br>
        Have you donated blood before? 
        <Switch {...label} defaultChecked />
        
        <br></br>
        Have you donated blood before? 
        <Switch {...label} defaultChecked />
        


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