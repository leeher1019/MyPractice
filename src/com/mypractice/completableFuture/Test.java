package com.mypractice.completableFuture;

public class Test {
    public static void main(String[] args){
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        System.out.println(shop.findPricesByCompletableFutureWithExecutor("myIPhone87s"));
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.println("Done in " + duration + " msecs");
    }
}
