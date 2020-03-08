package in.hp.boot.resources;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hp.boot.configs.DBConfigs;

@RestController
@RequestMapping("/config")
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
	private DBConfigs dbConfigs;
	
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
}
