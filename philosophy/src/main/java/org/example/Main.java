package org.example;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);
        for(int i = 1 ;i <= 4; i++)
            new Philosopher(sem, i).start();
    }
}

// класс философа
class Philosopher extends Thread
{
    Semaphore sem; // семафор. ограничивающий число философов
    // кол-во приемов пищи
    int num = 0;
    // условный номер философа
    int id;
    // в качестве параметров конструктора передаем идентификатор философа и семафор
    Philosopher(Semaphore sem, int id)
    {
        this.sem=sem;
        this.id=id;
    }

    public void run()
    {
        try
        {
            sem.acquire();
            System.out.println ("Философ " + id+" садится за стол");

            System.out.println ("Философ " + id+" выходит из-за стола");
            sem.release();

            // философ гуляет
            sleep(500);
        }
        catch(InterruptedException e)
        {
            System.out.println ("у философа " + id + " проблемы со здоровьем");
        }
    }
}