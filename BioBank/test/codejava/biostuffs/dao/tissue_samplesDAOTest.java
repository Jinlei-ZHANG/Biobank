package codejava.biostuffs.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import codejava.biostuffs.model.Tissue_samples;

class tissue_samplesDAOTest {
	private DriverManagerDataSource dataSource;
	private tissue_samplesDAO dao;

	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/biobank");
		dataSource.setUsername("root");
		dataSource.setPassword("19970613RACHEL");

		dao = new tissue_samplesDAOImpl(dataSource);
	}

	@Test
	void testSave() {
		Tissue_samples tissue_samples = new Tissue_samples(4, 90210, "Cerebrospinal fluid", "2019-06-03");
		int result = dao.save(tissue_samples);

		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Tissue_samples tissue_samples = new Tissue_samples(1, 4, 90, "Cerebrospinal", "2019-06-03");
		int result = dao.update(tissue_samples);

		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Tissue_samples tissue_samples = dao.get(id);
		if (tissue_samples != null) {
			System.out.print(tissue_samples);
		}

		assertNotNull(tissue_samples);
	}

	@Test
	void testDelete() {
		Integer id = 2;
		int result = dao.delete(id);

		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Tissue_samples> listSamples = dao.list();

		for (Tissue_samples aSample : listSamples) {
			System.out.println(aSample);

		}

		assertTrue(!listSamples.isEmpty());
	}

	@Test
	void testGetList() {
		Integer collection_id = 1;
		List<Tissue_samples> listSamples = dao.getlist(collection_id);

		for (Tissue_samples aSample : listSamples) {
			System.out.println(aSample);

		}

		assertTrue(!listSamples.isEmpty());
	}

}
