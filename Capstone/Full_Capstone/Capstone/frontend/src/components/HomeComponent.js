  
import React from 'react'
import HomeSection from './HomeSectionComponent';
import {homeObjOne} from '../shared/data'


function Home() {
    return (
        <>
        <HomeSection {...homeObjOne} />
        
        
        </>

    );
}
export default Home;