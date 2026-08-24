import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//import static Queue.CLQThreadExample.queue;


public class FullMultithreadingDemo {




        // =============================
        // 1. VOLATILE + THREAD SIGNAL
        // =============================
        static volatile boolean flag = false;

        static class SingalExample {
            public void runExample() {
                Thread t1 = new Thread(() -> {
                    System.out.println("waiting of singal....");
                    while (!flag) {
                    }//busy wait
                    System.out.println("Received singal!");

                });

                Thread t2 = new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    flag = true;
                    System.out.println("Singal sent!");

                });
                t1.start();
                t2.start();
            }
        }

        // =============================
        // 2. RACE CONDITION + SYNCHRONIZED
        // =============================
        static class Counter {
            int count = 0;

            public synchronized void increment() {
                count++;
            }
        }

        static void raceConditionDemo () throws Exception {
            Counter counter = new Counter();

            Runnable task = () -> {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();

                }
            };

            Thread t1 = new Thread(task);
            Thread t2 = new Thread(task);

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            System.out.println("Counter (synchronized)" + counter.count);
        }
        // =============================
        // 3. LOCK (ReentrantLock)
        // =============================

        static class LockExample {
            Lock lock = new ReentrantLock();
            int value = 0;

            public void increment() {
                lock.unlock();
                try {
                    value++;
                } finally {
                    lock.unlock();
                }
            }
        }
        // =============================
        // 4. THREADLOCAL
        // =============================

        static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

        static void ThreadLocalDemo () {
            Runnable task = () -> {
                threadLocal.set(threadLocal.get() + 1);
                System.out.println(Thread.currentThread().getName() + "->" + threadLocal.get());
            };

            new Thread(task).start();
            new Thread(task).start();
        }

        // =============================
        // 5. EXECUTOR SERVICE
        // =============================

        static void executorDemo () throws Exception {
            ExecutorService executor = Executors.newFixedThreadPool(2);

            Callable<Integer> task = () -> {
                return 10 + 20;
            };
            Future<Integer> result = executor.submit(task);
            System.out.println("Executer result:" + result.get());

            executor.shutdown();

        }
        // =============================
        // 6. BLOCKING QUEUE (Producer-Consumer)
        // =============================
        static void producerConsumerDemo () {
            BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

            Runnable producer = () -> {
                try {
                    for (int i = 0; i < 5; i++) {
                        queue.put(i);
                        System.out.println("Produced: " + i);
                    }
                } catch (Exception e) {
                }
            };

            Runnable consumer = () -> {
                try {
                    for (int i = 0; i < 5; i++) {
                        int val = queue.take();
                        System.out.println("Consumed: " + val);
                    }
                } catch (Exception e) {
                }
            };

            new Thread(producer).start();
            new Thread(consumer).start();
        }

        // =============================
        // 7. CONCURRENT HASH MAP
        // =============================
        static void concurrentMapDemo () {
            ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

            Runnable task = () -> {
                map.put(Thread.currentThread().getName(), 1);

            };
            new Thread(task).start();
            new Thread(task).start();

            System.out.println("concurrentMap:" + map);


        }

        // =============================
        // 8. ATOMIC (CAS)
        // =============================
        static void atomicDemo () throws Exception {
            AtomicInteger atomic = new AtomicInteger(0);

            Runnable task = () -> {
                for (int i = 0; i < 1000; i++) {
                    atomic.incrementAndGet();
                }
            };
            Thread t1 = new Thread(task);
            Thread t2 = new Thread(task);
            t1.start();
            t2.start();
            t1.join();
            t2.join();

            System.out.println("Atomic value :" + atomic.get());
        }
        // =============================
        // 9. FORK JOIN POOL
        // =============================
        static class SumTask extends RecursiveTask<Integer> {
            int start, end;

            SumTask(int start, int end) {
                this.start = start;
                this.end = end;
            }

            protected Integer compute() {
                if (start - end <= 10) {
                    int sum = 0;
                    for (int i = start; i <= end; i++) sum += i;
                    return sum;
                }
                int mid = (start + end) / 2;
                SumTask left = new SumTask(start, mid);
                SumTask right = new SumTask(mid + 1, end);
                left.fork();
                return right.compute() + left.join();
            }
        }
        static void forkJoinDemo () {
            ForkJoinPool pool = new ForkJoinPool();
            int result = pool.invoke(new SumTask(1, 100));
            System.out.println("ForkjoinPool result:" + result);
        }
        // =============================
        // 10. DEADLOCK (Example)
        // =============================
        static void deadlockDemo () {
            Object lock1 = new Object();
            Object lock2 = new Object();

            Thread t1 = new Thread(() -> {
                synchronized (lock1) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    synchronized (lock2) {
                        System.out.println("Thread1 done");
                    }
                }

            });
            Thread t2 = new Thread(() -> {
                synchronized (lock2) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    synchronized (lock1) {
                        System.out.println("Thread2 done");
                    }
                }

            });
            t1.start();
            t2.start();
        }
        // =============================
        // 11. VIRTUAL THREADS (Java 21+)
        // =============================
        static void virtualThreadDemo () throws Exception {
            Runnable task = () -> System.out.println("Virtual Thread: " + Thread.currentThread());

            Thread vt = Thread.ofVirtual().start(task);

            vt.start();
        }
        // =============================
        // MAIN METHOD
        // =============================
        public void main (String[]args) throws Exception {

            new SingalExample().runExample();

            raceConditionDemo();

            ThreadLocalDemo();

            executorDemo();

            producerConsumerDemo();

            concurrentMapDemo();

            atomicDemo();

            forkJoinDemo();

            deadlockDemo();

            new LockExample();
        }
    }

