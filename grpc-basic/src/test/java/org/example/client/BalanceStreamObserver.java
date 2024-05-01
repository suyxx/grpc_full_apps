package org.example.client;

import com.example.models.Balance;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;

public class BalanceStreamObserver implements StreamObserver<Balance> {

    private CountDownLatch latch;

    public BalanceStreamObserver(CountDownLatch latch){
        this.latch = latch;
    }


    @Override
    public void onNext(Balance balance) {
        System.out.println("Final balance "+balance.getAmount());
    }

    @Override
    public void onError(Throwable throwable) {
        this.latch.countDown();
    }

    @Override
    public void onCompleted() {
        System.out.println("Server is done");
        this.latch.countDown();
    }
}
