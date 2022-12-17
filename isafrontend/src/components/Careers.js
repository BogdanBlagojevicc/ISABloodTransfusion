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

const Careers = () => {
  let { id } = useParams();
  const [terms, setTerms] = useState([])
  const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }

  const columns = [
    { dataField: 'dateTerm', text: 'Date Term' },
    { dataField: 'duration', text: 'Duration' }
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
  return (
    <div className='app-container'>
      <BootstrapTable bootstrap4 keyField='name' columns={columns}
        data={terms}
        //rowEvents={rowEvent} 
        filter={filterFactory()} />
      <Paper elevation={3} style={paperStyle}>


      </Paper>

    </div>
  )
}

export default Careers