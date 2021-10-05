package kr.co.trevari.example.grpcwithids;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GRpcWithIdsApplication implements ApplicationRunner {

	private static final int PORT = 3030;
	private static final Server SERVER = ServerBuilder.forPort(PORT)
			.addService(new SampleServiceImpl())
			.build();

	public static void main(String[] args) {
		SpringApplication.run(GRpcWithIdsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
			SERVER.start();
	}
}
