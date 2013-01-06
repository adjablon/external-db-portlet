package adjablon.ext.db.portlet;

import org.springframework.jdbc.core.JdbcTemplate;


/**
 * @author Adam Jabłoński
 *
 */
public class PersonDao {

	private JdbcTemplate jdbcTemplate;
	
	public Long countPersons(String surname) {
		return this.jdbcTemplate.queryForLong("select count(*) from PERSONS where SURNAME = ?", surname);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
