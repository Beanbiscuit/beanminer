package com.beanbiscuit.beanminer.blockchain;

import com.beanbiscuit.beanminer.blockchain.hash.HashProviderException;
import java.util.List;

/**
 * Contract for block chain functionality providers.
 *
 * @author Bruce Silver <beanbiscuit@gmail.com>
 */
public interface BlockchainService {

    /**
     * Add a block to the chain.
     *
     * @param block 
     */
    void add(Block block);
    
    /**
     * Returns the block chain list.
     *
     * @return 
     */
    List<Block> getChain();
    
    /**
     * Check if the chain is valid.
     *
     * @return
     * @throws HashProviderException 
     */
    Boolean isChainValid() throws HashProviderException;
}