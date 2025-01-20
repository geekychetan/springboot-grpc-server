package com.geekychetan.springboot_grpc_server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.grpc.server.service.GrpcService;

import io.grpc.stub.StreamObserver;

@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {

	private static Log logger = LogFactory.getLog(GrpcServerService.class);

	@Override
	public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
		logger.info("Request received from client: " + request.getName());
		// super.sayHello(request, responseObserver);
		HelloReply response = HelloReply.newBuilder()
			.setMessage("Hey... " + request.getName() + ", Welcome to Geek on Wheels!")
			.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
