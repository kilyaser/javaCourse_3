package lesson_5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static boolean isWinner = false;
    public static CyclicBarrier cyclicBarrier;
    public static CountDownLatch cdl;
    public static CountDownLatch cdl2;
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            isWinner = false;
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            cyclicBarrier.await();
            System.out.println(this.name + " готов");
            cdl.countDown();
            cyclicBarrier.await();


        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if(!isWinner){
            isWinner = true;
            System.out.printf("%s - WIN\n", this.name);
        }
        cdl2.countDown();

    }
}