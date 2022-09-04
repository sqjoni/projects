
package com.sqjoni.polygon;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



/**
 *
 * @author Joona
 */
public class PolygonTest {

    @Test
    public void whenFilesContainCoordinatesThenArrayListIsNotEmpty() 
            throws IOException, ParseException {
        try {
            CoordinateReader fileReader = new CoordinateReader();
            ArrayList<Point3D> polygonCoordinates = fileReader
                    .getPolygonCoordinates();
            var result = "(1, 1, 1)";
            assertEquals(polygonCoordinates.get(0).toString(), result);
        } catch (IOException ex) {
            
        }
    }
}
