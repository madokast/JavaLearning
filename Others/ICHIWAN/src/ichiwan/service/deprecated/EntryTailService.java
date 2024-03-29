package ichiwan.service.deprecated;

import ichiwan.domain.EntryTail;
import ichiwan.domain.PageBean;
import ichiwan.domain.PageBeanForm;

import java.util.List;

public interface EntryTailService {
    /**
     * 全部查询
     *
     * @return List<EntryTail>
     */
    @Deprecated
    List<EntryTail> findAll();

    /**
     * 分页查询
     * 查第n页的数据
     * n从1开始
     *
     * @param n 从n页开始
     * @return List<EntryTail>
     */
    @Deprecated
    List<EntryTail> findLimit10(int n);

    /**
     * 分页10时，总页数
     *
     * @return 总页数
     */
    @Deprecated
    int pageNumberLimit10();

    /**
     * 分页的页数。每页显示limit条
     *
     * @param limit 每页显示条数
     * @return 总页数
     */
    @Deprecated
    int pageNumberLimit(int limit);

    /**
     * 根据校验好的PageBeanForm 查询得到PageBean<EntryTail>
     * @param pageBeanForm 以检验
     * @return PageBean<EntryTail>
     */
    @Deprecated
    PageBean<EntryTail> findByPageBeanForm(PageBeanForm pageBeanForm);

    /**
     * 获得默认的 PageBeanForm
     * 属性见 ichiwan.properties
     * @return 默认的 PageBeanForm
     */
    @Deprecated
    PageBeanForm getDefaultPageBeanForm();
}
