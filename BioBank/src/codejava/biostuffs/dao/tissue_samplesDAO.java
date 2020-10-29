package codejava.biostuffs.dao;

import java.util.List;

import codejava.biostuffs.model.Tissue_samples;

public interface tissue_samplesDAO {
	public int save(Tissue_samples tissue_samples);

	public int update(Tissue_samples tissue_samples);

	public Tissue_samples get(Integer id);

	public int delete(Integer id);

	public List<Tissue_samples> list();
	
	public List<Tissue_samples> getlist(Integer collection_id);
	
	
}
