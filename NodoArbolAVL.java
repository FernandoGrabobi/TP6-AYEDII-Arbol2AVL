package ArbolAVL;
public class NodoArbolAVL {

    int fact;
    int balanceFactor;
    NodoArbolAVL leftSon, rightSon;
  
    public NodoArbolAVL(int d) {
      this.fact = d;
      this.balanceFactor = 0;
      this.leftSon = null;
      this.rightSon = null;
    }
    
}
