package com.soundcenter.soundcenter.lib.udp;

import com.soundcenter.soundcenter.lib.data.GlobalConstants;

public class UdpOpcodes {

	public static final byte GROUP_STREAM = 00;
	public static final byte TYPE_VOICE = GlobalConstants.TYPE_VOICE;
	public static final byte GROUP_END_STREAM = 9;
	
	public static final byte TYPE_HEARTBEAT = 10;
	
	public static final byte INFO_LOCATION = 20;
}
