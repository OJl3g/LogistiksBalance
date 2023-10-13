package entity;

public class Cafe {
    private String address;
    private String name;
    private boolean coffeeMachine;
    private double loadingTime;

    public Cafe(String address, String name, boolean coffeeMachine, double loadingTime) {
        this.address = address;
        this.name = name;
        this.coffeeMachine = coffeeMachine;
        this.loadingTime = loadingTime;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public boolean isCoffeeMachine() {
        return coffeeMachine;
    }

    public double getLoadingTime() {
        return loadingTime;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoffeeMachine(boolean coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public void setLoadingTime(double loadingTime) {
        this.loadingTime = loadingTime;
    }
}
