
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
        ArrayList<Point> polygonCoordinates = fileReader
                .getPolygonCoordinates();
        
        ArrayList<Point> pointCoordinates = fileReader
                .getPointCoordinates();
        
        int n = polygonCoordinates.size();
        for (Point p : pointCoordinates) {
            if (isInside(polygonCoordinates, n, p))
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }

        }
       
    }
    static boolean onSegment(Point p, Point q, Point r)
    {
        if (q.getX() <= Math.max(p.getX(), r.getX()) &&
            q.getX() >= Math.min(p.getX(), r.getX()) &&
            q.getY() <= Math.max(p.getY(), r.getY()) &&
            q.getY() >= Math.min(p.getY(), r.getY()))
        {
            return true;
        }
        return false;
    }

    static int orientation(Point p, Point q, Point r)
    {
        int val = (q.getY() - p.getY()) * (r.getX()- q.getX())
                - (q.getX()) - p.getX()* (r.getY() - q.getY());
 
        if (val == 0)
        {
            return 0; // collinear
        }
        return (val > 0) ? 1 : 2; // clock or counterclock wise
    }
 
    // The function that returns true if
    // line segment 'p1q1' and 'p2q2' intersect.
    static boolean doIntersect(Point p1, Point q1,
                            Point p2, Point q2)
    {
        // Find the four orientations needed for
        // general and special cases
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);
 
        // General case
        if (o1 != o2 && o3 != o4)
        {
            return true;
        }
 
        // Special Cases
        // p1, q1 and p2 are collinear and
        // p2 lies on segment p1q1
        if (o1 == 0 && onSegment(p1, p2, q1))
        {
            return true;
        }
 
        // p1, q1 and p2 are collinear and
        // q2 lies on segment p1q1
        if (o2 == 0 && onSegment(p1, q2, q1))
        {
            return true;
        }
 
        // p2, q2 and p1 are collinear and
        // p1 lies on segment p2q2
        if (o3 == 0 && onSegment(p2, p1, q2))
        {
            return true;
        }
 
        // p2, q2 and q1 are collinear and
        // q1 lies on segment p2q2
        if (o4 == 0 && onSegment(p2, q1, q2))
        {
            return true;
        }
 
        // Doesn't fall in any of the above cases
        return false;
    }
 
    // Returns true if the point p lies
    // inside the polygon[] with n vertices
    static boolean isInside(ArrayList<Point> polygon, int n, Point p)
    {
        // There must be at least 3 vertices in polygon[]
        if (n < 3)
        {
            return false;
        }
 
        // Create a point for line segment from p to infinite
        Point extreme = new Point(10000, p.getY());
       
          // To count number of points in polygon
          // whose y-coordinate is equal to
          // y-coordinate of the point
          int decrease = 0;
 
        // Count intersections of the above line
        // with sides of polygon
        int count = 0, i = 0;
        do
        {
            int next = (i + 1) % n;
               
              if(polygon.get(i).getY() == p.getY()) decrease++;
 
            // Check if the line segment from 'p' to
            // 'extreme' intersects with the line
            // segment from 'polygon[i]' to 'polygon[next]'
            if (doIntersect(polygon.get(i), polygon.get(next), p, extreme))
            {
                // If the point 'p' is collinear with line
                // segment 'i-next', then check if it lies
                // on segment. If it lies, return true, otherwise false
                if (orientation(polygon.get(i), p, polygon.get(next)) == 0)
                {
                    return onSegment(polygon.get(i), p,
                                    polygon.get(next));
                }
 
                count++;
            }
            i = next;
        } while (i != 0);
       
          // Reduce the count by decrease amount
          // as these points would have been added twice
          count -= decrease;
 
        // Return true if count is odd, false otherwise
        return (count % 2 == 1); // Same as (count%2 == 1)
    }
    
}


