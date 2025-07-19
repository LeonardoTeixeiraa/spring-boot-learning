package GofSingletonExample;

public class SingletonEager {
    private static SingletonEager singletonEager = new SingletonEager();;

    public SingletonEager() {
        super();
    }

    public static SingletonEager getInstance(){
        return singletonEager;
    }
}
