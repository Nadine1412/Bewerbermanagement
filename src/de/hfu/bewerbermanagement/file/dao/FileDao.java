package de.hfu.bewerbermanagement.file.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.fasterxml.jackson.databind.JsonNode;

public class FileDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private JsonNode jsonNode;

	public FileDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// Files von der JSP in die Datenbank schreiben
	public int saveFileUpload(de.hfu.bewerbermanagement.file.model.File f) {
		String key = "file.upload";
		String statement = jsonNode.get(key).asText();

		if (statement != null) {
			try {
				int counter = jdbcTemplate.update(statement, new Object[] { f.getFilename(), f.getFile(),
						f.getDescription(), f.getUploadDate(), f.getA_id() });

				return counter;
			} catch (Exception e) {
				return 0;
			}
		} else {
			return 0;
		}
	}

	// Files anzeigen
	public List<de.hfu.bewerbermanagement.file.model.File> showFiles(int a_id) {

		// get SQL Statement
		String key = "file.show";
		String statement = jsonNode.get(key).asText();
		if (statement != null) {
			try {
				statement = statement + a_id;

				List<Map<String, Object>> resultList = jdbcTemplate.queryForList(statement);
				List<de.hfu.bewerbermanagement.file.model.File> fileList = new ArrayList<de.hfu.bewerbermanagement.file.model.File>();
				for (Map<String, Object> map : resultList) {

					de.hfu.bewerbermanagement.file.model.File file = new de.hfu.bewerbermanagement.file.model.File();

					int applID = (int) map.get("a_id");
					file.setA_id(applID);

					file.setFilename((String) map.get("file_name"));

					byte[] fileBytes = (byte[]) map.get("file_data");
					file.setFile(fileBytes);

					file.setDescription((String) map.get("description"));
					Date uploadDate = (Date) map.get("upload_date");
					file.setUploadDate(uploadDate.toLocalDate());

					fileList.add(file);
				}

				return fileList;
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}
}
