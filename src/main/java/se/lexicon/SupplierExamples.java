package se.lexicon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExamples {

    public static void main(String[] args) {

        Supplier<List<String>> init = () -> new ArrayList<>();

        List<String> stringList0 = new ArrayList<>();
        List<String> stringList1 = init.get();
        List<String> stringList2 = Collections.emptyList();

    }
}
