package com.geekychetan.springboot_grpc_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.grpc.server.exception.GrpcExceptionHandler;

import io.grpc.Status;

@SpringBootApplication
public class SpringbootGrpcServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGrpcServerApplication.class, args);
	}

	@Bean
	GrpcExceptionHandler globalInterceptor() {
		return exception -> {
			if (exception instanceof IllegalArgumentException) {
				return Status.INVALID_ARGUMENT.withDescription(exception.getMessage());
			}
			return null;
		};
	}

}
