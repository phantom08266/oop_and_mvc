package org.example.ch1_5;


/**
 * RaceCondition : 여러 스레드가 하나의 자원에 동시에 접근할 경우
 * Thread Safe하지 않기 때문에 원하지 않는 결과가 발생한다.
 */
public class RaceConditionDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
