package com.soundcenter.soundcenter.lib.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Box implements Station, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	
	private byte type = GlobalConstants.TYPE_BOX;
	private short id = 0;
	private SCLocation location = null;
	private String owner = null;
	private byte priority = 1;
	private byte maxVolume = 100;
	private boolean editableByOthers = false;
	private boolean startFromBeginning = false;
	private boolean loop = true;
	private int range = 25;
	private List<Song> songs = new ArrayList<Song>();
	
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

	
	/* not needed for boxes */
	@Override
	public String getName() { return null; }
	@Override
	public void setName(String name) {}
	@Override
	public SCLocation getMax() { return null; }
	@Override
	public SCLocation getMin() { return null; }
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
