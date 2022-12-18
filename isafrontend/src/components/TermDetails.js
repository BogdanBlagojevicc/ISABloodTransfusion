import React, { useEffect, useState, useRef } from 'react'
import Box from '@mui/material/Box';
import ReactDOM from 'react-dom';
import TextField from '@mui/material/TextField';
import './styles/Contact.scss'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ChangePassword from './ChangePassword';
import { Navigate  } from 'react-router-dom';
import { useParams } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'


export default function TermDetails() {
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}
  let { termId } = useParams();
  let { regUserId } = useParams();
  const navigate = useNavigate();

  const startClick = (e) =>{
    e.preventDefault()
    navigate(`/showRegUsers/showRegUserTerms` + regUserId + `/termDetails` + termId + `/startTerm`);
};

const didntClick = (e) =>{
  e.preventDefault()
  //window.location.href = '/signUp';
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
        <h1>Term Details</h1>
        <Paper elevation={3} style={paperStyle}>
  
        <Button variant="contained" color="secondary" onClick={startClick}>
          Start
        </Button>

        <Button variant="contained" color="secondary" onClick={didntClick}>
          Did't come
        </Button>

        </Paper>

      </Container>
      

    </Box>
  );
}