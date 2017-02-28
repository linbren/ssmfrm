package net.platform.utils.page;

/**
 * 
 * 
 * 描述 电子档案分页
 * 
 * @author yiting lin
 * @created 2015-3-17 上午11:20:25
 */
public class PageForFile {

    /**
     * 每页最大条数
     */
    public final static int MAX_ROW = 10;
    /**
     * 当前记录序号
     */
    private int index;
    /**
     * 页数
     */
    private int page_num;
    /**
     * 总数
     */
    private int total;
    /**
     * 地址
     */
    private String url;

    public PageForFile(int index, int total, String url) {
        this.index = index;
        this.total = total;
        this.url = url;
        this.page_num = total % MAX_ROW == 0 ? total / MAX_ROW : total
                / MAX_ROW + 1;
    }

    /**
     * 
     * 描述 获取分页
     * 
     * @author yiting lin
     * @created 2015-4-3 下午04:42:55
     * @return
     */
    public String getFooter() {
        // 不足一页 不显示分页信息
        // if (total <= MAX_ROW) {
        // return "";
        // }
        StringBuffer sb = new StringBuffer("");

        sb.append("  <span>共 " + total + "条数据</span>");
        sb.append("  <span>每页显示" + MAX_ROW + "条</span>");
        int num = index / MAX_ROW + 1;// 当前页数
        if (total == 0) {
            num = 0;
        }
        sb.append("  <span>页次" + num + "/" + page_num + "</span>");
        // 不足MAX_ROW页
        if (index != 0) {
            insertTag(sb, 0, "首页");
        } else {
            sb
                    .append("<a href='javascript:void(0);' class='pagination_disable'>首页</a> ");
        }
        if (index - MAX_ROW < total && index - MAX_ROW >= 0) {
            insertTag(sb, index - MAX_ROW, "上一页");
        } else {
            sb
                    .append("<a href='javascript:void(0);' class='pagination_disable'>上一页</a> ");
        }
        if (index + MAX_ROW < total) {
            insertTag(sb, index + MAX_ROW, "下一页");
        } else {
            sb
                    .append("<a href='javascript:void(0);' class='pagination_disable'>下一页</a> ");
        }
        if (index + MAX_ROW <= total) {
            insertTag(sb, (page_num - 1) * MAX_ROW, "尾页");
        } else {
            sb
                    .append("<a href='javascript:void(0);' class='pagination_disable'>尾页</a> ");
        }
        sb.append("<input id='maxrow' type='hidden' value='" + MAX_ROW + "'>");
        sb.append("<input id='url' type='hidden' value='" + url + "'>");
        sb
                .append("<input id='pageNum' type='hidden' value='" + page_num
                        + "'>");
        return sb.toString();
    }

    public void insertTag(StringBuffer sb, int num) {
        int temp = index / MAX_ROW;
        if (num == temp) {
            sb.append(
                    "<a href='javascript:void(0);' class='pagination_current'>"
                            + (num + 1) + "</a> ").append("  ");
        } else {
            sb.append("<a href=" + url + "&startIndex=");
            sb.append(num * MAX_ROW).append(">").append(num + 1).append(
                    "</a>  ");
        }
    }

    public void insertTag(StringBuffer sb, int num, String str) {
        sb.append("<a href=" + url + "&startIndex=");
        sb.append(num).append(">").append(str).append("</a>  ");
    }

    public static void main(String[] args) {
        System.out.println(new PageForFile(10, 10, "http://www.g.cn")
                .getFooter());
        // 输出: 分页:上10页 11 12 13 14 15 16 17 18 19 20 下10页
    }
}
