import { useState } from "react";
import axiosClient from "../api/axiosClient";

function ComidasPage() {
  const [comidas, setComidas] = useState([]);
  const [busqueda, setBusqueda] = useState("");
  const [cargando, setCargando] = useState(false);
  const [error, setError] = useState(null);

  const buscar = async () => {
    setCargando(true);
    setError(null);

    try {
      const respuesta = await axiosClient.get(`/themealdb/search?nombre=${busqueda}`);
      setComidas(respuesta.data || []);
    } catch (e) {
      setError("No se han podido cargar las comidas");
      setComidas([]);
    } finally {
      setCargando(false);
    }
  };

  return (
    <div>
      <h2>Buscar comidas</h2>

      <input
        type="text"
        value={busqueda}
        onChange={(e) => setBusqueda(e.target.value)}
        placeholder="Busca una comida"
      />

      <button onClick={buscar} disabled={cargando}>
        {cargando ? "Buscando..." : "Buscar"}
      </button>

      {error && <p>{error}</p>}

      <ul>
        {comidas.map((comida) => (
          <li key={comida.idMeal}>{comida.strMeal}</li>
        ))}
      </ul>
    </div>
  );
}

export default ComidasPage;