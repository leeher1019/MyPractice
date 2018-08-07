package com.mypractice.designpattern.builder;

public interface PersonBuilder {
    void buildHead();
    void buildBody();
    void buildHand();
    void buildFoot();
    Person buildPerson();   // 組裝
}
