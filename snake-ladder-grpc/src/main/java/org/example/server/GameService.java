package org.example.server;

import com.example.models.Die;
import com.example.models.GameServiceGrpc;
import com.example.models.GameState;
import io.grpc.stub.StreamObserver;

public class GameService extends GameServiceGrpc.GameServiceImplBase {

    @Override
    public StreamObserver<Die> roll(StreamObserver<GameState> responseObserver) {
        return super.roll(responseObserver);
    }
}
