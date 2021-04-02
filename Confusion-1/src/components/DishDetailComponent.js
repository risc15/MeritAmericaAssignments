import React, { Component } from 'react';
import {Card, CardImg, CardBody, CardTitle, Breadcrumb, BreadcrumbItem, CardText, Modal, ModalHeader, ModalBody, Button, Label, Col, Row } from 'reactstrap';
import { Link } from 'react-router-dom';
import { Control, LocalForm, Errors } from 'react-redux-form';
import { Loading } from './LoadingComponent';
import { baseUrl } from '../shared/baseUrl';
import { FadeTransform, Fade, Stagger } from 'react-animation-components';

// These constants are used for form validation
const required = (val) => val && val.length;
const maxLength = (len) => (val) => !(val) || (val.length <= len);
const minLength = (len) => (val) => (val) && (val.length >= len);

// The CommentForm component class, as specified in the instructions
class CommentForm extends Component {

  constructor(props) {
    super(props);

    // Setting a state here for the modal to be hidden
    this.state = {
      isModalOpen: false
    }

    this.toggleModal = this.toggleModal.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);

  }

  // Every time this method is called, it toggles the modal to true or false
  toggleModal() {
    this.setState({
      isModalOpen: !this.state.isModalOpen
    });
  }

  // When the LocalForm is submitted, it shows an alert and logs to the console
  handleSubmit(values) {
    this.props.postComment(this.props.dishId, values.rating, values.author, values.comment);
//    console.log("Current State is: " + JSON.stringify(values));
//    alert("Current State is: " + JSON.stringify(values));
  }

  render() {
    return(
      <React.Fragment>
        <div>
          <Button outline onClick={this.toggleModal} >
            <span className="fa fa-pencil fa-lg"></span> Submit Comment
          </Button>
        </div>

        <Modal isOpen={this.state.isModalOpen} toggle={this.toggleModal} >
          <ModalHeader toggle={this.toggleModal} >Submit Comment</ModalHeader>
          <ModalBody>
            <LocalForm onSubmit={(values) => this.handleSubmit(values)}>

              {/* The Rating row */}
              <Row className="form-group">
                <Label htmlfor="rating" md={12}>Rating</Label>
                <Col md={12}>
                <Control.select
                  model=".rating"
                  name="rating"
                  className="form-control"
                >
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option>
                </Control.select>
                </Col>
              </Row>

              {/* The "Your Name" row */}
              <Row className="form-group">
                <Label htmlfor="author" md={12}>Your Name</Label>
                <Col md={12}>
                  <Control.text
                    model=".author"
                    id="author"
                    name="author"
                    placeholder="Your Name"
                    className="form-control"
                    validators={{required, minLength: minLength(3), maxLength: maxLength(15)}}
                  />
                  <Errors
                    className="text-danger"
                    model=".name"
                    show="touched"
                    messages={{
                      required: 'Required. ',
                      minLength: 'Must be greater than 2 characters. ',
                      maxLength: 'Must be 15 characters or less. '
                    }}
                  />
                </Col>
              </Row>

              {/* The Comment row */}
              <Row className="form-group">
                <Label htmlfor="comment" md={12}>Comment</Label>
                <Col md={12}>
                  <Control.textarea
                    model=".comment"
                    id="comment"
                    className="form-control"
                    name="comment"
                    rows="6"
                  />
                </Col>
                </Row>

              {/* The row for the Submit button */}
              <Row className="form-group">
                <Col md={{size: 12}}>
                  <Button type="submit" color="primary">Submit</Button>
                </Col>
              </Row>
            </LocalForm>
          </ModalBody>
        </Modal>
      </React.Fragment>
    );
  }
}

function RenderDish({dish}){
  return (
    <div className="col-12 col-md-5 m-1">
    <FadeTransform
              in
              transformProps={{
                  exitTransform: 'scale(0.5) translateY(-50%)'
              }}>
          <Card>
              <CardImg top src={baseUrl + dish.image} alt={dish.name} />
              <CardBody>
                  <CardTitle>{dish.name}</CardTitle>
                  <CardText>{dish.description}</CardText>
              </CardBody>
          </Card>
          </FadeTransform>
    </div>
  );
}

function RenderComments({comments, postComment, dishId}){
  if (comments != null) return(
    <div className="col-12 col-md-5 m-1">
      <h4>Comments</h4>
      <ul className="list-unstyled">
        <Stagger in>
          {comments.map((comment) => {
            return (
              <Fade in>
                <li key={comment.id}>
                  <p>{comment.comment}</p>
                  <p>-- {comment.author} , {new Intl.DateTimeFormat('en-US', { year: 'numeric', month: 'short', day: '2-digit'}).format(new Date(Date.parse(comment.date)))}</p>
                </li>
              </Fade>
            );
          })}
        </Stagger>
      </ul>

      {/*Adding the CommentForm component here to render a button*/}
      <CommentForm dishId={dishId} postComment={postComment} />
    </div>
  );
  else return (
    <div></div>
  );
}
const DishDetail = (props) => {
  if (props.isLoading) {
    return (
      <div className="container">
        <div className="row">
          <Loading />
        </div>
      </div>
    );
  } else if (props.errMess) {
    return (
      <div className="container">
        <div className="row">
          <h4>{props.errMess}</h4>
        </div>
      </div>
    );
  } else if (props.dish != null) return (

    <div class="container">
      <div className="row">
        <Breadcrumb>
          <BreadcrumbItem><Link to='/menu'>Menu</Link></BreadcrumbItem>
          <BreadcrumbItem active>{props.dish.name}</BreadcrumbItem>
        </Breadcrumb>
        <div className="col-12">
          <h3>{props.dish.name}</h3>
          <hr />
        </div>
      </div>
      <div className="row">
        <RenderDish dish={props.dish} />
        <RenderComments comments={props.comments} postComment={props.postComment} dishId={props.dish.id} />
			</div>
	  </div>
  );
  else return (
    <div></div>
  );
}
export default DishDetail;
