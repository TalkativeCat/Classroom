

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        int width = 0, height = 0;
        double realPart = 0, imaginaryPart = 0;
        String outputFileName = "";

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-d":
                    String[] dimensions = args[++i].split(";");
                    width = Integer.parseInt(dimensions[0]);
                    height = Integer.parseInt(dimensions[1]);
                    break;
                case "-c":
                    String[] constants = args[++i].split(";");
                    realPart = Double.parseDouble(constants[0]);
                    imaginaryPart = Double.parseDouble(constants[1]);
                    break;
                case "-o":
                    outputFileName = args[++i];
                    break;
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            final int row = y;
            int finalWidth = width;
            int finalHeight = height;
            double finalRealPart = realPart;
            double finalImaginaryPart = imaginaryPart;
            executor.execute(() -> {
                for (int x = 0; x < finalWidth; x++) {
                    int color = calculatePixelColor(x, row, finalWidth, finalHeight, finalRealPart, finalImaginaryPart);
                    image.setRGB(x, row, color);
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Ждем, когда завершится выполнение всех потоков
        }

        try {
            File output = new File(outputFileName);
            ImageIO.write(image, "png", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculatePixelColor(int x, int y, int width, int height, double realPart, double imaginaryPart) {
        double zx = 1.5 * (x - width / 2.0) / (0.5 * width);
        double zy = (y - height / 2.0) / (0.5 * height);
        double escapeRadius = 2;
        int maxIterations = 300;
        int iteration = 0;

        while (zx * zx + zy * zy < escapeRadius * escapeRadius && iteration < maxIterations) {
            double xTemp = zx * zx - zy * zy + realPart;
            zy = 2.0 * zx * zy + imaginaryPart;
            zx = xTemp;
            iteration++;
        }

        if (iteration == maxIterations) {
            return 0x000000;
        } else {
            return 0xFFFFFF;
        }
    }

}
