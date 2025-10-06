import axios from "axios";

const API_URL = "/students"; // matches your Spring Boot endpoint

export const getAllStudents = () => axios.get(API_URL);

export const getStudentById = (id) => axios.get(`${API_URL}/${id}`);

export const addStudent = (student) => axios.post(API_URL, student);