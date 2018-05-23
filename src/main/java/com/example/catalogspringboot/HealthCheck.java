package com.example.catalogspringboot;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/catalog")
public class HealthCheck implements HealthIndicator {

    @Override
    @GetMapping("/health")
    public Health health() {
        int errorCode = check();
        if (errorCode != 0) {
            return Health
                    .down()
                    .withDetail("Error Code", errorCode).build();
        }
        Health.status("catalog service is UP : ").build();
        return Health.up().build();
    }

    public int check() {
        // Your logic to check health
        return 0;
    }
}
