import { useState, useEffect } from 'react'
import styled from "styled-components/dist/styled-components.js"
import Logo from 'assets/images/Logo.svg'
import Button from 'components/GlobalComponents/Button/index'

import {Link} from 'react-router-dom'
import axios from 'axios'
import useGetAPI from 'hooks/useGetAPI'
import LoadingWrapper from 'components/LoadingWrapper'

const MedicineScreen = ({history}) => {
    const {loading,data,error}=useGetAPI('/api/medic/allmedicine');

    const Container = styled.div`
        width: 100%;
        height: auto;
    `
    const Nav = styled.nav`
        width: 100%;
        padding: 0.8rem 0.7rem;
        display: flex;
        justify-content: space-around;
        background: ${"#ffffff"};
        box-shadow: 0px 0px 12px -3px rgba(0,0,0,0.87);
        position: sticky;
        top: 0;
        background: 
    `
    const Body = styled.div`
        margin: 0 auto;
        width: 90%;
        padding: 1rem;
        display: grid;
        grid-template-columns: repeat(5, 1fr);
        grid-template-rows: auto;
        grid-row-gap: 1rem;
        grid-column-gap: 1rem;
    `
    const Card = styled.div`
        width: 100%;
        height: 390px;
        display: grid;
        place-items: center;
        border-radius: 12px;
        box-shadow: 0px 0px 12px -3px rgba(0,0,0,0.87);
        padding: 0.3rem 0;
    `
    const Text = styled.div`
        font-size: ${props => props.size || '0.7rem'};
    `
    const addToCart=(id)=>{
        history.push(`/cart/${id}?`)
    }
    return (
        <>
            <Container>
                <Nav>
                    <Link to="/"><img src={Logo} alt="logo"    style={{height:'80px'}}  /></Link>
                    <Link to="/cart"><Button>Cart</Button></Link>
                </Nav>
                <Body>
                <LoadingWrapper loading={loading} data={data} emptyMessage={'No Medicines found'}>
                    {data.map(medicine => {
                        return (
                                <Card key={medicine._id}>
                                    <img style={{ width: '95%', borderRadius: '12px', margin: 'auto', objectFit: 'cover' }} src={medicine.image} alt="img" />
                                    <Text size="1rem">{medicine.name}</Text>
                                    <Button onClick={()=> addToCart(medicine._id)}>Add to Cart</Button>
                                    <Text size="1.5rem">Rs: {medicine.cost}</Text>
                                </Card>
                        )
                    })
                }
                </LoadingWrapper>
                </Body>
            </Container>
        </>
    )
}

export default MedicineScreen