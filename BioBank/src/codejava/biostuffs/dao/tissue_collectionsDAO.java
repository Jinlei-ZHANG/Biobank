package codejava.biostuffs.dao;

import java.util.List;

import codejava.biostuffs.model.Tissue_collections;

public interface tissue_collectionsDAO {
	public int save(Tissue_collections tissue_collections);

	public int update(Tissue_collections tissue_collections);

	public Tissue_collections get(Integer id);

	public int delete(Integer id);

	public List<Tissue_collections> list();

}
