package com.mypractice.designpattern.builder;

public class ManBuilder implements PersonBuilder {

    Person person;

    public ManBuilder(){
        person = new Person();
    }

    @Override
    public void buildHead(){
        person.setHead("set head");
    }

    @Override
    public void buildBody(){
        person.setBody("set body");
    }

    @Override
    public void buildHand(){
        person.setHand("set hand");
    }

    @Override
    public void buildFoot(){
        person.setFoot("set foot");
    }

    @Override
    public Person buildPerson(){
        return person;
    }
}
