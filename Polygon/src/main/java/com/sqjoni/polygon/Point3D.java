
package com.sqjoni.polygon;

/**
 *
 * @author Joona
 * 
 * This class is used as a datatype in the program to illustrate 3D points in
 * space.
 */
public class Point3D {
    
    private int x;
    private int y;
    private int z;
    
    public Point3D(int x, int y , int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getZ() {
        return this.z;
    }
    
    @Override
    public String toString() {
        return "("+this.x+", "+this.y+", "+this.z+")";
    }
}