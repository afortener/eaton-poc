package io.pivotal.eaton;

import org.springframework.xd.module.options.spi.ModuleOption;

/**
 * Spring XD custom module options metadata class for the 
 * Rabbit Decoder module.
 * 
 * @author Brian Jimerson
 *
 */
public class RabbitDecoderModuleOptionsMetadata {

	private String agentId;
	private String hostname;
	private String port;
	private String username;
	private String password;
	private String virtualHost;
	private String queue;
	private boolean amplifyTrends;
	private String amplifyFactor;
	
	/**
	 * @return the agentId
	 */
	public String getAgentId() {
		return agentId;
	}
	
	/**
	 * @param agentId the agentId to set
	 */
	@ModuleOption("The unique agent ID")
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	
	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return hostname;
	}
	
	/**
	 * @param hostname the hostname to set
	 */
	@ModuleOption("The hostname of the Rabbit MQ server.")
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}
	
	/**
	 * @param port the port to set
	 */
	@ModuleOption("The port of the Rabbit MQ server.")
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username the username to set
	 */
	@ModuleOption("The username to connect with.")
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	@ModuleOption("The password to connect with.")
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the vHost
	 */
	public String getVirtualHost() {
		return virtualHost;
	}
	
	/**
	 * @param vHost the vHost to set
	 */
	@ModuleOption("The virtual host to connect to.")
	public void setVirtualHost(String virtualHost) {
		this.virtualHost = virtualHost;
	}
	
	/**
	 * @return the queue
	 */
	public String getQueue() {
		return queue;
	}
	
	/**
	 * @param queue the queue to set
	 */
	@ModuleOption("The queue to listen on.")
	public void setQueue(String queue) {
		this.queue = queue;
	}
	
	/**
	 * @return the amplifyTrends
	 */
	public boolean getAmplifyTrends() {
		return amplifyTrends;
	}
	
	/**
	 * @param amplifyTrends the amplifyTrends to set
	 */
	@ModuleOption("Whether or not trend data should be amplified.")
	public void setAmplifyTrends(boolean amplifyTrends) {
		this.amplifyTrends = amplifyTrends;
	}
	
	/**
	 * @return the amplifyFactor
	 */
	public String getAmplifyFactor() {
		return amplifyFactor;
	}
	
	/**
	 * @param amplifyFactor the amplifyFactor to set
	 */
	@ModuleOption("The factor that trends should be amplified by, if amplifyTrends is true.")
	public void setAmplifyFactor(String amplifyFactor) {
		this.amplifyFactor = amplifyFactor;
	}
	
	
}
