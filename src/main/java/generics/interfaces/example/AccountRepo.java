package generics.interfaces.example;
//Account ile ilgili veritabani islemleri bu class'ta yapilmali

public class AccountRepo implements Repo<Account>{

    @Override
    public void save(Account obj) {
        //veritabanina kaydeder
    }

    @Override
    public Account find() {
        return null;
    }
}
