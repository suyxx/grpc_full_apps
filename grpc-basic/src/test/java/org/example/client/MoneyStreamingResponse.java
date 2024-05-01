package org.example.client;

import com.example.models.Money;
import io.grpc.stub.StreamObserver;

public class MoneyStreamingResponse implements StreamObserver<Money> {

    @Override
    public void onNext(Money money) {
        System.out.println("Received Money "+ money.getValue());
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("throwable = " + throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        System.out.println(
                "Server is Done!!"
        );
    }
}
