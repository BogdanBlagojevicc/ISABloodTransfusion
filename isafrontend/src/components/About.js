import React, { useEffect, useState } from 'react'
import './styles/About.css'
import {Button} from '@mui/material'
import BootstrapTable from 'react-bootstrap-table-next'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.css';
import filterFactory, { textFilter} from 'react-bootstrap-table2-filter'
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css'

const About = () => {
  const [centers, setCenters] = useState([])

const columns =[
{dataField:'name', text:'Name', sort:true, filter: textFilter()},
{dataField:'address', text:'Address',sort:true, filter: textFilter()},
{dataField:'description', text:'Description', sort:true, filter: textFilter()},
{dataField:'averageGrade', text:'Average Grade', sort:true, filter: textFilter()},
{dataField:'country', text:'Country',sort:true, filter: textFilter()}


]

  const CountryAsc = (e) =>{
    e.preventDefault()
    fetch("http://localhost:8081/api/centers/countryASC")
    .then(res =>res.json())
    .then((result)=>
    {
      setCenters(result);
    }
    )
  };

  const CountryDesc = (e) =>{
    e.preventDefault()
    fetch("http://localhost:8081/api/centers/countryDESC")
    .then(res =>res.json())
    .then((result)=>
    {
      setCenters(result);
    }
    )
  };

  const NameAsc = (e) =>{
    e.preventDefault()
    fetch("http://localhost:8081/api/centers/nameASC")
    .then(res =>res.json())
    .then((result)=>
    {
      setCenters(result);
    }
    )
  };

  const NameDesc = (e) =>{
    e.preventDefault()
    fetch("http://localhost:8081/api/centers/nameDESC")
    .then(res =>res.json())
    .then((result)=>
    {
      setCenters(result);
    }
    )
  };

  const gradeAsc = (e) =>{
    e.preventDefault()
    fetch("http://localhost:8081/api/centers/averageGradeASC")
    .then(res =>res.json())
    .then((result)=>
    {
      setCenters(result);
    }
    )
  };

  



     

  const gradeDesc = (e) =>{
    e.preventDefault()
    fetch("http://localhost:8081/api/centers/averageGradeDESC")
    .then(res =>res.json())
    .then((result)=>
    {
      setCenters(result);
    }
    )
  };

  useEffect(()=>{
    fetch("http://localhost:8081/api/centers/nameASC")
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

      {/* <Button variant="contained" color="secondary" onClick={CountryAsc}>
          CountryAsc
        </Button>
        <Button variant="contained" color="secondary" onClick={CountryDesc}>
        CountryDesc
        </Button>
        <Button variant="contained" color="secondary" onClick={NameAsc}>
          NameAsc
        </Button>
        <Button variant="contained" color="secondary" onClick={NameDesc}>
          NameDesc
        </Button>
        <Button variant="contained" color="secondary" onClick={gradeAsc}>
          gradeAsc
        </Button>
        <Button variant="contained" color="secondary" onClick={gradeDesc}>
          gradeDesc
        </Button> */}
    </div>
  )
}

export default About