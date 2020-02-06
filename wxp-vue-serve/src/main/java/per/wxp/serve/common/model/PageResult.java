package per.wxp.serve.common.model;

import java.util.List;

public class PageResult {
    private List<?> list;

    private Integer total;

    public List<?> getData() {
        return list;
    }

    public void setData(List<?> list) {
        this.list = list;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageResult [list=" + list + ", total=" + total + "]";
    }
}
