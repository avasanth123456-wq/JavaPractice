package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Java8Demo {
    public static void main(String[] args) {
        //Java8--> minimal code,function programing
        //java8-->lamba expresssion,Strams,Data&Time API
        //lambda expression
        //lambad expresssion is an anonymous function(no name,no return type, no access modifier)
        Thread t1 = new Thread(() -> {
            System.out.println("Hello");

        });
        MathOperation SumOperation = (a, b) -> a + b;
        MathOperation subtractOperation = (a, b) -> a - b;
        int res = SumOperation.operata(1, 2);
        System.out.println(res);

        //Perdicate --> Functional interface(Boolean valued Function)
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(4));
        Predicate<String> isWordStartingWithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> isWordEndingWithT = x -> x.toLowerCase().endsWith("t");
        Predicate<String> and = isWordStartingWithA.and(isWordEndingWithT);
        System.out.println(and.test("Askhay"));

        //Function --> work for you
        Function<Integer, Integer> doubleIt = x -> 2 * x;
        Function<Integer, Integer> tripletIt = x -> 3 * x;
        System.out.println(doubleIt.andThen(tripletIt).apply(20));
        System.out.println(doubleIt.andThen(doubleIt).apply(20));
        System.out.println(doubleIt.compose(tripletIt).apply(20));
        System.out.println(doubleIt.apply(100));
        Function<Integer, Integer> identity = Function.identity();
        Integer res2 = identity.apply(5);
        System.out.println(res2);

        //Consumer
        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(51);
        List<Integer> list = Arrays.asList(1, 2, 3);
        Consumer<List<Integer>> printList = x -> {
            for (int i : x) {
                System.out.println(i);
            }
        };
        printList.accept(list);
        //Supplier
        Supplier<String> giveHelloworld = () ->"Hello world";
        System.out.println(giveHelloworld.get());

        //combined example
        Predicate<Integer> predicate = x -> x%2 == 0;
        Function<Integer,Integer> function = x-> x*x;
        Consumer<Integer> consumer = x-> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;
        if(predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }
        //BiPredicate , BiConsumer,BiFunction
        BiPredicate<Integer,Integer> isSumEVen =(x,y) -> (x+y) %2 == 0;
        System.out.println(isSumEVen.test(5,5));
        BiConsumer<Integer,String> biConsumer = (x,y) ->{
            System.out.println(x);
            System.out.println(y);
        };
        BiFunction<String,String,Integer> biFunction =(x,y) -> (x+y).length();
        System.out.println(biFunction.apply("a","b"));

        //UnaryOperator, BinaryOPerator;
        UnaryOperator<Integer> a=x->2*x;
        BinaryOperator<Integer> b=(x,y)->x+y;

        //Method reference --> use method without invoking & oin place of lambda expression;
        List<String> students = Arrays.asList("Ram","Shyam","Ghanshyam");
        students.forEach(x->System.out.println(x));
        students.forEach(System.out::println);

       //Constrtructor reference
        List<String> name =Arrays.asList("A","B","C");
        List<MobilePhone> mobilePhoneList= name.stream().map(MobilePhone::new).collect(Collectors.toList());
        System.out.println(mobilePhoneList);

    }

}

class MobilePhone{
    String name;


    public MobilePhone(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "name='" + name + '\'' +
                '}';
    }
}
@FunctionalInterface
interface MathOperation{
    int operata(int a, int b);
}