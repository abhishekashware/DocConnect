
import styled from "styled-components/dist/styled-components.js"


const Button = styled.button`
    border-radius: 20px;
    outline: none;
    border: none;
    padding: 12px 20px;
    color: ${props => props.outlined === true ? "#396F78" : "#ffffff"};
    border: 2px solid${props => props.outlined === true ? "#396F78" : "transparent"};
    cursor: pointer;
    background: ${props => props.outlined === true ? "transparent" : "#396F78"};
    &:disabled {
        background: #858585;
    }
`

export default Button;

