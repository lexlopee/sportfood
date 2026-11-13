import { createContext, useContext, useState } from "react";

const AuthContext = createContext();

export function AuthProvider({ children }) {
  const [token, setToken] = useState(localStorage.getItem("token"));
  const [idUsuario, setIdUsuario] = useState(localStorage.getItem("idUsuario"));

  const login = (nuevoToken, nuevoId) => {
    localStorage.setItem("token", nuevoToken);
    localStorage.setItem("idUsuario", nuevoId)
    setIdUsuario(nuevoId);
    setToken(nuevoToken);
  };

  const logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("idUsuario");
    setIdUsuario(null);
    setToken(null);
  };

  return (
    <AuthContext.Provider value={{ token, idUsuario, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  return useContext(AuthContext);
}