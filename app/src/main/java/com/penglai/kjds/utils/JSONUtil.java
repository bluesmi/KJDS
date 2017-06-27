package com.penglai.kjds.utils;

import com.penglai.kjds.model.index.Company;
import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.model.index.JobDetail;
import com.penglai.kjds.model.resume.Assess;
import com.penglai.kjds.model.resume.AssessInfoRes;
import com.penglai.kjds.model.resume.EduBgInfo;
import com.penglai.kjds.model.resume.PersionInfo;
import com.penglai.kjds.model.resume.ResumeRes;
import com.penglai.kjds.model.resume.WorkExpInfoReq;
import com.penglai.kjds.model.user.CollectInfo;
import com.penglai.kjds.model.user.DeliverInfo;
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
            companyIfoList.add(getCompanyInfo(map));
        }
        return companyIfoList;
    }

    public static CompanyInfo getCompanyInfo(Map data){
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

    public static JobDetail getJobDetailInfo(Map data) {
         String iD  = (String) data.get("iD");
         String typeID = (String) data.get("typeID");
         String isRecommend = (String) data.get("isRecommend");
         String title = (String) data.get("title");
         String eduRequire = (String) data.get("eduRequire");
         String workExperience = (String) data.get("workExperience");
         String salary = (String) data.get("salary");
         String address = (String) data.get("address");
         String startTime = (String) data.get("startTime");
         String endTime = (String) data.get("endTime");
         String companyName = (String) data.get("companyName");
         String logoID = (String) data.get("logoID");
         String companyId = (String) data.get("companyId");
         String companyNumber = (String) data.get("companyNumber");
         String companyphone = (String) data.get("companyphone");
         String companyAddress = (String) data.get("companyAddress");
         String introduction = (String) data.get("introduction");
         String orgProp = (String) data.get("orgProp");
        String jobResp = (String) data.get("jobResp");
        String employDesc = (String) data.get("employDesc");
        String employAtract = (String) data.get("employAtract");
        JobDetail jobDetail = new JobDetail(iD, typeID, isRecommend,title, eduRequire,
                workExperience, salary, address, startTime, endTime,
                companyName, logoID, companyId, companyNumber, companyphone,
                companyAddress, introduction, orgProp,jobResp,employDesc,employAtract);
        return jobDetail;
    }

    public static List<WorkExpInfoReq> getWorkExpInfoList(List<Map> data) {
        List<WorkExpInfoReq> workExpInfoReqList = new ArrayList<WorkExpInfoReq>();
        for (Map map:data) {
            workExpInfoReqList.add(getWorkExpInfo(map));
        }

        return workExpInfoReqList;
    }

    public static WorkExpInfoReq getWorkExpInfo(Map map) {
         String id = (String) map.get("iD");
         String companyName = (String) map.get("companyName");
         String position = (String) map.get("position");
         String startTime = (String) map.get("startTime");
         String endTime = (String) map.get("endTime");
         String workContent = (String) map.get("workContent");
         String userId = (String) map.get("userID");
        WorkExpInfoReq workInfo = new WorkExpInfoReq( id,  companyName,  position,
                 startTime,  endTime,  workContent,  userId);
        return workInfo;
    }


    public static Company getCompany(Map data) {
         String companyLogo = (String) data.get("companyLogo");
         String companyName  = (String) data.get("companyName");
         String orgProp  = (String) data.get("orgProp");
         String orgPeopleNumber  = (String) data.get("orgPeopleNumber");
         String orgContact  = (String) data.get("orgContact");
         String telphone  = (String) data.get("telphone");
         String address  = (String) data.get("address");
         String introduction  = (String) data.get("introduction");
         String email  = (String) data.get("email");
        Company company = new Company(companyLogo,  companyName,  orgProp,
                 orgPeopleNumber,  orgContact,  telphone,
                 address,  introduction,  email);
        return company;
    }

    public static List<DeliverInfo> getDeliverInfoList(List<Map> deliverInfo) {
        List<DeliverInfo> deliverInfoList = new ArrayList<DeliverInfo>();
        for (Map map:deliverInfo) {
            deliverInfoList.add(getDeliverInfo(map));
        }

        return deliverInfoList;
    }

    public static DeliverInfo getDeliverInfo(Map map) {
         String iD = (String) map.get("iD");
         String companyName = (String) map.get("companyName");
         String logoID = (String) map.get("logoID");
         String typeID = (String) map.get("typeID");
         String isRecommend = (String) map.get("isRecommend");
         String title = (String) map.get("title");
         String orgProp = (String) map.get("orgProp");
         String eduRequire = (String) map.get("eduRequire");
         String workExperience = (String) map.get("workExperience");
         String salary = (String) map.get("salary");
         String address = (String) map.get("address");
         String startTime = (String) map.get("startTime");
         String endTime = (String) map.get("endTime");
         boolean state = (boolean) map.get("state");

        DeliverInfo deliverInfo = new DeliverInfo( iD,  companyName,  logoID,  typeID,  isRecommend,  title,  orgProp,
                 eduRequire,  workExperience,  salary,  address,  startTime,  endTime,  state);
        return deliverInfo;
    }

    public static List<CollectInfo> getCollectInfoList(List<Map> collectInfo) {
        List<CollectInfo> collectInfoList = new ArrayList<CollectInfo>();
        for (Map map:collectInfo) {
            collectInfoList.add(getColectInfo(map));
        }

        return collectInfoList;
    }

    public static CollectInfo getColectInfo(Map map) {
        String iD = (String) map.get("iD");
        String companyName = (String) map.get("companyName");
        String logoID = (String) map.get("logoID");
        String typeID = (String) map.get("typeID");
        String isRecommend = (String) map.get("isRecommend");
        String title = (String) map.get("title");
        String orgProp = (String) map.get("orgProp");
        String eduRequire = (String) map.get("eduRequire");
        String workExperience = (String) map.get("workExperience");
        String salary = (String) map.get("salary");
        String address = (String) map.get("address");
        String startTime = (String) map.get("startTime");
        String endTime = (String) map.get("endTime");
        String state = (String) map.get("state");

        CollectInfo collectInfo = new CollectInfo( iD,  companyName,  logoID,  typeID,  isRecommend,  title,  orgProp,
                eduRequire,  workExperience,  salary,  address,  startTime,  endTime,  state);
        return collectInfo;
    }

    private static Assess getAsses(Map map) {
        String content = (String) map.get("content");
        Assess assess = new Assess(content);
        return assess;
    }

    public static ResumeRes getPreResumeInfo(Map data) {
        ResumeRes resumeRes = new ResumeRes();
        if(null == data.get("persion")){
            resumeRes.setPersion(null);
        }else {
            resumeRes.setPersion(getPersionInfo((Map) data.get("persion")));
        }
        if(null == data.get("eduBg")){
            resumeRes.setEduBgInfoList(null);
        }else {
            resumeRes.setEduBgInfoList(getEduBgInfoList((List<Map>) data.get("eduBg")));
        }
        if(null == data.get("workExp")){
            resumeRes.setWorkExp(null);
        }else {
            resumeRes.setWorkExp(getWorkExpInfoList((List<Map>) data.get("workExp")));
        }
        if(null == data.get("assess")){
            resumeRes.setAssess(null);
        }else {
            resumeRes.setAssess(getAsses((Map)data.get("assess")));
        }
        return resumeRes;
    }


}
