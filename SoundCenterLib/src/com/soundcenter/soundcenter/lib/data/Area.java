package com.soundcenter.soundcenter.lib.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Area implements Station, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	
	private byte type = GlobalConstants.TYPE_AREA;
	private short id = 0;
	private SCLocation min = null;
	private SCLocation max = null;
	private String owner = null;
	private byte priority = 1;
	private byte maxVolume = 100;
	private boolean editableByOthers = false;
	private boolean startFromBeginning = false;
	private boolean loop = true;
	private int fadeout = 10;
	private List<Song> songs = new ArrayList<Song>();
	
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
	public void addSong(Song song) { songs.add(song); }
	@Override
	public void removeSong(Song song) { songs.remove(song); }
	@Override
	public void removeAllSongs() { songs.clear(); }
	@Override
	public List<Song> getSongs() { return songs; }
	
	public boolean shouldStartFromBeginning() {
		return startFromBeginning;
	}
	public void setStartFromBeginning(boolean value) {
		this.startFromBeginning = value;
	}
	
	public boolean shouldLoop() { return loop; }
	public void setLoop(boolean value) { this.loop = value;	}


	/* Not used for Areas */
	@Override
	public String getName() { return null; }
	@Override
	public void setName(String name) {}
	@Override
	public SCLocation getLocation() { return null; }
	@Override
	public List<SCLocation2D> getPoints() { return null; }
	
	/* we need to set default values for new variables, which aren't defined in the serialized object */
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
	    ois.defaultReadObject();
	    if (maxVolume == 0) {
	    	maxVolume = 100;
	    }
	}
}
