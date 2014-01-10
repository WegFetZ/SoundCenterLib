package com.soundcenter.soundcenter.lib.data;

import java.io.File;
import java.io.Serializable;
import java.text.DecimalFormat;

public class Song implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1052764580509872429L;
	private String owner = "";
	private String title = "";
	private long size = 0;
	
	public Song(String owner, String name, long size) {
		this.owner = owner;
		this.title = name;
		this.size = size;
	}
	
	public Song(String owner, File file) {
		this.owner = owner;
		this.title = file.getName();
		this.size = file.length();
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
	
	public String getPath() {
		return owner + File.separator + title;
	}

	public long getSize() {
		return size;
	}
	
	public String getMBSize() {
		DecimalFormat df = new DecimalFormat("#.##");
        return df.format((double) (size/(1024.0*1024.0))) + " MB";
	}

	public void setSize(long size) {
		this.size = size;
	}
	
}
