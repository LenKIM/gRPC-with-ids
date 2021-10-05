package kr.co.trevari.example.grpcwithids;

import io.grpc.stub.StreamObserver;
import kr.co.trevari.example.grpcwithids.service.Snowflake;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class IdGenerator extends IdGeneratorGrpc.IdGeneratorImplBase {


    @Override
    public void nextId(Request request, StreamObserver<IdResponse> responseObserver) {
        Snowflake snowflake = Snowflake.valueOfNodeId(request.getNodeId());

        IdResponse response = IdResponse.newBuilder()
                .setId(snowflake.nextId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
