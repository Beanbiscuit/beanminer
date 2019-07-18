package com.beanbiscuit.beanminer.blockchain;

import com.beanbiscuit.beanminer.blockchain.hash.HashProvider;
import com.beanbiscuit.beanminer.blockchain.hash.HashProviderException;
import com.beanbiscuit.beanminer.blockchain.hash.Sha256Provider;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Bruce Silver
 */
public class DefaultBlockTest {
    
    private Block block;
    private HashProvider provider;
    
    @Before
    public void setUp() {
        this.provider = new Sha256Provider(); 
        this.block = new DefaultBlock("some block", "snfjkdghiurgh", this.provider);
    }

    @Test
    public void testCalculateHash() throws HashProviderException {
        String value = "A message in the chain";
        assertNotNull(this.block.calculateHash());
        
        System.out.println(this.block.calculateHash());
    }
}