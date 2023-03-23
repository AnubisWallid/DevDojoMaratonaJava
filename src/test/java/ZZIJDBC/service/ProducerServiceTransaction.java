package ZZIJDBC.service;

import ZZIJDBC.domain.Producer;
import ZZIJDBC.repository.ProducerRepositoryRowSet;
import ZZIJDBC.repository.ProducerRepositoryTransaction;

import java.util.List;

public class ProducerServiceTransaction {
    private static final ProducerRepositoryTransaction producerRepositoryTransaction = new ProducerRepositoryTransaction();

    public static void saveTransaction(List<Producer> producers) {
        producerRepositoryTransaction.saveTransaction(producers);
    }
}
