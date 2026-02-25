public class JavaOOPInterfaces {
    public static void main(String[] args) {
        MyExtendClass classExtensionDemo = new MyExtendClass();
        classExtensionDemo.display();
        System.out.println(classExtensionDemo.myNumber);
    }
}
interface myfirstInterface{
    int myNumber = 10;
    void display();
}
class MyExtendClass implements myfirstInterface{

    public void display(){
        System.out.println("hello");
    }
}
