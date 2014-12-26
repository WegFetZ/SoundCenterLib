package com.soundcenter.soundcenter.lib.data;

import java.io.Serializable;

public class Song implements Serializable {

	private static final long serialVersionUID = 4L;
	private String owner = "";
	private String title = "";
	private String url = "";
	private String format = "";
	private long duration = 0;
	private long size = 0;

	public Song(String owner, String name, String url, long duration, long size) {
		this.owner = owner;
		this.title = name;
		this.url = url;
		this.duration = duration;
		this.size = size;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public String getUrl() {
		return url;
	}
	
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	
	public long getDuration() {
		return duration;
	}
	
	public long getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		return owner + " - " + title + " (" + url + ")";
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (other == this) {
			return true;
		}
		if (!(other instanceof Song)) {
			return false;
		}
		Song otherSong = (Song) other;
		return title.equalsIgnoreCase(otherSong.getTitle());
	}
}