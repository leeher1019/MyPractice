package com.mypractice.completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Shop {

    private static List<Shop> shopList;
    static {
        shopList = Arrays.asList(new Shop("BestPrice"),
                                 new Shop("LetsSaveBig"),
                                 new Shop("MyFavoriteShop"),
                                 new Shop("BuyItAll"),
                                 new Shop("AAA"),
                                 new Shop("BBB"),
                                 new Shop("CCC"),
                                 new Shop("DDD"),
                                 new Shop("EEE"));
    }

    private String shopName;
    private Executor executor = Executors.newFixedThreadPool(Math.min(shopList.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    public Shop(String shopName){
        this.shopName = shopName;
    }

    public String getShopName(){
        return shopName;
    }

    public List<String> findPricesBySequence(String product){
        return shopList.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getShopName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPricesByParrallel(String product){
        return shopList.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getShopName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPricesByCompletableFuture(String product){
        List<CompletableFuture<String>> priceFutures = shopList.stream()
                .map(shop ->
                    CompletableFuture.supplyAsync(() -> shop.getShopName() + " price is " + shop.getPrice(product))
                ).collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public List<String> findPricesByCompletableFutureWithExecutor(String product){
        Executor executor = Executors.newFixedThreadPool(Math.min(shopList.size(), 100), new ThreadFactory(){
            @Override
            public Thread newThread(Runnable r){
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });
        List<CompletableFuture<String>> priceFutures = shopList.stream()
                .map(shop ->
                        CompletableFuture.supplyAsync(() -> shop.getShopName() + " price is " + shop.getPrice(product), executor)
                ).collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception e){
                futurePrice.completeExceptionally(e);
            }
        }).start();
        return futurePrice;
    }

    public Future<Double> getPriceAsyncBySupply(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public double getPrice(String product){
        return calculatePrice(product);
    }

    private double calculatePrice(String product){
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    private void delay(){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args){
//        Shop shop = new Shop("BestShop");
////        long start = System.nanoTime();
////        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
////        long invocationTime = (System.nanoTime() - start) / 1000000;
////        System.out.println("Invocation returned after " + invocationTime + "msecs");
////
////        try {
////            double price = futurePrice.get();
////            System.out.printf("Price is %.2f%n", price);
////        } catch (Exception e){
////            throw new RuntimeException(e);
////        }
////
////        long retrievalTime = (System.nanoTime() - start) / 1000000;
////        System.out.println("price returned after " + retrievalTime + " msecs");
//        long start = System.nanoTime();
//        System.out.println(shop.findPricesByCompletableFutureWithExecutor("myIPhone87s"));
//        long duration = (System.nanoTime() - start) / 1000000;
//        System.out.println("Done in " + duration + " msecs");
//    }
}
