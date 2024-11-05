package generics.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GenericProductRunner {
    public static void main(String[] args) {

        //2 farkli urun: laptop, book

        //generic yapilari kullanirken data tipine karar verilir
        GenericProduct<String> labtop = new GenericProduct<>(); // T: artik String olarak islem gorecek class icinde artik
        labtop.setCode("ABC123");
        //labtop.setCode(123); // HATA burda artik labtop icine Stringten baska deger koyamayiz su koydugun kabin icine baska bir sey koyamassin

        GenericProduct<Integer> book = new GenericProduct<>(); // T: Integer olarak set edildi
        book.setCode(123);
        //book.setCode("123"); // ---> siki bir tur denetimi uygular atik Integer oldugu icin String deger atayamam

        String str = labtop.getCode(); // burda oto-casting yapabildi burda data tipi belirlendigi icin casting islemini sorunsuz gerceklestirdi

        //String str2 = book.getCode(); //HATA ama 2 castinge gerek kalmadi , ClassCastExeption almaktan kutulduk RunTimeExeption degil CompileTime Exeption aldigimiz icin hatayi direk burda cozeriz
        // burda Integer bir deger Integer a set edilemedigi icin oto-casting yapilamadi
        Integer str2 = book.getCode(); // bu sekilde hizli bir sekilde kodun duzeltimine gittik


        //------------onceden bildigimi Generic yapilari Gorelim-------------------------
        ArrayList<Boolean> list = new ArrayList<>();
        //list.add("abc"); // burda tur farkli oldugu icin ekleme yapamadik
        //K: String V: Integer
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Generic", 123);

        //------------COk PARAMETRELI GENERIC CLASS---------------
        //S:String U:Integer
        GenericClassTwoParameter<String,Integer> obj=new GenericClassTwoParameter<>("generic",123);

        //S:Integer U:Integer
        GenericClassTwoParameter<Integer,Integer> obj2=new GenericClassTwoParameter<>(1,2);


    }
}
