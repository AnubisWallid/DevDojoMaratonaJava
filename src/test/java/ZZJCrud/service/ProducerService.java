package ZZJCrud.service;

import ZZJCrud.domain.Producer;
import ZZJCrud.repository.ProducerRepository;

import java.util.Scanner;

public class ProducerService {
    private final Scanner SCANNER = new Scanner(System.in);
    protected final ProducerRepository producerRepository = new ProducerRepository();

        /* exemplo de uso:
        int i = switch (operacao){
            case 1,2,3,4,5: yield 100;
            default: yield 0;
        };*/
    public void builderMenu(int operacao) {
        switch (operacao) {
            case 1 -> createProducer();
            case 2 -> findByName();
            case 3 -> updateProducer();
            case 4 -> deleteProducer();
            default -> throw new IllegalArgumentException("Not a valid option");
        }
    }

    private void createProducer() {
        System.out.println("=== Create Producer ===");
        System.out.print("Enter Name: ");
        String name = SCANNER.nextLine();
        producerRepository.save(Producer.builder().name(name).build());
    }

    private void findByName() {
        System.out.println("=== Read Producer ===");
        System.out.print("Type the Name or Empty to all: ");
        String name = SCANNER.nextLine();
        if (name.isEmpty() || name.isBlank()) name = "";
        System.out.println("=== Producers ===");
        producerRepository.findByName(name).forEach(producer ->
                System.out.printf("ID: '%d' NAME: '%s'%n",
                        producer.getId(),
                        producer.getName()));
    }

    private void updateProducer() {
        System.out.println("=== Update Producer ===");
        System.out.println("Set NAME: ");
        String name = SCANNER.nextLine();
        System.out.println("Set ID: ");
        Integer id = SCANNER.nextInt();
        System.out.printf("Update ID: '%d', NAME: '%s' ? Y or N ?%n", id, name);
        if (SCANNER.next().equalsIgnoreCase("n")) return;
        Producer producer = Producer.builder().id(id).name(name).build();
        producerRepository.update(producer);
    }

    private void deleteProducer() {
        System.out.println("=== Delete Producer ===");
        System.out.print("Enter ID: ");
        int id = SCANNER.nextInt();
        producerRepository.delete(id);
    }
}
