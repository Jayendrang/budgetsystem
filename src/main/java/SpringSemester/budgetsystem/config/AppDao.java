package SpringSemester.budgetsystem.config;

import javax.sql.DataSource;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;

@Configuration
@ComponentScan(basePackages="SpringSemester.budgetsystem")
@PropertySource(value= {"classpath:appDAO.properties"}) 
public class AppDao {
	
	@Autowired
	private Environment environment;
	
	public AppDao() {
		System.out.println("DB Congiuration--start()");
		}
		
		
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.dbUrl}")
	private String dbURL;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${jdbc.database}")
	private String database;
	
	
	
	@Bean
	public DataSource initDataSource() throws DataSourceLookupFailureException{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(driverClassName);
		datasource.setUrl(dbURL.concat(database));
		datasource.setUsername(username);
		datasource.setPassword(password);
		

		return datasource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(){
		
		JdbcTemplate dbTemplate = new JdbcTemplate();
		dbTemplate.setDataSource(initDataSource());
		
		return dbTemplate;
	}
}
	