package ch5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class all {
    static Trader raoul = new Trader("Raoul", "Cambridge");
    static Trader mario = new Trader("Mario", "Milan");
    static Trader alan = new Trader("Alan", "Cambridge");
    static Trader brian = new Trader("Brian", "Cambridge");

    static List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                    new Transaction(raoul, 2012, 1000),
                    new Transaction(raoul, 2011, 400),
                    new Transaction(mario, 2012, 710),
                    new Transaction(mario, 2012, 700),
                    new Transaction(alan, 2012, 950));

    public static void main(String[] args) {
        List<Transaction> tr2011 = transactions.stream()
                        .filter(transaction -> transaction.getYear() == 2011)
                        .sorted(comparing(Transaction::getValue))
                        .collect(toList());
        System.out.println("Traders Min to Max 2011:");
        System.out.println(tr2011);

        List<String> citiesList = transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .distinct()
                        .collect(toList());
        System.out.println("Cities list:");
        System.out.println(citiesList);

        Set<String> citiesSet = transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .collect(Collectors.toSet());
        System.out.println("Cities set:");
        System.out.println(citiesSet);

        List<Trader> traders = transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList());
        System.out.println("All traders from Cambridge sorted alphabetically:");
        System.out.println(traders);

        String traderStr = transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + " " + n2);
        System.out.println("All names sorted alphabetically:");
        System.out.println(traderStr);

        String traderStrJoin = transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(joining());
        System.out.println("All names sorted alphabetically with join:");
        System.out.println(traderStrJoin);

        boolean basedInMilan = transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("Any traders in Milan?");
        System.out.println(basedInMilan);

        Optional<Integer> highestValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println("Highest value of transactions:");
        System.out.println(highestValue);

        Optional<Transaction> smallestTransaction = transactions.stream()
                        .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println("Smallest value of transactions:");
        System.out.println(smallestTransaction);

        Optional<Transaction> smallestTransactionMin = transactions.stream().min(comparing(Transaction::getValue));
        System.out.println("Smallest value of transactions [DONE BETTER]:");
        System.out.println(smallestTransactionMin);
    }

    public static class Trader {
        private final String name;
        private final String city;

        public Trader(String name, String city) {
            this.name = name;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }

        public String toString() {
            return "Trader:" + this.name + " in " + this.city;
        }
    }

    public static class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader() {
            return trader;
        }

        public int getYear() {
            return year;
        }

        public int getValue() {
            return value;
        }

        public String toString() {
            return "{" + this.trader + ", " + "year: " + this.year + ", " + "value: " + this.value + "}";
        }
    }
}
