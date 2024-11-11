package threads.multithreading;

public class SynchronizedBlock {
    public static void main(String[] args) {
        // TASk : konsola 1 den 10'a kadar 14 defa alt alta yazdiralim
        //bu task icin 2 tane thread kullanalim
        Charcters charcters = new Charcters();
        long start = System.currentTimeMillis();
        Thread thread1 =new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 1; i < 8; i++) {
                    charcters.printNumbers();
                    try {
                        Thread.sleep(500); // bu gecikme bir bosloga sebep oldugu icin ikinci thread araya girebiliyor
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread1.setName("Fred");

        Thread thread2 =new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 1; i <8 ; i++) {
                    charcters.printNumbers();
                }
            }
        });
        thread2.setName("Barnie");
        thread1.start();
        thread2.start();
        //burda yine ayni kaynaga erismeye calistiklari icin  tutarsisliga sebep olsu problemi cozmek icin synchronizedkeywordunu kullanabiliriz
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Sure: " + (finish-start));
        //senkron blok oldugunda gecen Sure: 17624
        //method senkron oldugunda gecen Sure: 31262

    }
}

class Charcters{
    //tek satirda 1 den 10 a kadar yazdiran method olusturalim
    public synchronized void printNumbers(){ //synchronized ile methodu senkronize yaptik simdilik bunu kaldirdim simdi senkron blogu gorecegiz
        //1'den 10'a kadar tek bir satirda yazilsin tek satirda
        //synchronized(this) { // istedigimiz alanida senkron sekilde senkron blok kullanarak yapabiliriz
            //burda this ile hangi objeyi kilitleyecegimizi belirmis olduk
            //
            for (int i = 1; i < 11; i++) {
                System.out.print(i + " ");
            }
            System.out.println("----> " + Thread.currentThread().getName());
        //}
        //----------------------

        // bu methodun baska bir gorevi daha varsa
        //a'dan e'ye kadar alt alta yazdirma: sirali olmasina gerek yok --buradada sira yoksa burayi daha verimli kullanmak istiyorum
        // burayi senkron yapmadik senkron blokla buranin hala asenkron olarak calismasina devam etmesini sagladik
        for (char i = 'a'; i < 'e'; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}