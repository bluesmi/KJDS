package com.penglai.kjds.utils;

import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.model.resume.EduBgInfo;
import com.penglai.kjds.model.resume.PersionInfo;
import com.penglai.kjds.model.user.UserData;
import com.penglai.kjds.model.user.UserImagePath;
import com.penglai.kjds.model.user.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by m199 on 2017/6/10.
 */

public class JSONUtil {
    public static UserData getUserData(Map map){
        UserData userData = new UserData();
        userData.setUserId((String) map.get("userId"));
        userData.setUserName((String) map.get("userName"));
        userData.setToken((String) map.get("token"));
        return userData;
    }

    public static UserInfo getUserInfo(Map data) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId((String) data.get("userId"));
        userInfo.setNickName((String) data.get("nickName"));
        userInfo.setUserImage((String) data.get("userImage"));
        userInfo.setSchool((String) data.get("school"));
        userInfo.setBirthday((String) data.get("birthday"));
        userInfo.setSex((String) data.get("sex"));
        return userInfo;
    }

    public static UserImagePath getUserImagePath(Map data) {
        UserImagePath userImage = new UserImagePath();
        userImage.setPath((String) data.get("path"));
        return userImage;
    }

    public static PersionInfo getPersionInfo(Map data) {
        PersionInfo persionInfo = new PersionInfo();
        persionInfo.setUserID((String) data.get("UserID"));
        persionInfo.setHeadPicID((String) data.get("HeadPicID"));
        persionInfo.setTrueName((String) data.get("TrueName"));
        persionInfo.setEducation((String) data.get("Education"));
        persionInfo.setAddress((String) data.get("Address"));
        persionInfo.setBirthDate((String) data.get("BirthDate"));
        persionInfo.setGender((String) data.get("Gender"));
        persionInfo.setPhone((String) data.get("Phone"));
        persionInfo.setEmail((String) data.get("Email"));
        return persionInfo;
    }


    public static List<CompanyInfo> getCompanyInfoList( List<Map> data) {
        List<CompanyInfo> companyIfoList = new ArrayList<CompanyInfo>();
        for (Map map: data) {
                companyIfoList.add(getCompanyIfo(map));
        }

        return companyIfoList;
    }

    public static CompanyInfo getCompanyIfo(Map data){
        String id = (String) data.get("ID");
        String companyName = (String) data.get("CompanyName");
        String logoID = (String) data.get("LogoID");
        String typeID = (String) data.get("TypeID");
        String isRecommend = (String) data.get("IsRecommend");
        String title = (String) data.get("Title");
        String orgProp = (String) data.get("OrgProp");
        String eduRequire = (String) data.get("EduRequire");
        String workExperience = (String) data.get("WorkExperience");
        String salary = (String) data.get("Salary");
        String address = (String) data.get("Address");
        String startTime = (String) data.get("StartTime");
        String endTime = (String) data.get("EndTime");
        String state = (String) data.get("State");
        CompanyInfo companyInfo = new CompanyInfo(id, companyName, logoID, typeID, isRecommend,
                title, orgProp, eduRequire, workExperience, salary, address, startTime, endTime, state);
        return companyInfo;
    }

    public static List<EduBgInfo> getEduBgInfoList(List<Map> data) {
        List<EduBgInfo> eduBgInfoList = new ArrayList<EduBgInfo>();
        for (Map map:data) {
            eduBgInfoList.add(getEduBgInfo(map));
        }

        return eduBgInfoList;
    }

    public static EduBgInfo getEduBgInfo(Map map) {
        EduBgInfo eduBgInfo = new EduBgInfo();
        eduBgInfo.setID((String) map.get("ID"));
        eduBgInfo.setAcademy((String) map.get("Academy"));
        eduBgInfo.setUserID((String) map.get("UserID"));
        eduBgInfo.setSchoolName((String) map.get("SchoolName"));
        eduBgInfo.setProfessional((String) map.get("Professional"));
        eduBgInfo.setStartTime((String) map.get("StartTime"));
        eduBgInfo.setEndTime((String) map.get("EndTime"));
        return eduBgInfo;
    }
}
