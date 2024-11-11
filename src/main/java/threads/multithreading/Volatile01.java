package threads.multithreading;

public class Volatile01 {
    public static  volatile  int flag= 0; // bu dongu sonlandirmak cin kullanilacak
    //Volatile:  burda budurumun olusmamasi icin flag degiskenini main memory den okunmasini ve main memorye yazilmasini garanti hala getirmek icin volatile kullanacagiz.

    public static void main(String[] args) {
        //volatile ile onemli degiskenlerinizi cache aldirmayip ana memory de saklayarak riski ortadan kaldiriryoruz
        //volatile on bellek kullanimin da karsilasilabilecek hatalarla bas etmek icin main memory kullanimina zorlamak icin kullanilir

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag == 0){
                    System.out.println("Bu sadece Bir RISK!");
                    //burda flag degerine mudahale etmedigimiz surece sonsuz calisacak
                    // bu dongunun tamamlanmasi icin thread2 flag degerini degistirmesi gerek
                }
            }
        });
        thread1.start(); //1.cekirdek , cache:flag =0
        //RISK: burda bellek guncellene kadar bir birini degerlerinden haberleri yok -- bu durum cok uzun surerse program calisamaz hali geldi
        //Volatile:  burda budurumun olusmamasi icin flag degiskenini main memory den okunmasini ve main memorye yazilmasini garanti hala getirmek icin volatile kullanacagiz.
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag=1;
                System.out.println("Flag Degiskeninin Degeri Degisti");
            }
        });
        thread2.start(); //2.cekirdek : cache: flag=1
    }
}
