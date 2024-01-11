package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Dao;
import dto.Movie;

@WebServlet("/updatemovie")
@MultipartConfig(maxFileSize =10*1024*1024)
public class UpdateMovie extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("mid"));
		String name = req.getParameter("mname");
		double price = Double.parseDouble(req.getParameter("mprice"));
		double rating = Double.parseDouble(req.getParameter("mrating"));
		String genre = req.getParameter("mgenre");
		String language = req.getParameter("mlanguage");
		Part image = req.getPart("mimage");
		
		Movie movie = new Movie();
		movie.setMovieid(id);
		movie.setMoviename(name);
		movie.setMovieprice(price);
		movie.setMovierating(rating);
		movie.setMoviegenre(genre);
		movie.setMovielanguage(language);
		movie.setMovieimage(image.getInputStream().readAllBytes());
				
		Dao dao1 = new Dao();
		
		try {
			if(image.getSize()>0) {
			dao1.updateMovie(movie);
			req.setAttribute("movies", dao1.getAllMovie());

			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

	
	}


