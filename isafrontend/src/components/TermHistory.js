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


const TermHistory = () => {
  let { id } = useParams();
  const [terms, setTerms] = useState([])
  const[dateTerm, setDateTerm] = useState('')
  const[duration, setDuration] = useState('')
  const[price, setPrice] = useState('')
  const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }

  const columns = [
    { dataField: 'dateTerm', text: 'Date Term', sort:true },
    { dataField: 'duration', text: 'Duration in hours', sort:true },
    {dataField: 'price', text: 'Price', sort:true}
  ]

  useEffect(() => {
    var test = JSON.parse(localStorage.getItem('testToken'))
    fetch("http://localhost:8081/api/terms/finishedTerms/" + localStorage.getItem('reg_user_username') , {
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
        filter={filterFactory()} />
    </div>
  )
}

export default TermHistory