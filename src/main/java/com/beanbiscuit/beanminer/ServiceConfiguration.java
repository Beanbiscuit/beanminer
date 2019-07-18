package com.beanbiscuit.beanminer;

import com.beanbiscuit.beanminer.blockchain.BlockchainService;
import com.beanbiscuit.beanminer.blockchain.DefaultBlockchain;
import com.beanbiscuit.beanminer.blockchain.hash.HashProvider;
import com.beanbiscuit.beanminer.blockchain.hash.Sha256Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public BlockchainService blockChainService() {
        return new DefaultBlockchain(sha256Provider());
    }

    @Bean
    public HashProvider sha256Provider() {
        return new Sha256Provider();
    }
}
