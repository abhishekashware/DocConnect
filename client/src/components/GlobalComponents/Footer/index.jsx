

import React from 'react'
import styled from "styled-components/dist/styled-components.js"
import Section from '../Section'


const FooterContainer = styled.div`
    text-align: center;
    background: ${"#4DADBD"}1A;
    color: ${"#4F3928"};
    padding: 20px 0;
`

const index = () => {
    return (
        <FooterContainer>
            <Section>Powered by Abhi</Section>
        </FooterContainer>
    )
}

export default index
