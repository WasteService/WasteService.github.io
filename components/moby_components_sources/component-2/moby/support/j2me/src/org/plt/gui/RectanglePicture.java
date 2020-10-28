package org.plt.gui;

public class RectanglePicture extends BasicPicture {
    int width;
    int height;
    String style;
    Color color;
    public RectanglePicture(int width, int height, 
			      String style,
			      Color color) {
	setPinhole(width/2, height/2);
	this.width = width;
	this.height = height;
	this.style = style;
	this.color = color;
    }

    public Color getColor() { return this.color; }

    public String getStyle() { return this.style; }

    public int getWidth() { return this.width; }

    public int getHeight() { return this.height; }
	
    public void accept(PictureVisitor visitor, int x, int y) {
	visitor.visit(this, x, y);
    }

}
