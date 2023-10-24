    package model.data;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import org.jooq.DSLContext;
    import org.jooq.SQLDialect;
    import org.jooq.impl.DSL;

    public final class DBConnector {
        private static final String URL = "jdbc:mysql://localhost:3306/";
        private static final DBConnector INSTANCE = new DBConnector();
        private static Connection connection = null;

        public static DBConnector getInstance() {
            return INSTANCE;
        }

        public static Connection connection(String username, String password) {
            try {
                if (connection == null || connection.isClosed()) {
                    connection = doConnection("", username, password);
                }
            } catch (SQLException e) {
                System.err.println("Error al comprobar si está cerrada la conexión: ");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return connection;
        }

        public static Connection connection(String db, String username, String password) {
            try {
                if (connection == null || connection.isClosed()) {
                    connection = doConnection(db, username, password);
                }
            } catch (SQLException e) {
                System.err.println("Error al comprobar si está cerrada la conexión: ");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return connection;
        }

        public static void closeConnection() {
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Conexión cerrada.");
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: ");
                e.printStackTrace();
            }
        }

        private static Connection doConnection(String db, String username, String password) {
            Connection conn;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL + db, username, password);
            } catch (SQLException | ClassNotFoundException e) {
                System.err.println("Error al crear la conexión: ");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.println("Conexion creada : " + conn);
            return conn;
        }

        public static void main(String[] args) {
            String nombreBD = "BD";


            try (Connection connection = DBConnector.connection(nombreBD, "root", "")) {
                DSLContext create = DSL.using(connection, SQLDialect.MYSQL);
                String version = create.select(DSL.field("version()")).fetchOne(0, String.class);
                System.out.println("La versión de MySQL es: " + version);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

