import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axiosClient from "../api/axiosClient";
import { useAuth } from "../context/AuthContext";
import { Link } from "react-router-dom";

function LoginPage() {
  const [correo, setCorreo] = useState("");
  const [contrasenia, setContrasenia] = useState("");
  const [error, setError] = useState(null);
  const [cargando, setCargando] = useState(false);
  const { login } = useAuth();
  const navigate = useNavigate();

  const entrar = async (e) => {
    e.preventDefault();
    setCargando(true);
    setError(null);

    try {
      const respuesta = await axiosClient.post(
        `/users/login?correo=${correo}&contrasenia=${contrasenia}`
      );

      if (!respuesta.data || !respuesta.data.token) {
        setError("Correo o contraseña incorrectos");
        return;
      }
      login(respuesta.data.token, respuesta.data.idUsuario);
      navigate("/comidas");
    } catch (e) {
      setError("No se ha podido conectar con el servidor");
    } finally {
      setCargando(false);
    }
  };

  return (
    <form onSubmit={entrar}>
      <h2>Iniciar sesión</h2>

      <input
        type="email"
        value={correo}
        onChange={(e) => setCorreo(e.target.value)}
        placeholder="Correo"
        required
      />

      <input
        type="password"
        value={contrasenia}
        onChange={(e) => setContrasenia(e.target.value)}
        placeholder="Contraseña"
        required
      />

      <button type="submit" disabled={cargando}>
        {cargando ? "Entrando..." : "Entrar"}
      </button>
      <p>¿No tienes cuenta? <Link to="/registro">Regístrate</Link></p>

      {error && <p>{error}</p>}
    </form>
  );
}

export default LoginPage;