package com.soundcenter.soundcenter.lib.tcp;

import java.io.Serializable;

public class TcpPacket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3970693351131837179L;
	private Byte type = null;
	private Object key = null;
	private Object value = null;
	
	public TcpPacket(Byte type, Object key, Object value) {
		this.type = type;
		this.key = key;
		this.value = value;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
