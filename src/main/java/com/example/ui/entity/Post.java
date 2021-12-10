package com.example.ui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Long id;

    private String content;

    private LocalDateTime dayPost;

    private Long userId;
//    public Post() {
//		// TODO Auto-generated constructor stub
//	}
    
//	public Post(Long id, String content, LocalDateTime dayPost, Long userId) {
//		super();
//		this.id = id;
//		this.content = content;
//		this.dayPost = dayPost;
//		this.userId = userId;
//	}
//
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public LocalDateTime getDayPost() {
//		return dayPost;
//	}
//	public void setDayPost(LocalDateTime dayPost) {
//		this.dayPost = dayPost;
//	}
//	public Long getUserId() {
//		return userId;
//	}
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
}
