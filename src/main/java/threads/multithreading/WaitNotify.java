package threads.multithreading;
        /*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
        Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
        Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/
//iki durum ayni anda gerceklesiyorsa : yani uretic ve tuketici iliskisinde wait-notify methodlari kullanilir
//uretici(producer) - tuketici(consumer) -->iliskilerinde wait-notify -->Thearedler arasi iletisim kullanilir

/*wait() : bir threadin belirli bir kaynağın kilidini serbest bırakmasını
ve başka bir threadden sinyal alana kadar beklemesini sağlar. wait metodu
genellikle bir kilit mekanizması olan synchronized blok veya metod içinde kullanılır.

notify(): Bir threadi uyandırır ve çalışmasına izin verir.*/

public class WaitNotify {
    //Thread ler ortak kaynak kullaniminda Thread ler bir biriyle iletisime gecever wait() ve Notify() methotlari kullanilir

            public static int balance = 0; // alican ve velihanin ortak hesabi

            //para yatirma islemi
            public synchronized void deposit(int amaunt){ // para yatirma: deposit

                System.out.println(Thread.currentThread().getName() + " para yatirmak istiyor.");
                balance += amaunt;
                System.out.println("Para yatirma islemi basarili, mevcut bakiye: " + balance);
                notify(); // wait() ile bekletilen Thread e bildirim gonderir -- whatshap mesaji ile para yatirdim cekebilirsin diyor
                notifyAll(); // bu ise wait() ile bekleyen tum Threadlere bildirim gonderir.
            }
            //para cekme islemi
            public synchronized void withdraw(int amount){ //withdraw : para cekme

                System.out.println(Thread.currentThread().getName() + " para cekmek istiyor.");
                //bakiye yetersiz mi yeterlimi kontrol etmeliyiz
                if (balance == 0 || balance < amount){
                    System.out.println("Bakiye Yetersiz!!! Mevcut Bakiye: " + balance);
                    //bu durumda isleme devam edilemez, bekleyecek
                    System.out.println("Bakiyenin Guncellenmesi Bekleniyor...");
                    try {
                        wait();  // monitör edilen objeyi geçici olarak serbest bırakır
                        // --wait()  synchronized ile birlikte kullanilmali cunku synchronized in tutugunu gecici olarak wait() servbest birakiyor
                        //notify ile uyarilana kadar  bu methodu kullanan Thread i bekletir
                    } catch (InterruptedException e) { // herhangi bir kesinti
                        throw new RuntimeException(e);
                    }
                }

                //kaldığı yerden işleme devam eder
                //bakiye güncellendi
                //bakiye yeterli ise
                if (balance>=amount){
                    System.out.println("Bakiye yeterli , işlem gerçekleşiyor...");
                    balance -= amount;
                    System.out.println("Para çekme başarılı, mevcut bakiye : "+balance);
                }else {
                    System.out.println("Bakiye yetrsiz!!! Mevcut bakiye : "+balance);
                    System.out.println("Umudunu kaybetme, yarın gel!!!");
                }

            }

            public static void main(String[] args) {
                WaitNotify obj = new WaitNotify();

                //para cekme ve yatirma islemlerini 2 tane threade yaptiralim

                Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        obj.withdraw(1000);
                    }
                });
                thread1.setName("Alican"); // tuketici


                Thread thread2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
//                        try {
//                            Thread.sleep(3000);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
                        obj.deposit(2000);
                    }
                });
                thread2.setName("Velihan"); // uretici
                thread1.start();
                thread2.start();
            }


}
