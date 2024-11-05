package generics.bounding;
// bounding = sinirlama - sinirlandirici
//generic yapilarda parametre olarak kullanilan data tipi ustten sinirlandirilabilir
public class GenericUpperBound<T extends  Number> { // burda artik Number class ile ustten Sinirlamis olduk
    // T burda hesaplama yapacaksak String, User,Object, .... gibi degisken turlerini almamali !!!
    // T burda BYTE, SHORT, INTEGER, DOUBLE, LONG, FLOAT, NUMBER ... gibi turleri kullanabilirim !!!
    //****burda matamatiksel islemler yapacaksak
    // T burda Number classi ve alt siniflariyla  ustten sinirlandirabiliri buna bounding denir

    public  T[] numberArray;
    //numerArray'in icindeki elemanlarin ortalamasini bulan bir method olusturalim
    public Double countAverage(){
        double sum = 0;
        for (T w : this.numberArray){
            sum += w.doubleValue(); // doubleValue() dizi icerisindeki elemanlarin double data tipine donusumunu saglar
        }
        double avg = sum / numberArray.length;
        return avg;
    }

}
