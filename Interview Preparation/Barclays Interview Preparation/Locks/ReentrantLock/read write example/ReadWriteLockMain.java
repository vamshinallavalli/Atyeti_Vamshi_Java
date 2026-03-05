import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWriteLockMain {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private final Lock readLock = readWriteLock.readLock();
    private final List<String> list = new ArrayList<>();

    // Write operation
    public void setElement(String value) {

        writeLock.lock();
        try {
            list.add(value);
            System.out.println("Element added by thread: "
                    + Thread.currentThread().getName());
        } finally {
            writeLock.unlock();
        }
    }

    // Read operation
    public String getElement(int i) {
        readLock.lock();
        try {
            System.out.println("Element read by thread: "
                    + Thread.currentThread().getName());
            return list.get(i);
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {

        ReadWriteLockMain obj = new ReadWriteLockMain();

        obj.setElement("Hi");
        obj.setElement("Hey");
        obj.setElement("Hello");

        System.out.println("Printing last element: "
                + obj.getElement(2));
    }
}