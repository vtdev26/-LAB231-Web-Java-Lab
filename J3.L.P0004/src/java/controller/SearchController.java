/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constrant.SystemConstrant;
import dao.ArticleDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ArticleModel;

/**
 *
 * @author s1tha
 */
public class SearchController extends HttpServlet {

    ArticleDAO articleDAO = new ArticleDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            ArticleModel mostRecentArticle = articleDAO.findRecentArticle(1).get(0);
            request.setAttribute("mostRecentArticle", mostRecentArticle);

            ArrayList<ArticleModel> fiveRecentArticle = articleDAO.findRecentArticle(5);
            request.setAttribute("fiveRecentArticle", fiveRecentArticle);

            HttpSession session = request.getSession();
            String keyword = session.getAttribute("keyword").toString();

            /*
            **** Paging
             */
            int currentPage = Integer.parseInt(request.getParameter("page"));
            request.setAttribute("currentPage", currentPage);

            int totalItemSearchResult = articleDAO.getSizeOfSearchList(keyword);

            //get number page to paging
            int visiblePage = (int) Math.ceil(totalItemSearchResult / SystemConstrant.MAX_PAGE_ITEM);
            request.setAttribute("visiblePage", visiblePage);

            //offset and limit for paging
            int offset = (currentPage - 1) * SystemConstrant.MAX_PAGE_ITEM;

            //get list article found
            ArrayList<ArticleModel> searchResult = articleDAO.findArticleByTitle(offset, SystemConstrant.MAX_PAGE_ITEM, keyword);
            request.setAttribute("searchResult", searchResult);

            request.getRequestDispatcher("search.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("search.jsp").forward(request, response);
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String keyword = request.getParameter("txtSearch");
            HttpSession session = request.getSession();
            session.setAttribute("keyword", keyword);
            response.sendRedirect("search?page=1");
        } catch (Exception e) {
            request.setAttribute("error", "Sorry! Error occurred");
            request.getRequestDispatcher("search.jsp").forward(request, response);
        }
    }

}
