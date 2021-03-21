package ru.senina.ifmo.Laba3Story;

public class PartOfBody {
    protected String partOfBodyName;
    protected Boolean hearts = false;

    public PartOfBody(String name){
        this.partOfBodyName = name;
    }

    public String getPartOfBodyName() {
        return partOfBodyName;
    }

    public void setHearts() {
        hearts = true;
        System.out.println(this.partOfBodyName + " hearts.");
    }
}
