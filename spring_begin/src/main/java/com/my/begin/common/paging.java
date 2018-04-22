package com.my.begin.common;

public class paging {
	private Integer displayRowCount=9;      // 출력할 데이터 개수
	
    private Integer rowStart;         // 시작행번호
    private Integer rowEnd;         // 종료행 번호
    
    private Integer totPage;        // 전체 페이수
    private Integer totRow=0;       // 전체 데이터 수
    
    private Integer page;       // 현재 페이지
    private Integer pageStart;       // 시작페이지
    private Integer pageEnd;       // 종료페이지

    public void pageCalculate(Integer total) {
        //getPage();//????
        totRow  = total;
        totPage    = (int) ( total / displayRowCount );
        
        if ( total % displayRowCount > 0 ) totPage++;

        pageStart = (page - (page - 1) % 10) ;
        pageEnd = pageStart + 9;
        if (pageEnd > totPage) pageEnd = totPage; 
        
        rowStart = ((page - 1) * displayRowCount) + 1 ;
        rowEnd = rowStart + displayRowCount -1;
    } 
}
