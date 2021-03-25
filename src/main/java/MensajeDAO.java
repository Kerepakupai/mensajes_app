import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDAO {
    public static void  crearMensajeDB(Mensaje mensaje) {
        Conexion db = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection conn = db.get_connection()) {
            try {
                String query = "INSERT INTO `mensajes` (mensaje, autor_mensaje) VALUES (?, ?)";
                ps = conn.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado satisfactoriamente");
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    public static void leerMensajeDB() {
        Conexion db = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection conn = db.get_connection()) {
            try {
                String query = "SELECT * FROM mensajes";
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();

                while(rs.next()) {
                    System.out.println("-----------------------------------------------------");
                    System.out.println("ID: " + rs.getInt("id_mensaje"));
                    System.out.println("Mensaje: " + rs.getString("mensaje"));
                    System.out.println("Autor: " + rs.getString("autor_mensaje"));
                    System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                    System.out.println("-----------------------------------------------------");
                }
            } catch (SQLException e) {
                System.out.println("No se pudieron reqcuperar los mensajes");
                System.out.println(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void borrarMensajeDB(int idMensaje) {
        Conexion db = new Conexion();
        PreparedStatement ps = null;

        try(Connection conn = db.get_connection()) {
            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, idMensaje);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado");
            } catch (SQLException e) {
                System.out.println("No se pudo borrar el mensaje");
                System.out.println(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void actualizarMensajeDB(Mensaje mensaje) {
        Conexion db = new Conexion();
        PreparedStatement ps = null;

        try(Connection conn = db.get_connection()) {
            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conn.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getIdMensaje());

                ps.executeUpdate();
                System.out.println("El mensaje ha sido actualizado");
            } catch (SQLException e) {
                System.out.println("No se pudo actualizar el mensaje");
                System.out.println(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
