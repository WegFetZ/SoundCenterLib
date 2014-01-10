package com.soundcenter.soundcenter.lib.data;

import java.io.Serializable;

import org.bukkit.Location;

import com.soundcenter.soundcenter.lib.util.StringUtil;

public class SCLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6546901205093406033L;

	private double x;
	private double y;
	private double z;
	private String world;
	private String biome;
	
	public SCLocation(double x, double y, double z, String world, String biome) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.world = StringUtil.cutForUdp(world);
		this.biome = StringUtil.cutForUdp(biome);
	}
	
	public SCLocation(Location loc) {
		this.x = loc.getX();
		this.y = loc.getY();
		this.z = loc.getZ();
		//limit strings to 24 characters
		this.world = StringUtil.cutForUdp(loc.getWorld().getName());
		this.biome = StringUtil.cutForUdp(loc.getWorld().getBiome(loc.getBlockX(), loc.getBlockZ()).toString());
	}
	
	
    public double distance(SCLocation o) {
        if (o == null) {
            throw new IllegalArgumentException("Cannot measure distance to a null location");
        } else if (o.getWorld() == null || getWorld() == null) {
            throw new IllegalArgumentException("Cannot measure distance to a null world");
        } else if (!o.getWorld().equals(getWorld())) {
            throw new IllegalArgumentException("Cannot measure distance between " + getWorld() + " and " + o.getWorld());
        }
    	
        return Math.sqrt(Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2) + Math.pow(z - o.z, 2));
    }
    
    public String getPoint() {
    	return "(" + getBlockX() + ", " + getBlockY() + ", " + getBlockZ() + ")";
    }
    
    public double getX() {
    	return x;
    }
    
    public int getBlockX() {
    	return (int) x;
    }
    
    public double getY() {
    	return y;
    }
    
    public int getBlockY() {
    	return (int) y;
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
    
    public void setY(double x) {
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
    
    public String getBiome() {
    	return biome;
    }
    
    public void setBiome(String biome) {
    	this.biome = StringUtil.cutForUdp(biome);
    }
	
    /**
     * Gets the minimum vector components of two CMLocations.
     *
     * @param v1 The first location.
     * @param v2 The second location.
     * @return minimum or null if locations are in different worlds
     */
    public static SCLocation getMinimum(SCLocation v1, SCLocation v2) {
    	if (!v1.world.equals(v2.world))
    		return null;
        return new SCLocation(Math.min(v1.x, v2.x), Math.min(v1.y, v2.y), Math.min(v1.z, v2.z), v1.world, v1.biome);
    }

    /**
     * Gets the maximum vector components of two CMLocations.
     *
     * @param v1 The first location.
     * @param v2 The second location.
     * @return maximum or null if locations are in different worlds
     */
    public static SCLocation getMaximum(SCLocation v1, SCLocation v2) {
    	if (!v1.world.equals(v2.world))
    		return null;
        return new SCLocation(Math.max(v1.x, v2.x), Math.max(v1.y, v2.y), Math.max(v1.z, v2.z), v1.world, v1.biome);
    }
    
    public boolean sameAs(SCLocation other) {
    	return (other.x == x && other.y == y && other.z == z 
    			&& other.world.equals(world) && other.biome.equals(biome));
    }
    
    @Override
    public String toString() {
    	return "X: " + x + " Y: " + y + " Z: " + z + " world: " + world + " biome: " + biome;
    }
}
