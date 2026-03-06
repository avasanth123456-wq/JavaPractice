package JavaMemoryModel2;

//import com.sun.jdi.Value;

public class ValueExchanger {

    private int valA;
    private int valB;
    private int valC;

    public void set(Value v) {

        synchronized (this) {
            this.valA = v.valA;
            this.valB = v.valB;
        }

        this.valC = v.valC;
    }

    public void get(Value v) {

        v.valA = this.valA;

        synchronized (this) {
            v.valB = this.valB;
            v.valC = this.valC;
        }
    }
}


/*public class ValueExchanger {

    private int a;
    private int b;
    private int c;

    public <DataValue> void set(DataValue v){

        synchronized (this){
            this.a = v.a;
            this.b = v.b;
        }

        this.c = v.c;
    }

    public <DataValue> void get(DataValue v){

        v.a = this.a;

        synchronized (this){
            v.b = this.b;
            v.c = this.c;
        }
    }
}*/