package GofSingletonExample;

public class SingletonLazy {

    private static SingletonLazy singletonLazy;

    public SingletonLazy() {
        super();
    }

    public static SingletonLazy getInstance(){
        if (singletonLazy == null){
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
