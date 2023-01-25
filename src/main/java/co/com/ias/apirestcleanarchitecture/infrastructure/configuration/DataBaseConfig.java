package co.com.ias.apirestcleanarchitecture.infrastructure.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

    @Bean
    public DBSecret dbSecret(Environment env){
        return DBSecret
                .builder()
                .build();
    }


    @Bean
    @Profile("test")
    public DataSource dataSource(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.h2.Driver");
        hikariConfig.setJdbcUrl("jdbc:h2:mem:test; DB_CLOSE_DELAY =- 1");

        return new HikariDataSource(hikariConfig);
    }
}
