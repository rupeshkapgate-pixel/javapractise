import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class JavaBasics {
    public static void main(String[] args) {
        // Primitive array
        //javaArray();
       // javaString();
       // javaRegEx();
        javaCollection();
    }
    public static void javaArray(){
        int[] arr = {10, 20, 30, 40};
        int n = arr.length;
        for (int i =0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
        String[] myString = {"Rupesh", "Kapgate"};
        for(int j=0; j < myString.length; j++){
            System.out.println(myString[j]);
        }
        List<String> names = Arrays.asList("Asish", "Geek", "Amiya");
        names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(names.stream().filter(s -> s.startsWith("A")).count());

    }
    public static void javaString(){
        String str= "geeks";
        String str2= new String("geeks");
        StringBuffer demoString = new StringBuffer("GeeksforGeeks");
        //StringBuffer is thread-safe due to synchronization, making it suitable for multi-threaded environments,
        // while StringBuilder is faster but not thread-safe.
        StringBuilder demoString2 = new StringBuilder();
        demoString.append("GFG");
        StringBuffer sb1 = new StringBuffer("Java");
        StringBuffer sb2 = sb1;
        sb1.append(" Programming");
        System.out.println(sb2);
        stringImmutable();
    }
    public static void stringImmutable(){
        String s = "Sachin";

        // concat() method appends the string at the end
        String result = s.concat(" Tendulkar");

        // This will print Sachin because strings are immutable objects
        System.out.println(s);
        System.out.println(result);
    }
    public static void javaRegEx(){
        /*Common Regex Patterns in Java
                . : Any character
                \d : Digit [0-9]
                \D : Non-digit
                \s : Whitespace
                \S : Non-whitespace
                \w : Word character [a-zA-Z0-9_]
                \W : Non-word character
                \b : Word boundary
                \B : Non-word boundary*/
        System.out.println( Pattern.matches("[a-zA-Z]+", "GfgTest"));
    }

    public static void javaCollection(){
        List<String> myArrayList = new ArrayList<>();
        myArrayList.add("Rupesh");
        myArrayList.add("Kapgate");
        for(String str : myArrayList){
            System.out.println(str);
        }

        Iterator<String> iterator = myArrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
