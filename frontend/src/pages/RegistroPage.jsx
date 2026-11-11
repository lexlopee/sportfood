import { useState } from "react";
import { useAsyncError, useNavigate } from "react-router-dom";
import axiosClient from "../api/axiosClient";

function RegistroPage() {
  const [correo, setCorreo] = useState("");
  const [nombreUsuario, setNombreUsuario] = useState("");
  const [contrasenia, setContrasenia] = useState("");
  const [repetirContrasenia, setrepetirContrasenia] = useState("");
  const [fechaNacimiento, setfechaNacimiento] = useState("");

  const [error, setError] = useState(null);
  const [cargando, setCargando] = useState(false);

  const navigate = useNavigate();

  const registrar = async (e) => {
    e.preventDefault();

    if (contrasenia != repetirContrasenia){
        setError("La contraseña no coincide")
        return;
    }

    setCargando(true);
    setError(null);

    try {
      await axiosClient.post("/users/register", {
        correo,
        nombreUsuario,
        contrasenia, 
        fechaNacimiento
      });

      navigate("/login");
    } catch (e) {
      setError("No se ha podido completar el registro");
    } finally {
      setCargando(false);
    }
  };

  return (
    <form onSubmit={registrar}>
      <h2>Crear cuenta</h2>

      {/* 4. Te doy el primer input. Haz los otros cuatro igual */}
      <input
        type="email"
        value={correo}
        onChange={(e) => setCorreo(e.target.value)}
        placeholder="Correo"
        required
      />
      <input
      type="text"
      value={nombreUsuario}
      onChange={(e) => setNombreUsuario(e.target.value)}
      placeholder="Usuario"
      required
      />
      <input 
      type="password"
      value={contrasenia}
      onChange={(e) => setContrasenia(e.target.value)}
      placeholder="Contraseña"
      required
      />
      <input 
      type="password"
      value={repetirContrasenia}
      onChange={(e) => setrepetirContrasenia(e.target.value)}
      placeholder="Repetir Contraseña"
      required
      />
      <input
       type="date"
       value={fechaNacimiento}
       onChange={(e) => setfechaNacimiento(e.target.value)}
       placeholder="Fecha Nacimiento"
       />

      <button type="submit" disabled={cargando}>
        {cargando ? "Creando..." : "Crear cuenta"}
      </button>

      {error && <p>{error}</p>}
    </form>
  );
}

export default RegistroPage;