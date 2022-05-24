package lesson_4;

public class Solution {
    private final Object monitor = new Object();
    public volatile char currentLetter = 'A';


    public static void main(String[] args) {
        Solution solution = new Solution();
        Thread thread1 = new Thread(solution::printA);
        Thread thread2 = new Thread(solution::printB);
        Thread thread3 = new Thread(solution::printC);
        thread1.start();
        thread2.start();
        thread3.start();


    }

    public void printA() {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'A'){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                currentLetter = 'B';
                monitor.notifyAll();
            }

        }
    }
    public void printB() {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'B'){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                currentLetter = 'C';
                monitor.notifyAll();
            }

        }
    }
    public void printC(){
        synchronized (monitor){
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'C'){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("C");
                currentLetter = 'A';
                monitor.notifyAll();
            }

        }
    }
}
