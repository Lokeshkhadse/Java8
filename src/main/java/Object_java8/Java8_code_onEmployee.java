package Object_java8;

import java.util.List;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Java8_code_onEmployee {
    public static void main(String[] args) {

        List<Employee> employees = Employee.employees;

        //1.print all Employee name in  reverse order
        employees.stream().map(Employee::getName).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("--------------------------");

        //2. Get list of all departments
        employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
        System.out.println("-----------------------------");

        //3.Filter employees from IT department
        employees.stream().filter(e -> e.getDepartment().equals("IT")).forEach(System.out::println);
        System.out.println("-----------------------------");

        //4.Get names of employees with salary > 50000
        employees.stream().filter(e -> e.getSalary() > 50000).map(Employee::getName).forEach(System.out::println);
        System.out.println("------------------------------");

        //5.Find total salary of all employees
        double totalsal = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("total salary sum is -> " + totalsal);
        System.out.println("------------------------------");

        // 6. Get employee with max salary
        Employee maxSalaryEmp = employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
        System.out.println("Employee with max salary is -> " + maxSalaryEmp);
        System.out.println("----------------------------");
        //or Employee maxEmp = employees.stream()
        //    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
        //    .findFirst()
        //    .orElse(null);

        // 7. Get employee with min salary
        Employee minSalaryEmp = employees.stream().min(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
        System.out.println("Employee with min salary is -> " + minSalaryEmp);
        System.out.println("----------------------------");


        //8.Get average age of employees
        double avg = employees.stream().mapToInt(Employee::getAge).average().orElse(0.0);
        System.out.println("avg of age -> " + avg);
        System.out.println("--------------------------------");

        //9. Group employees by department
        Map<String ,List<Employee>> grpBYDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(grpBYDept);
        System.out.println("--------------------------------");


        //10.🔹  Partition employees by age > 30
        Map<Boolean,List<Employee>> EmpAgeGreaterThan30 = employees.stream().collect(Collectors.groupingBy( e -> e.getAge()>30));
        Map<Boolean,List<Employee>> EmpAgeGreaterThan30Test = employees.stream().collect(Collectors.partitioningBy( e -> e.getAge()>30));
        System.out.println(EmpAgeGreaterThan30);
        System.out.println("--------------------------------");

        //11. Convert List<Employee> to Map<Id, Name>
        Map<Integer,String> convertToMap = employees.stream().collect(Collectors.toMap(Employee::getId,Employee::getName));
        System.out.println(convertToMap);
        System.out.println("-----------------------------------");

       // 🔹 12. Count employees in each department
           Map<String,Long> CountEachDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment , Collectors.counting()));
        System.out.println(CountEachDept);
        System.out.println("------------------------------------");


        //🔹 13. Get employee names as comma-separated string
        String CommaSepartedString = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println("employee names as comma-separated string -> " + CommaSepartedString);
        System.out.println("----------------------------------------");


        //13. Find any employee from HR
        Employee anyEmpHR = employees.stream().filter(s -> s.getDepartment().equals("HR")).findAny().orElse(null);
        System.out.println("Any Emp from hR -> " + anyEmpHR);
        System.out.println("----------------------------------------");

        //🔹 14. Check if all employees are older than 20
        boolean checkEmpOlderThan20 = employees.stream().allMatch(s -> s.getAge() > 20);
        System.out.println(checkEmpOlderThan20);
        System.out.println("----------------------------------------");

        //🔹 15. Sort employees by salary ascending
            employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).forEach(System.out::println);
        System.out.println("----------------------------------------");

        //🔹 16. Sort by name descending
        employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);
        System.out.println("-----------------------------------");

       // 17. Use Optional to find oldest employee
        Employee oldestEmp = employees.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);
        System.out.println("oldest empolyee is -> " + oldestEmp);
        System.out.println("------------------------------------");

        //18.Use Predicate to filter young employees
        Predicate<Employee> isyoung = e -> e.getAge() < 30;
        employees.stream().filter(isyoung).forEach(System.out::println);
        System.out.println("------------------------------------");


        //19.second highest salary
        double SecondHighestSalary = employees.stream().map(Employee::getSalary).sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
        System.out.println("SecondHighestSalary -> " +SecondHighestSalary);
        System.out.println("------------------------------------");


        //20.second Lowest salary
        double SecondLowestSalary = employees.stream().map(Employee::getSalary).sorted().skip(1).findFirst().orElse(null);
        System.out.println("SecondLowestSalary -> " +SecondLowestSalary);
        System.out.println("------------------------------------");


        // 21. Use Supplier to return an Employee object
        Supplier<Employee> newObje = () -> new Employee(7, "Gary", "QA", 40000, 27);
        System.out.println(newObje.get());
        System.out.println("------------------------------------");

        //22.Filter and convert to custom string format
        employees.stream()
                .map(e -> e.getName() + " (" + e.getDepartment() + ")")
                .forEach(System.out::println);
        System.out.println("------------------------------------");

   //23.Use peek() for debugging stream
        employees.stream()
                .peek(e -> System.out.println("Processing: " + e.getName()))
                .filter(e -> e.getSalary() > 50000)
                .forEach(System.out::println);
        System.out.println("------------------------------------");


        //24.Get the youngest employee in IT
        Employee youngestITEMP = employees.stream().filter(e -> e.getDepartment().equals("IT"))
                .min(Comparator.comparingInt(Employee::getAge)).orElse(null);
        System.out.println("youngest employee in IT -> " + youngestITEMP);
        System.out.println("------------------------------------");


        //25.Average salary by department

        Map<String, Double>avgSalaryByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average salary by department->" + avgSalaryByDept);
        System.out.println("------------------------------------");

        //26.List employee names grouped by department
        Map<String,List<String>> ListEmpNameGroupByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(ListEmpNameGroupByDept);
        System.out.println("------------------------------------");


        //27.Find employee(s) with max salary in each department
        Map<String,Optional<Employee>> EachDeptMaxSalaryEmp = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println("employee(s) with max salary in each department" + EachDeptMaxSalaryEmp);
        System.out.println("------------------------------------");

      //28.Group employees by age bracket (e.g., <30 and >=30)
       Map<String,List<Employee>> ageBracket = employees.stream().collect(Collectors.groupingBy(e -> e.getAge() < 30 ? "young":"old"));
        System.out.println(ageBracket);
        System.out.println("---------------------");

        //29.Find total salary of IT department
        double totalSalaryITDept = employees.stream().filter(e -> e.getDepartment().equals("IT")).mapToDouble(Employee::getSalary).sum();
        System.out.println("total salary of IT department -> " + totalSalaryITDept);
        System.out.println("---------------------");


        //30.Get department with highest total salary
        String highest_total_salary_dept = employees.stream().
                collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingDouble(Employee::getSalary)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println("highest_total_salary_dept -> " +highest_total_salary_dept);
        System.out.println("---------------------");


        //31. Get names of all employees with the highest salary
            double maxSal = employees.stream().
                    mapToDouble(Employee::getSalary)
                    .max().orElse(0.0);
            List<Employee> listEmp = employees.stream().filter(e -> e.getSalary() == maxSal).toList();

        double maxsal1 = employees.stream().map(Employee::getSalary).sorted(Comparator.reverseOrder()).findFirst().orElse(0.0);
        List<Employee> listEmp1 = employees.stream().filter(e -> e.getSalary() == maxsal1).toList();
        System.out.println(listEmp);
        System.out.println("maxsal1 is -> " +maxsal1);
        System.out.println("---------------------");

        //32. Group by department then by age
        Map<String, Map<Integer, List<Employee>>> complexGroup = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getAge)));
        System.out.println(complexGroup);
        System.out.println("---------------------");



     //33.Get salary statistics
        DoubleSummaryStatistics stat = employees.stream().mapToDouble(Employee::getSalary).summaryStatistics();
        System.out.println(stat);
        System.out.println("---------------------");

        //34.Print name and doubled salary using map
        employees.stream().map(e -> e.getName() + " -> " + (e.getSalary() * 2) ).forEach(System.out::println);
        System.out.println("-----------------------------");

        //35.Increase all IT salaries by 5%
        employees.stream().filter(e -> e.getDepartment().equals("IT")).map(e -> e.getSalary() * 1.05).forEach(System.out::println);
        System.out.println("---------------------");



        //36.Find average salary of employees under 30 per department
        Map<String,Double> ans = employees.stream().filter(a -> a.getAge() < 30)
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(ans);
        System.out.println("---------------------");

        //37.Get all employee names sorted by salary using collect(joining)
        String sortedNames = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println(sortedNames);
        System.out.println("---------------------");


        //38.Find the employee with the longest name
        Employee longestName = employees.stream().max(Comparator.comparingInt(i -> i.getName().length())).orElse(null);
        System.out.println("longest Name is -> " + longestName);
        System.out.println("---------------------");

        //39.Find the most repeated age
        int mostRepeatedAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0);
        System.out.println(mostRepeatedAge);

        //40 convert name into uppercase
        employees.stream().map(Employee::getName).map(name -> name.toUpperCase()).forEach(System.out::println);
        employees.stream().map(e -> e.getName().toUpperCase()).forEach(System.out::println);

        //41. Dept wise 2nd highest salary
        Map<String,Optional<Double>> dept2ndHighest = employees.stream().
                    collect(Collectors.groupingBy(Employee::getDepartment,
                            Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
                                    .map(Employee::getSalary)
                                    .sorted(Comparator.reverseOrder())
                                    .skip(1)
                                    .findFirst()
                            )
                    ));


        System.out.println(" dept wise 2nd highest salary ->" + dept2ndHighest);

        //41. Dept wise 2nd lowest salary
        Map<String,Optional<Double>> dept2ndLowest = employees.stream().
                collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
                                .map(Employee::getSalary)
                                .sorted()
                                .skip(1)
                                .findFirst()
                        )
                ));


        System.out.println(" dept wise 2nd Lowest salary ->" + dept2ndLowest);

        //42 .Get max salary employee name
        String name = employees.stream().
                collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),l -> l.get().getName()));
        System.out.println("max salary employee name -> " + name);


       // Find count of employees in each department but return result as Integer instead of Long.
        Map<String, Integer> deptCnt =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.counting(),
                                        Long::intValue
                                )
                        ));
        System.out.println("dept-Count ->" + deptCnt);




    }
}
