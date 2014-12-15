package com.soundcenter.soundcenter.lib.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Box implements Station, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7194233669366873597L;
	
	private byte type = GlobalConstants.TYPE_BOX;
	private short id = 0;
	private SCLocation location = null;
	private String owner = null;
	private byte priority = 1;
	private byte maxVolume = 100;
	private boolean editableByOthers = false;
	private int range = 25;
	private boolean radio = false;
	private String radioUrl = "";
	private ConcurrentHashMap<String, Song> songs = new ConcurrentHashMap<String, Song>();
	
	public Box(short id, String owner, SCLocation location, int range) {
		this.id = id;
		this.range = range;
		this.location = location;
		this.owner = owner;
		this.range = range;
	}
	
	
	@Override
	public byte getType() {
		return type;
	}
	
	@Override
	public short getId() { return id; }
	public void setId(short id) { this.id = id; }
	
	@Override
	public SCLocation getLocation() { return location; }
	public void setLocation(SCLocation location) { this.location = location; }

	@Override
	public String getWorld() { return location.getWorld(); }
	
	@Override
	public String getOwner() { return owner; }
	public void setOwner(String owner) { this.owner = owner; }

	@Override
	public byte getPriority() { return priority; }
	@Override
	public void setPriority(byte priority) { this.priority = priority; }
	
	@Override
	public byte getMaxVolume() { return maxVolume; }
	@Override
	public void setMaxVolume(byte maxVolume) { this.maxVolume = maxVolume; }

	@Override
	public boolean isEditableByOthers() { return editableByOthers; }
	@Override
	public void setEditableByOthers(boolean editableByOthers) {	
		this.editableByOthers = editableByOthers; 
	}

	@Override
	public int getRange() { return range; }
	@Override
	public void setRange(int range) { this.range = range; }
	
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

	
	/* not needed for boxes */
	@Override
	public String getName() { return null; }
	@Override
	public void setName(String name) {}
	@Override
	public SCLocation getMax() { return null; }
	@Override
	public SCLocation getMin() { return null; }
	
	
	/* we need to set default values for new variables, which aren't defined in the serialized object */
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
	    ois.defaultReadObject();
	    if (maxVolume == 0) {
	    	maxVolume = 100;
	    }
	}

}
