package com.example.curso.config;

import com.example.curso.entite.Order;
import com.example.curso.entite.User;
import com.example.curso.entite.enums.OrderStatus;
import com.example.curso.repositories.OrderRepository;
import com.example.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "3146846415", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "68453434866", "123456");

        Order o1 = new Order(null, Instant.parse("2021-10-09T18:57:45Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2021-11-10T03:42:45Z"), OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null, Instant.parse("2021-11-11T15:21:25Z"), OrderStatus.WAITING_PAYMENT,u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
