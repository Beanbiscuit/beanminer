package com.beanbiscuit.beanminer.blockchain.hash;

/**
 * Contract for classes that provide the ability to apply a hash to a given string value.
 *
 * @author Bruce Silver <beanbiscuit@gmail.com>
 */
public interface HashProvider {

    /**
     * Apply a hash to the given value and return the hash string.
     *
     * @param value
     * @return 
     * @throws HashProviderException 
     */
    public String applyHash(String value) throws HashProviderException;
}
