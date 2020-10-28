package myarchive;
import org.junit.*;


public class OverflowArchiveTest extends de.tuebingen.informatik.Test {
    IArchive oa1 = new OverflowArchive("foo", new EmptyArchiveList());
    
    @Test
    publiv void getName() {
        checkExpect(oa1.getName(), "foo");
    }
}
