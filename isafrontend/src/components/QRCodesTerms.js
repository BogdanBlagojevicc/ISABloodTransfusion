import React from 'react'
import { useEffect, useState } from 'react'
import QRCode from 'react-qr-code'
import {Button} from '@mui/material'

const QRCodesTerms = () => {
  const [terms, setTerms] = useState([])


  useEffect(() => {
    var test = JSON.parse(localStorage.getItem('testToken'))
    fetch("http://localhost:8081/api/terms/scheduledTerms/" + localStorage.getItem('reg_user_username') , {
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        Authorization: `Bearer ${test.accessToken}`,
      },
    })
      .then(res => res.json())
      .then((result) => {
        setTerms(result);
      }
      )
  }, []);

  const sortAscending = (e) =>{
    var test = JSON.parse(localStorage.getItem('testToken'))
    e.preventDefault()
    fetch("http://localhost:8081/api/terms/termASC/" + localStorage.getItem('reg_user_username'),{
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        Authorization: `Bearer ${test.accessToken}`,
      },
    })
    .then(res =>res.json())
    .then((result)=>
    {
      setTerms(result);
    }
    )
  };

  const sortDescending = (e) =>{
    var test = JSON.parse(localStorage.getItem('testToken'))
    e.preventDefault()
    fetch("http://localhost:8081/api/terms/termDESC/" + localStorage.getItem('reg_user_username'),{
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        Authorization: `Bearer ${test.accessToken}`,
      },
    })
    .then(res =>res.json())
    .then((result)=>
    {
      setTerms(result);
    }
    )
  };

  return (
    <div>
      <h1>QR Codes </h1>
      <Button variant="contained" sx={{mr:3}}  color="secondary" onClick={sortAscending}>
          Sort ascending
      </Button>

      <Button variant="contained" sx={{mr:3}} color="secondary" onClick={sortDescending}>
          Sort descending
      </Button>
      <br/>
      {
        terms.map(term => <><br></br><QRCode value={(term.dateTerm).toString()} /> <br></br></>)
      }
      
    </div>
  )
}

export default QRCodesTerms