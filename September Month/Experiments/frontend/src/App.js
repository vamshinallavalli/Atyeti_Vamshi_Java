import React from "react";
import StudentList from "./components/StudentList";
import AddStudent from "./components/AddStudent";
import GetStudentById from "./components/GetStudentById";

function App() {
  return (
    <div style={{ padding: "20px" }}>
      <h1>🎓 Student Management System</h1>
      <AddStudent />
      <hr />
      <GetStudentById />
      <hr />
      <StudentList />
    </div>
  );
}

export default App;