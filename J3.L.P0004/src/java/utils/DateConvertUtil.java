/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author s1tha
 */
public class DateConvertUtil {
    public String getDateFormat(Date date){
        return new SimpleDateFormat("MMM dd yyy '-' HH:mmaa").format(date).toLowerCase();
    }
}
