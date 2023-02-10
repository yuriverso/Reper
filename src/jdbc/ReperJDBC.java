package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReperJDBC {
	
	private Connection con;

	public ReperJDBC(Connection con){
		this.con = con;
	}
	
	public void removeSong(int id) {
		String sql = String.format("DELETE FROM all_songs WHERE id = %d;", id);
		try {
			con.createStatement().execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editSong(Song song) {
		int id = song.getId();
		String name = song.getName();
		String artist = song.getArtist();
		String tone = song.getTone();
		int length = song.getLength();
		String sql = String.format("UPDATE all_songs SET nome = '%s', artista = '%s', tom = '%s', duracao = '%d' WHERE id = '%d'",
									name, artist, tone, length, id);
		System.out.println(sql);
		try {
			con.createStatement().execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertSong(Song song) {
		String sql = "INSERT INTO all_songs(nome, artista, tom, duracao) VALUES (?,?,?,?);";
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, song.getName());
			ps.setString(2, song.getArtist());
			ps.setString(3, song.getTone());
			ps.setInt(4, song.getLength());
			ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Song> getAllSongs() {
		ArrayList<Song> songs = new ArrayList<Song>();
		String sql = "SELECT * FROM all_songs";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String name = rs.getString("nome");
				String artist = rs.getString("artista");
				String tone = rs.getString("tom");
				int length = rs.getInt("duracao");
				
				songs.add(new Song(id, name, artist, tone, length));
			}
		}catch(SQLException e) {
			e.printStackTrace();;
		}
		
		return songs;
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	
}
