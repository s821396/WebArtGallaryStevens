package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artwork;


/**
 * Servlet implementation class editArtServlet
 */
@WebServlet("/editArtServlet")
public class editArtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editArtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArtworkHelper dao = new ArtworkHelper();
		String act = request.getParameter("doThisToArt");
		
		if (act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/viewAllArtServlet").forward(request,response);
		}else if (act.equals("Delete Selected Art")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			System.out.println("This is tempid = " + tempId);
			Artwork artToDelete = dao.searchForArtById(tempId);
			System.out.println(artToDelete.toString());
			dao.deleteArt(artToDelete);
			
			getServletContext().getRequestDispatcher("/viewAllArtServlet").forward(request, response);
		}else if (act.equals("Edit Selected Art")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Artwork artToEdit = dao.searchForArtById(tempId);
			request.setAttribute("artToEdit", artToEdit);
			getServletContext().getRequestDispatcher("/edit-art.jsp").forward(request, response);
			
		}else if (act.equals("Add New Art")) {
			getServletContext().getRequestDispatcher("/addArt.html").forward(request, response);
		}
	}

	}

