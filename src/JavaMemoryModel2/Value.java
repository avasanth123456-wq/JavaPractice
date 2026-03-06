package JavaMemoryModel2;

import com.sun.jdi.Type;
import com.sun.jdi.VirtualMachine;

public abstract class Value {

    public int valA;
    public int valB;
    public int valC;

    public abstract VirtualMachine virtualMachine();

    public abstract Type type();
}
