package com.beanbiscuit.beanminer.blockchain;

import com.beanbiscuit.beanminer.blockchain.hash.HashProvider;
import com.beanbiscuit.beanminer.blockchain.hash.HashProviderException;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Packages default implementation of a block in the block chain.
 * 
 * @author Bruce Silver <beanbiscuit@gmail.com>
 */
public class DefaultBlock implements Block {

    private final String data;
    private final String previousHash;
    private final long timeStamp;
    private final HashProvider hashProvider;
    private String hash;
    
    /**
     * @param data
     * @param previousHash The hash signature of the previous block in the chain.
     * @param hashProvider The hashing mechanism.
     */
    public DefaultBlock(String data, String previousHash, HashProvider hashProvider) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = Timestamp.valueOf(LocalDateTime.now()).getTime();
        this.hashProvider = hashProvider;
    }

    @Override
    public String calculateHash() throws HashProviderException {
        this.hash = this.hashProvider.applyHash(this.previousHash + Long.toString(timeStamp) + this.data);
        return this.hash;
    }

    @Override
    public String getPreviousHash() {
        return this.previousHash;
    }

    @Override
    public String getHash() throws HashProviderException {
        if (this.hash == null) {
            throw new HashProviderException("Hash is empty, call calculate hash.");
        }
        return hash;
    }
}