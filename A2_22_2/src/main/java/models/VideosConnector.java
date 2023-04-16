package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import DBConnector.DBConnectorClass;

public class VideosConnector extends AbstractTableModel {

	// Table attributes
	private List<Videos> videos;
	private String[] columnNames = { "id", "title", "director", "cli_id" };
	private String DB = "Youtube";
	private Connection connection;
	private String table = "videos";
	
	public VideosConnector() {
		updateTable();
	}


	@Override
	public int getRowCount() {
		return videos.size();
	}


	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		// Make the first row non-editable
		return row > 0;
	}

	public List<Videos> getVideos() {
		return videos;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setVideos(List<Videos> videos) {
		this.videos = videos;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Videos video = videos.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return video.getId();
		case 1:
			return video.getTitle();
		case 2:
			return video.getDirector();
		case 3:
			return video.getCli_id();
		default:
			return null;
		}
	}
	public void updateTable() {
		this.videos = new ArrayList<Videos>();
		connection = DBConnectorClass.connect("192.168.1.128:3306","remote","por.java12DABA");
		DBConnectorClass.selectDB("Youtube");
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + table + ";");
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String director = rs.getString("director");
				int cli_id = rs.getInt("cli_id");
				Videos video = new Videos(id, title, director, cli_id);
				videos.add(video);
			}
			statement.close();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addVideoToDB(Videos video) {
		connection = DBConnectorClass.connect("192.168.1.128:3306","remote","por.java12DABA");
		DBConnectorClass.selectDB("Youtube");
		String query = "INSERT INTO " + table + " (title, director, cli_id) " + "VALUES (?,?,?);";

		try {
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, video.getTitle());
			pStatement.setString(2, video.getDirector());
			pStatement.setLong(3, video.getCli_id());

			// Execute statement and close if success
			pStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Usuario añadido", "Completado", JOptionPane.INFORMATION_MESSAGE);
			pStatement.close();
			connection.close();
			updateTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteCliente(int index) {
		Videos video = videos.get(index);
		int videoID = video.getId();
		connection = DBConnectorClass.connect("192.168.1.128:3306","remote","por.java12DABA");
		DBConnectorClass.selectDB("Youtube");
		String query = "DELETE FROM " + table + " WHERE id = " + videoID + ";";

		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Usuario eliminado", "Completado!",
					JOptionPane.INFORMATION_MESSAGE);

			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Remove from table
		videos.remove(index);
	}
}
	
