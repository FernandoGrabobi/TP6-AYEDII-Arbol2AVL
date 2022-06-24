package arbolBinario2;
import java.util.Scanner;

public class menu {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        arbolBinario tree = new arbolBinario();
        int menuOptions = 69;
        int nodeCounter = 0;
        int newNode = 69;
        
       
        do {
            try {
                System.out.println("Presione 1 para Insertar un nodox \n");
                System.out.println("Presione 2 para Eliminar un nodox \n");
                System.out.println("Presione 3 para Mostrar el arbol en PREORDEN \n");
                System.out.println("Presione 4 para recorrer el arbol en preOrden, inOrden y postOrden \n");
                System.out.println("Presione 0 para salir del programa \n");
                menuOptions = input.nextInt();
                input.nextLine();

            } catch (Exception e) {
                clearScreen();
                System.out.println("Ingreso un valor no valido\n");
            }

            switch (menuOptions) {
                case 1:
                    clearScreen();
                    try {
                        if(nodeCounter == 0){

                            String worth;
                            System.out.println("\n ingrese el valor correspondiente al nodo raiz ");
                            worth = input.nextLine();
                            tree = new arbolBinario(worth);
                            nodeCounter++;

                        }else{
                            do {
                                String worth;
                                System.out.println("\n Ingrese valor al nuevo nodo");
                                worth = input.nextLine();
                                node Node = new node(worth);
                                tree.insert(Node);
                            } while ( newNode != 0);
                        }
                    } catch (Exception e) {
                        System.out.println("Ingreso un valor no valido\n");
                    }
                break;
                case 2:
                    clearScreen();
                    try {
                        String worth;
                        System.out.println("\n Ingrese el valor del nodo que desea eliminar");
                        worth = input.nextLine();
                        tree.remove(worth);
                    } catch (Exception e) {
                        System.out.println("Ingreso un valor no valido\n");
                    }
                break;
                case 3:
                    clearScreen();
                    try {
                        arbolBinario.preOrden(tree.root);
                        System.out.println("\n ");
                    } catch (Exception e) {
                        System.out.println("Ingreso un valor no valido\n");
                    }
                break;
                case 4:
                    clearScreen();
                    try {
                        System.out.println("\n  Recorrido en inOrden: \n");
                        arbolBinario.inOrden(tree.root);
                        System.out.println("\n  Recorrido en preOrden: \n");
                        arbolBinario.preOrden(tree.root);
                        System.out.println("\n  Recorrido en postOrden: \n");
                        arbolBinario.postOrden(tree.root);
                    } catch (Exception e) {
                        System.out.println("Ingreso un valor no valido\n");
                    }
                break;
                case 0:
                    clearScreen();
                    System.out.println(" El programa a finalizado correctamente ");
                break;
                default:
                    clearScreen();
                    System.out.println(" \n Ingrese una opcion valida ");
                break;

            }

        } while (menuOptions != 0);

        input.close();
    }

}
