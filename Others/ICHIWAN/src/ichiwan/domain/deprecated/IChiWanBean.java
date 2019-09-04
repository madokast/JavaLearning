package ichiwan.domain.deprecated;

/**
 * see ichiwan.properties
 */


public class IChiWanBean {
    private String defaultPage;
    private String defaultRows;

    public String getDefaultPage() {
        return defaultPage;
    }

    public void setDefaultPage(String defaultPage) {
        this.defaultPage = defaultPage;
    }

    public String getDefaultRows() {
        return defaultRows;
    }

    public void setDefaultRows(String defaultRows) {
        this.defaultRows = defaultRows;
    }

    @Override
    public String toString() {
        return "IChiWanBean{" +
                "defaultPage='" + defaultPage + '\'' +
                ", defaultRows='" + defaultRows + '\'' +
                '}';
    }
}
