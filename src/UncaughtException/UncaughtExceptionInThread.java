package UncaughtException;

public class UncaughtExceptionInThread {
    public static void main(String[] args) {
        Thread.UncaughtExceptionHandler defaultHandler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Hi there");
            }
        };
        Thread.setDefaultUncaughtExceptionHandler(defaultHandler);

        CatchAllThreadExceptionHandler handler = new CatchAllThreadExceptionHandler();
        Thread.currentThread().setUncaughtExceptionHandler(handler);

        throw new RuntimeException();
    }
}
