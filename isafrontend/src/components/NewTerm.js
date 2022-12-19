import React, { useEffect, useState } from 'react'
import { Button } from '@mui/material'
import BootstrapTable from 'react-bootstrap-table-next'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.css';
import filterFactory, { textFilter } from 'react-bootstrap-table2-filter'
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css'
import TextField from '@mui/material/TextField'
import { Paper } from '@mui/material'
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom'


const NewTerm = () => {
    const [centers, setCenters] = useState([])
    const[dateTerm, setDateTerm] = useState('')
    const columns =[
        {dataField:'name', text:'Name'},
        {dataField:'address', text:'Address'},
        {dataField:'averageGrade', text:'Average Grade', sort:true},
    ]

    const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }
  
    const navigate = useNavigate();
   
    const rowEvent = {
      onClick: (e, row) => {
        var test = JSON.parse(localStorage.getItem('testToken'))
        fetch("http://localhost:8081/api/terms/scheduleTerm/" +row.id+"/"+dateTerm+"/"+1,{
        method:"POST",
        headers : { 
          'Content-Type': 'application/json',
           Authorization: `Bearer ${test.accessToken}`,
         },
        
    
      }).then(() =>{
        console.log("row.id")
      })
        navigate(`/NewTerm`);
        // window.location.href = `/Careers?id=${row}`;
      },
    }; 
    
  
    const handleClick = (e) =>{
        var test = JSON.parse(localStorage.getItem('testToken'))
        fetch("http://localhost:8081/api/terms/availableTerms/" + dateTerm,{

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
      }
      const handleClickk = (e) =>{
        navigate(`/questionaire`);
      }
      
  return (
    <div className='app-container'>
      <BootstrapTable bootstrap4 keyField='name' columns={columns}
        data={centers}
        rowEvents={rowEvent} 
        filter={filterFactory()} />
      <Paper elevation={3} style={paperStyle}>
      <TextField id="standard-basic" variant="standard" label=" Date"  
        value={dateTerm}
        onChange = {(e) =>setDateTerm(e.target.value)}
        //onChange = {(e) => setPas(e.target.value)}
        />
        <Button variant="contained" color="secondary" onClick={handleClick}>
          Add new term
        </Button>
        <Button  color="secondary" onClick={handleClickk}>
          Fill questionary
        </Button>


      </Paper>


    </div>
  )
}

export default NewTerm