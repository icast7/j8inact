package ch1;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class CurrencyEx {
    final static Gson gson = new Gson();
    public static final String EUR = "EUR";
    public static final String USD = "USD";
    public static final String CNY = "CNY";

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        Currency eur = new Currency(EUR);
        Currency usd = new Currency(USD);
        Currency cny = new Currency(CNY);

        transactions.add(new Transaction(eur, 0));
        transactions.add(new Transaction(usd, 500));
        transactions.add(new Transaction(cny, 1000));
        transactions.add(new Transaction(eur, 1500));
        transactions.add(new Transaction(usd, 2000));
        transactions.add(new Transaction(cny, 2500));
        transactions.add(new Transaction(eur, 3000));
        transactions.add(new Transaction(usd, 3500));
        transactions.add(new Transaction(cny, 4000));
        transactions.add(new Transaction(eur, 4500));
        transactions.add(new Transaction(usd, 5000));
        transactions.add(new Transaction(cny, 5500));

        System.out.println("=== BEFORE GROUPING ===");
        System.out.println(gson.toJson(transactions));

        Map<Currency, List<Transaction>> transactionsByCurrencies =
                transactions.stream().filter((Transaction t) -> t.getPrice() > 1000).collect(groupingBy(Transaction::getCurrency));

        System.out.println("=== AFTER GROUPING ===");
        transactionsByCurrencies.forEach((c, t) -> System.out.println("Currency:" + c.getCurrencyCode() + "\n\tTransactions:" + gson.toJson(t)));
    }

    static class Currency {
        private String currencyCode;

        public String getCurrencyCode() {
            return currencyCode;
        }

        public Currency(String currencyCode){
            this.currencyCode = currencyCode;
        }
    }

    static class Transaction {
        private double price;
        private Currency currency;

        public Transaction(Currency currency, double price) {
            this.currency = currency;
            this.price = price;
        }

        public Currency getCurrency() {
            return currency;
        }

        public double getPrice() {
            return price;
        }
    }
}
