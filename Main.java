package ArbolAVL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) {
     /// prueba clase = new prueba();
      int answers = 0;
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      
      do {
        System.out.println("Ingrese una opcion: \n1)Ingresar \n2)Imprimir \n3)Salir");
        try {
          answers = Integer.parseInt(input.readLine());
          switch(answers) {
            case 1:
              ///clase.capturar();
              break;
            case 2:
              ///clase.imprimir();
              break;
            case 3:
              break;
            case 4:
              break;
            default:
              System.out.println("Opcion incorrecta");
          }
        } catch (Exception e) {
          System.out.println("Error: "+ e );
        }
      } while (answers != 0);
    }
  }
