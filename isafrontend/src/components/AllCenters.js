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

const ShowCenters = () => {
  const [centers, setCenters] = useState([])

const columns =[
{dataField:'name', text:'name', sort:true, filter: textFilter()},
{dataField:'address', text:'address', sort:true, filter: textFilter()},
{dataField:'averageGrade', text:'averageGrade', sort:true, filter: textFilter()},
{dataField: 'country', text:'country', sort:true, filter: textFilter()}


]

const navigate = useNavigate();

const rowEvent = {
  onClick: (e, row) => {
    // navigate(`/Careers/`+row.id);
    navigate(`/RegularUserTerms/`+row.id);
    // window.location.href = `/Careers?id=${row}`;
  },
}; 

  useEffect(()=>{
    var test = JSON.parse(localStorage.getItem('testToken'))
    fetch("http://localhost:8081/api/centers/nameASC",{
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
       rowEvents={rowEvent} 
       filter = {filterFactory()}/>
    </div>
  )
}

export default ShowCenters