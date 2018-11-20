package com.project2;

import java.io.Serializable;

public class BookDTO implements Serializable {

	public String userId;
	private int id;
	private String name;
	private String author;
	private int rental;

	public int getRental() {
		return rental;
	}

	public void setRental(int rental) {
		this.rental = rental;
	}

	@Override
	public String toString() {
		String daeyu = "";

		if (rental == 1) {
			daeyu = "대여중";
		} else {
			daeyu = "대여가능";
		}
		if (userId == null) {
			userId = "";
		}
		String str = "";
		str = String.format(" %5d\t%15s\t%10s\t%8s\t%10s ", id, name, author,
				daeyu, userId);

		return str;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
