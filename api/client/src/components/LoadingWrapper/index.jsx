import React from 'react'
import ReactLoading from 'react-loading'
const LoadingWrapper = ({loading,children}) => {
  
  if(loading){
    return (
        <ReactLoading type="spin" color='grey' height='200px' width='300px'/>
    )
  }
  return (
    {children}
  )

}

export default LoadingWrapper