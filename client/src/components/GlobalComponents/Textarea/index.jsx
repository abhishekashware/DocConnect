
import styled from "styled-components/dist/styled-components.js"

const Textarea = styled.textarea`
    background: ${"#4DADBD"};
    border-radius: 10px;
    outline: none;
    width: ${props => props.fluid ? "100%" : 'initial'};
    padding: 20px;
    height: 100px;
    overflow: hidden;
      &:focus {
        box-shadow: 0 0 0 2pt ${"#4DADBD"};
    }
`

export default Textarea;