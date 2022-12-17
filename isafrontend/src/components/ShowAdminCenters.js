import React, { useEffect, useState } from 'react'
import './styles/About.css'
import {Button} from '@mui/material'
import BootstrapTable from 'react-bootstrap-table-next'
import TableHeaderColumn from 'react-bootstrap-table-next';
import 'bootstrap/dist/css/bootstrap.min.css'
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.css';
import filterFactory, { textFilter} from 'react-bootstrap-table2-filter'
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css'

// import Userfront from "@userfront/react";

const ShowAdminCenters = () => {
  const [adminCenters, setAdminCenters] = useState([])

const rowEvent = {
  onClick: (e, row) => {
   // console.log(row);
    window.location.href = '/';
  },
};

const columns =[
{dataField:'address', text:'Address'},
{dataField:'education', text:'Education'},
{dataField:'email', text:'Email'},
{dataField:'firstName', text:'First name'},
{dataField:'phoneNumber', text:'Phone number'},


]
  useEffect(()=>{
    var test = JSON.parse(localStorage.getItem('testToken'))
    fetch("http://localhost:8081/api/centerAdministrators/1",{
      headers : { 
        'Content-Type': 'application/json',
        'Accept': 'application/json',
         Authorization: `Bearer ${test.accessToken}`,
       },
    })
    .then(res =>res.json())
    .then((result)=>
    {
        setAdminCenters(result);
    }
    )
  }, [])
  return (
    <div className='app-container'>
      <BootstrapTable keyField='name' columns = {columns}
       data ={adminCenters} 
       rowEvents={rowEvent} 
       filter = {filterFactory()} />
    </div>
  )
}

export default ShowAdminCenters