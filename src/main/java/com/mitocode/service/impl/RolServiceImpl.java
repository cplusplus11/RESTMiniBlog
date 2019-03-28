package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.mitocode.dao.IRolDAO;
import com.mitocode.model.Rol;
import com.mitocode.model.Usuario;
import com.mitocode.service.IRolService;

@Named
public class RolServiceImpl implements IRolService, Serializable{

	@EJB
	private IRolDAO dao;


	@Override
	public int registrar(Rol t) throws Exception {
		int rpta = dao.registrar(t);
		return dao.registrar(t);
	}

	@Override
	public int modificar(Rol t) throws Exception {
		int rpta = dao.modificar(t);
		return rpta>0 ? 1: 0;
	}

	@Override
	public int eliminar(Rol t) throws Exception {
		return dao.eliminar(t);
	}

	@Override
	public List<Rol> listar() throws Exception {
		return dao.listar();
	}

	@Override
	public Rol listarPorId(Rol t) throws Exception {
		return dao.listarPorId(t);
	}

	@Override
	public Integer asignar(Usuario usuario, List<Rol> roles) {		
		/*try {
			List<UsuarioRol> usuario_roles = new ArrayList<>();
			
			roles.forEach(r -> {
				UsuarioRol ur = new UsuarioRol();
				ur.setUsuario(usuario);
				ur.setRol(r);
				usuario_roles.add(ur);
			});
			
			dao.asignar(usuario, usuario_roles);
		} catch (Exception e) {
			return 0;
		}
		
		return 1;*/
		return 0;
	}


}
