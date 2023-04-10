import './App.css';
import {BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Login from './Pages/Login';
import Login from './Pages/Home';

function App() {
  return (
    <div className="App">
     <Router>
        <Routes>
          
          <Route path="/" element={<Login/>}/>
          <Route path="/home" element={<Home/>}/>
          
        </Routes>

    </Router>
    </div>
  );
}

export default App;
