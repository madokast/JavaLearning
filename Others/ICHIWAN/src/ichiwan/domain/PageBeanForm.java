package ichiwan.domain;

public class PageBeanForm {
    //    private int totalCount; //总记录数
    //    private int totalPage;  //总页数
    //    private List<T> list;  //数据
    //    private int currentPage; //当前页数
    //    private int rows;  //每页显示行数

    private String rows;
    private String currentPage;

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageBeanForm{" +
                "rows='" + rows + '\'' +
                ", currentPage='" + currentPage + '\'' +
                '}';
    }
}
