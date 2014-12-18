package com.soundcenter.soundcenter.lib.data;

import java.util.List;

public interface Station {

	public boolean equals(Station station);
	public int hashCode();
	
	public byte getType();
	
	public short getId();
	public void setId(short id);
	
	public String getOwner();
	public void setOwner(String owner);
	
	public String getName();
	public void setName(String name);
	
	public SCLocation getMax();
	
	public SCLocation getMin();
	
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
	
	public boolean isRadio();
	public void setRadio(boolean value);
	
	public String getRadioURL();
	public void setRadioURL(String url);
	
	public List<Song> getSongs();
	public void addSong(Song song);
	public void removeSong(String path);
	public void removeSong(Song song);
	public void removeAllSongs();
}
