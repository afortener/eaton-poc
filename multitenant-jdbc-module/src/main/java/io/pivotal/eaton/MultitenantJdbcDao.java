package io.pivotal.eaton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

/**
 * Standard JDBC template DAO for 
 * multitenant inserts.
 * 
 * @author Brian Jimerson
 *
 */
public class MultitenantJdbcDao {

	private JdbcTemplate jdbcTemplate;
	private String baseTableName;
	private String multitenantField;
	private List<String> columnNames;
	
	private static final Log log = LogFactory.getLog(MultitenantJdbcDao.class);
	
	/**
	 * Sets the data source to be used by this DAO.
	 * 
	 * @param dataSource The data source to use.
	 */
	public void setDataSource(DataSource dataSource) {
		log.debug("Creating JDBC template with data source [" + dataSource + "].");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Inserts a record into the database.
	 * 
	 * @param payload The JSON payload to parse and
	 * insert.
	 */
	public void insertRecord(String payload) {
		String sql = this.createSqlInsertStatement(payload);
		log.info("Executing SQL statement [" + sql + "]");
		this.jdbcTemplate.update(sql);
	}
	
	/**
	 * Creates a SQL insert statement from a JSON 
	 * string of values.
	 * 
	 * @param json The JSON String of data values.
	 * @return A SQL insert statement created from the JSON.
	 */
	private String createSqlInsertStatement(String json) {
		StringBuilder sql = new StringBuilder();
		Map<String, Object> parsedPayload = this.parsePayload(json);
		sql.append("insert into ");
		sql.append(baseTableName);
		sql.append(parsedPayload.get(multitenantField));
		sql.append(" (");
		sql.append(this.getColumnsAsSql());
		sql.append(") values(");
		sql.append(this.getValuesAsSql(parsedPayload));
		sql.append(");");
		return sql.toString();
	}
	
	/**
	 * Creates a SQL snippet for the values passed in the map.
	 * 
	 * @param values A map of values to use for the SQL.
	 * @return A SQL snippet for the values passed.
	 */
	private String getValuesAsSql(Map<String, Object> values) {
		StringBuilder sb = new StringBuilder();
		for (String column : this.columnNames) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			Object value = values.get(column);
			if (value instanceof String) {
				sb.append("'");
			}
			sb.append(value);
			if (value instanceof String) {
				sb.append("'");
			}
		}
		return sb.toString();
	}
	
	/**
	 * Creates a SQL snippet for the columns set.
	 * @return The column names as a SQL snippet.
	 */
	private String getColumnsAsSql() {
		StringBuilder sb = new StringBuilder();
		for (String column : this.getColumnNames()) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(column);
		}
		return sb.toString();
	}
	
	/**
	 * Parses the payload String into a Map
	 * @param json  The JSON string to parse.
	 * @return A Map of the JSON string.  It may contain
	 * nested Maps.
	 */
	private Map<String, Object> parsePayload(String json) {
		ObjectMapper messageMapper = new ObjectMapper();
		Map<String, Object> data = null;
		try {
			data = messageMapper.readValue(json, 
					new TypeReference<Map<String, Object>>() {});
		} catch (JsonParseException e) {
			log.error("Error parsing payload JSON", e);
		} catch (JsonMappingException e) {
			log.error("Error parsing payload JSON", e);
		} catch (IOException e) {
			log.error("Error parsing payload JSON", e);
		}
		return data;
	}
	
	/**
	 * Gets the base table name.
	 * @return The base table name.
	 */
	public String getBaseTableName() {
		return baseTableName;
	}

	/**
	 * Sets the base table name.
	 * @param baseTableName The base table name.
	 */
	public void setBaseTableName(String baseTableName) {
		this.baseTableName = baseTableName;
	}

	/**
	 * Gets the multi-tenant field name.
	 * @return The multi-tenant field name.
	 */
	public String getMultitenantField() {
		return multitenantField;
	}

	/**
	 * Sets the multi-tenant field name.
	 * @param multitenantField The multi-tenant field name.
	 */
	public void setMultitenantField(String multitenantField) {
		this.multitenantField = multitenantField;
	}

	/**
	 * Gets the column names.
	 * @return The column names.
	 */
	public List<String> getColumnNames() {
		return columnNames;
	}

	/**
	 * Sets the column names.
	 * @param columnNames The column names to set.
	 */
	public void setColumnNames(String columnNames) {
		this.columnNames = new ArrayList<String>();
		String[] names = StringUtils.tokenizeToStringArray(columnNames, ",");
		for (String name : names) {
			this.columnNames.add(name.trim());
		}
	}

}
