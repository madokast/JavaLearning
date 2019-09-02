package ichiwanTest.dao;

import ichiwan.dao.EntryDao;
import ichiwan.dao.EntryDaoImpl;
import ichiwan.domain.Entry;
import org.junit.Test;

import java.util.List;

public class EntryDaoTest {
    @Test
    public void testFindAll(){
        final EntryDao entryDao = new EntryDaoImpl();
        final List<Entry> entryList = entryDao.findAll();
        System.out.println(entryList);
    }
}
