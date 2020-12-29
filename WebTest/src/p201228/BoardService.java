package p201228;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardService {
	BoardDAO boardDAO;

	public BoardService() {
		boardDAO = new BoardDAO();
	}

	public Map listArticles(Map<String, Integer> pagingMap) {
		Map articlesMap = new HashMap();
		// 전달된 pagingMap을 사용해 글 목록을 조회
		List<ArticleVO> articlesList = boardDAO.selectAllArticles(pagingMap);
		// 테이블에 존재하는 전체 글 수를 조회
		int totArticles = boardDAO.selectTotArticles();
		// 조회된 글 목록을 ArrayList에 저장한 후 다시 articlesMap에 저장
		articlesMap.put("articlesList", articlesList);
		// 전체 글 수를 articlesMap에 저장
		articlesMap.put("totArticles", totArticles);
		//articlesMap.put("totArticles", 170);
		return articlesMap;
	}

	public List<ArticleVO> listArticles() {
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}

	public int addArticle(ArticleVO article) {
		return boardDAO.insertNewArticle(article);
	}

	public ArticleVO viewArticle(int articleNO) {
		ArticleVO article = null;
		article = boardDAO.selectArticle(articleNO);
		return article;
	}

	public void modArticle(ArticleVO article) {
		boardDAO.updateArticle(article);
	}

	// 서버의 이미지 파일도 삭제하기 위함 
	public List<Integer> removeArticle(int articleNO) {
		List<Integer> articleNOList = boardDAO.selectRemovedArticles(articleNO);
		boardDAO.deleteArticle(articleNO);
		return articleNOList;
	}

	public int addReply(ArticleVO article) {
		return boardDAO.insertNewArticle(article);
	}

}