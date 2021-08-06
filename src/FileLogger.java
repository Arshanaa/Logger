/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arshanaa
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class FileLogger implements Logger {


    @Override
    public void log(String message) {
        try {

            try (PrintWriter writer = new PrintWriter("log.txt", StandardCharsets.UTF_8)) {
                writer.println(message);
            }
        } catch (IOException exception) {
            exception.fillInStackTrace();
        }
    }
}
