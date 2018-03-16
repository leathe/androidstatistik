package com.example.acod.del1;

public class Person{
    private String firstN;
    private String lastN;
    private float age;
    public Person(String f, String l, float a){
        firstN = f;
        lastN = l;
        age = a;
    }
    public String getFirstN(){
        return firstN;
    }
    public String getLastN(){
        return lastN;
    }
    public float getAge(){
        return age;
    }
}
