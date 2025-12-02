package multithreading_donewith;

public class ExampleForWhyMultithreading {

    /*

Real-Life Example: File Downloader

Before Multithreading (1995 style)

Java//

Main thread does everything → UI freezes for 10 seconds!
downloadFile();     // blocks for 10 sec
updateProgressBar(); // runs only after download finishes


After Multithreading (Modern Java)

new Thread(() -> {
    downloadFile();               // runs in background
    SwingUtilities.invokeLater(() -> updateProgressBar());
}).start();

updateUI();  // UI remains responsive!
*/
}
