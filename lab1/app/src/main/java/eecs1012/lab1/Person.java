package eecs1012.lab1;

/**
 * Created by user on 1/18/18.
 */
public class Person
{

    private String name;
    private double weight;
    private double height;

    public Person(String name, double weight, double height)
    {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public double getBMI(){
        return this.weight / (Math.pow(height, 2.0));
    }

}


