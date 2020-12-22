package p201222_2;

import java.util.List;

public class BoardService2 {
	BoardDAO2 boardDAO; //보드다오 변수 선언
	public BoardService2() {
		boardDAO = new BoardDAO2(); //보드다오 객체 생성
	}

	public List<ArticleVO2> listArticles() { //리스트 Articles를 아티클VO로 생성
		List<ArticleVO2> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}
	
	public int addArticle(ArticleVO2 article){
		return boardDAO.insertNewArticle(article);		
	}

}

