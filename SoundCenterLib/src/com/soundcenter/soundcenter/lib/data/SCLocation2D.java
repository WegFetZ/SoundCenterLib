package com.soundcenter.soundcenter.lib.data;

import java.io.Serializable;

import org.bukkit.Location;

import com.soundcenter.soundcenter.lib.util.StringUtil;

public class SCLocation2D implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6546901205093406033L;

	private double x;
	private double z;
	private String world;
	
	public SCLocation2D(double x, double z, String world) {
		this.x = x;
		this.z = z;
		this.world = StringUtil.cutForUdp(world);
	}
	
	public SCLocation2D(Location loc) {
		this.x = loc.getX();
		this.z = loc.getZ();
		//limit strings to 24 characters
		this.world = StringUtil.cutForUdp(loc.getWorld().getName());
	}
	
	
    public double distance(SCLocation2D o) {
        if (o == null) {
            throw new IllegalArgumentException("Cannot measure distance to a null location");
        } else if (o.getWorld() == null || getWorld() == null) {
            throw new IllegalArgumentException("Cannot measure distance to a null world");
        } else if (!o.getWorld().equals(getWorld())) {
            throw new IllegalArgumentException("Cannot measure distance between " + getWorld() + " and " + o.getWorld());
        }
    	
        return Math.sqrt(Math.pow(x - o.x, 2) + + Math.pow(z - o.z, 2));
    }
    
    public String getPoint() {
    	return "(" + getBlockX() + ", " + ", " + getBlockZ() + ")";
    }
    
    public double getX() {
    	return x;
    }
    
    public int getBlockX() {
    	return (int) x;
    }
    
    public double getZ() {
    	return z;
    }
    
    public int getBlockZ() {
    	return (int) z;
    }
        
    public void setX(double x) {
    	this.x = x;
    }
    
    public void setZ(double x) {
    	this.x = x;
    }
    
    public String getWorld() {
    	return world;
    }
    
    public void setWorld(String world) {
    	this.world = StringUtil.cutForUdp(world);
    }
	
    public boolean sameAs(SCLocation2D other) {
    	return (other.x == x && other.z == z 
    			&& other.world.equals(world));
    }
    
    @Override
    public String toString() {
    	return "X: " + x + " Z: " + z + " world: " + world;
    }
}
