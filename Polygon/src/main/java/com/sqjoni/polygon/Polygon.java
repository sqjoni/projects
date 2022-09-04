
package com.sqjoni.polygon;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Joona
 * 
 * This is the main class of the program. Here would be the algorithm for
 * locating the given point wheater it is on the polygon or inside or outside
 * of it. This class focuses only on processing the given data sets and then it
 * passes them to the ResultWriter class.
 */
public class Polygon {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        CoordinateReader fileReader = new CoordinateReader();
        ArrayList<Point3D> polygonCoordinates = fileReader
                .getPolygonCoordinates();
        
        ArrayList<Point3D> pointCoordinates = fileReader
                .getPointCoordinates();
        
    }

}


