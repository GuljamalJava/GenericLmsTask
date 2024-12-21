import generic.dao.impl.AnimalDaoImpl;
import generic.dao.impl.PersonDaoImpl;
import generic.enums.Gender;
import generic.models.Animal;
import generic.models.Person;
import generic.service.GenericService;
import generic.service.impl.AnimalServiceImpl;
import generic.service.impl.PersonServiceImpl;
import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// todo       1) Жаны проект тузунуз.
//        2) 3 жаны пакет тузунуз - model, dao, service
//        3) model пакеттин ичине Person, Animal деген класс тузунуз, свойствалары - id, name, age, Gender .
//                - Genderди enum кылып башка пакетке тузуп койсонуз болот.
//        5) service пакеттин ичине GenericService деген generic interface тузунуз жана impl деген пакет тузуп коюнуз.
//        6) GenericServiceтин ичинде 7 метод болот:
//        String add(List<T>t);
//        T getById(Long id);
//        List<T> getAll();
//        List<T> sortByName(); 1 ди басканда ascending, 2 ни басканда descending кылып сорттосун
//        List<T> filterByGender(); 1 ди басканда female, 2 ни басканда male кылып фильтрлесин
//        List<T> clear();
//        7) impl пакеттин ичине PersonServiceImpl, AnimalServiceImpl деген класстарды тузунуз, бул класстар GenericService интерфейсин ишке ашырат .
//        9) Main класста бардык методдорду чакырып иштетиниз.

        AnimalDaoImpl animalDao = new AnimalDaoImpl();
        AnimalServiceImpl animalService = new AnimalServiceImpl(animalDao);
        PersonDaoImpl personDao = new PersonDaoImpl();
        PersonServiceImpl personService = new PersonServiceImpl(personDao);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the command: ");
        boolean is = true;
        while (is) {
            System.out.println("""
                    1.Person:
                    2.Animal:""");
            switch (scanner.nextInt()) {
                case 1 -> {
                    boolean isBlock = true;
                    while (isBlock) {
                        System.out.println("""
                                   1->  Person add:
                                   2->  Person get By Id:
                                   3->  Person getAll :
                                   4->  Person sort By Name:
                                   5->  Person filter By Gender:
                                   6->  Person clear:
                                   7->  Stop!
                                """);

                        switch (scanner.nextInt()) {
                            case 1 -> {
                                LinkedList<Person> peopleList = new LinkedList<>(List.of(
                                        new Person(20, Gender.FEMALE, 1L, "Ainura"),
                                        new Person(21, Gender.MALE, 2L, "Kanchoro"),
                                        new Person(17, Gender.MALE, 3L, "Ernist")));
                                System.out.println("Person add: ");
                                System.out.println(personService.add(peopleList));
                            }
                            case 2 -> {
                                System.out.println("Person get By Id");
                                System.out.println(personService.getById(1L));
                            }
                            case 3 -> {
                                System.out.println("Person getAll:");
                                System.out.println(personService.getAll());
                            }
                            case 4 -> {
                                System.out.println("Person sort By Name:");
                                System.out.println(personService.sortByName());
                            }
                            case 5 -> {
                                System.out.println("Person filter By Gender:");
                                System.out.println(personService.filterByGender());
                            }
                            case 6 -> {
                                System.out.println("Person clear:");
                                System.out.println(personService.clear());
                            }
                            case 7 -> {
                                isBlock = false;
                            }
                            default -> {
                                System.out.println("Tuura emes commanda berildi!");
                            }
                        }
                    }
                }
                case 2 -> {
                    boolean check = true;
                    while (check) {
                        System.out.println("""
                                   1->  Animal add:
                                   2->  Animal get By Id:
                                   3->  Animal getAll :
                                   4->  Animal sort By Name:
                                   5->  Animal filter By Gender:
                                   6->  Animal clear:
                                   7->  Stop!
                                """);
                        switch (scanner.nextInt()) {
                            case 1 -> {
                                LinkedList<Animal> animalsList = new LinkedList<>(List.of(
                                        new Animal(2, Gender.FEMALE, 1L, "Рыжик"),
                                        new Animal(4, Gender.MALE, 2L, "Бобик"),
                                        new Animal(7, Gender.MALE, 3L, "Бетховен")));
                                System.out.println("Add animals: ");
                                System.out.println(animalService.add(animalsList));
                            }
                            case 2 -> {
                                System.out.println("Animal get By Id: ");
                                System.out.println(animalService.getById(3L));
                            }
                            case 3 -> {
                                System.out.println("Animal getAll");
                                System.out.println(animalService.getAll());
                            }
                            case 4 -> {
                                System.out.println("Animal sort By Name: ");
                                System.out.println(animalService.sortByName());
                            }
                            case 5 -> {
                                System.out.println("Animal filter By Gender");
                                System.out.println(animalService.filterByGender());
                            }
                            case 6 -> {
                                System.out.println("Animal clear: ");
                                System.out.println(animalService.clear());
                            }
                            case 7 -> {
                                check = false;
                            }
                            default -> {
                                System.out.println("Tuura emes commanda berildi!");
                            }
                        }
                    }
                }
                case 3 -> {
                    is = false;
                }
                default -> System.out.println("Tuura emes commanda berildi!");
            }
        }
    }
}