package com.soundcenter.soundcenter.lib.data;

import com.soundcenter.soundcenter.lib.udp.UdpPacket;

public class GlobalConstants {

	/* UDP */
	public static final short UDP_IDENT = 19092;
	public static final int STREAM_DATA_SIZE = 640;
	public static final int STREAM_PACKET_SIZE = STREAM_DATA_SIZE + UdpPacket.HEADER_SIZE;
	public static final int LOCATION_DATA_SIZE = 72;
	public static final int LOCATION_PACKET_SIZE = LOCATION_DATA_SIZE + UdpPacket.HEADER_SIZE;
	public static final int VOICE_DATA_RATE = 4000;
	public static final int LOCATION_DATA_RATE = LOCATION_DATA_SIZE*30;
	
	
	/* TYPES */
	public static final byte TYPE_AREA = 0;
	public static final byte TYPE_BOX = 1;
	public static final byte TYPE_BIOME = 2;
	public static final byte TYPE_WORLD = 3;
	public static final byte TYPE_WGREGION = 4;
	
	public static final byte TYPE_VOICE = 5;
	
	/* MISC */
	public static final String[] permissions = {"sc.init", "sc.add.song",
		"sc.set.area", "sc.set.box", "sc.set.biome", "sc.set.world", "sc.set.wgregion", "sc.set.wgregion.nomember", "sc.set.overlap", 
		"sc.play.world", "sc.play.global", "sc.speak", "sc.speak.global", "sc.others.edit", "sc.others.delete", 
		"sc.nolimits" };
}
