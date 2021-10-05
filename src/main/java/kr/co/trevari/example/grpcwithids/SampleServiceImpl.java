package kr.co.trevari.example.grpcwithids;

import io.grpc.stub.StreamObserver;
import kr.co.example.trevari.SampleRequest;
import kr.co.example.trevari.SampleResponse;
import kr.co.example.trevari.SampleServiceGrpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SampleServiceImpl extends SampleServiceGrpc.SampleServiceImplBase {

    @Override
    public void sampleCall(SampleRequest request, StreamObserver<SampleResponse> responseObserver) {
        log.info("SampleServiceImple#sampleCall - {}, {}", request.getUserId(), request.getMessage());
        SampleResponse sampleResponse = SampleResponse.newBuilder()
                .setMessage("grpc service response")
                .build();

        responseObserver.onNext(sampleResponse);
        responseObserver.onCompleted();
    }
}
