package in.hp.boot.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("db")
@Profile("test")
public class TestDBConfigs implements DBConfiguration {
	
	@Value("test")
	private String activeProfile;
	private String host;
	private String username;
	private String schema;
	private int port;
	
	public String getActiveProfile() {
		return activeProfile;
	}
	public void setActiveProfile(String activeProfile) {
		this.activeProfile = activeProfile;
	}
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
		return "TestDBConfigs [activeProfile=" + activeProfile + ", host=" + host + ", username=" + username
				+ ", schema=" + schema + ", port=" + port + "]";
	}
	
}
