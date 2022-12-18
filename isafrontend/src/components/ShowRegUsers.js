import React, { useEffect, useState } from 'react'
import './styles/About.css'
import {Button} from '@mui/material'
import BootstrapTable from 'react-bootstrap-table-next'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.css';
import filterFactory, { textFilter} from 'react-bootstrap-table2-filter'
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css'
import { useNavigate } from 'react-router-dom'

// import Userfront from "@userfront/react";

const ShowRegUsers = () => {
  const [regUsers, setRegUsers] = useState([])
  const navigate = useNavigate();

const rowEvent = {
    onClick: (e, row) => {
        console.log("SAD1: " + row.id);
        navigate(`/showRegUsers/showRegUserTerms` + row.id);
    }
}

const columns =[
{dataField:'username', text:'username'},
{dataField:'firstName', text:'firstName'},
{dataField:'lastName', text:'lastName'},
{dataField:'phoneNumber', text:'phoneNumber'},
{dataField:'jmbg', text:'jmbg'},

]
  useEffect(()=>{
    var test = JSON.parse(localStorage.getItem('testToken'))
    fetch("http://localhost:8081/api/regularUsers/getAllRegularUsers",{
      headers : { 
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        Authorization: `Bearer ${test.accessToken}`,
       },
    })
    .then(res =>res.json())
    .then((result)=>
    {
        setRegUsers(result);
    }
    )
  }, [])
  return (
    <div className='app-container'>
      <BootstrapTable bootstrap4 keyField='name' columns = {columns}
       data ={regUsers} 
       rowEvents={rowEvent}
       filter = {filterFactory()}/>
    </div>
  )
}

export default ShowRegUsers