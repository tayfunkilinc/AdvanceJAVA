package threads;

// javada iki tane yolu var

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.TreeMap;

public class ThreadCreationWays {

    public static void main(String[] args) {
        //her java programinda bir tane thread baslatilir ve ismi main thread dir.
        System.out.println("Mevcut Thread: " + Thread.currentThread().getName()); //Mevcut Thread: main
        //Thread cllassi icinden currentThread() guncel thread imiz getirir ve getName() isse ismini getirir

        //javada Thres olusturmaini 2 yolu vadir
        //run metodu override etmeliyiz
        //1.YOL
        Thread thread1 = new MyThread();
        thread1.start(); //---> burda bizim thread calisiyor // threadi baslatir ve run methodunu cagirir.
        //thread1.run(); //---> burda main thread calisiyor, kendi thread olusturmamiz gereksiz oldu
        // bundan sonra artik uygulamamda iki tane thread calisiyor
        thread1.setName("threadcik:)"); // thread ismini bu sekilde kendimiz isimlendorebiliyoruz

        //-------------------------------
        //2.YOL a) Runnable interfaceini somutlastirarak
        Runnable runnable = new MyRunnable();
        //burda run methodu Runnable interface i icinde oldugu icin turu Runnable yaptik
        // normalde interface uzerinden obje uretilmez ama parentini constructure yaparak bu sekilde kullanilir
        Thread thread2 = new Thread(runnable);
        thread2.start();
        thread2.setName("canimthread");
        //--------------------------------------
        //2.YOL b)anonymous class: isimsiz sinif
        //Runnable icinde sadece bir tane implemente edilecek method var
        Thread thread3 = new Thread(new Runnable() { // pratik yol : //bu sekilde bir class ile Runnable interface ini somutlastirip kullanmak yerine direk bu sekildede kullanabiliriz bosuna class olusturmayiz
            // sadece bir methodu varsa yeni bir class olusurmadan interface'i direk boyle kullanabiliriz
            @Override
            public void run() {
                System.out.println("Calisan Thread: " + Thread.currentThread().getName());
                System.out.println("Anonymous thread basladi....");
            }
        });
        thread3.start();
        thread3.setName("Anonymous thread");

        //--------------------------------------
        //2.YOL c)Lambda expretion: isimsiz sinif
        Thread thread4 = new Thread(() -> {
            //run methodunun bodysindeyiz
            System.out.println("Calisan Thread: " + Thread.currentThread().getName());
            System.out.println("Lambda expretion thread basladi....");
        });
        thread4.start();
        thread4.setName("Lambda expretion thread");

        System.out.println("main method burada tamamlandi."); //main thread gorevini tamaladi
        //burdan ciktilari arka arkaya calistirdigimizda calisma zamani zamani degisiyor

        //NOT : her thread kendi isini (run methodu icindeki kodlar sirali seklde calisir fakat) SEKRON
        //threadler kendi arasinda sirasi ASENKRON olarak calisir - threadler yarisa girer hangisi JVM i yakalarsa o calisir
        // yaptigi isleme gore daha yavas surebilir ama buda kesin degil kontrol bizde degil CPU dadir oncelik hangisine tahsis edilirse o calisir


    }
    //defaut thread ismi main threads dir (main ile karsitirma !!!)
}
