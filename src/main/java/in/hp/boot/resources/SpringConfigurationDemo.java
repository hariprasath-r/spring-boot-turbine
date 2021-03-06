package in.hp.boot.resources;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hp.boot.configs.DBConfiguration;

/**
 * The @RefreshScope annotation is used to tell spring that this bean needs its dependencies to be refreshed when
 * actuator refresh request comes through. Spring will check the bean and inject the latest dependency
 * 
 * @author haripr
 *
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class SpringConfigurationDemo {

	/**
	 * Retrieve the spring.application.name property from the file
	 * 
	 * The value turbine-stream-application is the default value if the property key does not exist
	 */
	@Value("${spring.application.name: turbine-stream-application}")
	private String springApplicationName;
	
	@Value("${apps.number: 3}")
	private int numberOfAppsRegisteredForStreaming;
	
	@Value("${stream.app.list}")
	private List<String> appList;
	
	@Value("#{${stream.app.description}}")
	private Map<String, String> appDescription;
	
	@Autowired
	private DBConfiguration dbConfigs;
	
	/**
	 * It is not recommended to use this way
	 */
	@Autowired
	private Environment environment;
	
	@GetMapping("/details")
	public String getDetails() {
		return springApplicationName + " : " +
				numberOfAppsRegisteredForStreaming + " : " +
				appList + " : " +
				appDescription;
	}
	
	@GetMapping("/dbConfigs")
	public String getDBConfigs() {
		return dbConfigs.toString();
	}
	
	@GetMapping("/env")
	public String getEnv() {
		return environment.toString();
	}
	
	@GetMapping("/activeProfiles")
	public String[] getActiveProfiles() {
		return environment.getActiveProfiles();
	}
}
