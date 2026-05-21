package com.spring.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectUtil<T> {
    // 总共的页数
    private long totalPages = 0L;
    // 总共的行数
    private long totalRows = 0L;
    // 当前页数
    private long currentPage = 1L;
    // 每页的行数
    private long pageSize = 12L;
    // 当前页的第一行的行号
    private long firstRow = 0L;
    // URL规则
    private String urlRule;
    // 列表数据
    private List<T> lists = new ArrayList();

    public CollectUtil() {
    }

    // 构造函数，指定当前页和每页行数
    public CollectUtil(long currentPage, long pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.calcFirstRow();
    }

    // 构造函数，指定当前页、总行数和每页行数
    public CollectUtil(long currentPage, long totalRows, long pageSize) {
        this.totalRows = totalRows;
        this.currentPage = currentPage < 1L ? 1L : currentPage;
        this.pageSize = pageSize;
        this.calcFirstRow();
        this.calcTotalPages();
    }

    // 判断是否有前一页
    public boolean IsPrev() {
        return this.currentPage > 1L;
    }

    // 获取前一页的URL
    public String getPrevPage() {
        return this.IsPrev() ? this.getUrlPath(this.currentPage - 1L) : "";
    }

    // 判断是否有后一页
    public boolean IsNext() {
        return this.currentPage < this.totalPages;
    }

    // 获取后一页的URL
    public String getNextPage() {
        return this.IsNext() ? this.getUrlPath(this.currentPage + 1L) : "";
    }

    // 获取第一页的URL
    public String getFirstPage() {
        return this.getUrlPath(1L);
    }

    // 获取最后一页的URL
    public String getLastPage() {
        return this.getUrlPath(this.totalPages);
    }

    // 获取页码列表
    public List<PageNumsPojo> getPageNums() {
        long rollPage = 2L; // 当前页左右两侧显示的页码数
        long show_nums = rollPage * 2L + 1L; // 显示的总页码数
        long i = 0L;
        long start = 0L;
        long end = 0L;
        List<PageNumsPojo> result = new ArrayList();
        if (this.totalPages < show_nums) { // 总页码数小于要显示的页码数
            start = 1L;
            end = this.totalPages;
        } else if (this.currentPage < 1L + rollPage) { // 当前页在左侧不足要显示的页码数的范围内
            start = 1L;
            end = show_nums;
        } else if (this.currentPage >= this.totalPages - rollPage) { // 当前页在右侧不足要显示的页码数的范围内
            start = this.totalPages - show_nums;
            end = this.totalPages;
        } else { // 当前页在中间位置
            start = this.currentPage - rollPage;
            end = this.currentPage + rollPage;
        }

        for (i = start; i <= end; ++i) {
            CollectUtil<T>.PageNumsPojo pojo = new CollectUtil.PageNumsPojo();
            pojo.page = i;
            pojo.url = this.getUrlPath(i);
            result.add(pojo);
        }

        return result;
    }

    // 获取指定页码的URL
    protected String getUrlPath(long page) {
        return this.urlRule.replace("{page}", String.valueOf(page));
    }

    // 获取总共的页数
    public long getTotalPages() {
        return this.totalPages;
    }

    // 获取总共的行数
    public long getTotalRows() {
        return this.totalRows;
    }

    // 设置总共的行数，并计算总共的页数
    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
        this.calcTotalPages();
    }

    // 计算总共的页数
    private void calcTotalPages() {
        if (this.totalRows > 0L && this.pageSize > 0L) {
            double ceil = Double.valueOf((double) this.totalRows) / Double.valueOf((double) this.pageSize);
            this.totalPages = Double.valueOf(Math.ceil(ceil)).longValue();
        }
    }

    // 计算当前页的第一行的行号
    private void calcFirstRow() {
        this.firstRow = this.pageSize * (this.currentPage - 1L);
    }

    // 获取当前页的第一行的行号
    public long getFirstRow() {
        return this.firstRow;
    }

    // 获取当前页码
    public long getCurrentPage() {
        return this.currentPage;
    }

    // 设置当前页码，并重新计算当前页的第一行的行号
    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
        this.calcFirstRow();
    }

    // 获取每页的行数
    public long getPageSize() {
        return this.pageSize;
    }

    // 设置每页的行数
    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    // 获取URL规则
    public String getUrlRule() {
        return this.urlRule;
    }

    // 设置URL规则
    public void setUrlRule(String urlRule) {
        this.urlRule = urlRule;
    }

    // 获取列表数据
    public List<T> getLists() {
        return this.lists;
    }

    // 向列表中添加一条数据
    public void add(T obj) {
        this.lists.add(obj);
    }

    // 向列表中添加多条数据
    public void addAll(Collection<T> list) {
        this.lists.addAll(list);
    }

    // 设置列表数据
    public void setLists(List lists) {
        this.lists = lists;
    }

    // 页码POJO类，表示一个页码以及对应的URL
    public class PageNumsPojo {
        private long page; // 页码
        private String url; // URL

        public PageNumsPojo() {
        }

        public long getPage() {
            return this.page;
        }

        public void setPage(long page) {
            this.page = page;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
