package com.pa.aerodream;

import com.pa.aerodream.persistence.entity.Cliente;
import com.pa.aerodream.persistence.entity.Role;
import com.pa.aerodream.persistence.entity.UserEntity;
import com.pa.aerodream.persistence.entity.enums.EnumRol;
import com.pa.aerodream.persistence.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.Set;

@SpringBootApplication
@Slf4j
@EnableCaching
public class AeroDreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeroDreamApplication.class, args);
	}

}
