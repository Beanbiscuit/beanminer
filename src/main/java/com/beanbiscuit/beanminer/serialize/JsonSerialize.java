package com.beanbiscuit.beanminer.serialize;

import com.beanbiscuit.beanminer.blockchain.BlockchainService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Bruce Silver <beanbiscuit@gmail.com>
 */
public class JsonSerialize {
    
    private static final Gson GSON  = new GsonBuilder().setPrettyPrinting().create();
    
    /**
     * @param blockchain
     * @return 
     */
    public String serialize(BlockchainService blockchain) {
        return GSON.toJson(blockchain.getChain());
    }
}