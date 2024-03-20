






public class phone{

    private String name;
    private int year;
    private int timesDropped;
    private Boolean works;
    private String priority;

    phone(String name, int year, int timesDropped, boolean works)
    {
        this.name = name;
        this.year = year;
        this.timesDropped = timesDropped;
        this.works = works;
        
    }

    public String getName()
    {
        return name;
    }
    public int getTimesDropped()
    {
        return timesDropped;
    } 

    public void setName(String newName)
    {
        name = newName;
    }
    public void setTimesDropped(int newAmount)
    {
        timesDropped = newAmount;
    }
    

}
