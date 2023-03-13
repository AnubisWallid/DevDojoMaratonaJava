package ZZIJDBC;

import ZZIJDBC.domain.Producer;
import ZZIJDBC.service.ProduceService;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.logging.Logger;

@Log4j2
public class A_ConnectionFactoryTest01 {
    public static void main(String[] args) {
        /*log.info("info");
        log.warn("warn");
        log.error("error");
        log.debug("debug");
        log.trace("trace");*/
        /*ProduceService.deleteAll();
        String[] nomes = {"ProdutoraA", "ProdutoraB", "ProdutoraX", "ProdutoraD", "ProdutoraE", "ProdutoraF"};
        for (String s : nomes) {
            ProduceService.save(Producer.builder().name(s).build());
        }*/
//        ProduceService.delete(3);
//        Producer producerAlternate = Producer.builder().id(3).name("ProdutoraC").build();
//        ProduceService.update(producerAlternate);
//        List<Producer> producerList = ProduceService.findAll();
//        List<Producer> producerList = ProduceService.findByName("ProdutoraB");
//        log.info("Producers found: {}",producerList);
//        System.out.println(producerList);
//        ProduceService.showProducerMetaData();
//        ProduceService.showDriverMetaData();
//        ProduceService.showTypeScrollWorking();
        ProduceService.findByNameAndToUpperCase("B");
        log.info("Logger '{}'", Logger.getLogger(A_ConnectionFactoryTest01.class.getName()).getName());
    }
}
