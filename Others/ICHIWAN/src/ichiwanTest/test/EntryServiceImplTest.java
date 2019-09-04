package ichiwanTest.test;

import ichiwan.domain.Entry;
import ichiwan.domain.EntryTail;
import ichiwan.service.EntryService;
import ichiwan.service.EntryServiceImpl;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.List;

public class EntryServiceImplTest {
    @Test
    public void test(){
        EntryService entryService = new EntryServiceImpl();
        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd");
        final List<Entry> all = entryService.findAll();
        for (int i = 0; i < all.size(); i++) {
            System.out.println(
                    "INSERT INTO entries(dateDone,name,lengthMinute,describing) VALUES (" +
                            "'"+simpleDateFormat.format(all.get(i).getDateDone())+"'," +
                            "'+"+all.get(i).getName()+"+',"+all.get(i).getLengthMinute()+",'"+all.get(i).getDescribing()+"'" +
                            ");"
            );
        }
    }

    @Test
    public void findAllTest(){
        EntryService entryService = new EntryServiceImpl();
        final List<Entry> all = entryService.findAll();
        for (Entry entry : all) {
            System.out.println(entry);
        }
    }

    @Test
    public void findAllTailTest(){
        EntryService entryService = new EntryServiceImpl();
        final List<EntryTail> all = entryService.findAllTail();
        for (EntryTail entryTail : all) {
            System.out.println(entryTail);
        }
    }

    @Test
    public void findTailPageTest(){
        EntryService entryService = new EntryServiceImpl();
        final List<EntryTail> tailPage = entryService.findTailPage(1, 2);
        for (EntryTail entryTail : tailPage) {
            System.out.println(entryTail);
        }
    }
}
