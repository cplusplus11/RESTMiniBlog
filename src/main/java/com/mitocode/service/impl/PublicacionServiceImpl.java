package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.mitocode.dao.IPublicacionDAO;
import com.mitocode.model.Mencion;
import com.mitocode.model.Persona;
import com.mitocode.model.Publicacion;
import com.mitocode.model.Tag;
import com.mitocode.service.IPublicacionService;

@Named
public class PublicacionServiceImpl implements IPublicacionService, Serializable{

	@EJB
	private IPublicacionDAO dao;

	@Override
	public int registrar(Publicacion publicacion) throws Exception {
		List<Tag> tags = new ArrayList<>();
		List<Mencion> menciones = new ArrayList<>();
		
		String texto = publicacion.getCuerpo();
		texto = texto.replaceAll(",", "");
		String[] arreglo = texto.split(" "); 
		
		for(String elemento: arreglo) {
			if(elemento.startsWith("@")) {
				elemento = elemento.substring(1, elemento.length());
				menciones.add(new Mencion(publicacion, elemento));
			}
			
			if(elemento.startsWith("#")) {
				elemento = elemento.substring(1, elemento.length());
				tags.add(new Tag(publicacion, elemento));
			}
		}
		
		publicacion.setTags(tags);
		publicacion.setMenciones(menciones);
		
		int rpta = dao.registrar(publicacion);
		
		return rpta > 0 ? 1 :0;
		
	}

	@Override
	public int modificar(Publicacion t) throws Exception {
		int rpta = dao.modificar(t);
		return rpta > 0 ? 1 :0;
	}

	@Override
	public int eliminar(Publicacion t) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminar(t);
	}

	@Override
	public List<Publicacion> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Publicacion listarPorId(Publicacion t) throws Exception {
		// TODO Auto-generated method stub
		return null; // ?
	}

	@Override
	public List<Publicacion> listarPublicacionesPorPublicador(Persona publicador) throws Exception {
		return dao.listarPublicacionesPorPublicador(publicador);
	}

	@Override
	public List<Publicacion> listarPublicacionesDeSeguidores(Persona per) {
		
		return dao.listarPublicacionesDeSeguidores(per);
	}
}
