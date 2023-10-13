package entity;

import entity.Cafe;

public class Route {
    private String nameRoute;
    private FreightForwarder freightForwarder;
    private Cafe[] cafes;

    public Route(String nameRoute, FreightForwarder freightForwarder, Cafe [] cafe) {
        this.nameRoute = nameRoute;
        this.freightForwarder = freightForwarder;
        this.cafes = cafe;
    }

    public void addCafe(Cafe cafe) {
        for (int i = 0; i < cafes.length; i++) {
            if (cafes[i] == null) {
                cafes[i] = cafe;
            }
        }
    }


    public String getNameRoute() {
        return nameRoute;
    }

    public FreightForwarder getFreightForwarder() {
        return freightForwarder;
    }

    public Cafe[] getCafes() {
        return cafes;
    }


    public void setNameRoute(String nameRoute) {
        this.nameRoute = nameRoute;
    }

    public void setFreightForwarder(FreightForwarder freightForwarder) {
        this.freightForwarder = freightForwarder;
    }

    public void setCafes(Cafe[] cafes) {
        this.cafes = cafes;
    }
}
