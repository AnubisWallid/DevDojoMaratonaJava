package ZZIJDBC;

import ZZIJDBC.domain.Producer;
import ZZIJDBC.repository.ProducerRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class A_ConnectionFactoryTest01 {
    public static void main(String[] args) {
        /*Producer producer = Producer.builder().name("Loja").build();
        ProducerRepository.save(producer);*/
        log.info("info");
        log.debug("debug");
        log.warn("warn");
        log.trace("trace");
        log.error("error");
    }
}
