package com.online.shopping.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * Read the appSql.xml and parse the SQL segments into Java map.
 * It also provide get SQL by its id.
 *
 */
@Component
@Scope("singleton")
public class SqlManager {
    Logger logger = Logger.getLogger(getClass());
    
    private Map<String, String> sqlSegmentsMap = new HashMap<String, String>();

    @PostConstruct
    public void initSqlManager()  {
        FileSystemResourceLoader sqlLoader = new FileSystemResourceLoader();
        Resource appSQL = sqlLoader.getResource("classpath:appSql.xml");
        
        SAXReader reader = new SAXReader();
        
        try {
            Document document = reader.read(appSQL.getInputStream());
            Element root = document.getRootElement();
            Iterator<?> elements = root.elementIterator("sql");
            
            while (elements.hasNext()) {
                Element e = (Element) elements.next();
                String id = e.attributeValue("id");
                String sql = e.getText();
                
                sqlSegmentsMap.put(id, sql);
                
                if (logger.isDebugEnabled())
                    logger.debug("---------- ID: " + id + ", SQL: " + StringUtils.trim(sql));
            }//end while
        } catch (DocumentException | IOException e) {
            logger.error("An error happen when reading the appSql.xml. ", e);
            e.getStackTrace();
        }
    }//end init
    
    
    /**
     * Get the SQL that is pre-defined in appSql.xml by using the id as the key.
     * 
     * @param idKey That is defined in appSql.xml and declare in this class at the same time.
     * @return a processed SQL.
     */
    public String getSQL(String idKey) {
        String sql = sqlSegmentsMap.get(idKey);
        return StringUtils.trim(sql);
    }
    
    /**
     * Get the SQL that is pre-defined in appSql.xml by using the id as the key, 
     * and there are some parameters in the SQL need to be replaced. The parameters
     * are indexed such as "{{index}}". They will be replaced with real parameters
     * that are from business logic.
     * 
     * The index number of parameters that are defined in appSql.xml should be sequential.
     * But its position can be random. That mean the max index number must be matched
     * with the length of parameters.
     * 
     * @param idKey That is defined in appSql.xml and declare in this class at the same time.
     * @param parameters That is defined as "{{index}}" in appSql.xml.
     * @return a processed SQL.
     */
    public String getSQL(String idKey, String[] parameters) {
        String sql = sqlSegmentsMap.get(idKey);
        
        if (sql != null && parameters != null) {
            int len = parameters.length;
            
            for (int i = 0; i < len; i++) {
                sql = sql.replaceAll(String.format("\\{\\{%d\\}\\}", i), parameters[i]);
            }//end for
        }//end if
        
        return StringUtils.trim(sql);
    }
    
    //Declare the id as the static variable below
    public static final String SQL_GET_USER_BY_ID = "getUserById";
    public static final String SQL_GET_USERS = "getUsers";
    public static final String SQL_CHECK_RIGHT_FOR_ANALY_COMMENT = "checkRightForAnalyComment";
    public static final String SQL_INSERT_ANALY_COMMENT = "insertAnalyComment";
    public static final String SQL_INSERT_ANALY_COMMENT_REPLY = "insertAnalyCommentReply";
    public static final String SQL_GET_ANALY_COMMENTS = "getAnalyComments";
    public static final String SQL_GET_ANALY_COMMENTS_REPLY = "getAnalyCommentReplies";
    public static final String SQL_DEL_ANALY_COMMENT = "deleteAnalyComment";
    public static final String SQL_DEL_ANALY_COMMENT_REPLY = "deleteAnalyCommentReply";
    public static final String SQL_UPDATE_ANALY_COMMENT = "updateAnalyComment";
    public static final String SQL_UPDATE_ANALY_COMMENT_REPLY = "updateAnalyCommentReply";
    public static final String SQL_GET_REPORT_COMMENT_RECEIVER = "getReportCommentReceiver";
    public static final String SQL_GET_IMAGE_COMMENT_NOTIF = "getImageCommentNotif";
    public static final String SQL_GET_FOLDER_SHARE_NOTIF = "getFolderShareNotif";
    public static final String SQL_GET_REPORT_COMMENT_NOTIF = "getReportCommentNotif";
    public static final String SQL_UPDATE_ANALY_COMMENT_NOTIF_FLAG = "updateNotificationFlagByAnalysisId";
    public static final String SQL_HEATMAP_HLI = "getHLIHeatmapData";
    public static final String SQL_HEATMAP_DEMAND_SUPPLY = "getDemandSupplyHeatmapData";
    public static final String SQL_HEATMAP_DEMAND_SUPPLY_WITH_PHYSICIAN_TYPES = "getDemandSupplyHeatmapDataWithPhysicianTypes";
    public static final String SQL_HEATMAP_POP_GROWTH = "getPoplationGrowthHeatmapData";
    public static final String SQL_BUBBLE_POP_GROWTH = "getPoplationGrowthBubbleData";
    
    public static final String SQL_GET_YEARS_FOR_BUBBLE_POP_GROWTH = "getYearsPoplationGrowthBubble";
    
    //add by lee add multiple physician type 
    public static final String SQL_PHYSICIAN_TYPES = "getPhysicianTypes";
    public static final String SQL_MARKET_FINANCIAL_GRAPH = "getMVFFacilityViewData";
    public static final String SQL_COST_QUALITY_FACILITY_DATA = "getCQFacilityViewData";
    public static final String SQL_COST_QUALITY_HLS_DATA = "getCQHlthSysViewData";
    //add by Marco
    //update image description
    public static final String SQL_UPDATE_IMAGE_DESCRIPTION = "updateImageDescription";
    
    //client group
    public static final String SQL_GET_ALL_PROVIDERS_FOR_CLIENT = "getAllProvidersForClient";
    public static final String SQL_GET_ALL_PROVIDERS_WITH_CONDITION = "getAllProvidersWithCondition";
    public static final String SQL_GET_HOSPS_OF_CLIENT_BY_ANALYSISID = "getHospsOfClientByAnalysisId";
    public static final String SQL_GET_HOSPS_BY_CLIENT_GRP_ID = "getHospsByClientGrpId";
    
    //competitor group
    public static final String SQL_GET_COMPETITORS_BY_FOOTPRINT = "getCompetitorsByFootprint";
    public static final String SQL_GET_COMPETITOR_GROUPS_BY_ANALYSIS_ID = "getCompetitorGroupsByAnalysisId";
    public static final String SQL_GET_COMPETITORS_IN_POOL_BY_ANALYSIS_ID = "getCompetitorsInPoolByAnalysisId";
    
    //footprint
    public static final String SQL_GET_FOOTPRINT_COUNTY_BY_ANALYSIS_ID = "getFootprintCountyByAnalysisId";
    public static final String SQL_GET_FOOTPRINT_CBSA_BY_ANALYSIS_ID = "getFootprintCBSAByAnalysisId";
    public static final String SQL_GET_FOOTPRINT_STATE_BY_ANALYSIS_ID = "getFootprintStateByAnalysisId";
    public static final String SQL_GET_FOOTPRINT_ZIP_BY_ANALYSIS_ID = "getFootprintZipByAnalysisId";
    public static final String SQL_COUNT_PROVIDERS_FOR_FOOTPRINT = "countProvidersForFootprint";
    
    //graph
    public static final String SQL_GET_GRAPH_DEMO_DATA = "getGraphDemoData";
    public static final String SQL_GET_DEMAND_SUPPLY_VS_OCCUPANCY_RATE_VIEWDATA = "getDemandSupplyVsOccupancyRateViewData";
    public static final String SQL_GEN_GET_AFFECT_HOSPS_SQL = "genGetAffectHospsSQL";
    
}
