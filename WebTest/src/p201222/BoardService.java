package p201222;

import java.util.List;

public class BoardService {
	BoardDAO boardDAO;
	public BoardService() {
		boardDAO = new BoardDAO();
	}

	public List<ArticleVO> listArticles() {
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}
}
//BoardDAO 클래스의 메서드 이름은 보통 각 메서드들이 실행하는 SQL문에 의해 결정됩니다.
//예를 들어 selectAllArticles() 메서드는 전체 글 정보를 조회하는 SQL문을 실행하므로
//메서드 이름에 selectAll이 들어갑니다.