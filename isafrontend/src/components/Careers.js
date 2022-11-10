//import React, { useEffect, useState } from 'react'
import React from "react";
import Grid from "@mui/material/Grid";
import { Button, Typography} from "@mui/material";
import { green } from "@mui/material/colors";
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axiosApi from "../api/axios";
import { useForm } from "react-hook-form";
import InputTextField from "./InputTextField"; 

const Careers = () => {
  return (
    <div>
        <h1>I am a careers page</h1>
    </div>
  )
}

 /*function UpdateAdministratorCenterForm(){

 let navigate = useNavigate();
  const {control, handleSubmit, reset} = useForm();
  const [CenterAdministrator, setCenterAdministrator] = useState({});

  const handleUpdate = async (data) => {
    try {
      const resp = await axiosApi.put(`/api/centerAdministrators/updatePassword/${CenterAdministrator.id}/`, data);
      console.log(resp.data);
      navigate('/user-profile/');
    }catch (error){
      console.log(error.response);
    }
  }

  const getAdministratorCenter = async (e) => {
    try{
      const res = await axiosApi.get('/api/centerAdministrators/user-profile/');
      console.log("Administrator centra update", res.data);
      setCenterAdministrator(res.data);
      return res.data;
    }catch (error){
      console.log(error.response);
    }
  };

  useEffect(() => {
    getAdministratorCenter().then(reset);
  },[]);

  return(
    <div>
      <Typography variant="h4" color={green[800]} marginTop={2}>
        Update profile
      </Typography>
      <Grid
        container
        marginTop={"-40px"}
        rowspacing={2}
        sx={{ padding: "55px 550px 0px 550px"}}
      >
        <Grid item xs={12}>
          <InputTextField
            name = "password"
            control = {control}
            variant = "filled"
            label = "Password"
            autoFocus
            fullWidth
          />
      </Grid>
        <Grid item xs = {12}>
          <Button
            type = "submit"
            fullWidth
            variant = "contained"
            onClick={handleSubmit(handleUpdate)}
            sx={{
                mt: 3,
                mb: 2,
                background: "#6fbf73",
                height: "30",
                "&.MuiButtonBase-root":{
                  "&:hover":{
                    backgroundColor: green[600],
                  },
                },
            }}
          >
            Submit
          </Button>  
        </Grid>
      </Grid> 
    </div>
  );
}*/

export default Careers