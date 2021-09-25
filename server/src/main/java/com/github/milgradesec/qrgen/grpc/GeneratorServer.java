package com.github.milgradesec.qrgen.grpc;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GeneratorServer {
    private static final Logger logger = Logger.getLogger(GeneratorServer.class.getName());

    private final int port;
    private Server server;

    public GeneratorServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        server = ServerBuilder.forPort(port).addService(new GeneratorService()).build().start();
        logger.info("gRPC GeneratorServer started.");
    }

    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
