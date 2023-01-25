import * as React from 'react';
import {useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import './styles/Contact.scss'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'
import { useParams } from 'react-router-dom';

const AdministratorComplaint = () => {
  let { id } = useParams();
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}
  const[text, setText] = useState('')
  const handleClick = (e) =>{
    e.preventDefault()
    let response = ""
    const complaint = {text, response}
    console.log(complaint);
    var test = JSON.parse(localStorage.getItem('testToken'))
    fetch("http://localhost:8081/api/complaint/centerAdmin/" + localStorage.getItem('reg_user_username') + "/" + localStorage.getItem('centerAdmin_username'), {
    method:"POST",
    headers : { 
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        Authorization: `Bearer ${test.accessToken}`,
       },
    body:JSON.stringify(complaint)

  }).then(() =>{
    console.log("New complaint added")
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
        <h1>Write complaint about center</h1>
        <Paper elevation={3} style={paperStyle}>

          <TextField id="standard-basic" label="text" variant="standard" fullWidth 
                value={text}
                onChange = {(e) =>setText(e.target.value)}
          />
        <Button variant="contained" color="secondary" onClick={handleClick}>
          Submit
        </Button>

        </Paper>

      </Container>
    </Box>
  )
}

export default AdministratorComplaint