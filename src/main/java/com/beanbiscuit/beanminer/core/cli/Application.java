package com.beanbiscuit.beanminer.core.cli;

import com.beanbiscuit.beanminer.blockchain.Block;
import com.beanbiscuit.beanminer.blockchain.BlockchainService;
import com.beanbiscuit.beanminer.blockchain.DefaultBlock;
import com.beanbiscuit.beanminer.blockchain.DefaultBlockchain;
import com.beanbiscuit.beanminer.blockchain.hash.HashProvider;
import com.beanbiscuit.beanminer.blockchain.hash.HashProviderException;
import com.beanbiscuit.beanminer.blockchain.hash.Sha256Provider;
import com.beanbiscuit.beanminer.serialize.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * @author Bruce Silver <beanbiscuit@gmail.com>
 */
@SpringBootApplication
@Component
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    private static final HashProvider HASH_PROVIDER = new Sha256Provider();

    @Autowired
    private static BlockchainService SERVICE;

    public static void main(String[] args) throws HashProviderException {
        // Setup
        SpringApplication.run(Application.class);
        JsonSerialize formatter = new JsonSerialize();
        
        System.out.println("BeanMiner has started.....");
        
        Block genesisBlock = new DefaultBlock("first block", "0", HASH_PROVIDER);
        genesisBlock.calculateHash();
        SERVICE.add(genesisBlock);
        
        Block secondBlock = new DefaultBlock("second block", genesisBlock.getHash(), HASH_PROVIDER);
        secondBlock.calculateHash();
        SERVICE.add(secondBlock);
        
        Block thirdBlock = new DefaultBlock("third block", secondBlock.getHash(), HASH_PROVIDER);
        thirdBlock.calculateHash();
        SERVICE.add(thirdBlock);
        
        System.out.println("Blockchain as JSON...");
        System.out.println(formatter.serialize(SERVICE));
        System.out.println("Is chain valid: " + SERVICE.isChainValid());

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();
    }
}
