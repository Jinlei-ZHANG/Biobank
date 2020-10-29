package codejava.biostuffs.model;

public class Tissue_samples {
	private Integer id;
	private Integer collection_id;
	private Integer donor_count;
	private String material_type;
	private String last_updated;

	public Tissue_samples(Integer id, Integer collection_id, Integer donor_count, String material_type,
			String last_updated) {
		this(collection_id, donor_count, material_type, last_updated);
		this.id = id;

	}

	public Tissue_samples(Integer collection_id, Integer donor_count, String material_type, String last_updated) {
		this.collection_id = collection_id;
		this.donor_count = donor_count;
		this.material_type = material_type;
		this.last_updated = last_updated;
	}

	public Tissue_samples() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCollection_id() {
		return collection_id;
	}

	public void setCollection_id(Integer collection_id) {
		this.collection_id = collection_id;
	}

	public Integer getDonor_count() {
		return donor_count;
	}

	public void setDonor_count(Integer donor_count) {
		this.donor_count = donor_count;
	}

	public String getMaterial_type() {
		return material_type;
	}

	public void setMaterial_type(String material_type) {
		this.material_type = material_type;
	}

	public String getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}

	@Override
	public String toString() {
		return "Tissue_samples [id=" + id + ", collection_id=" + collection_id + ", donor_count=" + donor_count
				+ ", material_type=" + material_type + ", last_updated=" + last_updated + "]";
	}

}
