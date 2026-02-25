package classes;

public class Audi extends Car{

    private String name;

    public Audi(String name, int weight){
        super(weight);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
