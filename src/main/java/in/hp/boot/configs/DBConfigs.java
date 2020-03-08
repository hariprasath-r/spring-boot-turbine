package in.hp.boot.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Annotation Configuration marks this class as spring configuration
 * TODO: Check what does that mean
 * 
 * Annotation @ConfigurationProperties allows spring to bind the properties with the value specified
 * The member variables will be binded to the properties under the value specified
 * We can inject this class and use the property values
 * 
 * @author haripr
 *
 */
@Configuration
@ConfigurationProperties(value = "db")
public class DBConfigs {
	
	private String host;
	private String username;
	private String schema;
	private int port;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "DBConfigs [host=" + host + ", username=" + username + ", schema=" + schema + ", port=" + port + "]";
	}
	
}
