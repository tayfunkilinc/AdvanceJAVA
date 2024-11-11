package threads.multithreading;
//
public class MultiThreading02 {
    public static int sayac = 0;

    public static void main(String[] args) {
        //task: sayacin degerini 2000 defa arttirip son degerinin 2000 olmasini saglayalim(Tom-Jery bilet satisi)
        //task icin 2 tane Thread gorevlendirelim : Tom ve Jerry

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<11;i++){
                    System.out.println("su satıldı");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Sayac.increment(); // Tom 1000 kere arttirma yapacak sira onemli degil onemli olan 1000 kere arttirma yapmak
                for (int i=1;i<11;i++){
                    System.out.println("su satıldı");
                }
            }
        });
        thread1.setName("Tom");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<6;i++){
                    System.out.println("meşrubat satıldı");
                }
                Sayac.increment(); // Tom 1000 kere arttirma yapacak sira onemli degil onemli olan 1000 kere arttirma yapmak
                for (int i=1;i<6;i++){
                    System.out.println("meşrubat satıldı");
                }
            }
        });
        thread2.setName("Jerry");
        thread1.start(); // bu Thread islemini baslatmayi unutma Thread baslatmassan olusturmanin anlami yok
        thread2.start();
//        Tom --> Sayac SON Degeri: 1430
//        Jerry --> Sayac SON Degeri: 1973
        //UYARI:  eger birden fazla Thread ayni anda ayni kaynaga erismeye calisirsa tutarsizlik olusur
        //bu tutarsizliktan kurtulmak icin Threadleri siraya koyabiliriz bunuda synchronized keywordu ile yapiyoruz

        //synchronized ile sorunu cozduktan sonraki cikti herzaman tutarli oldu
//        Tom --> Sayac SON Degeri: 1000
//        Jerry --> Sayac SON Degeri: 2000
    }
}

class  Sayac{
    //sayacin degerini 1000 kez arttiran bir method olusturalim
    //methoda ayni anda sadece 1 tana threadin erismeine izin verir.
    // burda kiyafet deneme kabinine girecek olan musterilerin erisimini ornek olarak dusunebilirsin
    public static synchronized void increment (){ // synchronized ile bu ortak kullanim alanina Threadlerin ayni bir Threadin erisimine izin verir
        for (int i =1; i<1001; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            MultiThreading02.sayac++; //1-okuma // 2-bir artırma // 3-yazdırma
            System.out.println(Thread.currentThread().getName() + " --> Sayac SON Degeri: " + MultiThreading02.sayac);
        }
    }
}