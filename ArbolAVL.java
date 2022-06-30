package ArbolAVL;
public class ArbolAVL {

    private NodoArbolAVL root;
    
    public ArbolAVL() {
        this.root = null;
    }
  
    public NodoArbolAVL getRoot(){
        return root;
    }
    
    //buscar
    public NodoArbolAVL search(int d, NodoArbolAVL node) {

        if (node == null) {
            return null;
        } else if (node.fact == d) {
            return node;
        } else if (node.fact < d) {
            return search(d, node.rightSon);
        } else {
            return search(d, node.leftSon);
        }

    }
  
    //obtener factor de equilibrio
    public int getBF (NodoArbolAVL node) {

        if (node==null) {
            return -1;
        } else {
            return node.balanceFactor;
        }

    }
  
    //rotacion simple a la izquierda
    public NodoArbolAVL leftRotation(NodoArbolAVL node) {

        NodoArbolAVL assistant = node.leftSon;
        node.leftSon = assistant.rightSon;
        assistant.rightSon = node;
        node.balanceFactor = Math.max(getBF(node.leftSon), getBF(node.rightSon)) + 1;  //obtiene el maximo
        assistant.balanceFactor = Math.max(getBF(assistant.leftSon), getBF(assistant.rightSon)) + 1;
        return assistant;

    }
  
    //rotacion simple derecha
    public NodoArbolAVL rightRotation(NodoArbolAVL node) {

        NodoArbolAVL assistant = node.rightSon;
        node.rightSon = assistant.leftSon;
        assistant.leftSon = node;
        node.balanceFactor = Math.max(getBF(node.leftSon), getBF(node.rightSon)) + 1;  //obtiene el maximo
        assistant.balanceFactor = Math.max(getBF(assistant.leftSon), getBF(assistant.rightSon)) + 1;
        return assistant;

    }
  
    //rotacion doble a la der
    public NodoArbolAVL leftDoubleRotatiion(NodoArbolAVL node) {

        NodoArbolAVL temporary;
        node.leftSon = rightRotation(node.leftSon);
        temporary = leftRotation(node);
        return temporary;

    }
    
    //rotacion doble a la izq
    public NodoArbolAVL rightDoubleRotation(NodoArbolAVL node) {

        NodoArbolAVL temporary;
        node.rightSon = leftRotation(node.rightSon);
        temporary = rightRotation(node);
        return temporary;

    }
  
    //insertar avl
    public NodoArbolAVL insertAVL(NodoArbolAVL newNode, NodoArbolAVL subTree) {

        NodoArbolAVL newFather=subTree;

        if (newNode.fact < subTree.fact) {

            if(subTree.leftSon==null){

                subTree.leftSon=newNode;

            } else {

                subTree.leftSon=insertAVL(newNode, subTree.leftSon);

                if((getBF(subTree.leftSon) - getBF(subTree.rightSon) == 2)) {

                    if(newNode.fact<subTree.leftSon.fact){

                        newFather=leftRotation(subTree);

                    } else {

                        newFather=leftDoubleRotatiion(subTree);

                    }
                }
            }

        } else if (newNode.fact > subTree.fact) {

            if (subTree.rightSon == null ){

                subTree.rightSon = newNode;
                
            } else {

                subTree.rightSon = insertAVL(newNode, subTree.rightSon);

                if((getBF(subTree.rightSon) - getBF(subTree.leftSon) == 2)) {

                    if(newNode.fact>subTree.rightSon.fact){

                        newFather=rightRotation(subTree);

                    } else {

                        newFather=rightDoubleRotation(subTree);

                    }
                }
            }
        } else {
            System.out.println("Nodo duplicado");
        }
    
        //actualizar altura
        if((subTree.leftSon == null) && (subTree.rightSon != null )) {
            
            subTree.balanceFactor = subTree.rightSon.balanceFactor + 1;

        } else if ((subTree.rightSon == null) && (subTree.leftSon != null)) {

            subTree.balanceFactor = subTree.leftSon.balanceFactor+1;

        } else {

            subTree.balanceFactor = Math.max(getBF(subTree.leftSon), getBF(subTree.rightSon))+1;
        }
        return newFather;
    }
  
  
    //insertar normal
    public void insert(int d) {

        NodoArbolAVL newNode = new NodoArbolAVL(d);

        if(root == null) {

            root = newNode;

        } else {

            root= insertAVL(newNode, root);
        }
    }
  
    //recorridos
    //recorrer en preorden
    public void preorden(NodoArbolAVL node){

        if(node!=null){

            System.out.println(node.fact);
            preorden(node.leftSon);
            preorden(node.rightSon);
        }
    }
    //recorrer in orden
    public void inOrden(NodoArbolAVL node) {

        if(node != null) {

            inOrden(node.leftSon);
            System.out.println(node.fact);
            inOrden(node.rightSon);
        } 
    }
    //recorrer postorden
    public void postOrden(NodoArbolAVL node) {

        if(node != null) {

            postOrden(node.leftSon);
            postOrden(node.rightSon);
            System.out.println(node.fact);
        }
    }
  
    public boolean itIsEmpty() {
        return root == null;
    }
}
