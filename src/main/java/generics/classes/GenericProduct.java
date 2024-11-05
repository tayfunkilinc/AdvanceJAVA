package generics.classes;
//amacımız: farklı data tipindeki ürün kodlarını tutabilmek için
//ayrı ayrı classlar oluşturmadan (book, phone, laptop,...)
//tek bir class ile ürün objelerini oluşturmak
//Cozum olarak Generic Class Olusturalim

/*
       E --> Element, collection gibi yapılarda kullanılır -- icerisine eleman alacak turler icin kullanilir
       K --> Key -- map gibi key ve value su olan turlerde tercih edilir
       V --> Value --  map gibi key ve value su olan turlerde tercih edilir
       N --> Number -- sayilar icin
       T --> Type -- herhangi bir data tipi icin
       S,U,V , vb --> 2., 3. ve 4. tipler için
  */

//generic product'da artik T disinda baska veri türü kullkanamayacagiz degil mi

public class GenericProduct <T>{
    private T code; // T: her hangi bir NON-PRIMITIVW data tipi olabilir
                    // T: data tipine kullanirken karar verilir

    public String name; // bu veri tipi sabit degisken
    public int stock; // bu veri tipi sabit degisken

    public T getCode() {
        return code;
    }

    public void setCode(T code) {
        this.code = code;
    }
}
