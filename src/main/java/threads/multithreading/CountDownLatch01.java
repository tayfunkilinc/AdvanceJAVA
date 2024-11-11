package threads.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/*
1) ORNEK 1: sinav sistemi uygulamasi   uyelik sistemiyle calisiyor icerisinde quizler, notlar v.b veriler var
---> duzey belirlemeliyizki soracagimiz sinavlari seviyelerine gore hazirlayalim
---> ogrenci kaydi, sinav yapan, seviye tespit yapan gibi kayitlarin hepsini ayri ayri threadler yapacak
---> ancak burda diger islemlerin yapilabilmesi icin seviye tespit threadi calismaliki digerleride islerini duzgun yapsin
---> onemli olan thread e oncelik vermek icin CountDownLatch kullanacagiz -- bir sayac baslatir oncelikliler bitince sayaci azaltir ve digerleri islemini yapar
------------------------------------------------------------------------
2) ORNEK 2 : --> tren yolundan arac gecisi icin trenin once gecmesi gerekir tren dursun ben gececegim diyemessiniz trenin onceligi vardir yani tren threadi onceliklidir

*/
public class CountDownLatch01 { // Latch mentese demektir ... burda istenilen zamanda acilip kapanmasini sagliyor
    public static void main(String[] args) {
        CountDownLatch  latch =new CountDownLatch(3); // oncelik vermek istedigimiz thread sayisi ile sayac olusturuyoruz
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //burda siralamaya mudahale etmedik bir oncelik vermeliyiz once duzey belirlenmelik ilgili alana kaydi yapilsin -- bunuda latch.await(); methodu ile yapiyoruz
                System.out.println("Ogrencinin Bilgileri ALiniyor...");
                System.out.println("Ogrencini Numarasi Uretildi...");
                //burda kayit yapilabilmesi icin seviyenin tespiti gerekir burda bekleyecegiz ki seviyemiz belli olsun
                try {
                    latch.await();  // burda worker threadler isini bitirene kadar , sayac sifir olana kadar bekler
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Ogrenci Kayit Ediliyor...");
            }
        });
        thread1.start();

        System.out.println("Main thread devam ediyor");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await(); // thread2 worker larin isini birmesini bekler cunku seviye tespiti yapilmali oncelikle
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Ogrencinin Duzeyine Gore Sorular Hazirlaniyor...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread2.start();

        WorkerThreads worker1 = new WorkerThreads("writing", 6000, latch);
        WorkerThreads worker2 = new WorkerThreads("reading", 5000, latch);
        WorkerThreads worker3 = new WorkerThreads("speaking", 3000, latch);
        worker1.start();
        worker2.start();
        worker3.start();
        //workerla kendi aralarinda asenkron: yine yaris var

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread devam ediyor ... SON SATIR");
    }
}

class  WorkerThreads extends Thread{

    public int duration;

    public CountDownLatch latch; // bu sinifin methodlarini kullanacagiz

    //parametreli constructure


    public WorkerThreads(String name, int duration, CountDownLatch latch) {
        super(name); // burda secmis oldugumuz consstructor ile Thread ismini super kelimesi ile degistirecegiz parent a direk ulasacagiz
        this.duration = duration;
        this.latch = latch;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " calismaya basladi....");
        System.out.println("Seviye tespiti yapiliyor.....");
        try {
            Thread.sleep(this.duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+ " bu Thread Seviye Tespitini Tamamlandi.....");
        latch.countDown(); // isini bitiren sayaci bir azaltir --- bunu isimizin bittigi yerde calistiriyoruz ki sayacimiz bir azalsin

    }
}
