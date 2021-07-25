package renderer.shapes;

import renderer.point.MyPoint;
import renderer.point.PointConverter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyPolygon {
    private MyPoint[] points;
    private Color color;

    public MyPolygon(MyPoint... points) {
        this.points = new MyPoint[points.length];
        this.color = Color.red;

        for (int i = 0; i < points.length; i++) {
            MyPoint p = points[i];
            this.points[i] = new MyPoint(p.x, p.y, p.z);
        }
    }

    public MyPolygon render(Graphics g) {
        Polygon poly = new Polygon();
        for (int i = 0; i < points.length; i++) {
            Point p = PointConverter.convertPoint(points[i]);
            poly.addPoint(p.x, p.y);
        }
        g.setColor(this.color);
        g.fillPolygon(poly);

        return this;
    }

    public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees) {
        for (MyPoint p : points) {
            PointConverter.rotateAxisX(p, CW, xDegrees);
            PointConverter.rotateAxisY(p, CW, yDegrees);
            PointConverter.rotateAxisZ(p, CW, zDegrees);
        }
    }

    public double getAverageX(){

        double sum = 0;

        for(MyPoint p : this.points) sum += p.x;

        return sum;
    }
    public static MyPolygon[] sortPolygons(MyPolygon[] polygons){

        List<MyPolygon> polygonList = new ArrayList<>();

        for(MyPolygon poly : polygons){
            polygonList.add(poly);
        }

        Collections.sort(polygonList, new Comparator<MyPolygon>() {
            @Override
            public  int compare(MyPolygon p1, MyPolygon p2){
                double a = p2.getAverageX() - p1.getAverageX();
                return a < 0 ? 1 : -1;
            }
        });

        for(int  i = 0; i < polygons.length; i++){
            polygons[i] = polygonList.get(i);
        }
        return polygons;
    }

    public MyPolygon changeColor(Color color) {
        this.color = color;
        return this;
    }
}
