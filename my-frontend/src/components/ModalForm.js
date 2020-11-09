import React, { useState } from "react";
import { Modal, ModalBody, Row, Col, FormGroup, Input, Form } from "reactstrap";
import { useHistory } from "react-router-dom";

function ModalForm(props) {
    const history = useHistory()
    const [client, setClient] = useState("");
    const [email, setEmail] = useState("");
    const [confirmEmail, setConfirmEmail] = useState("");
    const [errors, setErrors] = useState({});

    const handleValidation = () => {
        let errors = {};
        let formIsValid = true;

        //Client
        if(!client){
           formIsValid = false;
           errors["client"] = "Cannot be empty";
        }
  
        else if(typeof client !== "undefined"){
           if(!client.match(/^[a-zA-Z]+$/)){
              formIsValid = false;
              errors["client"] = "Only letters";
           }        
        }
   
        //Email
        if(!email){
           formIsValid = false;
           errors["email"] = "Cannot be empty";
        }
  
        else if(typeof email !== "undefined"){
           let lastAtPos = email.lastIndexOf('@');
           let lastDotPos = email.lastIndexOf('.');

           if (!(lastAtPos < lastDotPos && lastAtPos > 0 && email.indexOf('@@') === -1 && lastDotPos > 2 && (email.length - lastDotPos) > 2)) {
              formIsValid = false;
              errors["email"] = "Email is not valid";
            }
       } 
       //Confirmation Email
       if(!confirmEmail){
        formIsValid = false;
        errors["confirmEmail"] = "Cannot be empty";
     }

     else if(email !== confirmEmail){
        formIsValid = false;
        errors["confirmEmail"] = "Does not match email";
    } 

       setErrors(errors);
       return formIsValid;
   }
    
    const bookNowSubmit = () => {
        if(handleValidation()){
            props.functionVisibility(false);
            props.action(client,email);
            history.push("/thankyou");
        }else{
           alert("Form has errors.")
        }
  
    }

    return (
        <>
            <Modal isOpen={props.modal} toggle={() => (props.functionVisibility(false), setErrors({}))}>
                <div className="modal-header justify-content-center">
                    <h4 className="title title-up mb-3">Enter your details</h4>
                </div>
                <ModalBody>
                <Form className="form-design" action="" method="post" id="contactForm" novalidate="novalidate">
                    <Row>
                        <Col sm={12}>
                            <FormGroup className="form-group">
                                <Input className="form-control valid" onChange={(e) => setClient(e.target.value)} name="name" id="name" type="text" placeholder="Enter your name"></Input>
                                {errors["client"] && <span className="error">{errors["client"]}</span>}
                            </FormGroup>
                        </Col>
                        <Col sm={12}>
                            <FormGroup className="form-group">
                                <Input className="form-control valid" onChange={(e) => setEmail(e.target.value)} name="email" id="email" type="email" placeholder="Enter email address"></Input>
                                {errors["email"] && <span className="error">{errors["email"]}</span>}
                            </FormGroup>
                        </Col>
                        <Col sm={12}>
                            <FormGroup className="form-group">
                                <Input className="form-control valid" onChange={(e) => setConfirmEmail(e.target.value)} name="email" id="email" type="email" placeholder="Confirm your email address"></Input>
                                {errors["confirmEmail"] && <span className="error">{errors["confirmEmail"]}</span>}
                            </FormGroup>
                        </Col>
                    </Row>
                </Form>
                </ModalBody>
                <div className="modal-footer mt-2">
                    <span className="cancel_now" type="button" onClick={() => (props.functionVisibility(false), setErrors({}))}>Close</span>
                    <span className="book_now float-right" type="button" onClick={() => bookNowSubmit()}>Book now!</span>
                </div>
            </Modal>
        </>
    )
}

export default ModalForm;
