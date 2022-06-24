package arbolBinario2;

public class arbolBinario {
    
    protected node root;

    public arbolBinario(){
        root = null;
    }

    public arbolBinario(Object fact){
        this.root = new node(fact);
    }

    //methods
    public node findNode(Object fact){
        node current = root;
        int nodedata = Integer.parseInt((String.valueOf(fact)));

        while(current != null){

            if(nodedata<Integer.parseInt((current.fact.toString()))){
                current = current.leftBranch;
            }else if(nodedata>Integer.parseInt((current.fact.toString()))){
                current = current.rightBranch;
            }else if(Integer.parseInt(current.toString())==nodedata){
                return current;
            }

        }
        return null;
    }

    public void insert(node leftAux){

        node current = root;
        node previus = new node(null);
        int nodedata = Integer.parseInt((leftAux.fact.toString()));

        while(current != null){
            previus = current;
            if(nodedata<Integer.parseInt((current.fact.toString()))){
                current = current.leftSubtree();
            }else if(nodedata>Integer.parseInt((current.fact.toString()))){
                current = current.rightSubtree();
            }else{
                System.out.println("\n Lo ingresado ya pertenece al arbol");
            }
        }
        if(nodedata>Integer.parseInt((previus.fact.toString()))){
            previus.rightBranch = leftAux;
        }else if(nodedata<Integer.parseInt((previus.fact.toString()))){
            previus.leftBranch = leftAux;
        }else {
            System.out.println("\n Lo ingresado ya pertenece al arbol");
        }

    }

    public void remove(Object fact){
        node rem = findNode(fact);

        if(rem.leftSubtree() != null){
            node leftAux = rem.leftSubtree();
            insert(leftAux);
        }else if(rem.rightSubtree() != null){
            node rightAux = rem.rightSubtree();
            insert(rightAux);
        }
        System.out.println("\n El nodo seleccionado se ha eliminado correctamente ");
    }

    ///tours
    public static void preOrden(node Node){
        System.out.println("\n ["+String.valueOf(Node)+"] ");

        if(Node.leftSubtree() != null){
            preOrden(Node.leftSubtree());
        }
        if(Node.rightSubtree() != null){
            preOrden(Node.rightSubtree());
        }
    }

    public static void inOrden(node Node){

        if(Node.leftSubtree() != null){
            inOrden(Node.leftSubtree());
        }
        System.out.println(" ["+String.valueOf(Node)+"] ");
        if(Node.rightSubtree() != null){
            inOrden(Node.rightSubtree());
        }
    }

    public static void postOrden(node Node){
        if(Node.leftSubtree() != null){
            postOrden(Node.leftSubtree());
        }
        if(Node.rightSubtree() != null){
            postOrden(Node.rightSubtree());
        }
        System.out.println(" ["+String.valueOf(Node)+"] ");
    }

    private node Search (Object f, node r){

        if(root==null){
            return null;
        }else if(r.fact == f){
            return r;
        }else if(r.fact < f){
            return Search(f, r.rightBranch);
        }else{
            return Search(f, r.leftBranch);
        }

    }

    public int getBalanceFactor(node z){
        if (z == null) {
            return -1;
        }else{
            return z.balanceFactor;
        }
    }

    //rotations and fe

    public node rotationLeft(node n){
        node aux = n.leftBranch;
        n.leftBranch = aux.leftBranch;
        aux.rightBranch = n;
        n.balanceFactor = Math.max(getBalanceFactor(n.leftBranch), getBalanceFactor(n.rightBranch)) + 1;
        aux.balanceFactor = Math.max(getBalanceFactor(aux.leftBranch), getBalanceFactor(aux.rightBranch)) + 1;
        return aux;
    }

       
    public node rotationRight(node n){
        node aux=  n.rightBranch;
        n.rightBranch = aux.leftBranch;
        aux.leftBranch = n;
        n.balanceFactor = Math.max(getBalanceFactor(n.leftBranch), getBalanceFactor(n.rightBranch)) + 1;
        aux.balanceFactor = Math.max(getBalanceFactor(aux.leftBranch), getBalanceFactor(aux.rightBranch)) + 1;
        return aux;
    }

    public node doubleRotationLeft(node n){
        node aux;
        n.leftBranch = rotationRight(n.rightBranch);
        aux = rotationLeft(n);
        return aux;
    }
   
    public node doubleRotationRight(node n){
        node aux;
        n.rightBranch = rotationLeft(n.leftBranch);
        aux = rotationRight(n);
        return aux;
    }
  
    public node insertOrdened(node neww, node subtree){
            node newFather = subtree;
        if(neww.fact<subtree.neww){
            if(subtree.leftBranch==null){
                subtree.leftBranch=neww;
            }else{
                subtree.leftBranch=insertOrdened(neww,subtree.leftBranch);
                if(getBalanceFactor(subtree.leftBranch)-getBalanceFactor(subtree.rightBranch)==2){
                    if(neww.fact < subtree.leftBranch.fact){
                        newFather=rotationLeft(subtree);
                    }else{
                        newFather=doubleRotationLeft(subtree);
                    }
                }
            }
        }else if(neww.fact > subtree.fact){
            if(subtree.rightBranch==null){
                subtree.rightBranch=neww;
            }else{
                subtree.rightBranch=insertOrdened(neww,subtree.rightBranch);
                if(getBalanceFactor(subtree.rightBranch)-getBalanceFactor(subtree.rightBranch)==2){
                    if(neww.fact < subtree.rightBranch.fact){
                        newFather=rotationRight(subtree);
                    }else{
                        newFather=doubleRotationRight(subtree);
                    }
                }
            }
        }else{
        System.out.println("se repite el nodo que ha ingresado");
        }

        if((subtree.leftBranch==null && subtree.rightBranch!=null)){

            subtree.balanceFactor=subtree.rightBranch.balanceFactor+1;

        }else if(subtree.rightBranch==null && subtree.leftBranch!=null){

            subtree.balanceFactor=subtree.leftBranch.balanceFactor+1;

        }else{

            subtree.balanceFactor=Math.max(getBalanceFactor(subtree.leftBranch), getBalanceFactor(subtree.rightBranch))+1;

        }
        return newFather;
      }
}
