package enums;

public enum PasswordStrengthEnum {
    LOW(10),
    MEDIUM(50),
    HIGH(100);   //---> burada yazilanlar intance yani objelerdir constructor a  (--PasswordStrengthEnum(int level)--) gore parametre verilmek durumundadir

    private final int level; // baska bir classtan degistirilemez ve ulasilamaz

    // bir deger set etmek icin constructor kullaniriz

    PasswordStrengthEnum(int level) { // default olarak private erisim turune sahiptir
        this.level = level;
    }
}
