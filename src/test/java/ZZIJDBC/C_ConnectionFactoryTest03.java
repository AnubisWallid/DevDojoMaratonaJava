package ZZIJDBC;

import ZZIJDBC.domain.Producer;
import ZZIJDBC.repository.ProducerRepository;
import ZZIJDBC.service.ProducerServiceRowSet;
import ZZIJDBC.service.ProducerServiceTransaction;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class C_ConnectionFactoryTest03 {

    public static void main(String[] args) {
        ProducerRepository.clearAutoIncrement();
        Producer producer1 = Producer.builder().name("producer1").build();
        Producer producer2 = Producer.builder().name("producer2").build();
        Producer producer3 = Producer.builder().name("producer3").build();
        ProducerServiceTransaction.saveTransaction(List.of(producer1, producer2, producer3));
    }
}
