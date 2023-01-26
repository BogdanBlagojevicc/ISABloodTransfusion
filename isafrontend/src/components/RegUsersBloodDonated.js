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
import { useNavigate } from 'react-router-dom'

const RegUsersBloodDonated = () => {
  const [users, setUsers] = useState([])
//   const[firstnumber, setFirstNumber] = useState('')
//   const[secondnumber, setSecondNumber] = useState('')
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}

const columns =[
{dataField:'firstName', text:'FirstName', sort:true, filter: textFilter()},
{dataField:'LastName', text:'LastName',sort:true, filter: textFilter()},
{dataField:'Email', text:'Email', sort:true, filter: textFilter()},
{dataField:'DonationDate', text:'DonationDate', sort:true, filter: textFilter()},

]
  const navigate = useNavigate();

//   const rowEvent = {
//     onClick: (e, row) => {
//       navigate(`/Careers/`+row.id);
//       // window.location.href = `/Careers?id=${row}`;
//     },
//   }; 
  
//ispraviti
const FirstNameAsc = (e) =>{
    e.preventDefault()
    fetch("http://localhost:8081/api/centers/countryASC")
    .then(res =>res.json())
    .then((result)=>
    {
      setCenters(result);
    }
    )
  };

  const handleClick = (e) =>{
    e.preventDefault()
    fetch("http://localhost:8081/api/centers/filter/"+firstnumber+"/"+secondnumber)
    .then(res =>res.json())
    .then((result)=>
    {
      setCenters(result);
    }
    )
  };

  useEffect(()=>{
    var test = JSON.parse(localStorage.getItem('testToken'))
    fetch("http://localhost:8081/api/centers/nameDESC",{
      headers : { 
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        Authorization: `Bearer ${test.accessToken}`,
       },
    })
    .then(res =>res.json())
    .then((result)=>
    {
        setUsers(result);
    }
    )
  }, [])
  return (
    <div className='app-container'>
      <BootstrapTable bootstrap4 keyField='name' columns = {columns}
       data ={users} 
       rowEvents={rowEvent} 
       filter = {filterFactory()}/>
<Paper elevation={3} style={paperStyle}>
        {/* <TextField id="standard-basic" variant="standard" label="Min grade"  
        value={firstnumber}
        onChange = {(e) =>setFirstNumber(e.target.value)}
        //onChange = {(e) => setPas(e.target.value)}
        />
        
        <TextField id="standard-basic" variant="standard" label="Max grade"  
          value={secondnumber}
          onChange = {(e) =>setSecondNumber(e.target.value)}
          /> */}
        <Button variant="contained" color="secondary" onClick={handleClick}>
          Search
        </Button>

</Paper>
     
    </div>
  )
}

export default RegUsersBloodDonated