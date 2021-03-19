package me.method17.exception.utils.render;

public class Area {
    public int x1, y1, x2, y2;

    public Area(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean mouseIn(int mouseX, int mouseY) {
        return (mouseX > x1 && mouseX < x2) && (mouseY > y1 && mouseY < y2);
    }
}
