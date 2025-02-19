import { useState, useEffect } from 'react'
import { Link, useParams } from 'react-router-dom'
import Hospital from '../../../assets/images/dashboarsIcons/hospital.svg';
import Card from 'components/DashboardShared/CardLayout'
import { fonts } from 'fonts'
import styled from "styled-components/dist/styled-components.js"
import axios from 'axios'
import returnURLFromObjectOfStrings from 'utils/returnURLFromObjectOfStrings'
import truncate from 'truncate'
import LoadingWrapper from 'components/LoadingWrapper';
import useGetAPI from 'hooks/useGetAPI';

const Title = styled.div`
    font-size: 28px;
    font-weight: ${fonts.bold};
`

const CardHeader = styled.div`
    padding: 0 50px;
    display: flex;
    justify-content: space-between;
    align-items: center;
`

const Line = styled.div`
    margin: 30px 0;
    height: 1px;
    width: 100%;
    background: ${"#396F78"};
`

const CardBody = styled.div`
        padding: 0 50px;
        display: flex;
        gap: 230px;
`

const ChildCardContainer = styled.div`
    display: grid;
    grid-template-columns: repeat(3, minmax(300px, 1fr));
    gap: 65px;

`

const ChildCard = styled.div`
    background: #FBFBFB;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);    
    border-radius: 20px;
    overflow: hidden;
`
const ChildCardHeader = styled.div`

`

const ChildCardBody = styled.div`
    padding: 14px;
`

const ChildCardTitle = styled.h4`
    margin-bottom: 12px;
    font-size: 20px;
    font-weight: ${fonts.medium};
    line-height: 1.1;
`

const ChildCardImage = styled.img`
    width: 100%;
    object-fit: contain;
    height: 200px;
`

const ChildCardParagraph = styled.p`
    margin-bottom: 20px;

`
const StyledLink = styled(Link)`
    display: block;
    &:hover {
        color: #000;
    }
`

const Index = () => {

    const params = useParams();
    const {loading,data,error}=useGetAPI("/api/hospitals/allHospital");

    return (
        <Card>
            <CardHeader>
                <Title>
                    Hospitals Near You
                </Title>
            </CardHeader>
            <Line />
            <CardBody>
                <ChildCardContainer>
                    <LoadingWrapper loading={loading} data={data} emptyMessage={error?.message}> 
                    { 
                        data.map(hospital => (
                            <ChildCard >
                                <StyledLink to={`/${params.id}/userDashboard/hospitals/${hospital._id}`} key={hospital._id}>
                                    <ChildCardHeader>
                                        <ChildCardImage src={Hospital} alt={"Hospital"} />
                                    </ChildCardHeader>
                                    <ChildCardBody>
                                        <ChildCardTitle>
                                            {hospital.name}
                                        </ChildCardTitle>
                                        <ChildCardParagraph>
                                            {truncate( hospital.hospitalDescription, 150)}
                                        </ChildCardParagraph>
                                    </ChildCardBody>
                                </StyledLink>
                            </ChildCard>
                        ))
                    }
                    </LoadingWrapper>
                </ChildCardContainer>
            </CardBody>
        </Card>
    )
}

export default Index
