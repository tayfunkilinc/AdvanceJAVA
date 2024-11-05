package generics.classes;
//amacımız: farklı data tipindeki ürün kodlarını tutabilmek için
//ayrı ayrı classlar oluşturmadan (book, phone, laptop,...)
//tek bir class ile ürün objelerini oluşturmak
public class NonGenericsProducts {
    private Object code; //123 , "A12"
    //code fieldinin data tipi object(tum data tiplerinin parenti ) oldugu icin olusturululana nesnelerin
    //kod ozelliginde tup data tipleri kullanilir


    //getter-setter

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

}
