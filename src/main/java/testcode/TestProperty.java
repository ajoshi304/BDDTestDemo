package testcode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestProperty {

    public static void main(String[] args) {

        Properties properties= new Properties();
        BufferedReader bufferedReader;

        try {
            bufferedReader= new BufferedReader(new FileReader("C:\\Users\\Arjun Joshi\\IdeaProjects\\BDDTestDemo\\src\\test\\resources\\globalValues.properties"));
            properties.load(bufferedReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The Base URI is " + properties.getProperty("baseuri"));

    }
}
