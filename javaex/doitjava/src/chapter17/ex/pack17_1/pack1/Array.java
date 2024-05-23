package chapter17.ex.pack17_1.pack1;

public class Array {
    public static void main(String[] args) {
        String[] array = new String[] {"가","나","다","라","마","바","사"};
        array[2] = null;
        array[5] = null;
        System.out.println(array.length);
    }
}

