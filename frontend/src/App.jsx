import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import { AuthProvider, useAuth } from "./context/AuthContext";
import RutaProtegida from "./components/RutaProtegida";
import HomePage from "./pages/HomePage";
import ComidasPage from "./pages/ComidasPage";
import LoginPage from "./pages/LoginPage";
import RegistroPage from "./pages/RegistroPage";
import FavoritosPage from "./pages/FavoritosPage";
import EjerciciosPage from "./pages/EjerciciosPage";

function Menu() {
  const { token, logout } = useAuth();

  return (
    <nav>
      <Link to="/">Inicio</Link>
      {token && (
        <>
          {" | "}<Link to="/comidas">Comidas</Link>
          {" | "}<Link to="/ejercicios">Ejercicios</Link>
          {" | "}<Link to="/favoritos">Favoritos</Link>
        </>
      )}
      {token ? (
        <> | <button onClick={logout}>Cerrar sesión</button></>
      ) : (
        <> | <Link to="/login">Login</Link></>
      )}
    </nav>
  );
}

function App() {
  return (
    <AuthProvider>
      <BrowserRouter>
        <Menu />
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/registro" element={<RegistroPage />} />
          <Route
            path="/favoritos"
            element={
              <RutaProtegida>
                <FavoritosPage />
              </RutaProtegida>
            }
          />
          <Route
            path="/comidas"
            element={
              <RutaProtegida>
                <ComidasPage />
              </RutaProtegida>
            }
          />
          <Route
            path="/ejercicios"
            element={
              <RutaProtegida>
                <EjerciciosPage />
              </RutaProtegida>
            }
          />
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  );
}

export default App;