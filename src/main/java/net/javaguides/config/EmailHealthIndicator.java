package net.javaguides.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class EmailHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        try {
            // Simple logic: if no exception, service is UP
            boolean emailServiceAvailable = true;

            if (emailServiceAvailable) {
                return Health.up()
                        .withDetail("Email Service", "Available")
                        .build();
            }

            return Health.down()
                    .withDetail("Email Service", "Unavailable")
                    .build();

        } catch (Exception e) {
            return Health.down(e).build();
        }
    }
}
