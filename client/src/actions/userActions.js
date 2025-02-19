import axios from 'axios'
import {
  USER_LOGIN_REQUEST, USER_LOGIN_SUCCESS, USER_LOGIN_FAIL,
  USER_REGISTER_REQUEST, USER_REGISTER_SUCCESS, USER_REGISTER_FAIL, USER_LOGOUT,
  USER_UPDATE_PROFILE,
  USER_UPDATE_PROFILE_REQUEST,
  USER_UPDATE_PROFILE_FAIL,
  USER_UPDATE_PROFILE_SUCCESS,
} from '../constants/userConstants'

export const userLoginAction = (email, password) => async (dispatch, getState) => {
  try {
    dispatch({ type: USER_LOGIN_REQUEST })
    const { data } = await axios.post('/api/user/login', { email, password })
    console.log(data)

    dispatch({
      type: USER_LOGIN_SUCCESS,
      payload: data
    })
  } catch (error) {
    dispatch({
      type: USER_LOGIN_FAIL,
      payload: error.response && error.response.data.message ? error.response.data.message
        : error.message
    })
    throw new Error(error);
  }
}

export const userLogOutAction = () => async (dispatch) => {
  dispatch({
    type: USER_LOGOUT
  })
}

export const userRegisterAction = (name, email, dob, contacts, password) => async (dispatch) => {
  try {
    dispatch({
      type: USER_REGISTER_REQUEST,
    });

    const { data } = await axios.post("/api/user/register", { name, email, password, dob, contacts });
    console.log(data)
    dispatch({
      type: USER_REGISTER_SUCCESS,
      payload: data,
    });

    // localStorage.setItem("userInfo", JSON.stringify(data));

  } catch (err) {
    dispatch({
      type: USER_REGISTER_FAIL,
      payload:
        err.response && err.response.data.message
          ? err.response.data.message
          : err.message,
    });
    throw new Error(err);
  }
}


export const userUpdateProfileAction=(id,name,email,dob,phoneNo)=>async(dispatch)=>{
  try{
    dispatch({
      type:USER_UPDATE_PROFILE_REQUEST
    })
    const {data}=await axios.post(`/api/user/updateprofile/${id}`,
      {
        name,email,dob,contacts:phoneNo
      }
    )
    dispatch({
      type:USER_UPDATE_PROFILE_SUCCESS,
      payload:data
    })
  }catch(err){
    dispatch({
      type:USER_UPDATE_PROFILE_FAIL,
      payload:err
    })
    console.log(err);
  }

}

export const fetchUserProfileAction=(id)=>async(dispatch)=>{
  try{
    dispatch({
      type:USER_UPDATE_PROFILE_REQUEST
    })
    const {data}=await axios.get(`/api/user/${id}`)
    dispatch({
      type:USER_UPDATE_PROFILE_SUCCESS,
      payload:data
    })
  }catch(err){
    dispatch({
      type:USER_UPDATE_PROFILE_FAIL,
      payload:err
    })
    console.log(err);
  }

}