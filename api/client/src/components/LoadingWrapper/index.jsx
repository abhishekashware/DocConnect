import React from 'react'
import ReactLoading from 'react-loading'
const LoadingWrapper = ({loading,data,children,emptyMessage}) => {
  
  if(loading){
    return (
      <div style={{display:'flex',justifyContent:'center',alignItems:'center'}}>
        <ReactLoading type="spin" color='#4DADBD' height='100px' width='100px'/>
        </div>
    )
  }
  return data.length>0?(
    <>{children}</>
  ):(
    <h1>{emptyMessage}</h1>
  )

}

export default LoadingWrapper