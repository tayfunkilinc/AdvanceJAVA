package multithreading;

public class MultiThreading01 {
    public static void main(String[] args) {
        //TASK: 1 den 10 a 2 defa kadar sayalım:main thread - senkron
//        long start = System.currentTimeMillis();
//        Counter counter1 = new Counter("Ramazan");
//        Counter counter2 = new Counter("Ummuhani");
//        counter1.count();
//        counter2.count();
//        long finish = System.currentTimeMillis();
//        System.out.println("Single Thread ile Gecen Sure: " + (finish - start));

        //TASK: 1 den 10 a 2 defa kadar sayalım: multithreading - asenkron
        long start2 = System.currentTimeMillis();
        Thread counter3 = new CounterThread("Ronaldo");
        Thread counter4 = new CounterThread("Messi");
        counter3.start();
        counter4.start();

        try {
            counter3.join();
            counter4.join(); //-----------> counter3 ve counter4 isini bitirene kadar main thread bekleyecek ve bu sekilde multi thread scalisma suresini hesaplayabildik
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finish2 = System.currentTimeMillis();
        System.out.println("MultiThread ile Gecen Sure: " + (finish2 - start2)); // --> burada yazdirirsak main thread de calisacak ve islem bitmeden ekrana yazacak
        //MultiThread ile Gecen Sure: 5055 burda daha hizli oldu iki Thread ile calistigimiz icin hiz kazandik



    }
}
class Counter{
    //1 den 10 a kadar konsola yaziran bir method tanimlayalim

    String name;
    public Counter(String name) {
        this.name = name;
    }

    public void count(){
        for (int i = 1; i<11; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(i + "------>" + name);
        }
    }
 }

 class CounterThread extends Thread{

    public String name;

     public CounterThread(String name) {
         this.name = name;
     }

     //1 den 10 a kadar yazdiran methodu yazalim
     public void count(){
         for (int i =1; i< 11; i++){
             try {
                 Thread.sleep(500);
             } catch (InterruptedException e) {
                 System.out.println(e.getMessage());
             }
             System.out.println(i + "------->" + this.name);
         }
     }
     //run methodunu override edip bu sekilde run icinde thread ile calisma saglayalim
     //sayma islemini threadlere yaptiralim

     @Override
     public void run() {
         count();  // burda direk count() methodunu yazarak cagirma islemini Thread a vermis olduk
     }
 }