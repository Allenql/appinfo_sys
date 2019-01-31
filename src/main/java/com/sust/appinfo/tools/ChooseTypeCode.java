package com.sust.appinfo.tools;

public class ChooseTypeCode {

    /**
     * 选择类型代码
     * @param typeName
     * @return
     */
    public static String chooseTypeCode(String typeName){
        String typeCode = "";
        if(typeName.equals("用户类型")){
            typeCode = "USER_TYPE";
        }
        if(typeName.equals("APP状态")){
            typeCode = "APP_STATUS";
        }
        if(typeName.equals("所属平台")){
            typeCode = "APP_FLATFORM";
        }
        if(typeName.equals("发布状态")){
            typeCode = "PUBLISH_STATUS";
        }
        return typeCode;
    }
}
