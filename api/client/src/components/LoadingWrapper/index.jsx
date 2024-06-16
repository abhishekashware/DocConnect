import React from 'react'
import ReactLoading from 'react-loading'
const LoadingWrapper = ({loading,data,children,emptyMessage}) => {
  
  if(loading){
    return (
        <ReactLoading type="spin" color='grey' height='200px' width='300px'/>
    )
  }
  return data.length>0?(
    <>{children}</>
  ):(
    <h1>{emptyMessage}</h1>
  )

}

export default LoadingWrapper