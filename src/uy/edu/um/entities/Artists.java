package uy.edu.um.entities;

public class Artists implements Comparable<Artists> {
    private String name;
    public Artists(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
