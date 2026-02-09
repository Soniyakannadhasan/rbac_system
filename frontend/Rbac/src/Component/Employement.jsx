// src/components/EmployeeList.jsx
import React, { useEffect, useState } from "react";
import api from "../Api";


function EmployeeList({ user }) {
  const [employees, setEmployees] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    if (!user?.roleId) return;

    setLoading(true);
    api
      .get(`/employees/${user.roleId}`)
      .then((res) => setEmployees(res.data))
      .catch((err) => setError("Failed to load employees"))
      .finally(() => setLoading(false));
  }, [user?.roleId]);

  return (
    <div className="container">
      <h2>Employee List</h2>
      {loading && <p>Loading...</p>}
      {error && <p style={{ color: "red" }}>{error}</p>}
      {employees.map((emp) => (
        <div className="card" key={emp.id}>
          {emp.name && <p>Name: {emp.name}</p>}
          {emp.email && <p>Email: {emp.email}</p>}
          {emp.salary && <p>Salary: {emp.salary}</p>}
        </div>
      ))}
    </div>
  );
}

export default EmployeeList;
