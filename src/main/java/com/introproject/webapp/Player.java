package com.introproject.webapp;

public class Player {
    private final long id;
    private final String first;
    private final String last;

    public Player(long id, String first, String last) {
        this.id = id;
        this.first = first;
        this.last = last;
    }
    public long getId() {
        return id;
    }

    public String getFirst() {
        return first;
    }
    public String getLast() {
        return last;
    }
}
