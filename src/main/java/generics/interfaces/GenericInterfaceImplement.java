package generics.interfaces;
//1.SEÇENEK: Generic bir interfacei implemente eden class da generic olmalı -- GenericInterfaceImplement<T>

public class GenericInterfaceImplement<T> implements GenericInterface<T>{

    @Override
    public void print(T value) {
        //body
    }

    @Override
    public T find() {
        //body
        return null;
    }
}
