package jdbc;

public class Song {
	
	private int id;
	private String name;
	private String artist;
	private String tone;
	private int length;
	private int idx;
	
	public Song() {}
	
	public Song(int id, String name, String artist, String tone, int length) {
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.tone = tone;
		this.length = length;
	}
	
	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTone() {
		return tone;
	}

	public void setTone(String tone) {
		this.tone = tone;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int index) {
		this.idx = index;
	}
	
}
