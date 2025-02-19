import styled from "styled-components/dist/styled-components.js"

import Card from 'components/DashboardShared/CardLayout'
import EditProfileForm from 'components/UserDashboard/EditProfileForm'
import EditButton from 'assets/images/edit.svg'
import { fonts } from 'fonts';
import { useState, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchUserProfileAction } from "actions/userActions";
import { useParams } from "react-router-dom/cjs/react-router-dom.min";
import LoadingWrapper from "components/LoadingWrapper";



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
const CardBody = styled.div`
        padding: 0 50px;
        display: flex;
        gap: 230px;
`

const IconButton = styled.button`
    border-radius: 999px;
    background: ${"#4DADBD"};
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    border: 1px solid ${"#4DADBD"};
    width: 50px;
    height: 50px;
    display: grid;
    place-content: center;
  `
const Line = styled.div`
    margin: 30px 0;
    height: 1px;
    width: 100%;
    background: ${"#396F78"};
  `

const Icons = styled.div``

const CardBodyTitle = styled.div`
    font-size: 24px;
    font-weight: ${fonts.medium};
    margin-bottom: 10px;
  `

const CardBodyDescription = styled.div`
    font-size: 20px;
    font-weight: ${fonts.light};
    opacity: 0.8;
  `

const CardItem = styled.div`
    margin-bottom: 25px;
  `

const CardBodyRight = styled.div``
const CardBodyLeft = styled.div``



const Index = () => {

    const [open, setOpen] = useState(false);
    const userData = useSelector(state => state.userData)
    const params=useParams();
    const dispatch=useDispatch();

    const fetchData=async ()=>{    
    console.log("data",userData);
    await dispatch(fetchUserProfileAction(params.id))
    }
    useEffect(() => {
        fetchData()
    }, [])

    const info = userData.userInfo;
    return (
        <Card>
            <CardHeader>
                <Title>
                    Account
                </Title>
                {
                userData.loading?(''):(
                <Icons>
                    <IconButton onClick={() => setOpen(true)}>
                        <img src={EditButton} alt={"Edit Button "} />
                    </IconButton>
                </Icons>
                )
                }
            </CardHeader>
            <Line />
            <LoadingWrapper loading={userData.loading} data={[userData]} emptyMessage={'No Details Found'}>
            <CardBody>
                <CardBodyLeft>
                    <CardItem>
                        <CardBodyTitle>
                            User ID
                        </CardBodyTitle>
                        <CardBodyDescription>
                            {info?._id}
                        </CardBodyDescription>
                    </CardItem>
                    <CardItem>
                        <CardBodyTitle>
                            Name
                        </CardBodyTitle>
                        <CardBodyDescription>
                            {info?.name}
                        </CardBodyDescription>
                    </CardItem>
                    <CardItem>
                        <CardBodyTitle>
                            Email
                        </CardBodyTitle>
                        <CardBodyDescription>
                            {info?.email}
                        </CardBodyDescription>
                    </CardItem>
                </CardBodyLeft>
                <CardBodyRight>
                    <CardItem>
                        <CardBodyTitle>
                            Date Of Birth
                        </CardBodyTitle>
                        <CardBodyDescription>
                            {info?.dob}
                        </CardBodyDescription>
                    </CardItem>
                    <CardItem>
                        <CardBodyTitle>
                            Primary Number
                        </CardBodyTitle>
                        <CardBodyDescription>
                            {info?.contacts}
                        </CardBodyDescription>
                    </CardItem>
                </CardBodyRight>
            </CardBody>
            </LoadingWrapper>
            <EditProfileForm open={open} setOpen={setOpen} />
        </Card>
    )
}

export default Index
