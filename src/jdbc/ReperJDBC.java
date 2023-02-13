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
	
	public void dropTable(String name) {
		try {
			con.createStatement().execute(String.format("DROP TABLE %s", name));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createTable(String tableName, ArrayList<Song> songs) {
		String sql = String.format("CREATE TABLE %s LIKE all_songs", tableName);
		String sql2 = String.format("INSERT INTO %s (nome, artista, tom, duracao) VALUES ", tableName);
		for(int i=0; i<songs.size(); i++) {
			String name = songs.get(i).getName().replace("'", "");
			String artist = songs.get(i).getArtist().replace("'", "");
			String sqlValue = String.format("('%s', '%s', '%s', '%d')", name, artist, songs.get(i).getTone(), songs.get(i).getLength());
			if(i == songs.size()-1) {
				sql2 += sqlValue + ";";
			}else {
				sql2 += sqlValue + ", ";
			}
		}
		try {
			con.createStatement().execute(sql);
			con.createStatement().execute(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getSets(){
		ArrayList<String> sets = new ArrayList<String>();
		String sql = "SHOW TABLES";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				sets.add(rs.getString(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return sets;
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
	
	public ArrayList<Song> getSetSongs(String set) {
		ArrayList<Song> songs = new ArrayList<Song>();
		String sql = "SELECT * FROM "+set;
		
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
	
	public ArrayList<Song> getAllSongs(String orderBy) {
		ArrayList<Song> songs = new ArrayList<Song>();
		String sql = "SELECT * FROM all_songs ORDER BY "+orderBy;
		
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
