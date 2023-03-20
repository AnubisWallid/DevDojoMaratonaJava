package ZZIJDBC;

import ZZIJDBC.domain.Producer;
import ZZIJDBC.service.ProducerServiceRowSet;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class B_ConnectionFactoryTest02 {

    public static void main(String[] args) {

        Producer producerC = Producer.builder().id(1).name("ProdutoraAAAAA").build();
        ProducerServiceRowSet.updateCachedRowSet(producerC);
//        log.info("---------------------------------");
//        List<Producer> jdbcRowSet = ProducerServiceRowSet.findByNameJdbcRowSet("");
    }
}
