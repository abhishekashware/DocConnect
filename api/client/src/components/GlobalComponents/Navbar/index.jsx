import Logo from 'assets/images/Logo.svg'

import Section from 'components/GlobalComponents/Section'
import { fonts } from 'fonts'
import { Link, NavLink } from 'react-router-dom'
import styled from "styled-components/dist/styled-components.js"
import Button from 'components/GlobalComponents/Button'

const Nav = styled.nav`
    padding: 20px 0;
    background: ${"#ffffff"};
    position: sticky;
    top: 0;
    z-index: 2;
`
const NavSection = styled(Section)`
    display: flex;
    justify-content: space-between;
    align-items: center;
`

const NavLeft = styled.div``
const NavRight = styled.div`
    display: flex;
    align-items: center;
    gap: 40px;
    font-weight: ${fonts.regular};
    font-size: 20px;
`
const LinkContainer = styled.div`
    display: flex;
    gap: 20px;
`

const StyledNavLink = styled(NavLink)`
    color: ${"#000000"};
`
const ButtonContainer = styled.div``



const Navbar = () => {
    return (
        <Nav>
            <NavSection>
                <NavLeft>
                    <Link to="/">
                        <img src={Logo}  style={{height:'80px'}}  alt={"Doctor Sahab Logo"} />
                    </Link>
                </NavLeft>
                <NavRight>
                    <LinkContainer>
                        <StyledNavLink to="/" exact activeStyle={{ color: "#396F78" }}>
                            Home
                        </StyledNavLink>
                        <StyledNavLink to="/about" exact activeStyle={{ color: "#396F78" }}>
                            About
                        </StyledNavLink>
                        <StyledNavLink to="/covid19" exact activeStyle={{ color: "#396F78" }}>
                            Covid19
                        </StyledNavLink>
                        <StyledNavLink to="/doctors" exact activeStyle={{ color: "#396F78" }}>
                            Doctors
                        </StyledNavLink>
                    </LinkContainer>
                    <ButtonContainer>
                        <Link to="/login_options">
                            <Button>
                                Get Started
                            </Button>
                        </Link>

                    </ButtonContainer>
                </NavRight>
            </NavSection>

        </Nav>
    )
}

export default Navbar
