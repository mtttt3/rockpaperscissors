public class person {


    // instance variables
    private String name;
    private int age;
    public Boolean chill;
    


    // constructors

    person(String name, int age, boolean chill)
    {
        this.name = name;
        this.age = age;
        this.chill = chill;

    }


    // Getters and setters

    public void setChill(boolean newChill)
    {
        Boolean chill = newChill;
    }
    
}
