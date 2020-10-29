package codejava.biostuffs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import codejava.biostuffs.model.Persona;

public class personaDAOImpl implements personaDAO {

	private JdbcTemplate jdbcTemplate;

	public personaDAOImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public int save(Persona p) {
		String sql = "INSERT INTO persona(name,age,gender,occupation,computer_literacy,portrait,hobbies,bio) VALUES (?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, p.getName(), p.getAge(), p.getGender(), p.getOccupation(),
				p.getComputer_literacy(), p.getPortrait(), p.getHobbies(), p.getBio());
	}

	@Override
	public int update(Persona p) {
		String sql = "UPDATE persona SET name=?,age=?,gender=?,occupation=?,computer_literacy=?,portrait=?,hobbies=?,bio=? WHERE id=?";
		return jdbcTemplate.update(sql, p.getName(), p.getAge(), p.getGender(), p.getOccupation(),
				p.getComputer_literacy(), p.getPortrait(), p.getHobbies(), p.getBio(), p.getId());
	}

	@Override
	public Persona get(Integer id) {
		String sql = "SELECT * FROM persona WHERE id=" + id;

		ResultSetExtractor<Persona> extractor = new ResultSetExtractor<Persona>() {

			@Override
			public Persona extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String name = rs.getString("name");
					Integer age = rs.getInt("age");
					String gender = rs.getString("gender");
					String occupation = rs.getString("occupation");
					String computer_literacy = rs.getString("computer_literacy");
					String portrait = rs.getString("portrait");
					String hobbies = rs.getString("hobbies");
					String bio = rs.getString("bio");

					return new Persona(id,name, age, gender, occupation, computer_literacy, portrait, hobbies, bio);
				}

				return null;
			}

		};

		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM persona WHERE id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Persona> list() {
		String sql = "SELECT * FROM persona";

		RowMapper<Persona> rowMapper = new RowMapper<Persona>() {

			@Override
			public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				Integer age = rs.getInt("age");
				String gender = rs.getString("gender");
				String occupation = rs.getString("occupation");
				String computer_literacy = rs.getString("computer_literacy");
				String portrait = rs.getString("portrait");
				String hobbies = rs.getString("hobbies");
				String bio = rs.getString("bio");

				return new Persona(id, name, age, gender, occupation, computer_literacy, portrait, hobbies, bio);
			}

		};

		return jdbcTemplate.query(sql, rowMapper);
	}

}
