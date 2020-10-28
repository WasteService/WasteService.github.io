package myarchive;

import wsiarchive.*;


// Archiv, bei dem erst ein Archiv vollgeschrieben wird, dann das nächste etc.
public class OverflowArchive implements IArchive {

    String name; // Name des Archives

    // Die Archive werden der Reihe nach gefüllt
    public OverflowArchive(String name, IArchiveList archives) {
        this.name = name;
    }

    // Name des Archivs liefern
    public String getName() {
        return this.name;
    }
}
