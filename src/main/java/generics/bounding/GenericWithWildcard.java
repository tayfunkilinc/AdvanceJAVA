package generics.bounding;
//wildcard: (?) joker semboludur-- bilinmeyen data tipi olarak isimlendirili
// kullanilacak sembol ? tidir****
//generic yapilari kullanirken alttan veya ustten sinirlandirabiliriz

import java.util.ArrayList;
import java.util.List;

public class GenericWithWildcard {
    public static void main(String[] args) {
        List<Integer> integerList=new ArrayList<>();
        List<Double> doubleList=new ArrayList<>();
        List<String> stringList=new ArrayList<>();
        List<Number> numberList=new ArrayList<>();
        List<Object> objectList=new ArrayList<>();
        objectList.add("asd");

        //---------------------------
        addElements(integerList);
        //addElements(Double);//  HATA// Double Integer parent degil kardesidir bu sebele alamaz
        addElements(numberList);
        addElements(objectList);
        //--------------------------
        multiplyByTwo(integerList);
        multiplyByTwo(doubleList);
        //multiplyByTwo(stringList); //HATA bu string kabul etmez
        multiplyByTwo(numberList);
        //multiplyByTwo(objectList);  //HATA burda ustten sinirladik Object parent oldugu icin --
        // burda Object string degerde alabilecegi icin hatanin onune gecmek icin bunu yaptik yani bir stringin integer ile carpimini onlemis olduk


    }
    //Generic yapiyi kullanirken alttan sinirlama yapabiliriz
    // Listeye 1 den 10 a kadar tam sayilari yazdiran bir method tanimlayalim
    //-------------ALTTAN SINIRLAMA---------
    public static void addElements(List<? super Integer> list){ // alttan Integer ile sinirlayip uste dogru yol goztertik
        // en az Integer olabilir Number, Object diye ust parentlarini kullanabilir
        // burda List interfaceni kullanirken alttan sinirladik Generic olustururken alttan sinirlama yok -- burda dikkat cagirirken alttan sinirladik
        //data tipine kararverirken sinirlama yapiyoruz
        for (int i = 1; i < 11; i++) {
            list.add(i);
        }
    }
    //-----------------USTTEN SINIRLAMA----------------
    //listedeki elemanlari 2 ile carpan bir method tanimlayalim
    //E: Number ve childlari ile sinirlandiracagiz
    public static void  multiplyByTwo(List<? extends Number> list){ // extends ile burda ussten Number ile sinirlandirmis olduk
        //ayni generic olustururken yaptigimiz gibi alttan sinirlamada super anahtar kelimesini kullanmistik burda extends kullandik
        list.stream().map(t-> 2*t.doubleValue()); //doubleValue() burda gelen degerleri double a cevirdik
    }
    //List<?> ve List<T> arasindaki fark nedir?  -->
}
