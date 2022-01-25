package se.lexicon;

import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExamples {

    public static void main(String[] args) {

        Person simon = new Person(1, "Simon", "Elbrink", LocalDate.parse("1997-03-18"));
        Person ulf = new Person(2, "Ulf", "Bengtsson", LocalDate.parse("1985-01-01"));

        List<Person> personList = new ArrayList<>(Arrays.asList(simon,ulf));

        Consumer<Person> printOut = (Person person) -> System.out.println(person);

        System.out.println("Simon print");
        printOut.accept(simon);

        System.out.println("External Iterator");
        for (Person person : personList) {
            printOut.accept(person);
        }

        System.out.println("Internal Iterator + Pre-made consumer");
        personList.forEach(printOut);

        System.out.println("internal + lambda");
//        personList.forEach(person -> System.out.println(person));
        personList.forEach(System.out::println);





    }


}
