import React, { useEffect, useState } from "react";
import "./App.css";

function App() {

  const [message, setMessage] = useState(""
  useEffect(() => {
    fetch("http://localhost:8081/hello")
      .then(response => response.text())
      .then(data => setMessage(data));
  }, []);

  return (
    <div style={{textAlign:"center", marginTop:"150px"}}>
      <h1>Spring Boot + React 🚀</h1>

      <div style={{
        background:"white",
        width:"400px",
        margin:"auto",
        padding:"30px",
        borderRadius:"10px",
        boxShadow:"0px 10px 20px rgba(0,0,0,0.2)",
        fontSize:"22px"
      }}>
        {message ? message : "Loading..."}
      </div>
    </div>
  );
}

export default App;