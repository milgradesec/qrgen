package com.github.milgradesec.qrgen.grpc;

import io.grpc.stub.StreamObserver;

public class GeneratorService extends GeneratorServiceGrpc.GeneratorServiceImplBase {
    @Override
    public void generate(QRRequest req, StreamObserver<QRResponse> responseObserver) {
        QRResponse resp = QRResponse.newBuilder().setStatus("OK").build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}
