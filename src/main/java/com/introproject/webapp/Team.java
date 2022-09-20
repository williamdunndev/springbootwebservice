package com.introproject.webapp;

import org.springframework.stereotype.Component;

// Note the default name is overridden from "team" to "team1"
@Component("team1")
public class Team {
    private String name;
    private String stripColour;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStripColour() {
        return stripColour;
    }

    public void setStripColour(String stripColour) {
        this.stripColour = stripColour;
    }

    public void printInfo() {
        System.out.println(String.format("team name is %s", name));
        System.out.println(String.format("team strip colour is %s", stripColour));
    }


}
