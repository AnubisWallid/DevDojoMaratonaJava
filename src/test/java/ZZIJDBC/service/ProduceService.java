package ZZIJDBC.service;

import ZZIJDBC.domain.Producer;
import ZZIJDBC.repository.ProducerRepository;
import lombok.extern.log4j.Log4j2;

import java.util.List;

//TODO: Refatorar as pastas do projeto...
@Log4j2
public class ProduceService {

    public static void save(Producer producer) {
        ProducerRepository.save(producer);
    }

    public static void update(Producer producer) {
        requireValidId(producer.getId());
        ProducerRepository.update(producer);
    }

    public static void updatePreparedStatemante(Producer producer) {
        requireValidId(producer.getId());
        ProducerRepository.updatePreparedStatemante(producer);
    }

    public static List<Producer> findAll() {
        return ProducerRepository.findAll();
    }

    public static List<Producer> findByName(String name) {
        return ProducerRepository.findByName(name);
    }

    public static List<Producer> findByNameAndToUpperCase(String name) {
        return ProducerRepository.findByNameAndToUpperCase(name);
    }

    public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
        return ProducerRepository.findByNameAndInsertWhenNotFound(name);
    }

    public static List<Producer> findByNamePreparedStatement(String name) {
        return ProducerRepository.findByNamePreparedStatement(name);
    }

    public static List<Producer> findByNameCallableStatement(String name) {
        return ProducerRepository.findByNameCallableStatement(name);
    }

    public static void findByNameAndDelete(String name) {
        ProducerRepository.findByNameAndDelete(name);
    }

    public static void showProducerMetaData() {
        ProducerRepository.showProducerMetaData();
    }

    public static void showTypeScrollWorking() {
        ProducerRepository.showTypeScrollWorking();
    }

    public static void showDriverMetaData() {
        ProducerRepository.showDriverMetaData();
    }

    public static void delete(Integer id) {
        requireValidId(id);
        ProducerRepository.delete(id);
    }

    public static void deleteAll() {
        ProducerRepository.deleteAll();
        ProducerRepository.clearAutoIncrement();
    }

    public static int length() {
        return ProducerRepository.length();
    }

    public static void requireValidId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid value for id");
        }
    }
}
