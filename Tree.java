package Arbol;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root, value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(), value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(), value);
            }
        }
    }
    //FUNCIONES O(1)
    public Integer getRoot(){
        return this.root.getValue();
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    //BUSCQUEDA
    public boolean hasElement(Integer el){
        if(this.root == null){
            return false;
        }

        if(this.root.getValue() == el){
            return true;
        }

        return hasElement(this.root, el);
    }

    private boolean hasElement(TreeNode nodo, Integer el){
        if(nodo.getValue() > el){
            if(nodo.getLeft() == null){
                return false;
            }
            return hasElement(nodo.getLeft(), el);
        }else if(nodo.getValue() < el){
            if(nodo.getRight() == null){
                return false;
            }
            return hasElement(nodo.getRight(), el);
        }
        return false;
    }

    //ALTURA
    public Integer getHeight(){
        if(this.root == null){
            return 0;
        }
        return getHeight(root);
    }

    private Integer getHeight(TreeNode nodo){
        if(nodo == null){
            return 0;
        }
        Integer r = getHeight(nodo.getRight());
        Integer l = getHeight(nodo.getLeft());
        if(l >= r ){
            return l +1;
        }
        return r + 1;
    }

    //MAXIMO ELEMENTO
    public Integer getMaxElement(){
        if(this.root == null){
            return 0;
        }
        if(this.root.getLeft() == null && this.root.getRight() == null){
            return this.root.getValue();
        }

        return getMaxElement(this.root);
    }

    private Integer getMaxElement(TreeNode nodo){
        if(nodo.getRight() == null){
            return nodo.getValue();
        }
        if(nodo.getValue() < nodo.getRight().getValue()){
            return getMaxElement(nodo.getRight());
        }
        return nodo.getValue();
    }

    //PREORDEN
    public void imprimirPreOrden(){
        imprimirPreOrden(this.root);
    }
    private void imprimirPreOrden(TreeNode nodo) {
        if (nodo == null){
            return;
        }
        System.out.print(nodo.getValue() + " ");
        if(nodo.getLeft() == null){
            System.out.print("-");
        }else{
        imprimirPreOrden(nodo.getLeft());
        }
        if(nodo.getRight() == null){
            System.out.print("-");
        }else{
            imprimirPreOrden(nodo.getRight());
        }
        
    }

    //ORDEN
    public void imprimirEnOrden(){
        imprimirEnOrden(this.root);
    }
    private void imprimirEnOrden(TreeNode nodo) {
        if (nodo == null)
            return;
        imprimirEnOrden(nodo.getLeft());
        System.out.print(nodo.getValue() + " ");
        imprimirEnOrden(nodo.getRight());
    }

    //POSTORDEN
    public void imprimirPosOrden(){
        imprimirPosOrden(this.root);
    }
    private void imprimirPosOrden(TreeNode nodo) {
        if (nodo == null)
            return;
        imprimirPosOrden(nodo.getLeft());
        imprimirPosOrden(nodo.getRight());
        System.out.print(nodo.getValue() + " ");
    }
}
