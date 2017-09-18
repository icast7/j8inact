package ch3.fruit;

public class Apple implements Fruit {
    public int weight;
    public String color;

    public Apple() {
        this.weight = 50;
        this.color = "red";
    }

    public Apple(Integer weight) {
        this.weight = weight;
        this.color = "red";
    }

    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}
