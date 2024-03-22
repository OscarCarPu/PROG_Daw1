package pruebas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class FluxoBytesNIO {
public static void main(String[] args) {
    String directory = System.getProperty("user.home");
    String fileName = "sample.txt";
    String content = "This is a sample text.";
    Path path = Paths.get(directory, fileName);
    try {
        Files.write(path, content.getBytes(), StandardOpenOption.CREATE);
    } catch (IOException e) {
        System.err.println("Error na E/S");
    }
    try { 
        byte[] data = Files.readAllBytes(path);
        System.out.println(new String(data));
        } catch (IOException e) {
        System.err.println("Error na E/S");
        }
}}