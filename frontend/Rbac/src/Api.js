// src/api.js
import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080", // change if your backend URL is different
});

export default api;
