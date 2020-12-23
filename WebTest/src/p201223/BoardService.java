package p201223;

import java.util.List;

public class BoardService {
	BoardDAO boardDAO;

	public BoardService() {
		boardDAO = new BoardDAO();
	}

	public List<ArticleVO> listArticles() { //아티클VO를 리스트로 생성한다
		List<ArticleVO> articlesList = boardDAO.selectAllArticles(); 
		//아티클vo로 리스트를 생성하고 보드다오의 쿼리 정보들을 받아와서 아티클리스트에 저장
		return articlesList; //아티클리스트를 리턴
	}

	public int addArticle(ArticleVO article) { 
		//글을 삭제하는 메소드
		return boardDAO.insertNewArticle(article); 
		//보드다오의 insertNewArticle메소드를 리턴
	}

	public ArticleVO viewArticle(int articleNO) {
		ArticleVO article = null;
		article = boardDAO.selectArticle(articleNO);
		return article;
	}
}
