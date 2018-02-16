package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artwork;

/**
 * Servlet implementation class addArtServlet
 */
@WebServlet("/addArtServlet")
public class addArtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addArtServlet() {
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String artist = request.getParameter("artist");
		String media = request.getParameter("media");
		String year = request.getParameter("year");
		double value = Double.valueOf(request.getParameter("value"));
			
		Artwork  aw = new Artwork(title, artist, media, year, value);
		ArtworkHelper dao = new ArtworkHelper();
		dao.insertArtwork(aw);
		
		getServletContext().getRequestDispatcher("/addArt.html").forward(request, response);
		
	}
}


