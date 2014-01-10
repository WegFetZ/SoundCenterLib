package com.soundcenter.soundcenter.lib.udp;

import java.nio.ByteBuffer;

import org.bukkit.Location;

import com.soundcenter.soundcenter.lib.data.SCLocation;
import com.soundcenter.soundcenter.lib.util.StringUtil;

public class UdpPacket {
	
	public static final int HEADER_SIZE = 11;
	
	private byte[] data;
	
	public UdpPacket(int length) {
		data = new byte[length];
	}
	
	public UdpPacket(byte[] data) {
		this.data = data;
	}
	
	public void setData(byte[] data) {
		this.data = data;
	}
	public byte[] getData() {
		return data;
	}
	
	public int getLength() {
		return data.length;
	}
	

	public void setIdent(short ident) {
		putShort(0, ident);
	}
	public short getIdent() {
		return readShort(0);
	}
	
	public void setSeq(short seq) {
		putShort(2, seq);
	}
	public short getSeq() {
		return readShort(2);
	}
	
	public void setDestUserID(short id) {
		putShort(4,id);
	}
	
	public short getDestUserID() {
		return readShort(4);
	}
	
	public void setID(short id) {
		putShort(6, id);
	}
	public short getID() {
		return readShort(6);
	}
	
	public void setType(byte type) {
		data[8] = type;
	}
	
	public byte getType() {
		return data[8];
	}
	
	public void setVolume(byte value) {
		data[9] = value;
	}
	
	public byte getVolume() {
		return data[9];
	}
	
	public void setSongIndex(byte index) {
		data[10] = index;
	}
	
	public byte getSongIndex() {
		return data[10];
	}
	
	public void setStreamData(byte[] sData) {
		putBytes(HEADER_SIZE, sData);
	}
	
	public byte[] getStreamData() {
		return readBytes(HEADER_SIZE, data.length - HEADER_SIZE);
	}
	
	public void setLocation(Location loc) {
		putDouble(HEADER_SIZE, loc.getX());
		putDouble(HEADER_SIZE + 8, loc.getY());
		putDouble(HEADER_SIZE + 2*8, loc.getZ());
		String worldName = StringUtil.cutForUdp(loc.getWorld().getName());
		putString(HEADER_SIZE + 3*8, worldName);
		String biomeName = StringUtil.cutForUdp(loc.getWorld()
				.getBiome(loc.getBlockX(), loc.getBlockZ()).toString());
		putString(HEADER_SIZE + 6*8, biomeName);
	}
	
	public SCLocation getLocation() {
		double x = readDouble(HEADER_SIZE);
		double y = readDouble(HEADER_SIZE + 8);
		double z = readDouble(HEADER_SIZE + 2*8);
		String world = readString(HEADER_SIZE + 3*8);
		String biome = readString(HEADER_SIZE + 6*8);
		return new SCLocation(x, y, z, world, biome);
	}
	
	
	/* WRAPPER METHODS */
	public void putShort(int at, short value) {
		ByteBuffer.wrap(data).putShort(at, value);
	}
	
	public short readShort(int at) {
		return ByteBuffer.wrap(data).getShort(at);
	}
	
	public void putDouble(int at, double value) {
	    ByteBuffer.wrap(data).putDouble(at, value);
	}

	public double readDouble(int at) {
	    return ByteBuffer.wrap(data).getDouble(at);
	}
	
	public void putString(int at, String value) {
		byte[] stringBytes = value.getBytes();
		byte length = (byte) stringBytes.length;
		data[at] = length;
		putBytes(at+1, stringBytes);
	}
	
	public String readString(int at) {
		byte length = data[at];
		if (length > 23)
			length = 23;
		byte[] stringBytes = readBytes(at+1, length);
		return new String(stringBytes);
	}
	
	public void putBytes(int at, byte[] value) {
		System.arraycopy(value, 0, data, at, value.length);
	}
	
	public byte[] readBytes(int at, int length) {
		byte[] result = new byte[length];
		System.arraycopy(data, at, result, 0, length);
		return result;
	}
}
