package ThreadLocal;

public class ThreadLocalLazyInitExample {

    static void main() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        String value = threadLocal.get();

        if(value == null){
            threadLocal.set("Lazily set value");
            value=threadLocal.get();
        }
        System.out.println(value);
    }
}
