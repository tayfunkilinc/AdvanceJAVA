package enums;

public enum PasswordStrengthEnum {
    //-----> unem type larin sira numaralari vardir bunlara ordinal degerler denir
    LOW(10), //---ordinal: 0
    MEDIUM(50), //---ordinal: 1
    HIGH(100);   //---ordinal: 2
    //---> burada yazilanlar intance yani objelerdir constructor a  (--PasswordStrengthEnum(int level)--) gore parametre verilmek durumundadir

    private final int level; // baska bir classtan degistirilemez ve ulasilamaz

    // bir deger set etmek icin constructor kullaniriz

    PasswordStrengthEnum(int level) { // default olarak private erisim turune sahiptir
        this.level = level;
    }
    //baska class tan bu degerleri okumak icin getter methodu olusturacagiz

    public int getLevel() {
        return level;
    }
}
