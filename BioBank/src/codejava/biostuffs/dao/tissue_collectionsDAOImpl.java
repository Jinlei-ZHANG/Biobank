package codejava.biostuffs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import codejava.biostuffs.model.Tissue_collections;

public class tissue_collectionsDAOImpl implements tissue_collectionsDAO {

	private JdbcTemplate jdbcTemplate;

	public tissue_collectionsDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Tissue_collections t) {
		String sql = "INSERT INTO tissue_collections(disease_term,title) VALUES (?,?)";
		return jdbcTemplate.update(sql, t.getDisease_term(), t.getTitle());
	}

	@Override
	public int update(Tissue_collections t) {
		String sql = "UPDATE tissue_collections SET disease_term=?,title=? WHERE id=?";
		return jdbcTemplate.update(sql, t.getDisease_term(), t.getTitle(), t.getId());
	}

	@Override
	public Tissue_collections get(Integer id) {
		String sql = "SELECT * FROM tissue_collections WHERE id=" + id;

		ResultSetExtractor<Tissue_collections> extractor = new ResultSetExtractor<Tissue_collections>() {

			@Override
			public Tissue_collections extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String disease_term = rs.getString("disease_term");
					String title = rs.getString("title");

					return new Tissue_collections(id, disease_term, title);
				}

				return null;
			}

		};

		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM tissue_collections WHERE id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Tissue_collections> list() {
		String sql = "SELECT * FROM tissue_collections";

		RowMapper<Tissue_collections> rowMapper = new RowMapper<Tissue_collections>() {

			@Override
			public Tissue_collections mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String disease_term = rs.getString("disease_term");
				String title = rs.getString("title");

				return new Tissue_collections(id, disease_term, title);
			}

		};

		return jdbcTemplate.query(sql, rowMapper);
	}

}
