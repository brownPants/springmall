package com.example.springmall.sample.vo;

public class PageMaker {
	private int allCount; // 전체 게시물 개수
	private int currentPage; // 현재 페이지번호
	private int startRow; // 한 페이지에 시작하는 행
	private int pagePerRow = 10; // 한 페이지에 보여줄 행
	private int lastPage; // 전체 페이지 중 마지막 페이지번호
	private int startPage = 1; // 현재 페이지 블록의 시작페이지
	private int endPage = 10; // 현재 페이지 블록의 마지막페이지
	private boolean prevPage = false; // 이전페이지 화살표
	private boolean nextPage; // 다음페이지 화살표
	private int currentBlock; // 현재 페이지 블록
	private int lastBlock; // 마지막 페이지 블록
	private int blockPerPage;// 블록당 보여질 페이지의 개수
	
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getPagePerRow() {
		return pagePerRow;
	}
	public void setPagePerRow(int pagePerRow) {
		this.pagePerRow = pagePerRow;
	}
	public int getLastPage() {
		return lastPage;
	}
	// 마지막 페이지(전체 페이지)를 구해서 set한다. 전체게시글의 갯수 / 한페이지에 보여줄행
	// 전체게시글의 갯수 나누기 한페이지에 보여줄행이 0보다 크다면 +1 해줌으로써 마지막 페이지를 구한다.
	public void setLastPage(int allCount, int pagePerRow) {
		int lastPage = allCount / pagePerRow;
		if(allCount % pagePerRow != 0) {
			lastPage++;
		}
		this.lastPage = lastPage;
	}
	public int getStartPage() {
		return startPage;
	}
	// 현재 페이지 블록과 블록당 보여질 페이지의 개수를 이용하여 현재 페이지 블록의 시작 페이지를 구한다. ex) "1"2345678910
	public void setStartPage(int currentBlock, int pagePerBlock) {
		int startPage = (currentBlock * pagePerBlock) - (pagePerBlock - 1);
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int lastBlock, int currentBlock) {
		int endPage = 0;
		if (lastBlock == currentBlock) {
			endPage = getLastPage();
		} else {
			endPage = getStartPage();
		}
		this.endPage = endPage;
	}
	public boolean isPrevPage() {
		return prevPage;
	}
	public void setPrevPage(boolean prevPage) {
		this.prevPage = prevPage;
	}
	public boolean isNextPage() {
		return nextPage;
	}
	public void setNextPage(boolean nextPage) {
		this.nextPage = nextPage;
	}
	public int getCurrentBlock() {
		return currentBlock;
	}
	public void setCurrentBlock(int currentBlock) {
		this.currentBlock = currentBlock;
	}
	public int getLastBlock() {
		return lastBlock;
	}
	public void setLastBlock(int lastBlock) {
		this.lastBlock = lastBlock;
	}
	public int getBlockPerPage() {
		return blockPerPage;
	}
	public void setBlockPerPage(int blockPerPage) {
		this.blockPerPage = blockPerPage;
	}
}
