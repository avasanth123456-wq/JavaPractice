package CompareAndSwap;

public class ProblematicLock extends MyLock {

    private volatile  boolean locked = false;

    public void unlock(){this.locked = false;}

    public  void  lock(){
        while (this.locked){
            //busy wait-until this.locked == false
        }
        this.locked = true;
    }
}
