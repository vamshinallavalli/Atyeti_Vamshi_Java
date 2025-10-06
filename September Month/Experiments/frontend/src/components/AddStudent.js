import React, { useState } from "react";
import { addStudent } from "../services/studentService";

const AddStudent = () => {
  const [student, setStudent] = useState({ name: "", standard: "" });

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(student); // 🔹 debug: check what’s being sent
    addStudent(student)
      .then(() => {
        alert("Student added successfully!");
        setStudent({ name: "", standard: "" });
      })
      .catch((err) => console.error(err));
  };

  return (
    <div>
      <h2>Add Student</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="name"           // must match entity field
          placeholder="Name"
          value={student.name}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="standard"       // must match entity field
          placeholder="Standard"
          value={student.standard}
          onChange={handleChange}
          required
        />
        <button type="submit">Add</button>
      </form>
    </div>
  );
};

export default AddStudent;