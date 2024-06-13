package entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "digital")
public class Digital {
	@Id
	@Column(name = "ID")
	private int id;
	@Column(columnDefinition = "NVARCHAR(50)", nullable = false)
	private String title;
	@Column(columnDefinition = "TEXT",nullable = false)
	private String description;
	@Column(columnDefinition = "NVARCHAR(50)", nullable = false)
	private String image;
	@Column(columnDefinition = "NVARCHAR(50)", nullable = false)
	private String author;
	@Column(columnDefinition = "Date", nullable = false)
	private Date timePost;
	@Column(columnDefinition = "TEXT",nullable = false)
	private String shortDes;
	
	public Digital() {
	}
	
	public Digital(int id, String title, String description, String image, String author, Date timePost,
			String shortDes) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.author = author;
		this.timePost = timePost;
		this.shortDes = shortDes;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getTimePost() {
		return timePost;
	}

	public void setTimePost(Date timePost) {
		this.timePost = timePost;
	}

	public String getShortDes() {
		return shortDes;
	}

	public void setShortDes(String shortDes) {
		this.shortDes = shortDes;
	}

	@Override
	public String toString() {
		return "Digital [id=" + id + ", title=" + title + ", description=" + description + ", image=" + image
				+ ", author=" + author + ", timePost=" + timePost + ", shortDes=" + shortDes + "]";
	}
	
}
