
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by keets on 2017/10/11.
 */
public class Lambda {
    public static void main(String[] args) {
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API",
                "Date and Time API");
        features.forEach(n -> System.out.println(n));

        List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);

        new Thread(() -> System.out.println("Hello Lambda Expressions")).start();


        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> ((String) str).startsWith("J"));
        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> ((String) str).endsWith("a"));
        System.out.println("Print all languages :");
        filter(languages, (str) -> true);
        System.out.println("Print no language : ");
        filter(languages, (str) -> false);
        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> ((String) str).length() > 4);

        main8();
        //main7();
        //main5();
        //main4();
        //mail1();
        // main3();
    }


    public static void filter(List names, Predicate condition) {
        Something something = new Something();
        names.stream().filter((name) -> (condition.test(name)))
                .forEach((name) -> {
                    System.out.println(name + " ");
                });
    }

    static class Something {


        String startsWith(String s) {

            return String.valueOf(s.charAt(0));

        }

    }

    public static void main2() {
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));
        features.forEach(System.out::println);
    }

    public static void mail1() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);

        costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);

        double bill = costBeforeTax.stream().map((cost) -> cost + 0.12 * cost).reduce((sum, cost) -> sum
                + cost).get();
        System.out.println(bill + " ");

    }


    public static void main3() {
        List<String> strList = Arrays.asList("qw", "Default Method", "Stream API", "Date and Time API");

        List<String> filtered = strList.stream().filter(x -> x.length() >
                12).collect(Collectors.toList());

        strList.stream().filter(x -> x.length() >
                12).forEach(System.out::println);
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
    }


    public static void main4() {
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);
    }


    public static void main5() {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().sorted((x, y) -> x < y ? 1 : -1).limit(2).parallel().collect(Collectors.toList());

        long count = numbers.stream().map(i -> i * i).distinct().sorted((x, y) -> x < y ? 1 : -1).limit(2).count();


        System.out.printf("Original List : %s, Square Without duplicates : %s %n", numbers, distinct);
    }


    public static void main6() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }

    public static void main7() {
        long t0 = System.nanoTime();

        //初始化一个范围100万整数流,求能被2整除的数字，toArray（）是终点方法

        int a[] = IntStream.range(0, 1_000_000).filter(p -> p % 2 == 0).toArray();

        long t1 = System.nanoTime();

        //和上面功能一样，这里是用并行流来计算

        int b[] = IntStream.range(0, 1_000_000).parallel().filter(p -> p % 2 == 0).toArray();

        long t2 = System.nanoTime();

        //我本机的结果是serial: 0.06s, parallel 0.02s，证明并行流确实比顺序流快

        System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);

    }


    public static void main8() {

        Student student1 = new Student("Ashok", "Kumar", 9.5);
        PreidcateConsumerDemo demo = new PreidcateConsumerDemo();
        student1 = demo.updateStudentFee(student1,
                //Lambda expression for Predicate interface
                student -> student.grade > 8.5,
                //Lambda expression for Consumer inerface
                student -> student.feeDiscount = 30.0);

        student1.printFee();

        Student student2 = new Student("Rajat", "Verma", 8.0);

        student2 = demo.updateStudentFee(student2,
                student -> student.grade >= 8,
                student -> student.feeDiscount = 20.0);

        student2.printFee();

    }

    public static void filter1(List<String> names, Predicate condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
        names.stream().filter(condition).forEach(System.out::println);
    }


    static class PreidcateConsumerDemo {

        public static Student updateStudentFee(Student student, Predicate<Student> predicate, Consumer<Student> consumer) {

            //Use the predicate to decide when to update the discount.

            if (predicate.test(student)) {

                //Use the consumer to update the discount value.
                consumer.accept(student);
            }

            return student;

        }

    }


    static class Student {

        String firstName;

        String lastName;

        Double grade;

        Double feeDiscount = 0.0;

        Double baseFee = 20000.0;

        public Student(String firstName, String lastName, Double grade) {

            this.firstName = firstName;

            this.lastName = lastName;

            this.grade = grade;
        }

        public void printFee() {

            Double newFee = baseFee - ((baseFee * feeDiscount) / 100);

            System.out.println("The fee after discount: " + newFee);

        }

    }
}
