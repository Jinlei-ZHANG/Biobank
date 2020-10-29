package codejava.biostuffs.dao;

import java.util.List;

import codejava.biostuffs.model.Persona;

public interface personaDAO {
	public int save(Persona persona);
	
	public int update(Persona persona);
	
	public Persona get(Integer id);
	
	public int delete(Integer id);
	
	public List<Persona> list();
	
}
