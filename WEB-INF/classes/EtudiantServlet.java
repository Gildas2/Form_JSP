import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class EtudiantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EtudiantDAO etudiantDAO;

    public void init() {
        etudiantDAO = new EtudiantDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String dn = request.getParameter("date_naissance");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date dateNaissance = null;
        try {   
            dateNaissance = new Date (formatter.parse(dn).getTime());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Etudiant etudiant = new Etudiant(nom, prenom, dateNaissance, email, telephone);

        int result = 0;
        String msg = "Etudiant ajouté avec succès";
        try {
            result = etudiantDAO.ajouterEtudiant(etudiant);
            if(result == 0){
                msg = "Etudiant n'a pas ete ajouté";
            }
        } catch (Exception e) {
           msg = e.getMessage();
           System.err.println(e.getMessage());
        }

        request.setAttribute("msg", msg);
        request.setAttribute("result", result);
        request.getRequestDispatcher("etudiantdetails.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Etudiant> etudiants;
        try {
            etudiants = etudiantDAO.listerEtudiants();
            request.setAttribute("etudiants", etudiants);
            request.getRequestDispatcher("etudiantlist.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
