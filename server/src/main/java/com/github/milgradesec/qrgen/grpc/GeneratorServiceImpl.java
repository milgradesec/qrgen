package com.github.milgradesec.qrgen.grpc;

public class GeneratorServiceImpl extends GeneratorServiceGrpc.GeneratorServiceImplBase {
    @Override
    public void generate(QRRequest req, StreamObserver<QRResponse> responseObserver) {
        QRResponse reply = QRResponse.newBuilder().setStatus("OK").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
