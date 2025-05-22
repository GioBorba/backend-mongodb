package br.com.seuprojeto.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MongoConfig {

    private MongoClient mongoClient;

    @Bean
    public MongoClient mongoClient() {
        this.mongoClient = MongoClients.create("mongodb+srv://gioborba:Fiapl!6r@cluster-fiap.quxtyzp.mongodb.net/challenge?retryWrites=true&w=majority&appName=Cluster-fiap");
        return this.mongoClient;
    }

    @PreDestroy
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

}
