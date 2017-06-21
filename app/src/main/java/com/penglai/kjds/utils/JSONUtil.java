package com.penglai.kjds.utils;

import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.model.resume.AssessInfoRes;
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
        persionInfo.setUserID((String) data.get("userID"));
        persionInfo.setHeadPicID((String) data.get("headPicID"));
        persionInfo.setTrueName((String) data.get("trueName"));
        persionInfo.setEducation((String) data.get("education"));
        persionInfo.setAddress((String) data.get("address"));
        persionInfo.setBirthDate((String) data.get("birthDate"));
        persionInfo.setGender((String) data.get("gender"));
        persionInfo.setPhone((String) data.get("phone"));
        persionInfo.setEmail((String) data.get("email"));
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
        String id = (String) data.get("iD");
        String companyName = (String) data.get("companyName");
        String logoID = (String) data.get("logoID");
        String typeID = (String) data.get("typeID");
        String isRecommend = (String) data.get("isRecommend");
        String title = (String) data.get("title");
        String orgProp = (String) data.get("orgProp");
        String eduRequire = (String) data.get("eduRequire");
        String workExperience = (String) data.get("workExperience");
        String salary = (String) data.get("salary");
        String address = (String) data.get("address");
        String startTime = (String) data.get("startTime");
        String endTime = (String) data.get("endTime");
        String state = (String) data.get("state");
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
        eduBgInfo.setId((String) map.get("iD"));
        eduBgInfo.setAcademy((String) map.get("academy"));
        eduBgInfo.setUserId((String) map.get("userID"));
        eduBgInfo.setSchoolName((String) map.get("schoolName"));
        eduBgInfo.setProfessional((String) map.get("professional"));
        eduBgInfo.setStartTime((String) map.get("startTime"));
        eduBgInfo.setEndTime((String) map.get("endTime"));
        return eduBgInfo;
    }


    public static AssessInfoRes getAssessInfoRes(Map data) {
        AssessInfoRes info = new AssessInfoRes();
        info.setAssessId((String) data.get("assessId"));
        info.setContent((String) data.get("content"));
        return info;
    }
}
