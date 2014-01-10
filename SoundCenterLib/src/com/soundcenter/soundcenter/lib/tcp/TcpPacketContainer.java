package com.soundcenter.soundcenter.lib.tcp;

import java.io.ObjectOutputStream;

public class TcpPacketContainer {

	private TcpPacket packet = null;
	private ObjectOutputStream oos = null;
	
	public TcpPacketContainer(TcpPacket packet, ObjectOutputStream oos) {
		this.packet = packet;
		this.oos = oos;
	}

	public TcpPacket getPacket() {
		return packet;
	}

	public void setPacket(TcpPacket packet) {
		this.packet = packet;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}
}
