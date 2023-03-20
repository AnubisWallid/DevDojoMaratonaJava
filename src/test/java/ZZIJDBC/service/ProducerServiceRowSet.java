package ZZIJDBC.service;

import ZZIJDBC.domain.Producer;
import ZZIJDBC.repository.ProducerRepositoryRowSet;

import java.util.List;

public class ProducerServiceRowSet {
    private static final ProducerRepositoryRowSet producerRepositoryRowSet = new ProducerRepositoryRowSet();

    public static List<Producer> findByNameJdbcRowSet(String name) {
        return producerRepositoryRowSet.findByNameJdbcRowSet(name);
    }

    public static void updateJdbcRowSet(Producer producer) {
        producerRepositoryRowSet.updateJdbcRowSet(producer);
    }

    public static void updateCachedRowSet(Producer producer) {
        producerRepositoryRowSet.updateCachedRowSet(producer);
    }
}
