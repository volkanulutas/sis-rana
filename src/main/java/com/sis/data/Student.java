package com.sis.data;

import com.sis.EnhanceUserExperience.Colors;

import java.sql.SQLOutput;

public class Student {
    private int age;
    private String name;
    final private int id;

    public Student(int age, String name, int id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format(
                "ID      NAME        AGE\n" +
                        "-----------------------\n" +
                        Colors.RED + "%-6d" + Colors.RESET + " " +
                        Colors.GREEN + "%-12s" + Colors.RESET + " " +
                        Colors.ORANGE + "%-3d" + Colors.RESET,
                this.id, this.name, this.age
        );

    }
    public String showOnlyDetails() {
        return String.format(
                        Colors.RED + "%-6d" + Colors.RESET + " " +
                        Colors.GREEN + "%-12s" + Colors.RESET + " " +
                        Colors.ORANGE + "%-3d" + Colors.RESET,
                this.id, this.name, this.age
        );

    }

}
