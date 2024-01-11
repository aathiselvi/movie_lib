package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.BYTE_ARRAY;
import javax.sql.rowset.serial.SerialBlob;

import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.protocol.Resultset;

import dto.Admin;
import dto.Movie;

public class Dao {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbproject","root","root");
		
	}
	public int saveAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("insert into admin values(?,?,?,?,?)");
		pst.setInt(1, admin.getAdminid());
		pst.setString(2, admin.getAdminname());
		pst.setLong(3, admin.getAdmincontact());
		pst.setString(4, admin.getAdminmail());
		pst.setString(5, admin.getAdminpassword());
		return pst.executeUpdate();	
	}
	
	public int saveUser(User user) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("insert into User values ?,?,?,?,?");
		pst.setInt(1, user.getId());
		pst.setString(2, user.getName());
		pst.setLong(3, user.getContact());
		pst.setString(4, user.getMail());
		pst.setString(5, user.getPassword());
		return pst.executeUpdate();	
	}
	
	public Admin findByMail (String adminmail) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from admin where adminmail=?");
		pst.setString(1, adminmail);
		ResultSet rs = pst.executeQuery();
		rs.next();
		Admin admin = new Admin();
		admin.setAdminid(rs.getInt(1));
		admin.setAdminname(rs.getString(2));
		admin.setAdmincontact(rs.getLong(3));
		admin.setAdminmail(rs.getString(4));
		admin.setAdminpassword(rs.getString(5));
		return admin;
}
	public int saveMovie(Movie movie) throws SQLException, ClassNotFoundException {
		Connection conn = getConnection();
		PreparedStatement pst= conn.prepareStatement("insert into movie values (?,?,?,?,?,?,?)");
		pst.setInt(1, movie.getMovieid());
		pst.setString(2, movie.getMoviename());
		pst.setDouble(3, movie.getMovieprice());
		pst.setDouble(4, movie.getMovierating());
		pst.setString(5, movie.getMoviegenre());
		pst.setString(6, movie.getMovielanguage());
		java.sql.Blob imageBlob = new SerialBlob(movie.getMovieimage());
		pst.setBlob(7, imageBlob);
		return pst.executeUpdate();
	}
	
	public List<Movie> getAllMovie() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from movie");
		ResultSet rs = pst.executeQuery();	
		List<Movie> movie = new ArrayList<Movie>();
		
		while (rs.next()) {
			Movie m1 = new Movie();
			m1.setMovieid(rs.getInt(1));
			m1.setMoviename(rs.getString(2));
			m1.setMovieprice(rs.getDouble(3));
			m1.setMovierating(rs.getDouble(4));
			m1.setMoviegenre(rs.getString(5));
			m1.setMovielanguage(rs.getString(6));
			
			java.sql.Blob b =rs.getBlob(7);
			byte[] image = b.getBytes(1, (int) b.length());
			m1.setMovieimage(image);
			
			movie.add(m1);
					}
		return movie;
		
	}
	
	public int deleteMovie(int id) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("delete from movie where movieid = (?)");
		pst.setInt(1, id);
		return pst.executeUpdate();
		
	}
	
	public Movie findMovieById (int id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from movie where movieid = (?)");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		rs.next();
		Movie m = new Movie();
		m.setMovieid(rs.getInt(1));
		m.setMoviename(rs.getString(2));
		m.setMovieprice(rs.getDouble(3));
		m.setMovierating(rs.getDouble(4));
		m.setMoviegenre(rs.getString(5));
		m.setMovielanguage(rs.getString(6));
		
		java.sql.Blob b =rs.getBlob(7);
		byte[] image = b.getBytes(1, (int) b.length());
		m.setMovieimage(image);
		return m;
		
	}
	
	public int updateMovie(Movie movie) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("update movie set moviename=?, movieprice=?, movierating=?, moviegenre=?, movielanguage=?,movieimage=? where movieid=?");
		
		pst.setInt(7, movie.getMovieid());
		pst.setString(1, movie.getMoviename());
		pst.setDouble(2, movie.getMovieprice());
		pst.setDouble(3, movie.getMovierating());
		pst.setString(4, movie.getMoviegenre());
		pst.setString(5, movie.getMovielanguage());
		java.sql.Blob imageBlob = new SerialBlob(movie.getMovieimage());
		pst.setBlob(6, imageBlob);
		
		return pst.executeUpdate();
	
		
	}
	
	
	
	
}
