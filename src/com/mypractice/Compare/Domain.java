package com.mypractice.Compare;

public class Domain implements Comparable<Domain> {

    private String string;

    public String getString() {
        return this.string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Domain(String name) {
        this.string = name;
    }

    public int compareTo(Domain o) {
        // TODO Auto-generated method stub
        if (this.string.compareTo(o.getString()) > 0)
            return 1;
        else if (this.string.compareTo(o.getString()) == 0)
            return 0;
        else
            return -1;
    }

    public static void main(String[] args) {
        Domain d1 = new Domain("c");
        Domain d2 = new Domain("c");
        Domain d3 = new Domain("b");
        Domain d4 = new Domain("d");
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.compareTo(d3));
        System.out.println(d1.compareTo(d4));
    }
}
