package generics.bounding;

public class GnericUpperBoundRunner {
    public static void main(String[] args) {
        Integer[] integers={2,3,6,9,8,7};
        Double[] doubles={0.3,99.3,10.0,2.3};
        String[] strings={"generics","üstten","sınırlandıralabilir"};

        GenericUpperBound<Integer> obj = new GenericUpperBound<>();// T data tipine karar vercegiz sinirlandirildigi icin sacede NUMER ve childlarini alabilir
        obj.numberArray = integers;
        System.out.println("obj.countAverage() = " + obj.countAverage()); // obj.countAverage() = 5.833333333333333
        //---------------------------------------------------------------------------------------
        GenericUpperBound<Double> obj2 = new GenericUpperBound<>();
        //obj2.numberArray = integers; //HATA T data tipi artik Double sectigimiz icin farkli bir deger veremeyiz
        obj2.numberArray = doubles;
        obj2.countAverage();
        //----------------------------------------------------------------------------------------


    }
}
