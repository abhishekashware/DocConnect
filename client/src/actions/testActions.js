import axios from "axios"
import { DOCTOR_LOGIN_FAIL, DOCTOR_LOGIN_REQUEST } from "constants/doctorConstants"

export const ActionFill=(a1,a2)=>async (dispatch,getState)=>{
try{
dispatch({
    type:DOCTOR_LOGIN_REQUEST
})

const {data}=new axios.post('http://aaa.cm',{
    s:1,
    t:2
})

}catch(error){
    dis
    throw new Error("hello")
}
}