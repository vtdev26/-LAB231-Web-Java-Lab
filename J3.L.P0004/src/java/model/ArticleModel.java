/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import utils.DateConvertUtil;
import utils.ShortDesUtil;

/**
 *
 * @author s1tha
 */
public class ArticleModel {

    private int id;
    private String title;
    private String image;
    private String content;
    private Date date;
    private String author;
    private String shortDescription;

    public ArticleModel() {
    }

    public ArticleModel(int id, String title, String image, String content, Date date, String author, String shortDescription) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.date = date;
        this.author = author;
        this.shortDescription = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return new DateConvertUtil().getDateFormat(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShortDescription() {
        return new ShortDesUtil().getShortDes(content);
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

}
