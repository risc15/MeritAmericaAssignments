import React, {useState} from "react";
import 'rsuite/dist/styles/rsuite-default.css';
import {InputGroup,Input,Icon,Toggle,Loader,Col} from "rsuite";
import apiConfig from '../apiKeys';
import Conditions from "./Conditions";

const styles = {
  width: 100+"%",
  marginBottom:10
}

const GetForecast=()=>{
  const [city,setCity]=useState("");
  const [unit,setUnit]=useState("metric");
  const [loading,setLoading]=useState(true);
  const [weather,setWeather]=useState({})

  const searchWeather=()=>{
    const URL=`http://api.openweathermap.org/data/2.5/weather?q=${city}&units=${unit}&appid=${apiConfig.owmKey}`;
    fetch(URL)
            .then(res => {
                if (res.ok)
                {
                    return res.json()
                }
                else {
                    throw new Error(res.statusText);
                }
            })
            .then(
                res => {
                    setWeather({weather: res,unit:unit});
                }
            ).then(() => setLoading(false)).catch(error=>{
                console.log(error);
            });
    }
    return(
      <Col xs={24} sm={12} md={6}>
      <div className="get-forecast">
      <div style={{minHeight: 200+"px"}}>
      {loading?<Loader center size="md" content="loading..."/>:<Conditions resWeather={weather} />}
      </div>
      <InputGroup style={styles}>
      <Input type="text" id="city" value={city}  onChange={(value,event)=>setCity(event.target.value)}/>
      <InputGroup.Button onClick={searchWeather}>
      <Icon icon="search" />
      </InputGroup.Button>
      </InputGroup>
      <div>
      <Toggle size="lg"
      defaultChecked
      checkedChildren="&#176;C"
      unCheckedChildren="&#176;F"
      onChange={(state)=>{
        if (state)
        setUnit("metric")
        else
        setUnit("imperial")
      }}/>
      </div>
      </div>
      </Col>
    )
  }

  export default GetForecast;
