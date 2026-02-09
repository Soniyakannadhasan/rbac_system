// src/App.jsx
import React, { useState } from "react";
import Login from "./Component/Login";
import Employement from "./Component/Employement";

function App() {
  const [user, setUser] = useState(null);

  return (
    <div>
      <h1 style={{ textAlign: "center" }}>RBAC System</h1>
      {!user ? <Login setUser={setUser} /> : <Employement user={user} />}
    </div>
  );
}

export default App;
