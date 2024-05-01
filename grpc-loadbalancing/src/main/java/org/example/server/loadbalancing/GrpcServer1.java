package org.example.server.loadbalancing;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.server.rpctypes.TransferService;

import java.io.IOException;

public class GrpcServer1 {

    public static void main(String[] args) throws InterruptedException, IOException {

        Server server = ServerBuilder.forPort(6565)
                .addService(new BankService())
                .addService(new TransferService())
                .build();

        server.start();

        server.awaitTermination();
    }
}
