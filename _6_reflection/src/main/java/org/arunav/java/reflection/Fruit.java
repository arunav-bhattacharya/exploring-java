package org.arunav.java.reflection;

public class Fruit {

    private String name;
    private String color;

    Fruit(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }

    private void getSmell(Fruit fruit, String name){
        if(fruit.name.equals("Mango"))
            System.out.println("Sweet");
        else
            System.out.println("Don't know");
    }
}