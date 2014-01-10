package com.soundcenter.soundcenter.lib.udp;

import com.soundcenter.soundcenter.lib.data.GlobalConstants;

public class UdpOpcodes {

	public static final byte GROUP_STREAM = 00;
	public static final byte TYPE_MUSIC_AREA = GlobalConstants.TYPE_AREA;
	public static final byte TYPE_MUSIC_BOX = GlobalConstants.TYPE_BOX;
	public static final byte TYPE_MUSIC_BIOME = GlobalConstants.TYPE_BIOME;
	public static final byte TYPE_MUSIC_WORLD = GlobalConstants.TYPE_WORLD;
	public static final byte TYPE_MUSIC_GLOBAL = GlobalConstants.TYPE_GLOBAL;
	public static final byte TYPE_VOICE = GlobalConstants.TYPE_VOICE;
	public static final byte GROUP_END_STREAM = 9;
	
	public static final byte TYPE_GREET_PACKET = 10;
	
	public static final byte INFO_LOCATION = 20;
}
