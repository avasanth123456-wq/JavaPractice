package OttPlatfrom;


class OTTPlatfrom {
    String platfromName;

    OTTPlatfrom(String platfromName) {
        this.platfromName = platfromName;
    }

    void showContent() {
        System.out.println(platfromName + " is streaming movies & shows.");
    }
}
   public class  OTTExample{

    public static  void main(String[] args){
         OTTPlatfrom aah = new OTTPlatfrom("aah");
         aah.showContent();

         OTTPlatfrom prime = new OTTPlatfrom("prime");
         prime.showContent();
    }

}
