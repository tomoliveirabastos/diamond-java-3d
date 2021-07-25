package renderer.shapes;

import java.awt.*;

public class Tetrahedron {

    private MyPolygon[] polygons;
    private Color color;

    public Tetrahedron(boolean isDecay, MyPolygon... polygons) {
        this.polygons = polygons;
        this.color = new Color(255, 150, 0);
        if(isDecay){
            this.setDecayingPolygonColor();
        }
    }

    public Tetrahedron(MyPolygon... polygons) {
        this.polygons = polygons;
        this.color = new Color(255, 150, 0);
        this.setDecayingPolygonColor();
    }

    public void render(Graphics g) {

        for (MyPolygon poly : this.polygons) {
            poly.render(g);

        }
    }

    private void sortPolygons() {
        MyPolygon.sortPolygons(this.polygons);
    }

    public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees) {
        for (MyPolygon p : this.polygons) {
            p.rotate(CW, xDegrees, yDegrees, zDegrees);
        }

        this.sortPolygons();
    }

    private void setDecayingPolygonColor() {
        double decayFactor = 0.95;

        for (MyPolygon poly : this.polygons) {
            poly.changeColor(this.color);
            int r = (int) (this.color.getRed() * decayFactor);
            int g = (int) (this.color.getGreen() * decayFactor);
            int b = (int) (this.color.getBlue() * decayFactor);

            this.color = new Color(r,g,b);
        }
    }
}
