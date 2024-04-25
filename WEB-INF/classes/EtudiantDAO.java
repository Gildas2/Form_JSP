import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class EtudiantDAO {

    public int ajouterEtudiant(Etudiant etudiant) throws ClassNotFoundException {
        String INSERT_ETUDIANT_SQL = "INSERT INTO etudiants" +
            "  (nom, prenom, date_naissance, email, telephone) VALUES " +
            " (?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ETUDIANT_SQL)) {
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setDate(3, etudiant.getDateNaissance());
            preparedStatement.setString(4, etudiant.getEmail());
            preparedStatement.setString(5, etudiant.getTelephone());

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
           System.err.println("L'etudiant n'est pas bien enregistree");
           System.err.println(e.getMessage());
        }
        return result;
    }

    public List<Etudiant> listerEtudiants() throws ClassNotFoundException {
        String SELECT_ETUDIANTS_SQL = "SELECT * FROM etudiants;";
        List<Etudiant> etudiants = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ETUDIANTS_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                Date dateNaissance = rs.getDate("date_naissance");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");

                Etudiant etudiant = new Etudiant(nom, prenom, dateNaissance, email, telephone);
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return etudiants;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("com.mysql.jdbc.Driver", "root", "");
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
