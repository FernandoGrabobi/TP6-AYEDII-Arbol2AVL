package ArbolAVL;
import java.io.*;

public class Test {
    ArbolAVL arbolAVL= new ArbolAVL();

    public void caputeData() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int fact;
        System.out.print("Ingresa el numero: ");
        try {

            fact = Integer.parseInt(input.readLine());
            arbolAVL.insert(fact);
            System.out.println();
            System.out.println("Nodo "+fact+" agregado...");

        } catch (Exception e) {
            System.out.println("Error: "+ e );
        }
    }
  
    public void imprimir() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int d;
    
        System.out.println("Ingrese una opcion:");
        System.out.println(" (1) InOrden");
        System.out.println(" (2) PreOrden");
        System.out.println(" (3) PostOrden");
        try {
        d = Integer.parseInt(input.readLine());
        switch(d) {
            case 1:
                if(!arbolAVL.itIsEmpty()){

                    System.out.println("!! Recorrido InOrden");
                    arbolAVL.inOrden(arbolAVL.getRoot());

                }else {
                    System.out.println("--- El arbol esta vacio ---");
                }
            break;
            case 2:
                if(!arbolAVL.itIsEmpty()) {

                    System.out.println("Arbol en PreOrden");
                    arbolAVL.preorden(arbolAVL.getRoot());

                } else {
                    System.out.println("--- El arbol esta vacio ---");
                }
            break;
            case 3:
                if(!arbolAVL.itIsEmpty()) {

                    System.out.println("Arbol en PostOrden");
                    arbolAVL.postOrden(arbolAVL.getRoot());

                } else {
                    System.out.println("--- El arbol esta vacio ---");
                }
            break;
        }
        } catch (Exception e) {
        System.out.println("Error: "+ e );
        }
    
    }
}
