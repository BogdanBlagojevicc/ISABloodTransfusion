import React, { useEffect, useState } from 'react'
import './styles/About.css'
import {Button} from '@mui/material'
import BootstrapTable from 'react-bootstrap-table-next'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.css';
import filterFactory, { textFilter} from 'react-bootstrap-table2-filter'
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css'

// import Userfront from "@userfront/react";

const ShowCenters = () => {
  const [centers, setCenters] = useState([])

const columns =[
{dataField:'name', text:'name'},
{dataField:'address', text:'address'},
{dataField:'averageGrade', text:'averageGrade'},
// {dataField:'firstName', text:'First name'},
// {dataField:'phoneNumber', text:'Phone number'},
/*
{dataField:'city', text:'City'},
{dataField:'country', text:'Country'},
{dataField:'gender', text:'Gender',sort:true, filter: textFilter()},
{dataField:'jmbg', text:'JMBG',sort:true, filter: textFilter()},
{dataField:'lastName', text:'Last name',sort:true, filter: textFilter()},
{dataField:'password', text:'Password',sort:true, filter: textFilter()},
{dataField:'profession', text:'Profession',sort:true, filter: textFilter()},
*/

]
  useEffect(()=>{
    var test = JSON.parse(localStorage.getItem('testToken'))
    fetch("http://localhost:8081/api/centers",{
      headers : { 
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        Authorization: `Bearer ${test.accessToken}`,
       },
    })
    .then(res =>res.json())
    .then((result)=>
    {
        setCenters(result);
    }
    )
  }, [])
  return (
    <div className='app-container'>
      <BootstrapTable bootstrap4 keyField='name' columns = {columns}
       data ={centers} 
       filter = {filterFactory()}/>
    </div>
  )
}

export default ShowCenters