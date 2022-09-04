
/**
 *
 * @author Joona
 */
package com.sqjoni.polygon;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


public class CoordinateReaderTest {

    @Test
    public void whenWrongCharactersAreUsedInFilesThenThrowNumberFormatException()
        throws IOException, ParseException{
        try {
            CoordinateReader fileReader = new CoordinateReader();
            ArrayList<Point3D> polygonCoordinates = fileReader
                    .getPolygonCoordinates();
            assertThrows(NumberFormatException.class, () -> {
                Integer.parseInt("k");
            });
        } catch (IOException ex) {
            
        }
    }


}
