package model;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="artwork")
public class Artwork{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name= "TITLE")
	private String title;
	@Column(name = "ARTIST_NAME")
	private String artistName;
	@Column(name="MEDIA")
	private String media;
	@Column(name="YEAR")
	private String year;
	@Column(name="VALUE")
	private double value;
	
	public Artwork() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Artwork(String title, String artistName, String media, String year, double value) {
		super();
		this.title = title;
		this.artistName = artistName;
		this.media = media;
		this.year = year;
		this.value = value;
	}
	
	public Artwork(String title) {
		super();
		this.title = title;
	}
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
		 
	public String returnItemDetails() {
		return "ID: " + id + "  Title: " + title + "  Artist Name: " +  artistName;
	}
		
	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", artistName=" + artistName + ", media=" + media + ", year="
				+ year + ", value=" + value + "]";
	}
		
}
