package com.examples.corejava.Java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main( String[] args ) {

        List<Employee>  employeeList = populateEmployees();

        // print top 3 employee names earning highest salaries
        printTop3EmployeeSalaries(employeeList);

    }

    private static void printTop3EmployeeSalaries( List<Employee> employeeList ) {

        List<String> employeeNames = employeeList.stream()
                .sorted(Comparator.comparingDouble((Employee value) -> value.getEmpSalary()).reversed())
                .limit(3).map(Employee::getEmpName).collect(Collectors.toList());
        employeeNames.forEach(n -> System.out.println(n));

    }

    private static List<Employee> populateEmployees( ) {

        Employee e = new Employee(101L, "Scott", 12456.89d, 10L);
        Employee e1 = new Employee(102L, "Blake", 8972.00, 10L);
        Employee e2 = new Employee(103L, "David", 3492.00, 20L);

        Employee e3 = new Employee(104L, "John", 4567.89, 20L);
        Employee e4 = new Employee(105L, "Doe", 3789.25, 10L);
        Employee e5 = new Employee(106L, "Hoover", 3492.00, 30L);

        List<Employee> list = new ArrayList<>();
        list.add(e);list.add(e1);list.add(e2);list.add(e3);list.add(e4);list.add(e5);
        return list;
    }
}


class Employee {

    private Long empNo;
    private String empName;
    private Double empSalary;
    private Long deptNo;

    public Employee( Long empNo, String empName, Double empSalary, Long deptNo ) {
        this.empNo = empNo;
        this.empName = empName;
        this.empSalary = empSalary;
        this.deptNo = deptNo;
    }

    public Long getEmpNo( ) {
        return empNo;
    }

    public Employee setEmpNo( Long empNo ) {
        this.empNo = empNo;
        return this;
    }

    public String getEmpName( ) {
        return empName;
    }

    public Employee setEmpName( String empName ) {
        this.empName = empName;
        return this;
    }

    public Double getEmpSalary( ) {
        return empSalary;
    }

    public Employee setEmpSalary( Double empSalary ) {
        this.empSalary = empSalary;
        return this;
    }

    public Long getDeptNo( ) {
        return deptNo;
    }

    public Employee setDeptNo( Long deptNo ) {
        this.deptNo = deptNo;
        return this;
    }
}