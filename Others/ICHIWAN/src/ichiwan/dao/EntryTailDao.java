package ichiwan.dao;

import ichiwan.domain.EntryTail;
import ichiwan.domain.PageBean;
import ichiwan.domain.PageBeanForm;

import java.util.List;

public interface EntryTailDao {
    /**
     * 全部查询
     *
     * @return List<EntryTail>
     */
    List<EntryTail> findAll();

    /**
     * 分页查询
     * 从n页开始
     * n从1开始
     *
     * @param n 从n页开始
     * @return List<EntryTail>
     */
    @Deprecated
    List<EntryTail> findLimit10(int n);

    /**
     * entry 总数
     *
     * @return 总数
     */
    int entryNumber();

    /**
     * 分页查询。
     * 从start开始，每页显示limit
     * @param start 开始条
     * @param limit 每页限制
     * @return List<EntryTail>
     */
    List<EntryTail> findLimite(int start,int limit);
}
