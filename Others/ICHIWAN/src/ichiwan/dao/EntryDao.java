package ichiwan.dao;

import ichiwan.domain.Entry;
import ichiwan.domain.EntryForm;

import java.util.List;

public interface EntryDao {
    /**
     * 查询所有项
     *
     * @return 所有项
     */
    List<Entry> findAll();


//    /**
//     * 分页查询
//     * @param start 开始位置，第一个为0
//     * @param number 数目
//     * @return 项目
//     */
//    List<Entry> findPage(int start, int number);

    /**
     * 添加entry项目
     *
     * @param entryForm entry类的表单形式
     */
    void addEntry(EntryForm entryForm);

    /**
     * 删除一条entry by id
     *
     * @param id id
     */
    void deleteEntry(int id);

    /**
     * 查询Entry 通过id
     *
     * @param id id
     * @return entry
     */
    Entry queryEntryById(int id);


    /**
     * 全部entry
     * 包括被删除的
     * @return 总数
     */
    int totalEntry();

    /**
     * 全部entry
     * 但是不包括被删除的
     */
    int totalEntryExcludingDeleted();

    /**
     * 查最后一项的id
     * 当然不包括删除的
     * @return lastId
     */
    int lastId();
}
