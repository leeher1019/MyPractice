package com.mypractice.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class EmployeeImportance {
    public static void main(String[] args){
    }

    public int getImportance(List<Employee> employees, int id) {
        Employee employee = new Employee();
        List<Employee> employees1 = new LinkedList<>();
        employees1.addAll(employees);
        int sum = 0;
        for (Employee e : employees){
            if (id == e.id){
                employees1.remove(e);
                sum += e.importance;
                employee = e;
                break;
            }
        }

        List<Integer> subList = employee.subordinates;
        for (Integer aSubList : subList) {
            sum += getImportance(employees1, aSubList);
        }

        return sum;
    }


    int sum = 0;

    public int streamGetImportance(List<Employee> employees, int id){
        Employee employee = employees.stream().filter(e -> e.id == id).collect(toList()).get(0);
        sum += employee.importance;
        employee.subordinates.stream().forEach(i -> getImportance(employees, i));
        return sum;
    }

    public int getFastImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return getImportanceHelper(map, id);
    }

    private int getImportanceHelper(Map<Integer, Employee> map, int rootId) {
        Employee root = map.get(rootId);
        int total = root.importance;
        for (int subordinate : root.subordinates) {
            total += getImportanceHelper(map, subordinate);
        }
        return total;
    }
}



class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}