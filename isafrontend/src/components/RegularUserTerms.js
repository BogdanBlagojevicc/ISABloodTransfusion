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


const RegularUserTerms = () => {
  let { id } = useParams();
  const [terms, setTerms] = useState([])
  const[dateTerm, setDateTerm] = useState('')
  const[duration, setDuration] = useState('')
  const[price, setPrice] = useState('')
  const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }

  const columns = [
    { dataField: 'dateTerm', text: 'Date Term' },
    { dataField: 'duration', text: 'Duration in hours' },
    { dataField: 'price', text: 'price'}
  ]

  useEffect(() => {
    var test = JSON.parse(localStorage.getItem('testToken'))
    fetch("http://localhost:8081/api/terms/order/" + id, {
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        Authorization: `Bearer ${test.accessToken}`,
      },
    })
      .then(res => res.json())
      .then((result) => {
        setTerms(result);
      }
      )
  }, [])

  const rowEvent = {
    onClick: (e, row) => {
      var test = JSON.parse(localStorage.getItem('testToken'))
      fetch("http://localhost:8081/api/terms/assign/" +row.id,{
      method:"POST",
      headers : { 
        'Content-Type': 'application/json',
         Authorization: `Bearer ${test.accessToken}`,
       },
      body:JSON.stringify(test.accessToken)
  
    }).then(() =>{
      console.log(row.id)
    })
    },
  }; 
//   const handleClick = (e) =>{
//     var test = JSON.parse(localStorage.getItem('testToken'))
//       e.preventDefault()
//       const term = {dateTerm, duration}
//       console.log(term);
//       fetch("http://localhost:8081/api/terms/" +id,{
//       method:"POST",
//       headers : { 
//         'Content-Type': 'application/json',
//          Authorization: `Bearer ${test.accessToken}`,
//        },
//       body:JSON.stringify(term)
  
//     }).then(() =>{
//       console.log("New term added")
//     })
//   };
  return (
    <div className='app-container'>
      <BootstrapTable bootstrap4 keyField='name' columns={columns}
        data={terms}
        rowEvents = {rowEvent}
        //rowEvents={rowEvent} 
        filter={filterFactory()} />
      {/* <Paper elevation={3} style={paperStyle}> */}
      {/* <TextField id="standard-basic" variant="standard" label=" Date"  
        value={dateTerm}
        onChange = {(e) =>setDateTerm(e.target.value)}
        //onChange = {(e) => setPas(e.target.value)}
        />

        
        <TextField id="standard-basic" variant="standard" label="Duration"  
          value={duration}
          onChange = {(e) =>setDuration(e.target.value)}
          />
        <Button variant="contained" color="secondary" onClick={handleClick}>
          Add new term
        </Button> */}

      {/* </Paper> */}

    </div>
  )
}

export default RegularUserTerms