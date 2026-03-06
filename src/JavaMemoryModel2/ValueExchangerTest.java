
package JavaMemoryModel2;

import com.sun.jdi.Type;
//import  com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;

/*public class ValueExchangerTest {

  /*  public static void main(String[] args) {

        ValueExchanger exchanger = new ValueExchanger();

        Thread writer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                Value v = new Value() {
                    @Override
                    public VirtualMachine virtualMachine() {
                        return null;
                    }

                    @Override
                    public String toString() {
                        return "";
                    }

                    @Override
                    public Type type() {
                        return null;
                    }
                };
                v.valA = i;
                v.valB = i * 10;
                v.valC = i * 100;

                exchanger.set(v);

                System.out.println("Written: " + v.valA + " " + v.valB + " " + v.valC);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }

        });

        Thread reader = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                Value v = new Value() {
                    @Override
                    public VirtualMachine virtualMachine() {
                        return null;
                    }

                    @Override
                    public String toString() {
                        return "";
                    }

                    @Override
                    public Type type() {
                        return null;
                    }
                };

                exchanger.get(v);

                System.out.println("Read: " + v.valA + " " + v.valB + " " + v.valC);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }

        });

        writer.start();
        reader.start();
    }
}*/


    public class ValueExchangerTest {

        public static void main(String[] args) {

            ValueExchanger exchanger = new ValueExchanger();

            Value v1 = new Value() {
               @Override
               public VirtualMachine virtualMachine() {
                    return null;
                }

                @Override
                public String toString() {
                    return "";
                }

                @Override
                public Type type() {
                    return null;
                }
            };
            v1.valA = 10;
            v1.valB = 20;
            v1.valC = 30;

            exchanger.set(v1);

            Value v2 = new Value() {
               @Override
                public VirtualMachine virtualMachine() {
                    return null;
                }

                @Override
                public String toString() {
                    return "";
                }

                @Override
                public Type type() {
                    return null;
                }
            };

            exchanger.get(v2);

            System.out.println(
                    v2.valA + " " +
                            v2.valB + " " +
                            v2.valC);

        }
    }