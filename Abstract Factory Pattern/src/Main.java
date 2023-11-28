import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) {

        StringBuilder str = new StringBuilder("1234");

        String reversedStr = str.reverse().toString();
        int result = Integer.parseInt(reversedStr);

        System.out.println(result);


    }
}