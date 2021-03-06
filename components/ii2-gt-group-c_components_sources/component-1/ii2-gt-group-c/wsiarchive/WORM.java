package wsiarchive;

import java.util.*;


// WORM mit unbegrenzter Kapazität
public class WORM implements IArchive {

    private String name;
    private HashMap<WORMItemId, Item> map;

    public WORM(String name) {
        this.name = name;
        this.map = new HashMap<WORMItemId, Item>();
    }
    
    // Namen extrahieren
    public String getName() {
        return this.name;
    }
    
    // Item ins Archiv schreiben
    public IPutResult put(Item item) {
        WORMItemId newId = new WORMItemId();
        this.map.put(newId, item);
        return new OKPutResult(newId);
    }
    
    // Mehrere Items ins Archiv schreiben
    public IPutResultList putMultiple(IItemList items) {
        return items.putAll(this);
    }
    
    // Items aus Archiv auslesen
    public IGetResult get(IItemId id) {
        Item item = this.map.get(id);
        if (item == null) {
            return new NoItemResult();
        } else {
            return new ItemResult(item);
        }
    }

}
