import React, { useEffect, useState } from 'react'
import './styles/About.css'
import {Button} from '@mui/material'
import BootstrapTable from 'react-bootstrap-table-next'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.css';
import filterFactory, { textFilter} from 'react-bootstrap-table2-filter'
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css'
import { useParams } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'

// import Userfront from "@userfront/react";

const ShowRegUserTerms = () => {
  const [terms, setTerms] = useState([])
  let { regUserId } = useParams();
  const navigate = useNavigate();

const rowEvent = {
    onClick: (e, row) => {
        navigate(`/showRegUsers/showRegUserTerms` + regUserId + `/termDetails` + row.id);
    }
}

const columns =[
{dataField:'dateTerm', text:'dateTerm'},
{dataField:'duration', text:'duration'},

]
  useEffect(()=>{
    var test = JSON.parse(localStorage.getItem('testToken'))
    
    fetch("http://localhost:8081/api/terms/getAllTermsByRegUserId/" + regUserId ,{
      headers : { 
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
  }, [])
  return (
    <div className='app-container'>
      <BootstrapTable bootstrap4 keyField='name' columns = {columns}
       data ={terms} 
       rowEvents={rowEvent}
       filter = {filterFactory()}/>
    </div>
  )
}

export default ShowRegUserTerms