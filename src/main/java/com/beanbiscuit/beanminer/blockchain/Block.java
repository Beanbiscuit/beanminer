package com.beanbiscuit.beanminer.blockchain;

import com.beanbiscuit.beanminer.blockchain.hash.HashProviderException;

/**
 * Contract for the block chain block elements.
 *
 * @author Bruce Silver <beanbiscuit@gmail.com>
 */
public interface Block {

    /**
     * Returns the calculated hash for the block.
     * 
     * @return Usually a SHA-256 hash
     * @throws HashProviderException
     */
    String calculateHash() throws HashProviderException;
    
    /**
     * Returns the previous blocks hash.
     *
     * @return A hash.
     */
    String getPreviousHash();
    
    /**
     * Returns the block hash.
     * 
     * @return
     * @throws HashProviderException 
     */
    String getHash() throws HashProviderException;
}