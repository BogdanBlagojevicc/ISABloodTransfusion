import React, { useEffect, useState } from 'react'
import './styles/About.css'
import {Button} from '@mui/material'
import BootstrapTable from 'react-bootstrap-table-next'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.css';
import filterFactory, { textFilter} from 'react-bootstrap-table2-filter'
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css'
import TextField from '@mui/material/TextField'
import {Paper} from '@mui/material'

const About = () => {
  const [centers, setCenters] = useState([])
  const[firstnumber, setFirstNumber] = useState('')
  const[secondnumber, setSecondNumber] = useState('')
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}

const columns =[
{dataField:'firstName', text:'Name',  filter: textFilter()},
{dataField:'lastName', text:'Lastname',  filter: textFilter()},
// {dataField:'email', text:'email',sort:true, filter: textFilter()},
{dataField:'address', text:'address'},
{dataField:'city', text:'city'},
{dataField:'country', text:'Country'},
// {dataField:'phoneNumber', text:'phoneNumber',sort:true, filter: textFilter()},
// {dataField:'jmbg', text:'jmbg',sort:true, filter: textFilter()},
{dataField:'education', text:'education'},
{dataField:'loyalty', text:'loyalty'},
// {dataField:'points', text:'points',sort:true, filter: textFilter()},
{dataField:'penalties', text:'penalties'}


]



  useEffect(()=>{
    fetch("http://localhost:8081/api/regularUsers/getAllRegularUsers/1")
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

export default About