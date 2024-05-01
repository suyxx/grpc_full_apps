package org.example.user.service;

import io.grpc.stub.StreamObserver;
import org.example.model.UserGenreUpdateRequest;
import org.example.model.UserResponse;
import org.example.model.UserSearchRequest;
import org.example.model.UserServiceGrpc;
import org.example.model.common.Genre;
import org.example.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    private UserRepository repository;

    @Override
    public void getUserGenre(UserSearchRequest request, StreamObserver<UserResponse> responseObserver) {
        UserResponse.Builder builder = UserResponse.newBuilder();
        this.repository.findById(request.getLoginId())
                .ifPresent(user -> {builder.setName(user.getName())
                        .setLoginId(user.getLogin())
                        .setGenre(Genre.valueOf(user.getGenre().toUpperCase()));
                });

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateUserGenre(UserGenreUpdateRequest request, StreamObserver<UserResponse> responseObserver) {
        UserResponse.Builder builder = UserResponse.newBuilder();
        this.repository.findById(request.getLoginId())
                .ifPresent(user -> {
                    user.setGenre(request.getGenre().toString());
                    builder.setName(user.getName())
                            .setLoginId(user.getLogin())
                            .setGenre(Genre.valueOf(user.getGenre().toUpperCase()));

                });

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
