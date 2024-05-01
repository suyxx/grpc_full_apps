package org.example.movie.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.model.MovieDto;
import org.example.model.MovieSearchRequest;
import org.example.model.MovieSearchResponse;
import org.example.model.MovieServiceGrpc;
import org.example.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class MovieService extends MovieServiceGrpc.MovieServiceImplBase {

    @Autowired
    private MovieRepository repository;

    @Override
    public void getMovies(MovieSearchRequest request, StreamObserver<MovieSearchResponse> responseObserver) {
        List<MovieDto> movieDtoList = this.repository.getMovieByGenreOrderByYearDesc(request.getGenre().toString())
                .stream()
                .map(movie -> MovieDto.newBuilder()
                        .setTitle(movie.getTitle())
                        .setYear(movie.getYear())
                        .setRating(movie.getRating())
                        .build())
                .collect(Collectors.toList());
        responseObserver.onNext(MovieSearchResponse.newBuilder().addAllMovies(movieDtoList).build());
        responseObserver.onCompleted();
    }
}
