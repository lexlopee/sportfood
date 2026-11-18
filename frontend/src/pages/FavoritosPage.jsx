import { useState, useEffect } from "react";
import axiosClient from "../api/axiosClient";
import { useAuth } from "../context/AuthContext";

function FavoritosPage(){
    const [favoritos, setFavoritos] = useState([]);
    const [error, setError] = useState(null);
    const { idUsuario } = useAuth();

    const cargarFavoritos = async () => {
        setError(null);
        try{
            const respuesta = await axiosClient.get(`/users/${idUsuario}/favorites`);
            setFavoritos(respuesta.data || []);
        }catch(e){
            setError("No se ha podido ver los Favoritos")
        }
 
};

useEffect(() => {
  cargarFavoritos();
}, []);
    return(
        <div>
          <h2>Mis Favoritos</h2>
          {error && <p>{error}</p>}
          <ul>
            {favoritos.map((f) =>(
                <li key={f.idComida}>{f.nombre}</li>
            ))}
          </ul>
        </div>
    );
}
export default FavoritosPage;