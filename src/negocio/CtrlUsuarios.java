package negocio;

import java.util.List;

import dao.*;
import dominio.*;

public class CtrlUsuarios {
private UsuariosDAO daoUsuarios = new UsuariosDAO() ;
	
	public boolean crearUsuarios(String nombre, String apellido, String username, String password, int tipo) {
		if (daoUsuarios.daUsuarioByUsername(username) == null) {
			Usuarios usuarios = new Usuarios(nombre, apellido, username, password, tipo);
			daoUsuarios.guardaActualiza(usuarios) ;
			return true ;
		}
		else
			return false ;
	}
	
	public boolean eliminarUsuario(String username) {
		if (daoUsuarios.daUsuarioByUsername(username) != null) {
			Usuarios user = daoUsuarios.daUsuarioByUsername(username) ;
			daoUsuarios.eliminar(user) ;
			return true ;
		}
		else
			return false ;
	}
	
	public List<Usuarios> daUsuarios(){
		return daoUsuarios.daUsuarios() ;
	}
	
	public Usuarios daUsuarioByUsername(String username) {
		return daoUsuarios.daUsuarioByUsername(username) ;
	}

}
