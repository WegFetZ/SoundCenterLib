package com.soundcenter.soundcenter.lib.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class WGRegion implements Station, Serializable {

	private static final long serialVersionUID = 4655360206783598943L;
	
	private byte type = GlobalConstants.TYPE_WGREGION;
	private short id = 0;
	private SCLocation min = null;
	private SCLocation max = null;
	private List<SCLocation2D> points;
	private String name = null;
	private String owner = null;
	private byte priority = 1;
	private byte maxVolume = 100;
	private boolean editableByOthers = false;
	private int fadeout = 0;
	private boolean radio = false;
	private String radioUrl = "";
	private ConcurrentHashMap<String, Song> songs = new ConcurrentHashMap<String, Song>();
	
	
	public WGRegion(short id, String owner, String name, SCLocation min, SCLocation max, List<SCLocation2D> points) {
		this.id = id;
		this.owner = owner;
		this.name = name;
		this.min = min;
		this.max = max;
		this.points = points;
	}

	@Override
	public byte getType() {
		return type;
	}
	
	@Override
	public short getId() { return id; }
	@Override
	public void setId(short id) { this.id = id; }
	
	@Override
	public SCLocation getMin() { return min; }
	public void setMin(SCLocation min) { this.min = min; }
	
	@Override
	public SCLocation getMax() { return max; }
	public void setMax(SCLocation max) { this.max = max; }
	
	public List<SCLocation2D> getPoints() { return points; }
	public void setPoints(List<SCLocation2D> points) { this.points = points; }
	
	@Override
	public String getWorld() { return max.getWorld(); }
	
	public String getOwner() { return owner;}
	@Override
	public void setOwner(String owner) { this.owner = owner; }
	
	@Override
	public String getName() { return name; }
	@Override
	public void setName(String name) { this.name = name; }

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

	
	
	/* not needed for wgregions */
	@Override
	public SCLocation getLocation() { return null; }
	
	
	/* we need to set default values for new variables, which aren't defined in the serialized object */
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
	    ois.defaultReadObject();
	    if (maxVolume == 0) {
	    	maxVolume = 100;
	    }
	}
}
