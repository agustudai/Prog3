package Arbol;

public class Main {

    public static void main(String[] args) {
        Tree arbol = new Tree();

        arbol.add(4);
        arbol.add(2);
        arbol.add(8);
        arbol.add(1);
        arbol.add(3);
        arbol.add(9);
        arbol.add(10);
        arbol.imprimirPreOrden();
        System.out.println(" ");
        arbol.imprimirEnOrden();
        System.out.println(" ");
        System.out.println("RAIZ: ");
        System.out.println(arbol.getRoot());
        System.out.println("TIENE ELEENTO: ");
        System.out.println(arbol.hasElement(1));
        System.out.println("ALTURA");
        System.out.println(arbol.getHeight());

        //System.out.println(arbol.getMaxElement());
    }
}
