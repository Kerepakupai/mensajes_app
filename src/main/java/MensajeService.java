import java.util.Scanner;

public class MensajeService {

    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe tu mensaje");
        String texto = sc.nextLine();

        System.out.println("Escribe tu nombre");
        String autorMensaje = sc.nextLine();

        Mensaje mensaje = new Mensaje();
        mensaje.setMensaje(texto);
        mensaje.setAutorMensaje(autorMensaje);
        MensajeDAO.crearMensajeDB(mensaje);
    }

    public static void listarMensajes() {
        MensajeDAO.leerMensajeDB();
    }

    public static void borrarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el Id del mensaje a borrar");
        int idMensaje = sc.nextInt();
        MensajeDAO.borrarMensajeDB(idMensaje);
    }

    public static void editarMensaje() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el nuevo mensaje");
        String texto = sc.nextLine();

        System.out.println("Indica el Id del mensaje que quieres modificar");
        int idMensaje = sc.nextInt();

        Mensaje mensaje = new Mensaje();
        mensaje.setIdMensaje(idMensaje);
        mensaje.setMensaje(texto);

        MensajeDAO.actualizarMensajeDB(mensaje);
    }

}
