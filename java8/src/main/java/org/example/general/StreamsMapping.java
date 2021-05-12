package org.example.general;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsMapping {
    static List<Employee> employeeList =
            Arrays.asList(new Employee("Tom Jones", 45),
                    new Employee("Harry Major", 25),
                    new Employee("Ethan Hardy", 65),
                    new Employee("Nancy Smith", 15),
                    new Employee("Deborah Sprightly", 29));

    public void mapTheData(){
        employeeList.stream().map(e -> e.name).limit(2).collect(Collectors.toList());
    }

    public void flatMap() {
        Long dd = employeeList.stream().map(e -> e.name.toCharArray()).flatMap(chars ->
                                                                        Stream.of(chars).map( c -> String.valueOf(chars))
                                                                        ).collect(Collectors.counting());
        System.out.println("Long dd="+dd);
    }

    public static class Employee {
        String name;
        Integer age;
        Double salary;
        //Contructor of employee
        public Employee(String name, Integer age){
            this.name=name;
            this.age=age;
        }

        public Employee() {

        }

        public Employee(String harry_major, int i, double v) {
            this(harry_major, i);
            this.salary = v;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Double getSalary() {
            return salary;
        }
    }
}
