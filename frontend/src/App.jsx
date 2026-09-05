import { useState } from "react";
import axiosClient from "./api/axiosCliente";

function App() {
  const [comidas, setComidas] = useState([]);

  const buscar = async () => {
    const respuest = await axiosClient.get("/themealdb/search?nombre=pizza");
    setComidas(respuest.data);
  };
  return(
    <div>
    <h1>SportFood</h1>
    <button onClick={buscar}>Buscar pizza</button>
    <ul>
      {comidas.map((comidas) =>(
        <li key={comidas.idMeal}>{comidas.strMeal}</li>
      ))}
    </ul>
    </div>
  ) 
}

export default App;