import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, Link, browserHistory, IndexRoute } from 'react-router'
import GetForecast from "./Components/GetForecast";

class Home extends React.Component {
   render() {
      return (
         <div>
            <GetForecast/>
         </div>
      )
   }
}
export default Home;
