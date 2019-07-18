package com.beanbiscuit.beanminer.blockchain;

import com.beanbiscuit.beanminer.blockchain.hash.HashProvider;
import com.beanbiscuit.beanminer.blockchain.hash.HashProviderException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Provides functionality for manipulating a block chain.
 *
 * @author Bruce Silver <beanbiscuit@gmail.com>
 */
public class DefaultBlockchain implements BlockchainService{

    /**
     * Thread safe list
     */
    private final List<Block> blockchain = new CopyOnWriteArrayList<>();
    private final HashProvider hashingProvider;

    public DefaultBlockchain(HashProvider hashingProvider) {
        this.hashingProvider = hashingProvider;
    }

    /**
     * Add a new block to the chain.
     *
     * @param block 
     */
    @Override
    public void add(Block block) {
        this.blockchain.add(block);
    }

    /**
     * Returns the chain.
     *
     * @return
     */
    @Override
    public List<Block> getChain() {
        return this.blockchain;
    }
    
    @Override
    public Boolean isChainValid() throws HashProviderException {
        Block currentBlock;
        Block previousBlock;

        // Looping through the block chain to check hashes
        for (int idx = 1; idx < this.blockchain.size(); idx++) {
            currentBlock = this.blockchain.get(idx);
            previousBlock = this.blockchain.get(idx - 1);
            // Compare registered hash and calculated hash:
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            // Compare previous hash and registered previous hash
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                return false;
            }
        }

        return true;
    }
}