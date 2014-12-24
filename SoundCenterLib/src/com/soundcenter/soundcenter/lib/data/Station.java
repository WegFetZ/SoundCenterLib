package com.soundcenter.soundcenter.lib.data;

import java.util.List;

public interface Station {
	
	public byte getType();
	
	public short getId();
	public void setId(short id);
	
	public String getOwner();
	public void setOwner(String owner);
	
	public String getName();
	public void setName(String name);
	
	public SCLocation getMax();
	
	public SCLocation getMin();
	
	public List<SCLocation2D> getPoints();
	
	public SCLocation getLocation();
	
	public String getWorld();
	
	public int getRange();
	public void setRange(int value);
	
	public byte getPriority();
	public void setPriority(byte value);
	
	public byte getMaxVolume();
	public void setMaxVolume(byte value);
	
	public boolean isEditableByOthers();
	public void setEditableByOthers(boolean value);
	
	public List<Song> getSongs();
	public void addSong(Song song);
	public void removeSong(Song song);
	public void removeAllSongs();
	
	public boolean shouldStartFromBeginning();
	public void setStartFromBeginning(boolean value);
	
	public boolean shouldLoop();
	public void setLoop(boolean value);
}
