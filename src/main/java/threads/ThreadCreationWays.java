package threads;

// javada iki tane yolu var

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.TreeMap;

public class ThreadCreationWays {
    //defaut thread ismi main threads dir (main ile karsitirma !!!)
    public static void main(String[] args) {
        //her java programinda bir tane thread baslatilir ve ismi main thread dir.
        System.out.println("Mevcut Thread: " + Thread.currentThread().getName()); //Mevcut Thread: main
        //Thread cllassi icinden currentThread() guncel thread imiz getirir ve getName() isse ismini getirir

        //javada Thres olusturmaini 2 yolu vadir
        //run metodu override etmeliyiz
        //1.YOL
        Thread thread1 = new MyThread();
        thread1.start(); //---> burda bizim thread calisiyor // threadi baslatir ve run methodunu cagirir.
        //thread1.run(); //---> burda main thread calisiyor, kendi thread olusturmamiz gereksiz oldu - single Thread olarak devam edilmis olur
        // bundan sonra artik uygulamamda iki tane thread calisiyor
        thread1.setName("thread1 threadcik:)"); // thread ismini bu sekilde kendimiz isimlendorebiliyoruz

        //-------------------------------
        //2.YOL a) Runnable interfaceini somutlastirarak
        Runnable runnable = new MyRunnable();
        //burda run methodu Runnable interface i icinde oldugu icin turu Runnable yaptik
        // normalde interface uzerinden obje uretilmez ama parentini constructure yaparak bu sekilde kullanilir
        Thread thread2 = new Thread(runnable);
        thread2.start();
        thread2.setName("thread2 canimthread");
        //--------------------------------------
        //2.YOL b)anonymous class: isimsiz sinif
        //Runnable icinde sadece bir tane implemente edilecek method var
        Thread thread3 = new Thread(new Runnable() { // pratik yol : //bu sekilde bir class ile Runnable interface ini somutlastirip kullanmak yerine direk bu sekildede kullanabiliriz bosuna class olusturmayiz
            // sadece bir methodu varsa yeni bir class olusurmadan interface'i direk boyle kullanabiliriz
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Calisan Thread: " + Thread.currentThread().getName());
                try {
                    thread2.join();  // thread3 bekleyecek thread2 tamamlanana kadar
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Anonymous thread basladi....");
            }
        });
        thread3.start();
        thread3.setName("thread3 Anonymous thread");

        //--------------------------------------
        //2.YOL c)Lambda expretion: isimsiz sinif
        Thread thread4 = new Thread(() -> {
            //run methodunun bodysindeyiz
            System.out.println("Calisan Thread: " + Thread.currentThread().getName());
            System.out.println("Lambda expretion thread basladi....");
        });
        thread4.start();
        thread4.setName("thread4 Lambda expretion thread");

        System.out.println("main method burada tamamlandi."); //main thread gorevini tamaladi
        //burdan ciktilari arka arkaya calistirdigimizda calisma zamani zamani degisiyor

        //NOT : her thread kendi isini (run methodu icindeki kodlar sirali seklde calisir fakat) SEKRON
        //threadler kendi arasinda sirasi ASENKRON olarak calisir - threadler yarisa girer hangisi JVM i yakalarsa o calisir
        // yaptigi isleme gore daha yavas surebilir ama buda kesin degil kontrol bizde degil CPU dadir oncelik hangisine tahsis edilirse o calisir

        //main thread i biraz bekletebiliriz..... biraz uyutursak digerleri isini yapar ve biz en son alttaki kodu calistiririz
        try {
            Thread.sleep(1000); // hangi Thread icindeyse thread gorevini yapmasini 1000ms bekletir. ama en son calismasi garanti degil
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


        try {
            thread1.join(); // join methodu ile thread1 bitirilene kadar digerleri bekler
            thread2.join(); //thread2 bitirilene kadar digerleri bekler
            thread3.join(); //thread3 bitirilene kadar digerleri bekler
            thread4.join(); //thread4 bitirilene kadar digerleri bekler
        } catch (InterruptedException e) {
            System.out.println();
        }//thread'ler ne kadar surerse sursun main thread isleri bitene kadar bekler
        System.out.println("enson clisacak beklmeden dolayi .. en son calismasi garanti degil");

    }

}
