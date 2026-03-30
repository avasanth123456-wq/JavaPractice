package FalseSharing;

public class Counter4 {

         @jdk.internal.vm.annotation.Contended("group1")

        public volatile long count1 =0;
        //padding bytes
        @jdk.internal.vm.annotation.Contended("group2")
        public volatile long count2=0;
        //padding bytes

    @jdk.internal.vm.annotation.Contended("group3")
    public volatile long count3=0;
    }
