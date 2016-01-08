
package com.online.shopping.common;


public class Constants {

    public final static String EMPTY = ""; //empty string.
    
    public final static String USER_SESSION = "USER_SESSION"; //session user
    public final static String USER_SESSION_LISTENER = "USER_SESSION_LISTENER";
    
    //request result
    public final static String REQ_SUCCESS = "success";
    public final static String REQ_FAILED = "failed";
    
    public final static String ANALYSIS_REPORT_ID = "ANALYSIS_REPORT_ID"; //analysis report id for new report
    public final static String REPORT_ID = "REPORT_ID"; //report id for new report
    
    public final static String SEPARATOR_SEMICOLON = ";";
    public final static String SEPARATOR_SEMICOLON_WITH_SPACE = "; ";
    public final static String SEPARATOR_FORWARD = "/";
    
    //for peer group type
    public final static String PEER_GRP_TYPE_STANDARD = "standard";
    public final static String PEER_GRP_TYPE_CUSTOM = "custom";
    
    //folder default id
    public final static int FOLDER_DEFAULT_ID = 4;
    
    //teach indicator
    public final static String TEACH_IND_Y = "Teaching";
    public final static String TEACH_IND_N = "Non-teaching";
    
    //Urban Vs Rural 
    public final static String ATTR_URBAN = "URBAN";
    public final static String ATTR_RURAL = "RURAL";
    
    //BUFFER_LENGTH
    public final static int BUFFER_LENGTH = 2048;
    
    public final static String CHARSET_UTF8 = "UTF-8";
    
    //N none new zip/ county/ state/ cbsa
    public final static String N_FOOTPRINT = "N";
    
    //foot print
    public final static String FOOTPRINT_CBSA = "CBSA";
    public final static String FOOTPRINT_STATE = "STATE";
    public final static String FOOTPRINT_COUNTY = "COUNTY";
    public final static String FOOTPRINT_ZIP = "ZIP";
    
    //clientGroup
    public final static String PROVIDER_NUMBER = "providerNumber";
    public final static String PROVIDER_NAME = "providerName";
    public final static String HEALTH_SYSTEM = "healthSystem";
    
    //The parameter name in APP properties.
    public final static String APP_CONFIG_RPTS_COPY_FOR_NEW_USR = "NeedRptsCopyForNewUser";
    
    //Environment setting flag
    public final static String APP_ENV_SETTING = "ENV.SETTING";
    public final static String APP_ENV_LOCAL = "LOCAL";
    
    //Report locked flag
    public final static String FLAG_REPORT_LOCKED = "Y";
    public final static String FLAG_REPORT_UNLOCKED = "N";
    public final static String FLAG_REPORT_EXISTED = "Y";
    public final static String FLAG_REPORT_NOT_EXISTED = "N";
    
    //Notification type id, which is recorded in DB.
    public final static int NOTIFICATION_SESSION_OVERWRITE = 99;// this value is not DB.
    public final static int NOTIFICATION_COMMENTS = 1;
    public final static int NOTIFICATION_SHARE_FOLDER = 2;
    public final static int NOTIFICATION_REMOVE_SHARE_FOLDER = 3;
    public final static int NOTIFICATION_ANALY_COMMENTS = 5;
    
    //
    public final static String IS_VALID_ACCOUNT  = "SUCCESS";
    public final static String ENV_PROD  = "PROD";
    
    //year for getting graph data
    public final static int YEAR_MOST_RECENTLY = 2099;
    
    //invite a user to visit a folder, if the user already exist
    public final static String USER_EXIST_IN_FOLDER = "isExistUsr";
    
    //report view id
    public final static int VIEW_ID_FOR_POPLATION_GROWTH_BUBBLE = 13;
    
}
