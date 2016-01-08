

package com.online.shopping.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**

 *
 */
public class DateUtil {

    /**
     *  Format the date with "yyyy-MM-dd"
     */
    public static String getCurrentDateSimpleFormat(Date d) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(d);
    }
    
    /**
     *  Format the date with "yyyy-MM-dd HH:mm:ss"
     */
    public static String getFormatDateFull(Date d) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(d);
    }
    
    /**
     *  Format the date with "yyyy-MM-dd HH:mm:ss:SSS"
     */
    public static String getFormatDateALL(Date d) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return df.format(d);
    }
}
