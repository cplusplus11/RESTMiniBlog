package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.facelets.Tag;
import javax.inject.Named;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Mencion;
import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@Named
public class PersonaServiceImpl implements IPersonaService, Serializable{

	@EJB //@Inject
	private IPersonaDAO dao;
	
	/*public PersonaServiceImpl() {
		dao = new PersonaDAOImpl();
	}*/
	
	@Override
	public int registrar(Persona per) throws Exception {
		int rpta = dao.registrar(per);
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public int modificar(Persona per) throws Exception {
		int rpta =  dao.modificar(per);
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public int eliminar(Persona per) throws Exception {		
		return dao.eliminar(per);
	}

	@Override
	public List<Persona> listar() throws Exception {
		return dao.listar();
	}

	@Override
	public Persona listarPorId(Persona per) throws Exception {
		return dao.listarPorId(per);
	}

}
