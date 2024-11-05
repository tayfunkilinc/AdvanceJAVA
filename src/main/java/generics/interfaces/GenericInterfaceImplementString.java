package generics.interfaces;
//2.SEÇENEK:Generic interface i implemente ederken data tipine karar verebiliriz
public class GenericInterfaceImplementString implements GenericInterface<String> {

    @Override
    public void print(String value) {
        //body
    }

    @Override
    public String find() {
        //body
        return "";
    }
}
