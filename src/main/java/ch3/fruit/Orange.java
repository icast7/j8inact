package ch3.fruit;

public class Orange implements Fruit {
    private Integer weight;
    private String color;

    public Orange(Integer weight) {
        this.weight = weight;
        this.color = "orange";
    }
}