package com.thenightmare;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by peteraguilar on 8/15/16.
 */
public interface PlayerRepository extends MongoRepository<Player, String> {

}
