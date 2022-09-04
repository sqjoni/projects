
package com.sqjoni.polygon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


/**
 *
 * @author Joona
 * 
 * CoordinateReader is a class created to fetch data from resources and save it
 * for later use in the program. It uses the BufferedReader to acquire data from
 * the files. The data should be in the form of "n,n,n" in the files in order to
 * this class works properly.
 */

public class CoordinateReader {
    
    //Paths to the text files
    private final String polygonCoordinatesFile = "src/main/resources/polygoni.txt";
    private final String pointCoordinatesFile = "src/main/resources/pisteet.txt";
    
    //Data structures for coordinates
    private ArrayList<Point3D> polygonCoordinates;
    private ArrayList<Point3D> pointCoordinates;
    
    //The data is read when an instance of this class is initialized
    CoordinateReader() throws IOException, ParseException {
        try {
            polygonCoordinates = new ArrayList<>();
            pointCoordinates = new ArrayList<>();

            
            BufferedReader reader = new BufferedReader(
                    new FileReader(polygonCoordinatesFile));
            
            String line;
            while (( line = reader.readLine()) != null) {
                String[] coordinates = line.split(",");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                int z = Integer.parseInt(coordinates[2]);
                
                this.addPolygonCoordinate(x, y, z);                
            }
            
            reader = new BufferedReader(new FileReader(pointCoordinatesFile));
            while (( line = reader.readLine()) != null) {
                String[] coordinates = line.split(",");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                int z = Integer.parseInt(coordinates[2]);
                
                this.addPointCoordinate(x, y, z);                
            }
        
        } catch (IOException e) {
            System.out.println("Required file was not found");
        } catch (NumberFormatException e) {
            System.out.println("False character in coordinates");
        }
    }
    
    private void addPolygonCoordinate(int x, int y, int z) {
        polygonCoordinates.add(new Point3D (x, y, z));        
    }
    private void addPointCoordinate(int x, int y, int z) {
        pointCoordinates.add(new Point3D (x, y, z));        
    }
    
    public ArrayList<Point3D> getPolygonCoordinates() {       
        return this.polygonCoordinates;
    }
    
    public ArrayList<Point3D> getPointCoordinates() {       
        return this.pointCoordinates;
    }
    
    
}
