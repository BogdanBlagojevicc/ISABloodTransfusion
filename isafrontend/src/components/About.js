import React, { useEffect, useState } from 'react'
import './styles/About.css'

const About = () => {
  const [centers, setCenters] = useState([])

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
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Description</th>
            <th>Average grade</th>
            <th>Country</th>
            <th>Start time</th>
            <th>End time</th>
          </tr>
        </thead>
        <tbody>
          {centers.map((center) =>
            <tr>
                <td>{center.name}</td>
                <td>{center.address}</td>
                <td>{center.description}</td>
                <td>{center.averageGrade}</td>
                <td>{center.country}</td>
                <td>{center.startTime}</td>
                <td>{center.endTime}</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  )
}

export default About