package Weather;

class Weather {

    String condition;
    int temperature;

    Weather(String condition, int temperature) {
        this.condition = condition;
        this.temperature = temperature;

    }

     void showWeather(){
        System.out.println("Today Weather :" + condition+","+ temperature + "%c");
     }
}
 public  class WeatherExample{
    public  static void main (String[] args){

        Weather Sunny = new Weather("sunny",32);
        Sunny.showWeather();
        Weather Rainy = new Weather("Rainy",48);
        Rainy.showWeather();
        Weather cloudy = new Weather("cloudy",28);
         cloudy.showWeather();
    }
}