package fund;

public class ClassSingleton {
    //静态内部类
    private ClassSingleton(){

    }
    public static final ClassSingleton getInstance(){
        return LazyHolder.instance;
    }
    private static class LazyHolder{
        private static final ClassSingleton instance = new ClassSingleton();
    }



}
