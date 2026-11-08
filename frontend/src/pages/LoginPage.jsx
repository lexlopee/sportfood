import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axiosClient from "../api/axiosClient";

function LoginPage() {
  const [correo, setCorreo] = useState("");
  const [contrasenia, setContrasenia] = useState("");
  const [error, setError] = useState(null);
  const [cargando, setCargando] = useState(false);

  const navigate = useNavigate();

  const entrar = async (e) => {
    e.preventDefault();
    setCargando(true);
    setError(null);

    try {
      const respuesta = await axiosClient.post(
        `/users/login?correo=${correo}&contrasenia=${contrasenia}`
      );

      if (!respuesta.data) {
        setError("Correo o contraseña incorrectos");
        return;
      }

      localStorage.setItem("token", respuesta.data);
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

      {error && <p>{error}</p>}
    </form>
  );
}

export default LoginPage;