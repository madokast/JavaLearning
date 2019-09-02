package ichiwan.dao;

import ichiwan.domain.Entry;
import ichiwan.domain.EntryForm;

import java.util.List;

public interface EntryDao {
    /**
     * 查询所有项
     * @return 所有项
     */
    List<Entry> findAll();

    /**
     * 添加entry项目
     * @param entryForm entry类的表单形式
     */
    void addEntry(EntryForm entryForm);

    /**
     * 删除一条entry by id
     * @param id id
     */
    void deleteEntry(int id);

    /**
     * 查询Entry 通过id
     * @param id id
     * @return entry
     */
    Entry queryEntryById(int id);


}
