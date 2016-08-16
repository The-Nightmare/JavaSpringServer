package com.thenightmare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by peteraguilar on 8/15/16.
 */

@RestController
@RequestMapping("/player")
public class PlayerRestController {

    @Autowired
    private PlayerRepository repo;

    @RequestMapping(method= RequestMethod.GET)
    public List<Player> getAll() {return repo.findAll();}

    @RequestMapping(method=RequestMethod.POST)
    public Player create(@RequestBody Player player) { return repo.save(player);}

    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id) { repo.delete(id);}

    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public Player update(@PathVariable String id, @RequestBody Player player){
        Player update = repo.findOne(id);
        update.setFirst_name(player.getFirst_name());
        update.setLast_name(player.getLast_name());
        update.setEmail_address(player.getEmail_address());
        update.setHighscore(player.getHighscore());
        update.setAvatar(player.getAvatar());
        return repo.save(update);
    }

}
