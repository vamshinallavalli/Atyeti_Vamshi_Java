package tasks;

import java.nio.file.*;
import java.util.Arrays;
import java.util.concurrent.*;

public class FileWordCounterUsingThreadPool {
    public static void main(String[] args) throws Exception {
        String filepath = "C:\\Users\\VamshiNallavalli\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Vamshi_Java\\June Month\\Multi Threading\\Excecutor_Service\\src\\main\\java\\tasks\\tasks.txt";


        ExecutorService executor=Executors.newFixedThreadPool(5);

        Callable<Integer> counter=()->{
            Path path=Paths.get(filepath);
            long count=
                    Files.lines(path)
                    .flatMap(line -> Arrays.stream(line.trim().split("\\s+")))
                    .filter(word -> !word.isEmpty())
                    .count();
            return (int)count;
        };

        try{
            Future<Integer> future=executor.submit(counter);
            int count=future.get();
            System.out.println(count);
        }catch (Exception e){
            System.out.println(e);
        }
        finally {
            executor.shutdown();
        }
    }
}
