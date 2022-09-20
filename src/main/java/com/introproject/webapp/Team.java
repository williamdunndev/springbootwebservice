package com.introproject.webapp;

import java.util.ArrayList;

public class Team {
    private final long id;
    private final String name;
    private final ArrayList<Player> players;

    public Team(long id, String name, ArrayList<Player> players) {
        this.id = id;
        this.name = name;
        this.players = players;
    }

    public Team(long id) {
        this.id = id;
        this.name = "";
        this.players = new ArrayList<Player>();
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void addPlayer(Player player) {
        players.add(player);
    }
}