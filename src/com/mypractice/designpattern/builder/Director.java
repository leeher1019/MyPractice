package com.mypractice.designpattern.builder;

public class Director {
    public Person constructPerson(PersonBuilder personBuilder){
        personBuilder.buildHead();
        personBuilder.buildBody();
        personBuilder.buildHand();
        personBuilder.buildFoot();
        return personBuilder.buildPerson();
    }

    public static void main(String[] args){
        Director director = new Director();
        Person person = director.constructPerson(new ManBuilder());
        System.out.println(person.getHead() + ", " + person.getBody() + ", " + person.getHand() + ", " + person.getFoot());
    }
}
