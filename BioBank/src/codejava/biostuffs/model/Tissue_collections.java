package codejava.biostuffs.model;

public class Tissue_collections {
	private Integer id;
	private String disease_term;
	private String title;

	public Tissue_collections(Integer id, String disease_term, String title) {
		this(disease_term, title);
		this.id = id;
	}

	public Tissue_collections(String disease_term, String title) {

		this.disease_term = disease_term;
		this.title = title;
	}

	public Tissue_collections() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisease_term() {
		return disease_term;
	}

	public void setDisease_term(String disease_term) {
		this.disease_term = disease_term;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Tissue_collections [id=" + id + ", disease_term=" + disease_term + ", title=" + title + "]";
	}

}
