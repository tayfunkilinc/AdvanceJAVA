package generics.classes;

public class NonGenericRunner {
    public static void main(String[] args) {
        //2 farkli urun:  book, labtop
        NonGenericsProducts laptop = new NonGenericsProducts(); // ilk urunumuzu olusturduk
        laptop.setCode("ABC123"); // code ozelligini String ile set ettik -- Object turu oldugu icin String set edebildik

        NonGenericsProducts book = new NonGenericsProducts();
        book.setCode(123); //code ozelligini Integer ile set ettik -- Object turu oldugu icin Integer set edebildik

        //1.Proble---CAST problemi
        //2.ClassCastException problemi yasanabilir
        // String str = laptop.getCode(); //HATA burda Object daha buyuk bir data tipi oldugu icin String icine otomatik casting yapamadi
        String str = (String) laptop.getCode(); // bu sekilde biz manuel Casting yaparak sorunu cozduk
        //------------
        String str2 = (String) book.getCode(); // burda integer bir degeri String casting yaptik ClassCastException HATAsi aliriz
        System.out.println(str+str2); // ClassCastException yalnis veri tipine casting yaptigimiz icin bu hataya sebebolduk
    }
}
