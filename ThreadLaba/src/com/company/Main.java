package com.company;

import com.sun.jdi.event.ThreadStartEvent;

import java.util.concurrent.*;

public class Main
{

    public static void main(String[] args)
    {
        //Labs labs = new Labs(args);
        //Semaphore sem = new Semaphore(1);
        /*MySemafore mySemafore = new MySemafore();
        mySemafore.args = args;
        mySemafore.start();*/
        /*MyCountDown myCountDown = new MyCountDown();
        myCountDown.args = args;
        myCountDown.start();*/
        //MyCyclicBarrier myCyclicBarrier = new MyCyclicBarrier(args);
        //MyExchanger myExchanger = new MyExchanger(args);
        MyPhaser myPhaser = new MyPhaser(args);
        //laba3.main(args);
    }

}
class Labs extends Thread
{
    String[] args;
    Labs()
    {
    }
    Labs (String[] a)
    {
        args = a;
        new Thread(this).run();
    }
    @Override
    public void run()
    {
        new Lab1().run();
        new Lab4().run();
        new Lab3().run();
        new Lab2().run();
    }
    class Lab1 extends Thread
    {
        @Override
        public void run()
        {
            laba1.main(args);
        }
    }
    class Lab2 extends Thread
    {
        @Override
        public void run()
        {
            laba2.main(args);
        }
    }
    class Lab3 extends Thread
    {
        @Override
        public void run()
        {
            laba3.main(args);
        }
    }
    class Lab4 extends Thread
    {
        @Override
        public void run()
        {
            laba4.main(args);
        }
    }
}

class MySemafore extends Thread
{
    String[] args;
    @Override
    public void run()
    {
        Semaphore sem = new Semaphore(2);
        Lab1Sem l1 = new Lab1Sem();
        Lab2Sem l2 = new Lab2Sem();
        Lab3Sem l3 = new Lab3Sem();
        Lab4Sem l4 = new Lab4Sem();

        l1.semaphore = sem;
        l2.semaphore = sem;
        l3.semaphore = sem;
        l4.semaphore = sem;

        l1.start();
        l2.start();
        l3.start();
        l4.start();
    }
    class Lab1Sem extends Thread
    {
        Semaphore semaphore;
        @Override
        public void run()
        {
            try {
                semaphore.acquire();
                System.out.println("Начало 1-ой лабы");
                laba1.main(args);
                Thread.sleep(1000);
                System.out.println("Конец 1-ой лабы");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class Lab2Sem extends Thread
    {
        Semaphore semaphore;
        @Override
        public void run()
        {
            try {
                semaphore.acquire();
                System.out.println("Начало 2-ой лабы");
                laba2.main(args);
                Thread.sleep(1000);
                System.out.println("Конец 2-ой лабы");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class Lab3Sem extends Thread
    {
        Semaphore semaphore;
        @Override
        public void run()
        {
            try {
                semaphore.acquire();
                System.out.println("Начало 3-ой лабы");
                laba3.main(args);
                Thread.sleep(1000);
                System.out.println("Конец 3-ой лабы");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class Lab4Sem extends Thread
    {
        Semaphore semaphore;
        @Override
        public void run()
        {
            try {
                semaphore.acquire();
                System.out.println("Начало 4-ой лабы");
                laba4.main(args);
                Thread.sleep(1000);
                System.out.println("Конец 4-ой лабы");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MyCountDown extends Thread
{
    String[] args;
    @Override
    public void run()
    {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Lab1cndw l1 = new Lab1cndw(countDownLatch,1250);
        Lab2cndw l2 = new Lab2cndw(countDownLatch,1500);
        l1.start();
        l2.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ожидание выполнения первых двух лаб");
        Lab3cndw l3 = new Lab3cndw(countDownLatch,1400);
        Lab4cndw l4 = new Lab4cndw(countDownLatch,1400);
        l3.start();
        l4.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    class Lab1cndw extends Thread
    {
        CountDownLatch latch;
        int sleep;
         Lab1cndw()
        {
            sleep = 1000;
        }
        Lab1cndw(CountDownLatch l,int sl)
        {
            latch = l;
            sleep = sl;
        }
        @Override
        public void run()
        {
            try {
                System.out.println("Начало 1-ой лабы");
                laba1.main(args);
                Thread.sleep(sleep);
                System.out.println("Конец 1-ой лабы");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class Lab2cndw extends Thread
    {
        CountDownLatch latch;
        int sleep;

        Lab2cndw() {
            sleep = 1000;
        }

        Lab2cndw(CountDownLatch l, int sl) {
            latch = l;
            sleep = sl;
        }

        @Override
        public void run() {
            try {
                System.out.println("Начало 2ой лабы");
                laba2.main(args);
                Thread.sleep(sleep);
                System.out.println("Конец 2-ой лабы");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class Lab3cndw extends Thread
    {
        CountDownLatch latch;
        int sleep;

        Lab3cndw() {
            sleep = 1000;
        }

        Lab3cndw(CountDownLatch l, int sl) {
            latch = l;
            sleep = sl;
        }

        @Override
        public void run() {
            try {
                System.out.println("Начало 3-ей лабы");
                laba3.main(args);
                Thread.sleep(sleep);
                System.out.println("Конец 3-ей лабы");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class Lab4cndw extends Thread
    {
        CountDownLatch latch;
        int sleep;

        Lab4cndw() {
            sleep = 1000;
        }

        Lab4cndw(CountDownLatch l, int sl) {
            latch = l;
            sleep = sl;
        }

        @Override
        public void run() {
            try {
                System.out.println("Начало 4-ой лабы");
                laba4.main(args);
                Thread.sleep(sleep);
                System.out.println("Конец 4-ой лабы");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MyCyclicBarrier extends Thread
{
    String[] args;
    MyCyclicBarrier(String[] st)
    {
        args = st;
        new Thread(this).start();
    }

    @Override
    public void run ()
    {
        CyclicBarrier cb = new CyclicBarrier(4/*, new BarAction()*/);
        Lab1cb l1 = new Lab1cb(cb,5*1000);
        Lab2cb l2 = new Lab2cb(cb,12*1000);
        Lab3cb l3 = new Lab3cb(cb,23*1000);
        Lab4cb l4 = new Lab4cb(cb,12*1000);
    }
    class Lab1cb extends Thread
    {
        CyclicBarrier br;
        int sleep;
        Lab1cb()
        {
            sleep = 1000;
        }
        Lab1cb(CyclicBarrier l,int sl)
        {
            br = l;
            sleep = sl;
            new Thread(this).start();
        }
        @Override
        public void run()
        {
            try {
                System.out.println("Начало 1-ой лабы");
                laba1.main(args);
                Thread.sleep(sleep);
                System.out.println("Лаба 1 подошла к барьеру");
                br.await();
                System.out.println("Конец 1-ой лабы");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException exc) {
                System.out.println(exc);
            }
        }
    }
    class Lab2cb extends Thread
    {
        CyclicBarrier br;
        int sleep;
        Lab2cb()
        {
            sleep = 1000;
        }
        Lab2cb(CyclicBarrier l,int sl)
        {
            br = l;
            sleep = sl;
            new Thread(this).start();
        }
        @Override
        public void run()
        {
            try {
                System.out.println("Начало 2-ой лабы");
                laba2.main(args);
                Thread.sleep(sleep);
                System.out.println("Лаба 2 подошла к барьеру");
                br.await();
                System.out.println("Конец 2-ой лабы");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException exc) {
                System.out.println(exc);
            }
        }
    }
    class Lab3cb extends Thread
    {
        CyclicBarrier br;
        int sleep;
        Lab3cb()
        {
            sleep = 1000;
        }
        Lab3cb(CyclicBarrier l,int sl)
        {
            br = l;
            sleep = sl;
            new Thread(this).start();
        }
        @Override
        public void run()
        {
            try {
                System.out.println("Начало 3-eй лабы");
                laba3.main(args);
                Thread.sleep(sleep);
                System.out.println("Лаба 3 подошла к барьеру");
                br.await();
                System.out.println("Конец 3-eй лабы");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException exc) {
                System.out.println(exc);
            }
        }
    }
    class Lab4cb extends Thread
    {
        CyclicBarrier br;
        int sleep;
        Lab4cb()
        {
            sleep = 1000;
        }
        Lab4cb(CyclicBarrier l,int sl)
        {
            br = l;
            sleep = sl;
            new Thread(this).start();
        }
        @Override
        public void run()
        {
            try {
                System.out.println("Начало 4-ой лабы");
                laba4.main(args);
                Thread.sleep(sleep);
                System.out.println("Лаба 4 подошла к барьеру");
                br.await();
                System.out.println("Конец 4-ой лабы");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException exc) {
                System.out.println(exc);
            }
        }
    }

}
class MyExchanger extends Thread
{
    String [] args;
    MyExchanger(String[]a)
    {
        args = a;
        new Thread(this).start();
    }
    @Override
    public void run()
    {
        Exchanger<String> ex = new Exchanger<String>();
        new L1EX(ex);
        new L2EX(ex);
        new L3EX(ex);
        new L4EX(ex);

    }
    class L1EX extends Thread
    {
        Exchanger<String> ex;
        String predstr;
        String currstr = "Лаба 1!";
        L1EX(Exchanger<String> c)
        {
            ex = c;
            new Thread(this).start();
        }

        @Override
        public void run()
        {
            try {
                System.out.println("Начало 1-ой лабы");
                laba1.main(args);
                currstr = ex.exchange(currstr);
                System.out.println("Передаю строку от 1-ой лабы");
                System.out.println("Конец 1-ой лабы");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class L2EX extends Thread
    {
        L2EX(Exchanger<String> c)
        {
            ex = c;
            new Thread(this).start();
        }
        Exchanger<String> ex;
        String predstr;
        String currstr = "Лаба 2!";
        @Override
        public void run()
        {
            try {
                System.out.println("Начало 2-ой лабы");
                laba2.main(args);
                predstr = ex.exchange(new String());
                System.out.println("Принял строку от "+predstr);
                currstr = ex.exchange(currstr);
                System.out.println("Передаю строку от 2-ой лабы");
                System.out.println("Конец 2-ой лабы");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class L3EX extends Thread
    {
        L3EX(Exchanger<String> c)
        {
            ex = c;
            new Thread(this).start();
        }
        Exchanger<String> ex;
        String predstr;
        String currstr = "Лаба 3!";
        @Override
        public void run()
        {
            try {
                System.out.println("Начало 3-ой лабы");
                laba3.main(args);
                predstr = ex.exchange(new String());
                System.out.println("Принял строку от "+predstr);
                currstr = ex.exchange(currstr);
                System.out.println("Передаю строку от 3-ей лабы");
                System.out.println("Конец 3-ой лабы");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class L4EX extends Thread
    {
        L4EX(Exchanger<String> c)
        {
            ex = c;
            new Thread(this).start();
        }
        Exchanger<String> ex;
        String predstr;
        String currstr = "Лаба 4!";
        @Override
        public void run()
        {
            try {
                System.out.println("Начало 4-ой лабы");
                laba4.main(args);
                predstr = ex.exchange(new String());
                System.out.println("Принял строку от "+predstr);
                //currstr = ex.exchange(currstr);
                //System.out.println("Передаю строку от 4-ой лабы");
                System.out.println("Конец 4-ой лабы");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MyPhaser extends Thread
{
    String [] args;
    MyPhaser(String [] a)
    {
        args = a;
        new Thread(this).start();
    }
    @Override
    public void  run()
    {
        Phaser phsr = new Phaser(1);
        int curPhase;
        new L1PH(phsr,4200,3100);
        new L2PH(phsr,2400,1900);
        new L3PH(phsr,8000,500);
        new L4PH(phsr,1600,1300);
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " Complete");
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " Complete");
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " Complete");
        phsr.arriveAndDeregister();
    }
    class L1PH extends Thread
    {
        Phaser ph;
        int sleep1,sleep2;
        L1PH(Phaser p,int s1,int s2)
        {
            ph = p;
            sleep1 = s1;
            sleep2 = s2;
            ph.register();
            new Thread(this).start();
        }
        @Override
        public void run()
        {
            try {
                System.out.println("Подготавливаем 1-ую лабу");
                Thread.sleep(sleep1);
                System.out.println("Лаба 1 готова");
                ph.arriveAndAwaitAdvance();
                System.out.println("Начинаем 1-ую лабу");
                laba1.main(args);
                ph.arriveAndAwaitAdvance();
                System.out.println("Завершаем 1-ую лабу");
                Thread.sleep(sleep2);
                ph.arriveAndDeregister();
                System.out.println("1-ая лаба окончена");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    class L2PH extends Thread
    {
        Phaser ph;
        int sleep1,sleep2;
        L2PH(Phaser p,int s1,int s2)
        {
            ph = p;
            sleep1 = s1;
            sleep2 = s2;
            ph.register();
            new Thread(this).start();
        }
        @Override
        public void run()
        {
            try {
                System.out.println("Подготавливаем 2-ую лабу");
                Thread.sleep(sleep1);
                System.out.println("Лаба 2 готова");
                ph.arriveAndAwaitAdvance();
                System.out.println("Начинаем 2-ую лабу");
                laba2.main(args);
                ph.arriveAndAwaitAdvance();
                System.out.println("Завершаем 2-ую лабу");
                Thread.sleep(sleep2);
                ph.arriveAndDeregister();
                System.out.println("2-ая лаба окончена");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    class L3PH extends Thread
    {
        Phaser ph;
        int sleep1,sleep2;
        L3PH(Phaser p,int s1,int s2)
        {
            ph = p;
            sleep1 = s1;
            sleep2 = s2;
            ph.register();
            new Thread(this).start();
        }
        @Override
        public void run()
        {
            try {
                System.out.println("Подготавливаем 3-ю лабу");
                Thread.sleep(sleep1);
                System.out.println("Лаба 3 готова");
                ph.arriveAndAwaitAdvance();
                System.out.println("Начинаем 3-ю лабу");
                laba3.main(args);
                ph.arriveAndAwaitAdvance();
                System.out.println("Завершаем 3-ю лабу");
                Thread.sleep(sleep2);
                ph.arriveAndDeregister();
                System.out.println("3-я лаба окончена");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    class L4PH extends Thread
    {
        Phaser ph;
        int sleep1,sleep2;
        L4PH(Phaser p,int s1,int s2)
        {
            ph = p;
            sleep1 = s1;
            sleep2 = s2;
            ph.register();
            new Thread(this).start();
        }
        @Override
        public void run()
        {
            try {
                System.out.println("Подготавливаем 4-ую лабу");
                Thread.sleep(sleep1);
                System.out.println("Лаба 4 готова");
                ph.arriveAndAwaitAdvance();
                System.out.println("Начинаем 4-ую лабу");
                laba4.main(args);
                ph.arriveAndAwaitAdvance();
                System.out.println("Завершаем 4-ую лабу");
                Thread.sleep(sleep2);
                ph.arriveAndDeregister();
                System.out.println("4-ая лаба окончена");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

