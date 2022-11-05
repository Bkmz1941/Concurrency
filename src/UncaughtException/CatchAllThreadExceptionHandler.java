package UncaughtException;

public class CatchAllThreadExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Caught exception from thread: " + t.getName());
    }
}
