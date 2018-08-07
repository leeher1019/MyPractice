package com.mypractice.lamda.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Process {
    private Trader raoul = new Trader("Raoul", "Cambridge");
    private Trader mario = new Trader("Mario", "Milan");
    private Trader alan = new Trader("Alan", "Cambridge");
    private Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    // 找出2011年发生的所有交易，并按交易额排序（从低到高）
    public void first(){
        transactions.stream()
                    .filter(y -> y.getYear() == 2011)
                    .sorted(Comparator.comparing(Transaction::getValue))
                    .forEach(System.out::println);
    }

    // 交易员都在哪些不同的城市工作过？
    public void second(){
        transactions.stream()
                    .map(t -> t.getTrader().getCity())
                    .distinct()
                    .forEach(System.out::println);
    }

    // 查找所有来自于剑桥的交易员，并按姓名排序
    public void third(){
        transactions.stream()
                    .map(Transaction::getTrader)
                    .filter(t -> t.getCity().equals("Cambridge"))
                    .distinct()
                    .sorted(Comparator.comparing(Trader::getName))
                    .forEach(System.out::println);
    }

    // 返回所有交易员的姓名字符串，按字母顺序排序
    public String forth(){
        return transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a, b) -> a + b);
    }

    // 有没有交易员是在米兰工作的
    public Boolean fifth(){
        return transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
    }

    // 打印生活在剑桥的交易员的所有交易额
    public void sixth(){
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    // 所有交易中，最高的交易额是多少
    public Optional<Integer> seventh(){
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
    }

    // 找到交易额最小的交易
    public Optional<Transaction> eighth(){
        return transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
    }

    public static void main(String[] args){
        Process process = new Process();
        System.out.println(process.eighth().get());
//        process.sixth();
    }
}
