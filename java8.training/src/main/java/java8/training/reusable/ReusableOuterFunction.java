package java8.training.reusable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReusableOuterFunction {

    public void excecute() {
        Source1 s1 = new Source1("a");
        Source1 s2 = new Source1("b");
        Source1 s3 = new Source1("c");
        Set<Source1> sources = new HashSet<>(Arrays.asList(s1, s2, s3));

        // Example 1 - reuse1
        System.out.println("Example 1");
        Set<Target1> result1 = convertSet1(sources, this::convertS1ToT1);
        result1.forEach(t -> System.out.println(t.id));

        // Example 2 - reuse2 - IMHO best alternative
        System.out.println("Example 2");
        Set<Target1> result3 = convertSet2(sources, this::convertS1ToT1);
        result3.forEach(t -> System.out.println(t.id));

        // Example 3 - directly
        System.out.println("Example 3");
        Set<Target1> result2 = (Set<Target1>) sources.stream().map(this::convertS1ToT1).collect(Collectors.toSet());
        result2.forEach(t -> System.out.println(t.id));
    }

    // Example 1
    private <S extends DomainObject, T extends DomainObject> Set<T> convertSet1(Set<S> sources, Function<S, T> innerFunc) {
        Set<T> result = new HashSet<>();
        for (S source : sources) {
            DomainObject target = innerFunc.apply(source);
            result.add((T) target);
        }
        return result;
    }

    // Example 2
    private <S, T> Set<T> convertSet2(Set<S> sources, Function<S, T> converter) {
        return sources.stream().map(x -> converter.apply(x)).collect(Collectors.toSet());
    }

    private Target1 convertS1ToT1(Source1 s) {
        Target1 t = new Target1(s.id);
        return t;
    }
}
