package se.lexicon;

import se.lexicon.model.Calculator;

import java.util.function.BiFunction;
import java.util.function.ToDoubleBiFunction;

public class MethodsReferenceObject {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();


        calculator.add(10, 92);

        BiFunction<Double, Double, Double> add = (num1, num2) -> calculator.add(num1, num2);
        BiFunction<Double, Double, Double> addMF = calculator::add;
        ToDoubleBiFunction<Double, Double> addMFToDouble = calculator::add;




    }
}
