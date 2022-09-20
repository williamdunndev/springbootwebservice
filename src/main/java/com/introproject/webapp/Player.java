package com.introproject.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Prototype scope means the object is only created on request.
@Component
@Scope(value="prototype")
public class Player {
    private final long id;
    private final String first;
    private final String last;
    // Player class is dependent on Team class. Team Bean exists in Spring container because of @Component annotation
    // in Team class. But to connect the two we need @Autowired annotation, which searched by type by default.
    // @Qualifier is added to search the object by name.
    @Autowired
    @Qualifier("team1")
    private Team team;

    public Player(long id, String first, String last) {
        this.id = id;
        this.first = first;
        this.last = last;
    }

    public Player() {
        this.id = 0;
        this.first = "";
        this.last = "";
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

    public void printHello() {
        System.out.println("hello from Player object");
        // We use the Team object here so the two classes must be linked using "@Autowired".
        team.printInfo();
    }
}
