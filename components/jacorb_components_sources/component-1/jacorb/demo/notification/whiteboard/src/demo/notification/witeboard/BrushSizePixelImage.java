package demo.notification.whiteboard;

import java.awt.Color;
import org.apache.log.Logger;
import org.apache.log.Hierarchy;

/**
 * @author Alphonse Bendt
 * @version $Id: BrushSizePixelImage.java,v 1.1 2009-11-09 16:10:48 alexander.bykov Exp $
 */

public class BrushSizePixelImage extends PixelImage {

    Logger logger_ = Hierarchy.getDefaultHierarchy().getLoggerFor("PixelImage");
    
    int brushSize = 1;
    boolean brush = true;
    int width, height;

    public void setBrushSize(int x) {
	brushSize = x;
    }

    public int getBrushSize() {
	return brushSize;
    }

    public BrushSizePixelImage(int width, int height) {
	super(width, height);

	logger_.debug("init");

	this.width = width;
	this.height = height;
    }
    
    public void setArea(int x, int y, int r, int g, int b) {
	for ( int xi = x - brushSize; xi <= x+brushSize; xi++ )
	    for ( int yi = y - brushSize; yi<=y+brushSize; yi++) {
		if ( xi >= 0 && yi >= 0 && xi < width && yi < height)
		    super.setPixel(xi,yi,r,g,b);
	    }
    }
    
    public void setPixel(int x, int y, int red, int green, int blue) {
	Color color = new Color(red,green,blue);
	if (brush) {
	    setArea(x,y,red,green,blue);
	} else {
	    super.setPixel(x,y,red,green,blue);
	}
    }    
    
    public void clearAll() {
	for(int x=0;x<width;x++) {
	    for(int y=0;y<height;y++) {
		super.setPixel(x,y,0,0,0);
	    }
	}
    }
} // BPixelImage
