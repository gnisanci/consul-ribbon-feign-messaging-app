package gurkan.nisanci.external;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ExternalApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExternalApplication.class, args);
    }
}
