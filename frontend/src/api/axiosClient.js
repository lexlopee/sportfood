import axios from "axios";

const axiosClient = axios.create({
    baseURL: "http://localhost:8080/api/v1",
})
axiosClient.interceptors.request.use((config) => {
  const rutasPublicas = ["/users/login", "/users/register"];
  const esPublica = rutasPublicas.some((ruta) => config.url.startsWith(ruta));

  const token = localStorage.getItem("token");
  if (token && !esPublica) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});
export default axiosClient;