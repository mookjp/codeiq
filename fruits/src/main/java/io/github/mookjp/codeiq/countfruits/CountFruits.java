package io.github.mookjp.codeiq.countfruits;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 */
public class CountFruits {
    public static void main(String[] args) {
        try {
            Files.readAllLines(Paths.get(args[0]), Charset.defaultCharset()).stream()
                    .forEach(s -> System.out.println(new Counter(s).count()));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
