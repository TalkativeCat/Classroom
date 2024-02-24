
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 6 || !args[0].equals("-a") || !args[2].equals("-h") || !args[4].equals("-l")) {
            System.out.println("Usage: myapp -a <algorithm> -h <hash> -l <length>");
            return;
        }

        String algorithm = args[1];
        String targetHash = args[3];
        int length = Integer.parseInt(args[5]);

        Thread[] threads = new Thread[Runtime.getRuntime().availableProcessors()];

        for (int i = 0; i < threads.length; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> findStringWithHash(algorithm, targetHash, length, threadId, threads.length));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void findStringWithHash(String algorithm, String targetHash, int length, int start, int step) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            StringBuilder sb = new StringBuilder();
            for (int i = start; i < Integer.MAX_VALUE; i += step) {
                sb.setLength(0);
                sb.append(String.format("%0" + length + "d", i));
                byte[] hashBytes = digest.digest(sb.toString().getBytes());
                StringBuilder hashString = new StringBuilder();
                for (byte b : hashBytes) {
                    hashString.append(String.format("%02x", b));
                }
                if (hashString.toString().equals(targetHash)) {
                    System.out.println(sb);
                    break;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
