import React, { useEffect, useState } from 'react'
import './styles/About.css'
import {Button} from '@mui/material'
import BootstrapTable from 'react-bootstrap-table-next'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.css';
import filterFactory, { textFilter} from 'react-bootstrap-table2-filter'
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css'
import { useNavigate } from 'react-router-dom'

const AdministratorComplaintList = () => {
    const [adminCenters, setAdminCenters] = useState([])

    const columns =[
        {dataField:'firstName', text:'First name'},
        {dataField:'lastName', text:'Last name'},
        {dataField:'address', text:'Address'},
        {dataField:'email', text:'Email'},
        {dataField:'phoneNumber', text:'Phone number'},
        
        
        ]

    const navigate = useNavigate();

    const rowEvent = {
    onClick: (e, row) => {
        localStorage.setItem('centerAdmin_username', row.username)
        navigate(`/AdministratorComplaint/`+row.id);
    },
    }; 

    useEffect(()=>{
        var test = JSON.parse(localStorage.getItem('testToken'))
        fetch("http://localhost:8081/api/centerAdministrators/complaint/" + localStorage.getItem('reg_user_username'),{
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
    <BootstrapTable bootstrap4 keyField='name' columns = {columns}
       data ={adminCenters} 
       rowEvents={rowEvent} 
       filter = {filterFactory()}/>
    </div>
  )
}

export default AdministratorComplaintList