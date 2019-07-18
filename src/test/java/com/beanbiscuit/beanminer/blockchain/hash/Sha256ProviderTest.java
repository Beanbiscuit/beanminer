package com.beanbiscuit.beanminer.blockchain.hash;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Bruce Silver
 */
public class Sha256ProviderTest {

    private Sha256Provider instance;
    
    @Before
    public void setUp() {
       this. instance = new Sha256Provider();
    }

    @Test
    public void testApplyHash() throws HashProviderException {
        String value = "Hash Me 343434^^";
        String result = instance.applyHash(value);
        assertFalse(result.isEmpty());
        assertEquals("eb54a53314003c6a0f683fabddc485183bcad7643a897e53ebf72e1dd50ae967", result);
    }
}