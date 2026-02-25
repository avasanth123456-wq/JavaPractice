package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEqualMethod {
    public static  void main(String[] args){
        HashMap<Persons, String> map = new HashMap<>();
        Persons p1 = new Persons("vasanth",1);
        Persons p2 = new Persons("Vamika",2);
        Persons p3 = new Persons("Riju",1);

        map.put( p1,"software");
        map.put(p2,"player");
        map.put(p3,"Stundent");

        System.out.println("HashMap Size: " +map.size());
        System.out.println("Value for p1: " +map.get(p1));
        System.out.println("Value for p3: " +map.get(p3));


        Map<String,Integer> map1 = new HashMap<>();
        map1.put("Jyothi",90);
        map1.put("Sakku",92);
        map1.put("Saidi",99);




    }
}

class Persons{
    private String name;

    private  int id;

    public  Persons(String name, int id){
        this.name = name;
        this.id=id;
    }
    public String getName(){
        return  name;
    }
    public int getId(){
        return  id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode( name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this  == obj) {

            return true;
        }
        if (obj == null){
            return  false;
        }
        if(getClass() != obj.getClass()){
            return  false;
        }
        Persons other = (Persons)  obj;
        return  id == other.getId() && Objects.equals(name,other.getName());
    }

    @Override
    public String toString() {
        return "id:" +id+",name:" + name;
    }
}
