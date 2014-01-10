package com.soundcenter.soundcenter.lib.tcp;

import java.io.Serializable;

public class MidiNotificationPacket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6800404882817370136L;
	private short id = -1;
	private byte type = 0;
	private String path = "";
	private long bytesToSkip = 0;
	
	public MidiNotificationPacket(byte type, short id, String path, long bytesToSkip) {
		this.type = type;
		this.id = id;
		this.path = path;
		this.bytesToSkip = bytesToSkip;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getBytesToSkip() {
		return bytesToSkip;
	}

	public void setBytesToSkip(long bytesToSkip) {
		this.bytesToSkip = bytesToSkip;
	}
	
}
