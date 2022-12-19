import React, { useEffect, useState, useRef } from 'react'
import Box from '@mui/material/Box';
import './styles/Contact.scss'
import TextField from '@mui/material/TextField'
import { Container } from '@mui/system';
import {Paper, Button} from '@mui/material'
import { useParams } from 'react-router-dom'

export default function StartTerm() {
  const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto"}
  var [questionnaire, setQuestionnaire] = useState([])
  var [warehousee, setWarehousee] = useState([])
  var [updatedWarehousee, setUpdatedWarehousee] = useState([])
  let { termId } = useParams();
  let { regUserId } = useParams();

  var [isFelGood, setIsFelGood] = useState('')
  var [isSkinChang, setisSkinChang] = useState('')
  var [isPrevTherMoreThanSixDays, setisPrevTherMoreThanSixDays] = useState('')
  var [isInMonthlyCycle, setInMonthlyCycle] = useState('')
  var [isPrevDentalInterMoreThanSicDay, setisPrevDentalInterMoreThanSicDay] = useState('')
  var [isPrevSurgicalInterMoreThanSicMonths, setisPrevSurgicalInterMoreThanSicMonths] = useState('')

  var [bqA, setBqA]  = useState('')
  var [bqB, setBqB]  = useState('')
  var [bqAB, setBqAb]  = useState('')
  var [bq0, setBq0]  = useState('')
  var [needle, setNeedle]  = useState('')
  var [testTube, setTestTube]  = useState('')
  var [bandag, setBandag]  = useState('')


  useEffect(() =>{
    var test = JSON.parse(localStorage.getItem('testToken'))
    console.log("IDR:" + regUserId);
    fetch("http://localhost:8081/api/questionnaire/getOneByRegularUserId/" + regUserId,{
        
        headers : { 
            'Content-Type': 'application/json',
            'Accept': 'application/json',
            Authorization: `Bearer ${test.accessToken}`,
           },
    })
    .then(res => res.json())
    .then((result) =>
    {
        setQuestionnaire(result);
    }
    )

    fetch("http://localhost:8081/api/warehouse/getOneByTermId/" + termId,{
    headers : { 
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        Authorization: `Bearer ${test.accessToken}`,
       },
    })
    .then(res => res.json())
    .then((result) =>
    {
      setWarehousee(result);
    }
    )

    if(questionnaire.isFeelsGood == true){
        setIsFelGood("Yes");
    }else{
        setIsFelGood("No");
    }

    if(questionnaire.isSkinChanged == true){
        setisSkinChang("Yes");
    }else{
        setisSkinChang("No");
    }

    if(questionnaire.isPreviousTherapyMoreThanSixDays == true){
        setisPrevTherMoreThanSixDays("Yes");
    }else{
        setisPrevTherMoreThanSixDays("No");
    }

    if(questionnaire.isUnderRegularMonthlyCycle == true){
        setInMonthlyCycle("Yes");
    }else{
        setInMonthlyCycle("No");
    }

    if(questionnaire.isUnderRegularMonthlyCycle == true){
        setisPrevDentalInterMoreThanSicDay("Yes");
    }else{
        setisPrevDentalInterMoreThanSicDay("No");
    }

    if(questionnaire.isUnderRegularMonthlyCycle == true){
        setisPrevSurgicalInterMoreThanSicMonths("Yes");
    }else{
        setisPrevSurgicalInterMoreThanSicMonths("No");
    }


  },[])

  const handleClick = (e) =>{
    e.preventDefault()
    var admin = warehousee;
    admin.bloodQuantityA = bqA;
    admin.bloodQuantityB = bqB;
    admin.bloodQuantityAB = bqAB;
    admin.bloodQuantity0 = bq0;
    admin.needles = needle;
    admin.testTubes = testTube;
    admin.bandage = bandag;

    console.log(admin);
    var test = JSON.parse(localStorage.getItem('testToken'))
    fetch("http://localhost:8081/api/warehouse/update/1",{
      method:"PUT",
      headers:{
        "Content-Type":"application/json",
        Authorization: `Bearer ${test.accessToken}`,
      },
      body:JSON.stringify(admin)
  
    }).then(() =>{
      console.log("Admin changed")
    })
}

// const notAllowClick = (e) =>{
//   e.preventDefault()
//   var admin = warehousee;
//   admin.bloodQuantityA = bqA;
//   admin.bloodQuantityB = bqB;
//   admin.bloodQuantityAB = bqAB;
//   admin.bloodQuantity0 = bq0;
//   admin.needles = needle;
//   admin.testTubes = testTube;
//   admin.bandage = bandag;
  
//   var test = JSON.parse(localStorage.getItem('testToken'))
//   fetch("http://localhost:8081/api/regularUsers/updatePenalty/" + regUserId,{
//     method:"PUT",
//     headers:{
//       "Content-Type":"application/json",
//       Authorization: `Bearer ${test.accessToken}`,
//     },
//     body:JSON.stringify(admin)

//   }).then(() =>{
//     console.log("Admin changed")
//   })
// }

  return (
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <Container>
        <h1>Start term</h1>
        <Paper elevation={3} style={paperStyle}>

        <label>Questionnaire datails:</label>
        <br/>
        <br/>

        <label> Date of donation:  {questionnaire.currentDateTime}</label>
        <br/>

        <label> Number of previous Transfusions:  {questionnaire.previousTransfusions}</label>
        <br/>

        <label> Weight:  {questionnaire.weight}</label>
        <br/>

        <label> Are you feel good:  {isFelGood}</label>
        <br/>

        <label> Is skin changed:  {isSkinChang}</label>
        <br/>

        <label> High blood pressure:  {questionnaire.highBloodPressure}</label>
        <br/>

        <label> Low blood pressure:  {questionnaire.lowBloodPressure}</label>
        <br/>

        <label> Is previous therapy more than six days:  {isPrevTherMoreThanSixDays}</label>
        <br/>

        <label> Are you in monthly cycle (woman):  {isInMonthlyCycle}</label>
        <br/>

        <label> Is previous dental intervention more than six days:  {isPrevDentalInterMoreThanSicDay}</label>
        <br/>

        <label> Is previous surgical intervention or blood donation more than six months:  {isPrevSurgicalInterMoreThanSicMonths}</label>
        <br/>

        <label> Blood type:  {questionnaire.bloodType}</label>
        <br/>

        </Paper>

        <Paper elevation={3} style={paperStyle}>

        <label>Warehouse datails:</label>
        <br/>
        <br/>


        <TextField id="standard-basic" variant="standard" label="bloodQuantityA" fullWidth 
        placeholder={warehousee.bloodQuantityA}
        onChange = {(e) => setBqA(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="bloodQuantityB" fullWidth 
        placeholder={warehousee.bloodQuantityB}
        onChange = {(e) => setBqB(e.target.value)}
        />

       <TextField id="standard-basic" variant="standard" label="bloodQuantityAB" fullWidth 
        placeholder={warehousee.bloodQuantityAB}
        onChange = {(e) => setBqAb(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="bloodQuantity0" fullWidth 
        placeholder={warehousee.bloodQuantity0}
        onChange = {(e) => setBq0(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="Needles" fullWidth 
        placeholder={warehousee.needles}
        onChange = {(e) => setNeedle(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="testTubes" fullWidth 
        placeholder={warehousee.testTubes}
        onChange = {(e) => setTestTube(e.target.value)}
        />

        <TextField id="standard-basic" variant="standard" label="bandage" fullWidth 
        placeholder={warehousee.bandage}
        onChange = {(e) => setBandag(e.target.value)}
        />

        <Button variant="contained" color="secondary" onClick={handleClick}>
          Submit
        </Button>

        {/* <Button variant="contained" color="secondary" onClick={notAllowClick}>
          Not allow
        </Button> */}
        
        </Paper>
        

      </Container>
    </Box>
  );
}
