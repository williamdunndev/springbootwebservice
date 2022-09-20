package com.introproject.webapp;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

// RestController contains routes of application and determines what happens when users visit those routes
@RestController
@RequestMapping("/player")
public class PlayerController {

    ArrayList<Player> players = new ArrayList<Player>();

    private final AtomicLong counter = new AtomicLong();


    @GetMapping(value = "/{id}")
    public Player findPlayerById(@PathVariable("id") Long id) {
        for (Player p : players) {
            if (p.getId() == id) {
                return p;
            }
        }
        // TODO return not found status
        return null;
    }

    @GetMapping
    public ArrayList<Player> getAll() {
        return players;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addPlayer(@RequestParam(value = "firstName", defaultValue = "John") String firstName, @RequestParam(value = "lastName", defaultValue = "Jones") String lastName) {
        Player newPlayer = new Player(counter.incrementAndGet(), firstName, lastName);

        players.add(newPlayer);
        return String.format("new player added with id %s", newPlayer.getId());
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@RequestParam(value = "firstName", defaultValue = "John") String firstName, @RequestParam(value = "lastName", defaultValue = "Jones") String lastName, @PathVariable("id") Long id) {
        Player newPlayer = new Player(id, firstName, lastName);
        for (Player p : players) {
            if (p.getId() == id) {
                players.remove(p);
                players.add(newPlayer);
                return String.format("player with id %s updated", id);
            }
        }
        players.add(newPlayer);
        return String.format("new player added with id %s", newPlayer.getId());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object delete(@PathVariable("id") Long id) {
        for (Player p : players) {
            if (p.getId() == id) {
                players.remove(p);
                return null;
            }
        }
        return null;
    }


}
