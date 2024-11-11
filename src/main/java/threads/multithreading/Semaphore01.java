package threads.multithreading;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.Semaphore;

/*Semaphore, n tane(2,3,4....) aynı anda ortak bir kaynağa erişmesine
izin vermemizi sağlar. - burda erisimi arttirabiliyoruz ama yinede bir ust sinir belirliyoruz asiri yuklenmeyi engellemek icin --> OTO PARK

Synchronized, ayni anda ortak bir kaynaga SADECE 1 Threadin erisimine izin vermemizi saglar. Bunda Kesinlikle birden fazla kisiye izin vermiyoruz --> GIYINME KABINI
*/

// bir kaynagabirden cok thread ulasmaya calistiginda erimi duzenlemek icin kullanilir
// otopark sorusunu hatirla: otoparka girek raclarin girisinin kontrolu
public class Semaphore01 {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(4); // burda ayni anda 4 tane Thread in ortak kaynak kullanimina izin vermis olduk
        Car car1 = new Car("Audi", 8000,semaphore);
        Car car2 = new Car("Toyota", 5000,semaphore);
        Car car3 = new Car("BMW", 2000,semaphore);
        Car car4 = new Car("Opel", 1000,semaphore);
        Car car5 = new Car("Skoda", 9000,semaphore);
        Car car6 = new Car("Honda", 3000,semaphore);
        Car car7 = new Car("Mercedes", 6000,semaphore);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start(); // 7 tane Aktif Thread imiz var main thread haric

    }
}
class Car extends Thread{

    public String carName;

    public int duration;

    public Semaphore semaphore; // sinirli kapasitenin iznlerini takip etmek icin kullanilacak : oto park gorevlisi


    //degiskenlerin degerlerini set edelim parametreli constructure ile
    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() { // burada thread kullanimina baslayalim
        //burada consolo yazi yazdirmak icin consola kaynagina erisimi semaphore ile kontrol altinda tutacagiz
        //.......buralarda baska kodlar olabilir
        System.out.println(this.carName + " park etmek istiyorum...");

        ////----------------ortak kaynak basi---------
        try {
            semaphore.acquire(); // eger ortak kaynaga erisim talebi var ise - acquire ortak kaynaga erisim isnini kontrol ediyor -- izin belgesini verdi
            //ortak kaynaga giris yapildi(veri tabani ile ilgili isler)
            System.out.println("--->" + this.carName + " park alanina girdi....");
            Thread.sleep(duration);
            System.out.println("<---" + this.carName + "park alanindan cikiyor....");
            semaphore.release(); // izin belgesini geri iade etti - musait alan sayisi arttirilir
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ////-----------------ortak kaynak sonu-------


        //.......buralarda baska kodlar olabilir
    }
}
