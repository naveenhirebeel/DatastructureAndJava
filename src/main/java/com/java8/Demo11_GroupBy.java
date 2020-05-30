package all;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

class BlogPost {
	int id;
    String title;
    String author;
    BlogPostType type;
    int likes;
    
    public BlogPost(int id, String title, String author) {
    	this.id = id;
    	this.title = title;
    	this.author = author;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BlogPostType getType() {
		return type;
	}

	public void setType(BlogPostType type) {
		this.type = type;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
    
}

enum BlogPostType {
    NEWS,
    REVIEW,
    GUIDE
}




abstract
public class Demo11_GroupBy {
	
	public static void main(String[] args) {
		Map<String, List<BlogPost>> map = Arrays.asList(new BlogPost(1, "a", "ABC"),
				new BlogPost(2, "b", "ABC"),
				new BlogPost(3, "c", "XYZ"),
				new BlogPost(4, "d", "XYZ"),
				new BlogPost(5, "e", "LMN"))
		.stream()
		.collect(Collectors.groupingBy(BlogPost::getAuthor));

		System.out.println(map);
		
	}



}
