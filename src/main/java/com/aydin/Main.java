package com.aydin;


import com.aydin.model.InsufficientBalanceException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {

    public static void main(String[] args) throws InsufficientBalanceException {
        SpringApplication.run(Main.class, args);
    }
}
