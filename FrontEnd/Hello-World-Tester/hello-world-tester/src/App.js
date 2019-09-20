import React from 'react';
import './App.css';
import helloWorld from './URLTest.json'
import axios from 'axios'

function App() {
  console.log(helloWorld.url);
  
  const [data, setData] = React.useState('');
  const [numReq, setNumReq]= React.useState(0);

  function testUrl(){
    axios.get(helloWorld.url).then(response => {
      setData(response.data.content);
      setNumReq(response.data.id);
    });
  }

  return (    
    <div className="App">
      <header className="App-header">  
     
        <button  className="btn btn-light text-dark mt-3" onClick={testUrl} >
        Test the URL
        </button>   
        <p className="App-intro">{numReq>0
        ?"Request: "+numReq
      :''
       }</p>  
        <p className="App-intro">{data}</p>      
      </header>
    </div>
  );
}

export default App;
