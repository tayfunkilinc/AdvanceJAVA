package threads.multithreading;

//DEADLOCK cozumu
//1.COZUM: synchronized bloacklar ic ice degil alt alta kullanarak cozebiliriz
//2.COZUM: anlasmayi saglayabilirsin duzeni koruyarak soruyu cozebilirsin. kullanim sirasini kendin kod icin de belli bir duzene sokabilirsin

/*
Ölümcül kilitlenme; iki veya daha fazla threadin çalışmak için
aynı kaynağa/lara erişmek istemesiyle oluşur.

Kaynağa erişmek için sürekli birbirlerini beklemeleri sonucunda
sistem kaynakları olumsuz etkilenir ve hatta uygulama cevap veremez hale gelir.
 */

public class DeadLockSolution {
    public static void main(String[] args) {
        String sugar = "seker";
        String coffe = "kahve";


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // bu sekilde ic ice synchronized kullaninca DeadLock ile karsilasilabilir
                System.out.println("Tom Seker Kullanmak Istiyor...");
                synchronized (coffe){
                    System.out.println(Thread.currentThread().getName() + " " + coffe + " i kullanmaya basladi...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + sugar + " yi kullanmak istiyor...");
                    synchronized (sugar){
                        System.out.println(Thread.currentThread().getName() + " " +sugar+ " yi kullaniyor...");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }// sekeri biraktik
                }//kahveyi biraktik
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
