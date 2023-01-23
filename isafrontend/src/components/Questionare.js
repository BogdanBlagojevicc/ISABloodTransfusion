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

  const [bloodType, setAge] = React.useState('');
  const [previousTransfusions, setPreviousTransfusions] = React.useState('');
  const [weight, setWeight] = React.useState('');
  const [highBloodPressure, setHighBloodPressure] = React.useState('');
  const [lowBloodPressure, setLowBloodPressure] = React.useState('');
  const [isFeelsGood, setIsFeelsGood] = React.useState(false);
  const [isSkinChanged, setSkinChanged] = React.useState(false);
  const [isPreviousTherapyMoreThanSixDays, setSsPreviousTherapyMoreThanSixDays] =React.useState(false);
  const [isUnderRegularMonthlyCycle, setIsUnderRegularMonthlyCycle] = React.useState(false);
  const [isPreviousDentalInterventionMoreThanSixDays, setIsPreviousDentalInterventionMoreThanSixDays] =React.useState(false);
  const [isPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths, setIsPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths] = React.useState(false);

  const handleChange = (event) => {
    setAge(event.target.value);
  };
  const handleClick = (e) =>{
    e.preventDefault()
    const new_questionnaire = {bloodType, previousTransfusions, weight, highBloodPressure, lowBloodPressure, isFeelsGood, isSkinChanged, isPreviousTherapyMoreThanSixDays, isUnderRegularMonthlyCycle,
      isPreviousDentalInterventionMoreThanSixDays, isPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths}
    console.log(new_questionnaire);
    var test = JSON.parse(localStorage.getItem('testToken'))
    fetch("http://localhost:8081/api/questionnaire/new/" + localStorage.getItem('reg_user_username'),{
    method:"POST",
    headers : { 
      'Content-Type': 'application/json',
       Authorization: `Bearer ${test.accessToken}`,
     },
    body:JSON.stringify(new_questionnaire)

  }).then(() =>{
    console.log("New questionnaire added")
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
      <h1>Questionare</h1>
      <Paper elevation={3} style={paperStyle}>


      <TextField id="standard-basic" label="previousTransfusions" variant="standard" fullWidth 
          value={previousTransfusions}
          onChange = {(e) =>setPreviousTransfusions(e.target.value)}
          />

      <TextField id="standard-basic" label="weight" variant="standard" fullWidth 
          value={weight}
          onChange = {(e) =>setWeight(e.target.value)}
          />

      <TextField id="standard-basic" label="highBloodPressure" variant="standard" fullWidth 
          value={highBloodPressure}
          onChange = {(e) =>setHighBloodPressure(e.target.value)}
          />

    <TextField id="standard-basic" label="lowBloodPressure" variant="standard" fullWidth 
          value={lowBloodPressure}
          onChange = {(e) =>setLowBloodPressure(e.target.value)}
          />

                      <br></br>
                      <br></br>

      <FormControl fullWidth>

              <InputLabel id="demo-simple-select-label">Blood</InputLabel>
              <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                value={bloodType}
                label="Age"
                onChange={handleChange}
              >

                <MenuItem value={"A"}>A</MenuItem>
                <MenuItem value={"B"}>B</MenuItem>
                <MenuItem value={"AB"}>AB</MenuItem>
                <MenuItem value={"ZERO"}>0</MenuItem>
              </Select>
      </FormControl>

        <br></br>
        <br></br>
        <br></br>
        
      <label>
        <input
          type="checkbox"
          value="check"
          onChange = {(e) =>setIsFeelsGood(prevCheck => !prevCheck)}
        />
        Is Feels good?
      </label>

      <br></br>
      <label>
        <input
          type="checkbox"
          value="check"
          onChange = {(e) =>setSkinChanged(prevCheck => !prevCheck)}
        />
        Is skin changed?
      </label>

      <br></br>
      <label>
        <input
          type="checkbox"
          value="check"
          onChange = {(e) =>setSsPreviousTherapyMoreThanSixDays(prevCheck => !prevCheck)}
        />
        Is previous therapy more than six days?
      </label>
      <br></br>
      <label>
        <input
          type="checkbox"
          value="check"
          onChange = {(e) =>setIsUnderRegularMonthlyCycle(prevCheck => !prevCheck)}
        />
        Is under regular monthly cycle?
      </label>
      <br></br>
      <label>
        <input
          type="checkbox"
          value="check"
          onChange = {(e) =>setIsPreviousDentalInterventionMoreThanSixDays(prevCheck => !prevCheck)}
        />
        Is previous dental intervention more than six days?
      </label>
      <br></br>
      <label>
        <input
          type="checkbox"
          value="check"
          onChange = {(e) =>setIsPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths(prevCheck => !prevCheck)}
        />
        is previous surgical intervention or blood donation more than six months?
      </label>

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