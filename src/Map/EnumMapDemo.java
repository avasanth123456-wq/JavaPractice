package Map;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo {

    public static  void main(String[] args){
        Map<Day, String> map = new EnumMap<>(Day.class);
        map.put(Day.TUESDAY,"Gym");
        map.put(Day.MONDAY,"walk");
        map.put(Day.WEDNESDAY,"Reading");
        map.put(Day.THURSDAY,"writing");
        map.put(Day.FRIDAY,"Cooking");
        map.put(Day.SATURDAY,"Temple");
        map.put(Day.SUNDAY,"Party");
        System.out.println(map);
    }
}

enum Day{
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
}