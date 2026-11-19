import { useState, useEffect } from "react";
import axiosClient from "../api/axiosClient";
import { useAuth } from "../context/AuthContext";

function RutinasPage() {
  const [rutinas, setRutinas] = useState([]);
  const [nombre, setNombre] = useState("");
  const [tiempo, setTiempo] = useState("");
  const [error, setError] = useState(null);
  const [cargando, setCargando] = useState(false);
  const { idUsuario } = useAuth();

  const cargarRutinas = async () => {
    setCargando(true);
    setError(null);
    try {
      const respuesta = await axiosClient.get(`/routines/user/${idUsuario}`);
      setRutinas(respuesta.data || []);
    } catch (e) {
      setError("No se han podido cargar las rutinas");
    } finally {
      setCargando(false);
    }
  };

  const crearRutina = async (e) => {
    e.preventDefault();
    setError(null);
    if (tiempo <= 1) {
      setError("El tiempo tiene que ser mayor que 1");
      return;
    }
    try {
      await axiosClient.post("/routines", {
        nombre,
        tiempo,
        usuarioEntity: { idUsuario: idUsuario },
      });
      setNombre("");
      setTiempo("");
      cargarRutinas();
    } catch (e) {
      setError("No se ha podido crear la rutina");
    }
  };

  useEffect(() => {
    cargarRutinas();
  }, []);

  return (
    <div>
      <h2>Mis rutinas</h2>

      <form onSubmit={crearRutina}>
        <input
          type="text"
          value={nombre}
          onChange={(e) => setNombre(e.target.value)}
          placeholder="Nombre de la rutina"
          required
        />
        <input
          type="number"
          min={1}
          value={tiempo}
          onChange={(e) => {
            const valor = e.target.value;
            if (valor === "" || Number(valor) > 0) {
              setTiempo(valor);
            }
          }}
          onKeyDown={(e) => {
            if (e.key === "-" || e.key === "e") {
              e.preventDefault();
            }
          }}
          placeholder="Minutos"
          required
        />
        <button type="submit">Crear</button>
      </form>

      {error && <p>{error}</p>}
      {cargando && <p>Cargando...</p>}

      <ul>
        {rutinas.map((r) => (
          <li key={r.idRutina}>
            {r.nombre} — {r.tiempo} min
          </li>
        ))}
      </ul>
    </div>
  );
}

export default RutinasPage;