package homework.question07;

import java.util.List;

public class Board {
	String title;
	String conents;
	List<Comment> comments;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getConents() {
		return conents;
	}
	public void setConents(String conents) {
		this.conents = conents;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
