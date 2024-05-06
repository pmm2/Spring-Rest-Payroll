package demo.Payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository,OrderRepository orderRepository){
        return args -> {
            log.info("Preloading " + employeeRepository.save(new Employee("Laios","Touden", "Warrior")));
            log.info("Preloading " + employeeRepository.save(new Employee("Marcille","Donato", "Healer")));
            log.info("Preloading " + orderRepository.save(new Order("Sword", Status.COMPLETED)));
            log.info("Preloading " + orderRepository.save(new Order("Potions", Status.IN_PROGRESS)));
        };
    }
}
