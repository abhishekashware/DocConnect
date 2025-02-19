import React from "react";
import Logo from 'assets/images/Logo.svg';
import { Link, useParams } from 'react-router-dom'
import styled from "styled-components/dist/styled-components.js";


import Message from 'assets/images/message.svg'
import Notifications from 'assets/images/notifications.svg'
import ProfilePicture from 'assets/images/sampleProfilePic.jpg'
import AngleDown from 'assets/images/angle-down.svg'
import { fonts } from "fonts";
import SearchInput from 'components/GlobalComponents/SearchInput'
import { useSelector } from "react-redux";

const Nav = styled.nav`
  padding: 20px 0;
`
const NavInner = styled.div`
  margin: auto;
  padding: 0 0 0 20px;
`
const FlexContainer = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
`

const FlexLeft = styled.div`
  width: 280px;
`

const FlexRight = styled.div`
  flex: 1;
  display: flex;
  gap: 50px;
  align-items: center;
`



const NotificationsAndUser = styled.div`
  display: flex;
  align-items: center;
  gap: 25px;
`

const ImageIcon = styled.div`
    cursor: pointer;
`

const ImagesContainer = styled.div`
  display: flex;
  align-items: center;
  gap: 20px;
`

const ProfilePictureContainer = styled.div``

const ProfileName = styled.div`
  font-weight: ${fonts.medium};
  font-size: 24px;
  color: ${"#4DADBD"};
`

const UserDetails = styled.div`
  display: flex;
  gap: 8px;
  align-items: center;
`
const AngleDownImage = styled.img`
  cursor: pointer;
`

const StyledLink = styled(Link)`
  display: block;
  max-width: max-content;
`


function Navbar({ type }) {
  const hospitalLogin = useSelector((state) => {
    return state.hospitalLogin;
  });
  const userData = useSelector((state) => {
    return state.userData;
  })

  const params = useParams();
  console.log({params})
  
  const returnValidObject = (id) => {
    if (userData.userInfo && (id === userData.userInfo._id)) {
      return { ...userData.userInfo }
    }
    if (  hospitalLogin.hospitalInfo && (id === hospitalLogin.hospitalInfo._id)) {
      return { ...hospitalLogin.hospitalInfo }
    }
  }
  
  let responseObject = returnValidObject(params.id);
  
  return (
    <Nav>
      <NavInner>
        <FlexContainer>
          <FlexLeft>
            <StyledLink to={type === "hospital" ? `/${responseObject?._id}/hospitalDashboard/` : `/${responseObject?._id}/userDashboard/`}>
              <img src={Logo}   style={{height:'80px'}} alt={"Logo "} />
            </StyledLink>
          </FlexLeft>
          <FlexRight>
            <SearchInput />
            <NotificationsAndUser>
              <ImagesContainer>
                <ImageIcon>
                  <img src={Message} alt={"Message "} />
                </ImageIcon>
                <ImageIcon>
                  <img src={Notifications} alt={"Notifications"} />
                </ImageIcon>
            </ImagesContainer>
              <ProfilePictureContainer>
                <img src={ProfilePicture} alt={ "User Profile"}/>
              </ProfilePictureContainer>
              <UserDetails>
                <ProfileName>
                  {responseObject?.name ? responseObject?.name : "Abhishek Ashware"}
                </ProfileName>
                <AngleDownImage src={AngleDown} alt={"Angle Down "} />
              </UserDetails>
            </NotificationsAndUser>
          </FlexRight>
        </FlexContainer>


      </NavInner>
    </Nav>
  );
}

export default Navbar;
