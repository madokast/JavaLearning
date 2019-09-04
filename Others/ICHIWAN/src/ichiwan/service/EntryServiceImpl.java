package ichiwan.service;

import ichiwan.dao.EntryDao;
import ichiwan.dao.EntryDaoImpl;
import ichiwan.domain.*;
import ichiwan.util.Tools;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.ref.ReferenceQueue;
import java.util.*;

public class EntryServiceImpl implements EntryService {
    private final EntryDao entryDao = new EntryDaoImpl();

    @Override
    public void addEntry(EntryForm entryForm) {
        entryDao.addEntry(entryForm);
    }

    @Override
    public List<Entry> findAll() {
        return entryDao.findAll();
    }

    @Override
    public void deleteEntry(int id) {
        entryDao.deleteEntry(id);
    }

    @Override
    @Deprecated
    public int EntryNumber() {
        return entryDao.totalEntry();
    }

    @Override
    public int totalNumber() {
        return entryDao.totalEntry();
    }

    @Override
    public int totalNumberExcludingDeleted() {
        return entryDao.totalEntryExcludingDeleted();
    }

    @Override
    public Entry queryEntryById(int id) {
        return entryDao.queryEntryById(id);
    }

    @Override
    public List<EntryTail> findAllTail() {
        //    private int id;
        //    private Date dateDone;
        //    private String name;
        //    private int lengthMinute;
        //    private String describing;
        final List<Entry> entryList = entryDao.findAll();

        int id = 0;
        Date dateDone = null;
        String name;
        int lengthMinute;
        String describing;


        //public class EntryTail extends Entry{
        //    private static final int HOUR_MINUTE = 60;
        //    private static final int MaximumFractionDigits = 3;
        //    private int relativeDate;
        //    private int totalMinute;
        //    private double averageMinute;
        final List<EntryTail> entryTailList = new ArrayList<>(entryList.size());

        Date startDate = entryList.get(0).getDateDone();//第一天
        int relativeDate = 0;
        int totalMinute = 0;
        double averageMinute = 0.0;

        Map<String, Object> map = new HashMap<>();


        for (int i = 0; i < entryList.size(); i++) {
            map.put("id", entryList.get(i).getId());
            map.put("dateDone", entryList.get(i).getDateDone());
            map.put("name", entryList.get(i).getName());
            map.put("lengthMinute", entryList.get(i).getLengthMinute());
            map.put("describing", entryList.get(i).getDescribing());

            relativeDate = Tools.dateInterval(startDate, entryList.get(i).getDateDone()) + 1;
            totalMinute += entryList.get(i).getLengthMinute();
            averageMinute = ((double) (totalMinute)) / relativeDate;

            map.put("relativeDate", relativeDate);
            map.put("totalMinute", totalMinute);
            map.put("averageMinute", averageMinute);


            EntryTail entryTail = new EntryTail();
            try {
                BeanUtils.populate(entryTail, map);
            } catch (Exception e) {
                e.printStackTrace();
            }

            entryTailList.add(i, entryTail);
        }


        return entryTailList;
    }

    @Override
    public List<EntryTail> findTailPage(int start, int maxNumber) {
        final List<EntryTail> allTail = findAllTail();
        final List<EntryTail> ans = new ArrayList<>(maxNumber);
        int end = Math.min(start + maxNumber, allTail.size());
        for (int i = start; i < end; i++) {
            ans.add(allTail.get(i));
        }

        return ans;
    }

    @Override
    public int totalPage(int rows) {
        final int totalNumberExcludingDeleted = totalNumberExcludingDeleted();
        int totalPage = totalNumberExcludingDeleted / rows;
        return totalPage + ((totalNumberExcludingDeleted - totalPage * rows > 0) ? 1 : 0);
    }

    @Override
    public PageBean<EntryTail> findByPageBeanForm(PageBeanForm pageBeanForm) {
        //form
        //    private String rows;
        //    private String currentPage;

        //bean
        //    private int totalCount; //总记录数
        //    private int totalPage;  //总页数
        //    private List<T> list;  //数据
        //    private int currentPage; //当前页数
        //    private int rows;  //每页显示行数

        int totalCount = 0;
        int totalPage = 0;
        List<EntryTail> list = null;
        int currentPage = 0;
        int rows = 0;

        try {
            currentPage = Integer.valueOf(pageBeanForm.getCurrentPage());
            rows = Integer.valueOf(pageBeanForm.getRows());
        } catch (Exception e) {
            e.printStackTrace();
        }

        totalCount = totalNumberExcludingDeleted();
        totalPage = totalPage(rows);
        list = findTailPage((currentPage - 1) * rows, rows);

        PageBean<EntryTail> pageBean = new PageBean<>();
        Map<String,Object> map = new HashMap<>();

        map.put("totalCount",totalCount);
        map.put("totalPage",totalPage);
        map.put("list",list);
        map.put("currentPage",currentPage);
        map.put("rows",rows);

        try {
            BeanUtils.populate(pageBean,map);
        }catch (Exception e){e.printStackTrace();}


        return pageBean;
    }

    @Override
    public int lastId() {
        return entryDao.lastId();
    }
}
