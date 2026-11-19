import { useState, useEffect } from "react";
import axiosClient from "../api/axiosClient";

function EjerciciosPage() {
  const [ejercicios, setEjercicios] = useState([]);
  const [cargando, setCargando] = useState(false);
  const [error, setError] = useState(null);

  const cargarEjercicios = async () => {
    setCargando(true);
    setError(null);
    try {
      const respuesta = await axiosClient.get(`/exercisedb`);
      setEjercicios(respuesta.data || []);
    } catch (e) {
      setError("No se han podido cargar los ejercicios");
      setEjercicios([]);
    } finally {
      setCargando(false);
    }
  };

  useEffect(() => {
    cargarEjercicios();
  }, []);

  return (
    <div>
      <h2>Ejercicios</h2>
      {cargando && <p>Cargando...</p>}
      {error && <p>{error}</p>}
      <ul>
        {ejercicios.map((ejercicio) => (
          <li key={ejercicio.exerciseId}>{ejercicio.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default EjerciciosPage;