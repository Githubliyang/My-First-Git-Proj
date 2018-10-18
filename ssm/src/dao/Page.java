package dao;

public class Page {

	int pageNow=1;//当前在第一页
	int pageSize=2;//每页显示的数据条数
	int totalCount;//总的记录条数
	int totalPageCount;//总的页数
	int startPos;//开始位置
	public Page(int totalCount, int pageNow) { 
        this.totalCount = totalCount; 
        this.pageNow = pageNow; 
    } 
	public int getTotalPageCount() { 
        totalPageCount = getTotalCount() / getPageSize(); 
        return (totalCount % pageSize == 0) ? totalPageCount  //总页数
                : totalPageCount + 1; 
    } 
   
    public void setTotalPageCount(int totalPageCount) { 
        this.totalPageCount = totalPageCount; 
    } 
   
    public int getPageNow() { 
        return pageNow; 
    } 
   
    public void setPageNow(int pageNow) { 
        this.pageNow = pageNow; 
    } 
   
    public int getPageSize() { 
        return pageSize; 
    } 
   
    public void setPageSize(int pageSize) { 
        this.pageSize = pageSize; 
    } 
   
    public int getTotalCount() { 
        return totalCount; 
    } 
   
    public void setTotalCount(int totalCount) { 
        this.totalCount = totalCount; 
    } 
    /**
     * 取得选择记录的初始位置
     * @return
     */ 
    public int getStartPos() { 
        return (pageNow - 1) * pageSize; 
    } 
   
    public void setStartPos(int startPos) { 
        this.startPos = startPos; 
    } 
}
