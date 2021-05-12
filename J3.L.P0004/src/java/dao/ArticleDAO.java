/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ArticleModel;
import utils.DateConvertUtil;

/**
 *
 * @author s1tha
 */
public class ArticleDAO {

    DBContext db = null;
    Connection conection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    DateConvertUtil df = new DateConvertUtil();
    ArrayList<ArticleModel> articles = null;

    public ArrayList<ArticleModel> findRecentArticle(int numberArticle) throws Exception {
        articles = new ArrayList<>();
        String sql = "SELECT TOP (?) * "
                + "FROM Article ORDER BY Date DESC";
        try {
            db = new DBContext();
            conection = db.getConnection();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setInt(1, numberArticle);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ArticleModel article = new ArticleModel();
                article.setId(resultSet.getInt(1));
                article.setTitle(resultSet.getString(2));
                article.setImage(db.getResource() + resultSet.getString(3));
                article.setContent(resultSet.getString(4));
                article.setDate(resultSet.getDate(5));
                article.setAuthor(resultSet.getString(6));
                articles.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(conection, preparedStatement, resultSet);
        }
        return articles;
    }

    public ArticleModel findArticleByID(int id) throws Exception {
        ArticleModel article = new ArticleModel();
        String sql = "SELECT id, title, image, content, date, author "
                + "FROM Article WHERE id = ? ";
        try {
            db = new DBContext();
            conection = db.getConnection();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                article.setId(resultSet.getInt(1));
                article.setTitle(resultSet.getString(2));
                article.setImage(db.getResource() + resultSet.getString(3));
                article.setContent(resultSet.getString(4));
                article.setDate(resultSet.getDate(5));
                article.setAuthor(resultSet.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(conection, preparedStatement, resultSet);
        }
        return article;
    }

    public ArrayList<ArticleModel> findArticleByTitle(int offset, int limit, String keyword) throws Exception {
        articles = new ArrayList<>();
        db = new DBContext();

        String sql = "SELECT * FROM Article WHERE title like ?"
                + " ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try {
            keyword = "%" + keyword + "%";

            conection = db.getConnection();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setString(1, keyword);
            preparedStatement.setInt(2, offset);
            preparedStatement.setInt(3, limit);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ArticleModel article = new ArticleModel();
                article.setId(resultSet.getInt(1));
                article.setTitle(resultSet.getString(2));
                article.setImage(db.getResource() + resultSet.getString(3));
                article.setContent(resultSet.getString(4));
                article.setDate(resultSet.getDate(5));
                article.setAuthor(resultSet.getString(6));
                articles.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.closeConnection(conection, preparedStatement, resultSet);
        }

        return articles;
    }

    public int getSizeOfSearchList(String keyword) throws Exception {
        articles = new ArrayList<>();
        int count = 0;
        String sql = "SELECT COUNT (id) FROM Article \n"
                + "WHERE title LIKE ?";

        try {
            keyword = "%" + keyword + "%";

            db = new DBContext();
            conection = db.getConnection();
            preparedStatement = conection.prepareStatement(sql);
            preparedStatement.setString(1, keyword);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count;
        } catch (Exception e) {
            return 0;
        } finally {
            db.closeConnection(conection, preparedStatement, resultSet);
        }
    }
}
