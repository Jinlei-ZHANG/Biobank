package codejava.biostuffs.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//import codejava.biostuffs.dao.tissue_collectionsDAO;
//import codejava.biostuffs.dao.tissue_collectionsDAOImpl;
import codejava.biostuffs.model.Tissue_collections;

class tissue_collectionsDAOTest {
	private DriverManagerDataSource dataSource;
	private tissue_collectionsDAO dao;

	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/biobank");
		dataSource.setUsername("root");
		dataSource.setPassword("19970613RACHEL");

		dao = new tissue_collectionsDAOImpl(dataSource);
	}

	@Test
	void testSave() {
		Tissue_collections tissue_collections = new Tissue_collections("Fit and well", "Lymphoblastoid cell linesy");
		int result = dao.save(tissue_collections);

		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Tissue_collections tissue_collections = new Tissue_collections(3, "Fit and well", "Lymphoblastoid cell lines");
		int result = dao.update(tissue_collections);

		assertTrue(result > 0);

	}

	@Test
	void testGet() {
		Integer id = 1;
		Tissue_collections tissue_collections = dao.get(id);
		if (tissue_collections != null) {
			System.out.print(tissue_collections);
		}

		assertNotNull(tissue_collections);
	}

	@Test
	void testDelete() {
		Integer id = 5;
		int result = dao.delete(id);

		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Tissue_collections> listCollections = dao.list();

		for (Tissue_collections aCollection : listCollections) {
			System.out.println(aCollection);

		}

		assertTrue(!listCollections.isEmpty());
	}

}
