package renderer.entity;

import renderer.shapes.Tetrahedron;

import java.awt.*;
import java.util.List;

public class Entity implements IEntity {

    private List<Tetrahedron> tetra;

    public Entity(List<Tetrahedron> tetra) {
        this.tetra = tetra;
    }

    @Override
    public void render(Graphics g) {
        for (var t : this.tetra) {
            t.render(g);
        }
    }

    @Override
    public void rotate(boolean CW, double xDegrees, double yDegrees, double zDegrees) {
        for (var t : this.tetra) {
            t.rotate(CW, xDegrees, yDegrees, zDegrees);
        }
    }
}
