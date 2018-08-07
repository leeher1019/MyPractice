package com.mypractice.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Test {
    public static void main(String[] args){
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
                                                              @Override
                                                              public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                                                                  observableEmitter.onNext("shot");
                                                              }
                                                          }
        );

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s + "receive");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);


    }
}
