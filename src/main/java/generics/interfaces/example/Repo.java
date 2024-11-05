package generics.interfaces.example;

public interface Repo<T> {
    //bunu implement edenler methodlarini kullanmak zorunda
    //interface kod azaltmaz bir sozlesme olusturarak herkesin uymasini saglariz
    //---standartlik saglanir bir duzene saghip olmus olursunuz -- davranis farkli olabilir ama genel cerceve ayni olur

    //save methodu -- bu methoda varkli turlerde veri gonderilebilir bu sebeple generic kullandik
   // void save(Customer obj); // eger musteri kaydedecekse alacagi vareable Customer class turunde olmali
   // void save(Account obj); // eger burda hesap kaydedeceksek Customer class turunde olmali
   //ama burdagenel bir repo olusturdugumuz icin burayi genellestirmemiz gerekir
    void save (T obj);


    //find methodu -- geri donus degeri olusturulan nesneye gore farklilik gosterebilir bu sebeple Generic olarak tasarladik
   //Customer find(); // burdada geriye donus tipi degisiklik gosteriyor bu nedenle Generic kullanmaliyiz
    T find();

}
