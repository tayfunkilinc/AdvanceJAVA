package threads;
//2.YOL Runnable interfaceini implement ederek yapilir
//NOT: Runnable: Functional Interface : Implemente edilmesi gereken sadece 1 tane method vardir(buda run methoduudr)
public class MyRunnable implements Runnable{
    // bu class i Runnable implemetini somutlastirmak icin kullandi run methodunu override etmek icin kullandik
    @Override
    public void run() {
        //threade yapilmasini istedigimiz isleri bura yaziyoruz
        System.out.println("Calisan Thread: " + Thread.currentThread().getName());
        System.out.println("MyRunnable ile Olusturulan thread basladi....");
    }
}
