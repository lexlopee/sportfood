import { useState } from "react";
import axiosClient from "../api/axiosClient";
import { useAuth } from "../context/AuthContext";

function ComidasPage() {
  const [comidas, setComidas] = useState([]);
  const [busqueda, setBusqueda] = useState("");
  const [cargando, setCargando] = useState(false);
  const [error, setError] = useState(null);
  const { idUsuario } = useAuth();

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

  const guardarFavorito = async (idExterno) => {
    setError(null);
    try {
      await axiosClient.post(`/users/${idUsuario}/favorites?idExterno=${idExterno}`);
    } catch (e) {
      setError("No se ha podido guardar el favorito");
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
          <li key={comida.idMeal}>
            {comida.strMeal}
            <button onClick={() => guardarFavorito(comida.idMeal)}>Guardar</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ComidasPage;