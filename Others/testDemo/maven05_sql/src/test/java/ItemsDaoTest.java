import cn.zrx.domain.Items;
import cn.zrx.domain.cn.zrx.dao.ItemsDao;
import cn.zrx.domain.cn.zrx.dao.impl.ItemsDaoimpl;
import org.junit.Test;

import java.util.List;

public class ItemsDaoTest {
    @Test
    public void testFindAll() throws Exception{
        ItemsDao itemsDao = new ItemsDaoimpl();
        final List<Items> all = itemsDao.findAll();
        System.out.println("all = " + all);
    }
}
