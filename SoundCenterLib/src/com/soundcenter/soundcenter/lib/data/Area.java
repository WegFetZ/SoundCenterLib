package com.soundcenter.soundcenter.lib.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Area implements Station, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1208342847293146757L;
	
	private byte type = GlobalConstants.TYPE_AREA;
	private short id = 0;
	private SCLocation min = null;
	private SCLocation max = null;
	private String owner = null;
	private byte priority = 1;
	private boolean editableByOthers = false;
	private int fadeout = 10;
	private boolean radio = false;
	private String radioUrl = "";
	private ConcurrentHashMap<String, Song> songs = new ConcurrentHashMap<String, Song>();
	
	public Area(short id, String owner, SCLocation c1, SCLocation c2, int fadeout) {
		this.id = id;
		this.owner = owner;
		setCorners(c1, c2);
		this.fadeout = fadeout;
	}
	
	
	@Override
	public byte getType() {
		return type;
	}
	
	@Override
	public short getId() { return id; }
	public void setId(short id) { this.id = id; }
	
	@Override
	public SCLocation getMin() { return min; }
	@Override
	public SCLocation getMax() { return max; }
	
	public void setCorners(SCLocation c1, SCLocation c2) {
		this.min = SCLocation.getMinimum(c1, c2);
		this.max = SCLocation.getMaximum(c1, c2);
	}

	@Override
	public String getWorld() { return min.getWorld(); }
	public void setWorld(String world) { min.setWorld(world); }
	
	@Override
	public String getOwner() { return owner; }
	public void setOwner(String owner) { this.owner = owner; }

	@Override
	public byte getPriority() { return priority; }
	@Override
	public void setPriority(byte priority) { this.priority = priority; }

	@Override
	public boolean isEditableByOthers() { return editableByOthers; }
	@Override
	public void setEditableByOthers(boolean editableByOthers) {	
		this.editableByOthers = editableByOthers; 
	}
	
	@Override
	public int getRange() { return fadeout; }
	@Override
	public void setRange(int fadeout) { this.fadeout = fadeout; }
	
	@Override
	public boolean isRadio() { return radio; }
	@Override
	public void setRadio(boolean value) { this.radio = value; }
	
	@Override
	public String getRadioURL() { return radioUrl; }
	@Override
	public void setRadioURL(String url) { this.radioUrl = url; }
	
	@Override
	public void addSong(Song song) { songs.put(song.getPath(), song); }
	@Override
	public void removeSong(String path) { songs.remove(path); }
	@Override
	public void removeSong(Song song) { songs.remove(song.getPath()); }
	@Override
	public void removeAllSongs() { songs.clear(); }
	@Override
	public List<Song> getSongs() { return new ArrayList<Song>(songs.values()); }


	/* Not used for Areas */
	@Override
	public String getName() { return null; }
	@Override
	public void setName(String name) {}
	@Override
	public SCLocation getLocation() { return null; }
}
