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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@SpringBootApplication
@Slf4j
@EnableCaching
public class AeroDreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeroDreamApplication.class, args);
	}

	@Bean
	@Order(1)
	ApplicationRunner applicationRunner(ClienteRepository clienteRepository) {
		return args -> {
			Cliente c = Cliente.builder()
					.nombre("Jose")
					.correo("Jose@correo.com")
					.telefono("3123249245")
					.user(UserEntity.builder()
							.username("Jose")
							.password(new BCryptPasswordEncoder().encode("123"))
							.roles(Set.of(Role.builder()
									.rol(EnumRol.ADMIN)
									.build()))
							.build())
					.build();
			log.info(c.toString());
			clienteRepository.save(c);
		};
	}

	@Bean
	@Order(2)
	ApplicationRunner applicationRunner2(ClienteRepository clienteRepository) {
		return args -> {
			Cliente c = Cliente.builder()
					.nombre("Maria")
					.correo("Maria@correo.com")
					.telefono("3145248719")
					.user(UserEntity.builder()
							.username("Maria")
							.password(new BCryptPasswordEncoder().encode("321"))
							.roles(Set.of(Role.builder()
									.rol(EnumRol.CLIENT)
									.build()))
							.build())
					.build();
			log.info(c.toString());
			clienteRepository.save(c);
		};
	}

}
