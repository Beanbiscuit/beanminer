package com.beanbiscuit.beanminer.blockchain.hash;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Apply a SHA-256 hash to a given string value.
 * 
 * @author Bruce Silver <beanbiscuit@gmail.com>
 */
public class Sha256Provider implements HashProvider {

    public static final String ENCODING = "SHA-256";
    
    @Override
    public String applyHash(String value) throws HashProviderException {
        if (value.isEmpty()) {
            throw new HashProviderException("Hash provider input is empty.");
        }
        return DigestUtils.sha256Hex(value);
    }
}