package com.dikovandrey.spring.mvc;

import javax.validation.constraints.*;
import java.util.*;

public class Employee {

    @Size(min = 2, message = "длина имени должна быть не менее 2 символов")
    private String name;

    @NotBlank(message = "это обязательное поле")
    private String surname;

    @Min(value = 15000, message = "зарплата должна быть больше 15000")
    @Max(value = 1000000, message = "зарплата должна быть меньше 1000000")
    private int salary;
    private String department;
    private Map<String, String> departments;
    private String sex;
    private Map<String, String> genders;
    private String[] skills;
    private List<String> skillsAsList;

    @Size(min = 11, message = "номер телефона должен содержать 11 цифр")
    @Pattern(message = "номер телефона должен содержать только цифры и +",
            regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")
    private String phoneNumber;

    @Pattern(message = "неправильный адресс почты",
            regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    public Employee() {
        departments = new HashMap<String, String>() {{
            put("IT", "IT");
            put("HR", "HR");
            put("Бухгалтерия", "Бухгалтерия");
            put("Главный департамент", "Главный департамент");
        }};
        genders = new HashMap<String, String>() {{
            put("Мужской", "М ");
            put("Женский", "Ж ");
        }};
        skillsAsList = new ArrayList<String>() {{
            add("C");
            add("C++");
            add("Java");
            add("Hibernate");
            add("SQL");
            add("1C Bitrix");
            add("Python");
            add("ChatGPT");
            add("Frontend");
        }};
    }

    public Employee(String name,
                    String surname,
                    int salary,
                    String department,
                    Map<String, String> departments,
                    String sex,
                    Map<String, String> genders,
                    String[] skills,
                    List<String> skillsAsList,
                    String phoneNumber,
                    String email) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        this.departments = departments;
        this.sex = sex;
        this.genders = genders;
        this.skills = skills;
        this.skillsAsList = skillsAsList;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", departments=" + departments +
                ", sex='" + sex + '\'' +
                ", genders=" + genders +
                ", skills=" + Arrays.toString(skills) +
                ", skillsAsList=" + skillsAsList +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Map<String, String> getGenders() {
        return genders;
    }

    public void setGenders(Map<String, String> genders) {
        this.genders = genders;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public List<String> getSkillsAsList() {
        return skillsAsList;
    }

    public void setSkillsAsList(List<String> skillsAsList) {
        this.skillsAsList = skillsAsList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
