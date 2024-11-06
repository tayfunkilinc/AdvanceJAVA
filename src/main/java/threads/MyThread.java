package threads;
//1.YOL : Thread Classini extend ederek
public class MyThread extends Thread{
    @Override
    public void run() { // burda normal thread icindeki run methodunu run ettik
        // thread de yaptirmak istedigimiz isleri, kodllari burda tanimliyoruz
        System.out.println("Calisan Thread: " + Thread.currentThread().getName());
        System.out.println("MyThread treadi calisiyor: HARIKA!");
    }
}
