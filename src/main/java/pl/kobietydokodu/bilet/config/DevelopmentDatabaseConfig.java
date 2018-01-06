package pl.kobietydokodu.bilet.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.mysql.jdbc.Driver;

import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService;

@Configuration
@Profile({"development", "test"})
public class DevelopmentDatabaseConfig {
 
  protected static final int DB_PORT = 3310;
  
  @Bean
  @DependsOn("mariadb4j")
  public DataSource ds() {
    SimpleDriverDataSource ds = new SimpleDriverDataSource();
    ds.setDriverClass(Driver.class);
    ds.setUrl(String.format("jdbc:mysql://localhost:%d/test", DB_PORT));
    ds.setUsername("root");
    return ds;
  }
  
  @Bean(name = "mariadb4j")
  public MariaDB4jSpringService mariaDB4j() {
    MariaDB4jSpringService service = new MariaDB4jSpringService();
    service.setDefaultPort(DB_PORT);
    return service;
  }
  
}
