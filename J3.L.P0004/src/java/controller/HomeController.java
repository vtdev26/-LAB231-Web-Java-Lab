/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ArticleDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ArticleModel;

/**
 *
 * @author s1tha
 */
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ArticleDAO articleDAO = new ArticleDAO();

        try {
            //get most and five recent article
            ArticleModel mostRecentArticle = articleDAO.findRecentArticle(1).get(0);
            request.setAttribute("mostRecentArticle", mostRecentArticle);
            request.setAttribute("articleModel", mostRecentArticle);

            ArrayList<ArticleModel> fiveRecentArticle = articleDAO.findRecentArticle(5);
            request.setAttribute("fiveRecentArticle", fiveRecentArticle);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
