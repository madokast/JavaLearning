package ichiwan.service;

import ichiwan.domain.Entry;
import ichiwan.domain.EntryForm;
import org.apache.catalina.User;

import java.util.List;

public interface EntryService {
    /**
     * 查找所有entry项目
     * @return entry表
     */
    List<Entry> findAll();

    /**
     * 保存entry
     * 注意接受的是entryForm
     * @param entryForm entry的孪生表单类
     */
    void addEntry(EntryForm entryForm);

    /**
     * 用id删除一条Entry
     * @param id id 号
     */
    void deleteEntry(int id);

    /**
     * entry 总数
     * @return 总数
     */
    int EntryNumber();


    /**
     * 查询entry
     * @param id id
     * @return entry
     */
    Entry queryEntryById(int id);

}
