package com.geekychetan.springboot_grpc_server;

import org.springframework.grpc.server.service.GrpcService;

import io.grpc.stub.StreamObserver;

@GrpcService
public class GrpcServerService extends UserServiceGrpc.UserServiceImplBase {

	@Override
	public void getUserDetails(UserRequest request, StreamObserver<UserResponse> responseObserver) {
		System.out.println("Request received from client: " + request.getId());
		UserResponse userResponse = UserResponse.newBuilder()
			.setName("Name of the user id: " + request.getId() + " is 'CHAI'")
			.build();
		responseObserver.onNext(userResponse);
		responseObserver.onCompleted();
	}

}
