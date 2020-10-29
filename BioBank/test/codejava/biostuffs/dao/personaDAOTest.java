package codejava.biostuffs.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import codejava.biostuffs.model.Persona;

class personaDAOTest {
	private DriverManagerDataSource dataSource;
	private personaDAO dao;

	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/biobank");
		dataSource.setUsername("root");
		dataSource.setPassword("19970613RACHEL");

		dao = new personaDAOImpl(dataSource);
	}

	@Test
	void testSave() {
		Persona persona = new Persona("May Black", 25, "Female", "Doctor", "Beginner", "111", "Climbing",
				"Work hard, play hard.");
		int result = dao.save(persona);

		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Persona persona = new Persona(2, "May White", 25, "Female", "Doctor", "Beginner", "111", "Climbing",
				"Work hard, play hard.");
		int result = dao.update(persona);

		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 2;
		Persona persona = dao.get(id);
		if (persona != null) {
			System.out.print(persona);
		}

		assertNotNull(persona);
	}

	@Test
	void testDelete() {
		Integer id = 1;
		int result = dao.delete(id);

		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Persona> listpersonas = dao.list();

		for (Persona aPersona : listpersonas) {
			System.out.println(aPersona);

		}

		assertTrue(!listpersonas.isEmpty());
	}

}
