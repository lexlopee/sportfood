import { useState } from "react";
import axiosClient from "./api/axiosClient";

function App() {
  const [comidas, setComidas] = useState([]);
  const [busqueda, setBusqueda] = useState("");

  const buscar = async () => {
    const respuesta = await axiosClient.get(`/themealdb/search?nombre=${busqueda}`);
    setComidas(respuesta.data);
  };

  return (
    <div>
      <h1>SportFood</h1>

      <input
        type="text"
        value={busqueda}
        onChange={(e) => setBusqueda(e.target.value)}
        placeholder="Busca una comida"
      />

      <button onClick={buscar}>Buscar</button>

      <ul>
        {comidas.map((comida) => (
          <li key={comida.idMeal}>{comida.strMeal}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;