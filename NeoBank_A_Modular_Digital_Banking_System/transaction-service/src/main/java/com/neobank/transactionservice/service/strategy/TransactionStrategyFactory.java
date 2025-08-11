package com.neobank.transactionservice.service.strategy;

import com.neobank.transactionservice.entity.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class TransactionStrategyFactory {

    private final Map<TransactionType, TransactionStrategy> strategyMap = new EnumMap<>(TransactionType.class);

    @Autowired
    public TransactionStrategyFactory(NEFTTransactionStrategy neftStrategy,
                                      IMPOSTransactionStrategy impsStrategy,
                                      RTGSTTransactionStrategy rigstStrategy) {
        strategyMap.put(TransactionType.NEFT, neftStrategy);
        strategyMap.put(TransactionType.IMPS, impsStrategy);
        strategyMap.put(TransactionType.RTGS, rigstStrategy);
    }

    public TransactionStrategy getStrategy(TransactionType type) {
        return strategyMap.get(type);
    }
}