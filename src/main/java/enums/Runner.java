package enums;
// uygulamada icerdigi karakterlere gore password gucu belirleniyor: EnYuksek seviye HIGH orta MEDIUM Dusuk LOW
//seviye belirlendikten sonra kullaniciya mesaj verilecek
//LOW: Dikkat Sifreniz yetesiz seviyededir
//MEDIUM: Dikkat Sifreniz orta seviyededir
//HIGH: Tebrikler, sifre gucunuz yuksek seviyede
//kullaniciya yukardaki mesajlar verilecek
public class Runner {
    public static void main(String[] args) {

    printMessage("LOW"); //Dikkat Sifreniz yetesiz seviyededir
    printMessage("MEDIUM"); //Dikkat Sifreniz orta seviyededir
    printMessage("high"); // ****burda CTE vey RTE zamaninda hata almadik SORUN: method beklenen islevi yerine geitrmedi
    printMessage("HIGH "); //burada sona bir bosluk yazsak yine hata gorunmez ama mantiksal hata olusuz
        //COZUM nedir bakalim
        //method parametlersina arguman olarak sadece belirledigimiz sabit degiskenleri verilmeli--> Enum Type


    }
    //kullaniciya parametrede verilen password gucune gore
    //mesaj gosteren bir method yazalim
    public static void printMessage(String passStrength){
        if(passStrength.equals(PasswordStrength.LOW)){
            System.out.println("Dikkat Sifreniz yetesiz seviyededir");
        } else if (passStrength.equals(PasswordStrength.MEDIUM)) {
            System.out.println("Dikkat Sifreniz orta seviyededir");
        } else if (passStrength.equals(PasswordStrength.HIGH)) {
            System.out.println("Tebrikler, sifre gucunuz yuksek seviyede");
        }
    }

    //todo: kullaniciya parametrede Enum ile verilen pasword gucune gore mesaj gosteren bir method yazalim
}
