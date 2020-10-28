package myarchive;

import wsiarchive.*;


// Kurzbeschreibung
public class LimitedArchive implements IArchive{
    private int size;
    
    public LimitedArchive(int size) {
        this.size = size;
    }
}
