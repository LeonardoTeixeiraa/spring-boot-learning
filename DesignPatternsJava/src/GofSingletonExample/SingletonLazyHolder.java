package GofSingletonExample;

public class SingletonLazyHolder {

    private static class Holder {
        private static SingletonLazyHolder instancia = new SingletonLazyHolder();
    }
    private SingletonLazyHolder(){
        super();
    }
    public static SingletonLazyHolder getInstance(){
        return Holder.instancia;
    }

}
