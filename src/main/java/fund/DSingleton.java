package fund;


public class DSingleton {
    private DSingleton(){}
    private static DSingleton singleton;
    public static DSingleton getSingleton(){
        if (singleton == null) {
            synchronized (DSingleton.class) {
                if (singleton == null) {
                    singleton = new DSingleton();
                }
            }
        }
        return singleton;
    }

}
