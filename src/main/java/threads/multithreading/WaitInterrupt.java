package threads.multithreading;
/*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
        Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
        Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/

//üretici(producer)-tüketici(consumer)

//wait() : bir threadin belirli bir kaynağın kilidini serbest bırakmasını
//        ve başka bir threadden sinyal alana kadar beklemesini sağlar. wait metodu
//        genellikle bir kilit mekanizması olan synchronized blok veya metod içinde kullanılır.

//multithreading uygulamalarda bir threadin işini sürdürebilmesi için
//diğer threadi beklemesi gerekirse wait-notify/wait-interrupt metodlarıyla
//iletişim sağlanabilir.

public class WaitInterrupt {

    public static int balance=0;//alican ve velihanın ortak hesabı

    //para yatırma
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor. ");
        balance+=amount;//okuma,artırma,yazdırma
        System.out.println("Para yatırma işlemi başarılı, mevcut bakiye : "+balance);
    }

    //para çekme
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para çekmek istiyor. ");
        //bakiye yetersiz ise
        if (balance==0 || balance<amount){
            System.out.println("Bakiye yetersiz!!! Mevcut bakiye : "+balance);
            //işleme devam edemez, bekleyecek
            System.out.println("Bakiyenin güncellenmesi bekleniyor...");
            try {
                wait();//monitör edilen objeyi geçici olarak serbest bırakır
            } catch (InterruptedException e) {
                System.out.println("Bakiye güncellendi...");
            }

        }

        //kaldığı yerden işleme devam eder
        //bakiye güncellendi
        //bakiye yeterli ise
        if (balance>=amount){
            System.out.println("Bakiye yeterli , işlem gerçekleşiyor...");
            balance-=amount;//okuma,azalt,yazdırma
            System.out.println("Para çekme başarılı, mevcut bakiye : "+balance);
        }else {
            System.out.println("Bakiye yetersiz!!! Mevcut bakiye : "+balance);
            System.out.println("Umudunu kaybetme, yarın gel!!!");
        }
    }


    public static void main(String[] args) {

        WaitInterrupt obj=new WaitInterrupt();

        //para çekme ve yatırma işlemlerini 2 tane threade yaptıralım
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {

                obj.withdraw(1000);
            }
        });
        thread1.setName("AliCan");//tüketici

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
                thread1.interrupt();//threadi kesintiye uğratır
                //thread wait,sleep,join ile beklemekteyse  exception fırlatır
                //bu durum işlemi sürdürmek için kullanılabilir

            }
        });
        thread2.setName("VeliHan");//üretici

        thread1.start();
        thread2.start();






    }





}