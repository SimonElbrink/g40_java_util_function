package se.lexicon;

import se.lexicon.model.Person;

import java.time.LocalDate;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {

        //AIC - Anonymous Inner Class
        Predicate<Integer> negative = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer < 0;
            }
        };

        //Lambda
        Predicate<Integer> positive = integer -> integer > 0;


        Predicate<Person> leapYearAIC = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                if (person.getBirthDate().isLeapYear() == true){
                    return true;
                }else{
                    return false;
                }
            }
        };

        //Lambda
        Predicate<Person> leapYear = (Person person) -> person.getBirthDate().isLeapYear();

        Predicate<Person> bornAfterCovid19 = person -> person.getBirthDate().isAfter(LocalDate.parse("2020-03-14"));


//        Predicate<Person> bornAfterCovid19ANDBornOnLeapYear = person -> person.getBirthDate().isLeapYear() && person.getBirthDate().isAfter(LocalDate.parse("2020-03-14"));

        Person simon = new Person(1, "Simon", "Elbrink", LocalDate.parse("1997-03-18"));

        System.out.println(leapYear.test(simon));

        System.out.println(bornAfterCovid19.test(simon));

//        System.out.println(bornAfterCovid19ANDBornOnLeapYear.test(simon));

        leapYear
                .and(bornAfterCovid19)
                .or(null)
                .negate()
                .test(simon);







    }
}
