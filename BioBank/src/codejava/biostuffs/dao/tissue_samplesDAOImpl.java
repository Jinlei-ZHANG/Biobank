package codejava.biostuffs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import codejava.biostuffs.model.Tissue_samples;

public class tissue_samplesDAOImpl implements tissue_samplesDAO {

	private JdbcTemplate jdbcTemplate;

	public tissue_samplesDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Tissue_samples s) {
		String sql = "INSERT INTO tissue_samples(collection_id,donor_count,material_type,last_updated) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, s.getCollection_id(), s.getDonor_count(), s.getMaterial_type(),
				s.getLast_updated());
	}

	@Override
	public int update(Tissue_samples s) {
		String sql = "UPDATE tissue_samples SET donor_count=?,material_type=?,last_updated=? WHERE id=?";
		return jdbcTemplate.update(sql, s.getDonor_count(), s.getMaterial_type(), s.getLast_updated(), s.getId());
	}

	@Override
	public Tissue_samples get(Integer id) {
		String sql = "SELECT * FROM tissue_samples WHERE id=" + id;

		ResultSetExtractor<Tissue_samples> extractor = new ResultSetExtractor<Tissue_samples>() {

			@Override
			public Tissue_samples extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Integer collection_id = rs.getInt("collection_id");
					Integer donor_count = rs.getInt("donor_count");
					String material_type = rs.getString("material_type");
					String last_updated = rs.getString("last_updated");

					return new Tissue_samples(id, collection_id, donor_count, material_type, last_updated);
				}

				return null;
			}

		};

		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {

		String sql = "DELETE FROM tissue_samples WHERE id=" + id;
		return jdbcTemplate.update(sql);

	}

	@Override
	public List<Tissue_samples> list() {
		String sql = "SELECT * FROM tissue_samples";

		RowMapper<Tissue_samples> rowMapper = new RowMapper<Tissue_samples>() {

			@Override
			public Tissue_samples mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				Integer collection_id = rs.getInt("collection_id");
				Integer donor_count = rs.getInt("donor_count");
				String material_type = rs.getString("material_type");
				String last_updated = rs.getString("last_updated");

				return new Tissue_samples(id, collection_id, donor_count, material_type, last_updated);
			}

		};

		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<Tissue_samples> getlist(Integer collection_id) {
		String sql = "SELECT * FROM tissue_samples where collection_id =" + collection_id;

		RowMapper<Tissue_samples> rowMapper = new RowMapper<Tissue_samples>() {

			@Override
			public Tissue_samples mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				Integer collection_id = rs.getInt("collection_id");
				Integer donor_count = rs.getInt("donor_count");
				String material_type = rs.getString("material_type");
				String last_updated = rs.getString("last_updated");

				return new Tissue_samples(id, collection_id, donor_count, material_type, last_updated);
			}

		};

		return jdbcTemplate.query(sql, rowMapper);
	}

}
