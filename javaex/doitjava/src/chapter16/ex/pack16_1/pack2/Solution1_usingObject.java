package chapter16.ex.pack16_1.pack2;

class Apple{}
class Pencil{}
class Goods {
    private Object object = new Object();

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
public class Solution1_usingObject {
    public static void main(String[] args) {
        Goods goods1 = new Goods();
        goods1.setObject(new Apple());
        Apple apple = (Apple) goods1.getObject();

        Goods goods2 = new Goods();
        goods2.setObject(new Pencil());
        Pencil pencil = (Pencil) goods2.getObject();

        Goods goods3 = new Goods();
        goods3.setObject(new Apple());
        Pencil pencil2 = (Pencil) goods3.getObject();
    }
}
