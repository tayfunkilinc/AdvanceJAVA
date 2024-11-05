package generics.methods;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {
        Integer[] intArr={2,3,8,99,55};
        Double[] doubleArr={1.3,35.6,99.9,0.5};
        String[] stringArr={"Java","generics","hayatımızı","kolaylaştırır"};

        System.out.println("-------------printArr kullanimi-------------------");
        printArr(intArr); //2 3 8 99 55
        //printArr(doubleArr); // burda yazdirilmak istenen deger tipi degisiklige gittigi icin yazdiramayiz
        //printArr(stringArr); // burda yazdirilmak istenen deger tipi degisiklige gittigi icin yazdiramayiz
        //bu sorunu overloading yaparak cozume gidebiliriz
        System.out.println("-------------printArrGeneric kullanimi-------------------");
        printArrGeneric(intArr); // T: yerine Integer yerlesti
        printArrGeneric(doubleArr); // T: yerine Double yerlesti
        printArrGeneric(stringArr); // T: yerine String yerlesti
        System.out.println("-------------return type i olan generic method kullanimi-------------------");
        Integer eleman = getFirst(intArr);
        String eleman2 = getFirst(stringArr);
        Double eleman3 = getFirst(doubleArr);
        System.out.println("-------------iki parametreli method kullanimi-------------------");
        printArrAndElement(stringArr, 5); // S:String U: Integer
        printArrAndElement(intArr,"abc"); // S:Integer U: String
        printArrAndElement(stringArr,"abc"); // S:String U: String

    }
    //amacimiz: farkli data tipindeki Array leri konsola yazdirmak icin method tanimlama
    // generic methoda hangi durumlarda ihtiyac duyulur
    public static void printArr(Integer[] arr){ // int bir array alip yazdiracak bir method yazacagiz
        Arrays.stream(arr).forEach(t-> System.out.print(t + " "));
        System.out.println();
    }
    public static void printArr(String[] arr){ // OverLoading yaparak tipi String olanlar icin
        Arrays.stream(arr).forEach(t-> System.out.print(t + " "));
        System.out.println();
    }
    public static void printArr(Double[] arr){ // OverLoading yaparak tipi Double olanlar icin
        Arrays.stream(arr).forEach(t-> System.out.print(t + " "));
        System.out.println();
    }

    //GENERIC tipinde bir Method Olusturalim************
    //keske methodumuz generic olsaydi....bu sekilde bir suru overloading yapmadan sorunu cozerdik
    public static <T>void printArrGeneric(T[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t + " "));
        System.out.println();
    }

    //retur ttype i olan generic method?
    //verilen array in ilk elemanini donderen bir method yazalim
    public static <T> T getFirst(T[] arr){
        T first = arr[0];

        return first;
    }

    //birden fazla parametreli generic method kullanabilirmiyiz
    public static <S,U> void printArrAndElement(S[] arr, U obj){ // burda S ve U farkli tiplerde de degerlendirilebilir

        //arr[0] = obj; // HATA burda tipi hali hazirda belli olmadigi icin atama yapilamaz
        //data tipleri farkli olabilir S farkli U farkli tipte olabilir -- iki tata tipininde auyni oldugunu garanti edersek o zaman durumunu belirleriz



        Arrays.stream(arr).forEach(t-> System.out.println(t +" "));
        System.out.println(obj);
    }




}
