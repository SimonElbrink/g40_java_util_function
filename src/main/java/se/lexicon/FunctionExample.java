package se.lexicon;

import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {


        Person simon = new Person(1, "Simon", "Elbrink", LocalDate.parse("1997-03-18"));
        Person ulf = new Person(2, "Ulf", "Bengtsson", LocalDate.parse("1985-01-01"));

        List<Person> personList = new ArrayList<>(Arrays.asList(simon,ulf));

        System.out.println(simon);

        Function<Person, String> fullName = person -> person.getFirstName() + " " +person.getLastName();
        Function<Person, LocalDate> birthDate = person -> person.getBirthDate();

        personList.forEach( person -> System.out.println(fullName.apply(person)));
        System.out.println(fullName.apply(simon));



        List<String> fullNames = extractNames(personList, fullName);

        personList.forEach(person -> fullNames.add(person.getFirstName() + " " + person.getLastName()));

        fullNames.forEach(System.out::println);
    }

    public static List<String> extractNames(List<Person> personList, Function<Person, String> function){
        List<String> temp = new ArrayList<>();

        for (Person p : personList) {
            temp.add(function.apply(p));
        }
        return temp;
    }
}
