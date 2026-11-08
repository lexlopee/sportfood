import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import HomePage from "./pages/HomePage";
import ComidasPage from "./pages/ComidasPage";
import LoginPage from "./pages/LoginPage";

function App() {
  return (
    <BrowserRouter>
      <nav>
        <Link to="/">Inicio</Link> | <Link to="/comidas">Comidas</Link> | <Link to="/login">Login</Link>
      </nav>

      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/comidas" element={<ComidasPage />} />
          <Route path="/login" element={<LoginPage />} />   
     </Routes>
    </BrowserRouter>
  );
}

export default App;