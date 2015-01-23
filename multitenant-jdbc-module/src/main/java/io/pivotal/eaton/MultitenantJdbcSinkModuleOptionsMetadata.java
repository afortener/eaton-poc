package io.pivotal.eaton;

import org.springframework.xd.jdbc.JdbcConnectionMixin;
import org.springframework.xd.jdbc.JdbcConnectionPoolMixin;
import org.springframework.xd.jdbc.JdbcSinkModuleOptionsMetadata;
import org.springframework.xd.module.options.spi.Mixin;
import org.springframework.xd.module.options.spi.ModuleOption;

/**
 * Extends the standard JdbcSinkModuleOptionsMetadata to add
 * custom fields for the Eaton PoC.
 * 
 * @author Brian Jimerson
 *
 */
@Mixin({JdbcConnectionMixin.class, JdbcConnectionPoolMixin.class, JdbcSinkModuleOptionsMetadata.JdbcSinkImportToJdbcMixin.class})
public class MultitenantJdbcSinkModuleOptionsMetadata extends
		JdbcSinkModuleOptionsMetadata {
	
	private String multitenantField = null;

	/**
	 * Gets the field that should be used
	 * to determine the multitenancy table name.
	 * 
	 * @return The field to use determine the full
	 * table name.
	 */
	public String getMultitenantField() {
		return multitenantField;
	}

	/**
	 * Sets the field that should be used
	 * to determine the multitenancy table name.
	 * 
	 * @param multitenantField The field to use to determine
	 * the full table name.
	 */
	@ModuleOption("The field that is used to determine the full table name.")
	public void setMultitenantField(String multitenantField) {
		this.multitenantField = multitenantField;
	}

}
