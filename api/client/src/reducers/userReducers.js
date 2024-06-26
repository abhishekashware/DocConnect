// import {} from '../constants/userConstants'

import {
    USER_LOGIN_REQUEST, USER_LOGIN_SUCCESS, USER_LOGIN_FAIL, USER_LOGOUT,
    USER_REGISTER_REQUEST, USER_REGISTER_SUCCESS, USER_REGISTER_FAIL,
    USER_UPDATE_PROFILE_REQUEST,
    USER_UPDATE_PROFILE_SUCCESS,
    USER_UPDATE_PROFILE_FAIL,
} from "../constants/userConstants"

const initialState = {
    userInfo: {},
    loading: false,
    error: ''
}

export const userLoginReducer=(state={...initialState}, action)=>{
    switch(action.type){
        case USER_LOGIN_REQUEST:
            return {loading: true}
        case USER_LOGIN_SUCCESS:
            return {loading: false, userInfo: action.payload}
        case USER_LOGIN_FAIL:
            return { loading: false, error: action.payload }
        case USER_LOGOUT:
            return {...initialState}
        default:
            return state
    }
}

export const userRegisterReducer= (state={...initialState}, action)=>{
    switch(action.type){
        case USER_REGISTER_REQUEST:
            return {loading: true}
        case USER_REGISTER_SUCCESS:
            return {loading: false, userInfo: action.payload}
        case USER_REGISTER_FAIL:
            return {loading: false, error: action.payload}
        default:
            return state
    }
}

export const userUpdateProfileReducer=(state={...initialState},action)=>{
    switch(action.type){
        case USER_UPDATE_PROFILE_REQUEST:
            return {
                loading:true
            }
        case USER_UPDATE_PROFILE_SUCCESS:
            return {
                loading:false,
                userInfo:action.payload
            }
        case USER_UPDATE_PROFILE_FAIL:
            return {
                loading:false,
                error:action.payload
            }
        default:
            return state
    }
}