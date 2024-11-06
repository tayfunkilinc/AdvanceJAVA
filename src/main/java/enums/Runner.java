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
 //-------------------------------
        printMessageEnum(PasswordStrengthEnum.LOW); // burda parametre olarak sadece enum kabul ediyor bu yontem sayesinde girilecek argumani stabillestirdik
        printMessageEnum(PasswordStrengthEnum.MEDIUM);
        printMessageEnum(PasswordStrengthEnum.HIGH);
        //burada artik olusabilecek mantiksal hatadan kurtulmus olduk

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

    //kullaniciya parametrede Enum ile verilen pasword gucune gore mesaj gosteren bir method yazalim
    public static void printMessageEnum(PasswordStrengthEnum strength){
        if(strength.equals(PasswordStrengthEnum.LOW)){
            System.out.println("Dikkat Sifreniz yetesiz seviyededir");
        } else if (strength.equals(PasswordStrengthEnum.MEDIUM)) {
            System.out.println("Dikkat Sifreniz orta seviyededir");
        } else if (strength.equals(PasswordStrengthEnum.HIGH)) {
            System.out.println("Tebrikler, sifre gucunuz yuksek seviyede");
        }
        System.out.println("Enum Sirasi: " + strength.ordinal());
    }
    //-------> Burdada ordinal degerlerle kosullarimizi belirleyebiliriz ama
    // ekleme yapildiginda siralamada, ordinal degerlerinde degisiklik olusacagi icin sorun yasanabilir buna dikkat et
    //ordinal hafatanin gunleri gibi kesin degismeyecek verilerde kullanilir

    public static void printMessageEnum2(PasswordStrengthEnum strength){
        System.out.println("Enum Sirasi: " + strength.ordinal()); //enum numaralarina ulasmak
        System.out.println("Enum Ismi: " + strength.name());  //enum ismine bu sekilde ulasiriz
        if(strength.ordinal()==0){
            System.out.println("Dikkat Sifreniz yetesiz seviyededir");
        } else if (strength.ordinal()==1) {
            System.out.println("Dikkat Sifreniz orta seviyededir");
        } else if (strength.ordinal()==2) {
            System.out.println("Tebrikler, sifre gucunuz yuksek seviyede");
        }
    }
}
