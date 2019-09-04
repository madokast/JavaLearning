package ichiwan.service.deprecated;

import ichiwan.dao.deprecated.EntryTailDao;
import ichiwan.dao.deprecated.EntryTailDaoImpl;
import ichiwan.domain.EntryTail;
import ichiwan.domain.PageBean;
import ichiwan.domain.PageBeanForm;
import ichiwan.web.servlet.utils.IChiWan;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;
import java.util.Properties;

public class EntryTailServiceImpl implements EntryTailService{
    private final EntryTailDao entryTailDao = new EntryTailDaoImpl();
    @Override
    public List<EntryTail> findAll() {
        return entryTailDao.findAll();
    }

    @Override
    public List<EntryTail> findLimit10(int n) {
        return entryTailDao.findLimit10(n);
    }

    @Override
    public int pageNumberLimit10() {
        //业务逻辑应该写在这里
        final int LIMIT = 10;
        final int entryNumber = entryTailDao.entryNumber();
        int page = entryNumber / LIMIT;
        int residual = entryNumber - page * LIMIT ;
        return page + ((residual==0) ? 0 : 1);
    }

    @Override
    public int pageNumberLimit(int limit) {
        final int entryNumber = entryTailDao.entryNumber();
        int page = entryNumber / limit;
        int residual = entryNumber - page * limit ;
        return page + ((residual==0) ? 0 : 1);
    }

    @Override
    public PageBean<EntryTail> findByPageBeanForm(PageBeanForm pageBeanForm) {
        int start = 0;
        int page = 0;
        int limit = 0;
        try {
            limit = Integer.valueOf(pageBeanForm.getRows());
            page = Integer.valueOf(pageBeanForm.getCurrentPage());
        }catch (NumberFormatException e){e.printStackTrace();}

        start = (page-1)*limit;

        final List<EntryTail> entryTailList = entryTailDao.findLimite(start, limit);

//        private int totalCount; //总记录数
//        private int totalPage;  //总页数
//        private List<T> list;  //数据
//        private int currentPage; //当前页数
//        private int rows;  //每页显示行数

        final PageBean<EntryTail> pageBean = new PageBean<>();
        pageBean.setTotalCount(entryTailDao.entryNumber());
        pageBean.setTotalPage(pageNumberLimit(limit));
        pageBean.setList(entryTailList);
        pageBean.setCurrentPage(page);
        pageBean.setRows(limit);

        return pageBean;

    }

    @Override
    public PageBeanForm getDefaultPageBeanForm() {
        PageBeanForm defaultPageBeanForm = new PageBeanForm();
        Properties properties = new Properties();
        try {
            properties.load(IChiWan.class.getClassLoader().getResourceAsStream("ichiwan.properties"));
            BeanUtils.populate(defaultPageBeanForm, properties);

        } catch (Exception ee) {
            ee.printStackTrace();
        }

        return defaultPageBeanForm;
    }
}
