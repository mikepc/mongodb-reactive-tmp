package config;


import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

/**
 * Author: Michael Draper
 * Date: 2018-10-26
 **/
@Configuration
@EnableAutoConfiguration
public class Mongo {

    @Value("${mongo.database_name}")
    private String databaseName;

    @Autowired
    MongoClient mongoClient;



    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(){
        return new ReactiveMongoTemplate(mongoClient,  databaseName );
    }

}
