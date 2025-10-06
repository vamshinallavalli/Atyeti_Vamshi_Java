import React, { useState } from "react";
import { getStudentById } from "../services/studentService";

const GetStudentById = () => {
  const [id, setId] = useState("");
  const [student, setStudent] = useState(null);

  const handleSearch = () => {
    getStudentById(id)
      .then((res) => setStudent(res.data))
      .catch(() => alert("Student not found!"));
  };

  return (
    <div>
      <h2>Search Student by ID</h2>
      <input
        type="number"
        value={id}
        onChange={(e) => setId(e.target.value)}
        placeholder="Enter ID"
      />
      <button onClick={handleSearch}>Search</button>

      {student && (
        <div>
          <p><strong>ID:</strong> {student.id}</p>
          <p><strong>Name:</strong> {student.name}</p>
          <p><strong>Grade:</strong> {student.grade}</p>
        </div>
      )}
    </div>
  );
};

export default GetStudentById;