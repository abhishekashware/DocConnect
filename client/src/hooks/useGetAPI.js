import axios from 'axios';
import React, { useEffect, useState } from 'react'

const useGetAPI = (url) => {
    const [loading,setLoading]=useState(true);
    const [data,setData]=useState([]);
    const [error,setError]=useState(null);
    useEffect(()=>{
        const fetchData=async ()=>{
            try{
                const data= await axios.get(url);
                setData(data.data);
            }catch(err){
                setError(err);
                console.log(err);
            }finally{
                setLoading(false);
            }
        }
        fetchData();
    },[url]);
  return {loading,data,error};
}

export default useGetAPI