package models;

public class Videos {
	
	private int id;
	private String title;
	private String director;
	private int cli_id;
	
	public Videos()
	{
		
	}
	public Videos(int id, String titulo, String director, int cli_id)
	{
		this.id = id;
		this.title = titulo;
		this.director = director;
		this.cli_id = cli_id;
	}
	public String toString() {
		return "Videos id=" + id + ", titulo=" + title + ", director=" + director + ", codigo cliente=" +cli_id+ "";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getCli_id() {
		return cli_id;
	}
	public void setCli_id(int cli_id) {
		this.cli_id = cli_id;
	}
	

}
