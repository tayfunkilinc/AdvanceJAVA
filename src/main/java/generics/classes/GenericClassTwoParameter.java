package generics.classes;
//amacimiz: farkli fieldlarda farkli data tiplerini bagimsiz olarak kullanma
public class GenericClassTwoParameter<S, U> { // farkli farkli data tiplerini tutmak icin bu sekilde iki parametre kullanmamiz gerekir
    private S anahtar; // tum NON-PRIMITIVE data tipleri kullanilsin
    public  U deger;  // tum NON-PRIMITIVE data tipleri kullanilsin

    //constructur
    public GenericClassTwoParameter(S anahtar, U deger) {
        this.deger = deger;
        this.anahtar=anahtar;
    }


    //getter-setter

    public S getAnahtar() {
        return anahtar;
    }

    public void setAnahtar(S anahtar) {
        this.anahtar = anahtar;
    }

    public U getDeger() {
        return deger;
    }

    public void setDeger(U deger) {
        this.deger = deger;
    }
}
