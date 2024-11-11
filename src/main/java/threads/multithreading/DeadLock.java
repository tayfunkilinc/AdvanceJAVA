package threads.multithreading;

//DEADLOCK olusma durumu

/*
Ölümcül kilitlenme; iki veya daha fazla threadin çalışmak için
aynı kaynağa/lara erişmek istemesiyle oluşur.

Kaynağa erişmek için sürekli birbirlerini beklemeleri sonucunda
sistem kaynakları olumsuz etkilenir ve hatta uygulama cevap veremez hale gelir.
 */

public class DeadLock {
    public static void main(String[] args) {
        String sugar = "seker";
        String coffe = "kahve";

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // bu sekilde ic ice synchronized kullaninca DeadLock ile karsilasilabilir
                System.out.println("Tom Seker Kullanmak Istiyor...");
                synchronized (sugar){
                    System.out.println(Thread.currentThread().getName() + " " + sugar + " i kullanmaya basladi...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + coffe + " yi kullanmak istiyor...");
                    synchronized (coffe){
                        System.out.println(Thread.currentThread().getName() + " " + " yi kullaniyor...");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }// kahveyi biraktik
                }//sekeri biraktik
                System.out.println("Tom, Sicak Su Ekledi ve Kahvesini Keyifle Yudumluyor");
            }
        });
        thread1.setName("Tom");
        thread1.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Jerry Kahveyi Kullanmak Istiyor...");
                synchronized (coffe){
                    System.out.println(Thread.currentThread().getName()+ " " +coffe+ "yi kullaniyor...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Jerry Sekeri Kullanmak SItiyor");
                    synchronized (sugar){
                        System.out.println(Thread.currentThread().getName()+ " " +sugar+ "yi kullaniyor...");
                    }
                }
            }
        });
        thread2.setName("Jerry");
        thread2.start();
    }
}
