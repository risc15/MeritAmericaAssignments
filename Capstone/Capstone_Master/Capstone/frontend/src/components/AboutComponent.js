import React, { Component } from 'react';
import { Card, CardTitle, CardBody, CardImg, CardSubtitle } from 'reactstrap';
import '../css/About.css';

class AboutUs extends Component {


    render(){
        return(
            <div class="About-Wrapper">
                <div class="About-Container">
                    <h1>About Us</h1>
                    <Card> 
                        <CardTitle>Allana Gray</CardTitle>
                        <CardSubtitle>Front-End Developer</CardSubtitle>
                        <CardImg src="/allana.jpg" height="70" width="70" />
                        <CardBody></CardBody>
                    </Card>
                    <Card> 
                        <CardTitle>Wiliam Haywood</CardTitle>
                        <CardSubtitle>Team Lead</CardSubtitle>
                        <CardImg src="/will.jpg" height="70" width="70" />
                        <CardBody></CardBody>
                    </Card>
                    <Card> 
                        <CardTitle>Rod Wombles</CardTitle>
                        <CardSubtitle>Back-End Developer</CardSubtitle>
                        <CardImg src="/rod.jpg" height="70" width="70" />
                        <CardBody></CardBody>
                    </Card>
                </div>
            </div>
        );
    }
}

export default AboutUs