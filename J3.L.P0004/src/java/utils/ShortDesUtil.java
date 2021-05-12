/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author s1tha
 */
public class ShortDesUtil {

    public String getShortDes(String content) {
        if (content.length() > 350) {
            return content.substring(0, 350) + "...";
        }
        return content;
    }
}
