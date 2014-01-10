package com.soundcenter.soundcenter.lib.tcp;

public class TcpOpcodes {
	
	
	/* ------------ opcodes going to client --------------- */
	
	// connection
	public static final byte CL_GROUP_CON = 1;
	public static final byte CL_CON_REQ_VERSION = 1;
	public static final byte CL_CON_REQ_NAME = 2;
	public static final byte CL_CON_INFO_DISCONNECT = 3;
	public static final byte CL_CON_INFO_ACCEPTED = 4;
	public static final byte CL_CON_INFO_INITIALIZED = 5;
	public static final byte CL_CON_INFO_NOT_ONLINE = 6;
	public static final byte CL_CON_DENY_USER_CAP = 7;
	public static final byte CL_CON_DENY_VERSION = 8;
	public static final byte CL_CON_DENY_NAME = 9;
	public static final byte CL_CON_DENY_ALREADY_CONNECTED = 10;
	public static final byte CL_CON_DENY_IP = 11;
	public static final byte CL_CON_DENY_INIT_TIMEOUT = 12;
	public static final byte CL_CON_DENY_PROTOCOL = 13;
	public static final byte CL_CON_DENY_PERMISSION_INIT = 14;
	public static final byte CL_GROUP_END_CON = 19;
	
	// infodata
	public static final byte CL_GROUP_INFODATA = 20;
	public static final byte CL_INFODATA_START = 20;
	public static final byte CL_INFODATA_AVAILABLE_BIOME = 21;
	public static final byte CL_INFODATA_AVAILABLE_WORLD = 22;
	public static final byte CL_INFODATA_SONG = 23;
	public static final byte CL_INFODATA_PERMISSION = 24;
	public static final byte CL_INFODATA_END = 25;
	public static final byte CL_GROUP_END_INFODATA = 29;
	
	// data
	public static final byte CL_GROUP_DATA = 30;
	public static final byte CL_DATA_STATION = 30;
	public static final byte CL_DATA_SONG_CHUNK = 31;
	public static final byte CL_DATA_CMD_DELETE_SONG = 32;
	public static final byte CL_DATA_CMD_DELETE_STATION = 33;
	public static final byte CL_DATA_SONG_TRANSFER_START = 34;
	public static final byte CL_DATA_SONG_TRANSFER_END = 35;
	public static final Byte CL_DATA_SONG_UPLOAD_START = 36;
	public static final Byte CL_DATA_SONG_UPLOAD_DONE = 37;
	public static final byte CL_GROUP_END_DATA = 39;
	
	// commands
	public static final byte CL_GROUP_CMD = 40;
	public static final byte CL_CMD_START_RECORDING = 40;
	public static final byte CL_CMD_STOP_RECORDING = 41;
	public static final byte CL_CMD_PLAY_MIDI = 42;
	public static final byte CL_CMD_CHANGE_VOLUME = 43;
	public static final byte CL_CMD_MUTE_MUSIC = 44;
	public static final byte CL_CMD_UNMUTE_MUSIC = 45;
	public static final byte CL_CMD_MUTE_VOICE = 46;
	public static final byte CL_CMD_UNMUTE_VOICE = 47;
	public static final byte CL_CMD_STOP_GLOBAL = 48;
	public static final byte CL_GROUP_END_CMD = 49;
	
	// errors
	public static final byte CL_GROUP_ERR = 60;
	public static final byte CL_ERR_UPLOAD_PERMISSION = 60;
	public static final byte CL_ERR_UPLOAD_MAX_STORAGE = 61;
	public static final byte CL_ERR_FILE_NOT_EXISTANT = 62;
	public static final byte CL_ERR_STREAM_SERVER_LOAD = 63;
	public static final byte CL_ERR_STREAM_NO_SONGS = 64;
	public static final byte CL_ERR_PLAY_GLOBAL_PERMISSION = 65;
	public static final byte CL_ERR_OTHERS_EDIT_PERMISSION = 66;
	public static final byte CL_ERR_OTHERS_DELETE_PERMISSION = 67;
	public static final byte CL_ERR_EDIT_RANGE = 68;
	public static final byte CL_ERR_CREATE_PERMISSION = 69;
	public static final byte CL_ERR_ALREADY_EXISTS = 70;
	public static final byte CL_ERR_NOT_INITIALIZED = 71;
	public static final byte CL_ERR_UNKNOWN = 72;
	public static final byte CL_GROUP_END_ERR = 79;
	
	
	/* opcodes going to server */
	
	// commands
	public static final byte SV_GROUP_END_CON = -1;
	public static final byte SV_CON_REQ_JOIN = -1;
	public static final byte SV_CON_INFO_VERSION = -2;
	public static final byte SV_CON_INFO_NAME = -3;
	public static final byte SV_CON_INFO_DISCONNECT = -4;
	public static final byte SV_GROUP_CON = -5;	
	
	//stream
	public static final byte SV_GROUP_END_STREAM = -10;
	public static final byte SV_STREAM_CMD_START = -11;
	public static final byte SV_STREAM_CMD_STOP = -12;
	public static final byte SV_STREAM_CMD_PLAY_GLOBAL = -13;
	public static final byte SV_STREAM_CMD_STOP_GLOBAL = -14;
	public static final byte SV_STREAM_CMD_MUTE_VOICE = -15;
	public static final byte SV_STREAM_CMD_UNMUTE_VOICE = -16;
	public static final byte SV_GROUP_STREAM = -19;

	// data
	public static final byte SV_GROUP_END_DATA = -20;
	public static final byte SV_DATA_REQ_INFODATA = -20;
	public static final byte SV_DATA_REQ_SONG = -21;
	public static final byte SV_DATA_STATION_AREA = -22;
	public static final byte SV_DATA_STATION_BOX = -23;
	public static final byte SV_DATA_STATION_BIOME = -24;
	public static final byte SV_DATA_STATION_WORLD = -25;
	public static final byte SV_DATA_CMD_CREATE_STATION = -26;
	public static final byte SV_DATA_CMD_EDIT_STATION = -27;
	public static final byte SV_DATA_CMD_DELETE_STATION = -28;
	public static final byte SV_DATA_CMD_RECEIVE_SONG = -29;
	public static final byte SV_DATA_SONG_CHUNK = -30;
	public static final byte SV_DATA_INFO_UPLOAD_ENDED = -31;
	public static final byte SV_DATA_CMD_DELETE_SONG = -32;
	public static final byte SV_GROUP_DATA = -39;
	
}
