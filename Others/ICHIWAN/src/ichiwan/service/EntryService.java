package ichiwan.service;

import ichiwan.domain.*;
import org.apache.catalina.User;

import java.util.List;

public interface EntryService {
    /**
     * 查找所有entry项目
     *
     * @return entry表
     */
    List<Entry> findAll();

    /**
     * 包含统计信息的eentry
     *
     * @return List<EntryTail>
     */
    List<EntryTail> findAllTail();


    /**
     * 分页查询
     * @param start 开始项 注意第一个是0
     * @param maxNumber 最多返回数目
     * @return List<EntryTail>
     */
    List<EntryTail> findTailPage(int start,int maxNumber);

    /**
     * 分页查询，直接来一个 PageBean
     * @param pageBeanForm 已校验
     * @return PageBean<EntryTail>
     */
    PageBean<EntryTail> findByPageBeanForm(PageBeanForm pageBeanForm);

    /**
     * 每页显示rows，计算一共多少页
     * @param rows 每页行数
     * @return 总页数
     */
    int totalPage(int rows);

    /**
     * 保存entry
     * 注意接受的是entryForm
     *
     * @param entryForm entry的孪生表单类
     */
    void addEntry(EntryForm entryForm);

    /**
     * 用id删除一条Entry
     *
     * @param id id 号
     */
    void deleteEntry(int id);

    /**
     * entry 总数
     *
     * @return 总数
     */
    @Deprecated
    int EntryNumber();


    /**
     * entry 总数
     *
     * @return 总数
     */
    int totalNumber();

    /**
     * entry 总数
     *
     * @return 总数
     */
    int totalNumberExcludingDeleted();


    /**
     * 查询entry
     *
     * @param id id
     * @return entry
     */
    Entry queryEntryById(int id);


    /**
     * 查询最后一项的id
     * 当然是未删除的
     * @return lastId
     */
    int lastId();
}
