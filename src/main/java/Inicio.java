import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        do {
            System.out.println("-----------------------------------------------------");
            System.out.println("              Aplicacion de mensajes");
            System.out.println("-----------------------------------------------------");
            System.out.println("              1. crear mensaje");
            System.out.println("              2. listar mensaje");
            System.out.println("              3. editar mensaje");
            System.out.println("              4. eliminar mensaje");
            System.out.println("              5. salir");
            System.out.println("*****************************************************");
            // Leer opcion del usuario

            switch (opcion) {
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensajes();
                    break;
                case 3:
                    MensajeService.editarMensaje();
                    break;
                case 4:
                    MensajeService.borrarMensaje();
                    break;
                default:
                    break;
            }
        } while (opcion != 5);
    }
}
