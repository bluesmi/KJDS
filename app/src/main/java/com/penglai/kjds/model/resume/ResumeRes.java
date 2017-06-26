package com.penglai.kjds.model.resume;


import java.io.Serializable;
import java.util.List;

/**
 * Created by m199 on 2017/6/26.
 */

public class ResumeRes  implements Serializable{
    private PersionInfo persion;
    private List<EduBgInfo>  eduBgInfoList;
    private List<WorkExpInfoReq> workExp;
    private Assess assess;

    public ResumeRes(PersionInfo persion, List<EduBgInfo> eduBgInfoList, List<WorkExpInfoReq> workExp, Assess assess) {
        this.persion = persion;
        this.eduBgInfoList = eduBgInfoList;
        this.workExp = workExp;
        this.assess = assess;
    }

    public ResumeRes() {
    }

    public PersionInfo getPersion() {
        return persion;
    }

    public void setPersion(PersionInfo persion) {
        this.persion = persion;
    }

    public List<EduBgInfo> getEduBgInfoList() {
        return eduBgInfoList;
    }

    public void setEduBgInfoList(List<EduBgInfo> eduBgInfoList) {
        this.eduBgInfoList = eduBgInfoList;
    }

    public List<WorkExpInfoReq> getWorkExp() {
        return workExp;
    }

    public void setWorkExp(List<WorkExpInfoReq> workExp) {
        this.workExp = workExp;
    }

    public Assess getAssess() {
        return assess;
    }

    public void setAssess(Assess assess) {
        this.assess = assess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResumeRes resumeRes = (ResumeRes) o;

        if (persion != null ? !persion.equals(resumeRes.persion) : resumeRes.persion != null)
            return false;
        if (eduBgInfoList != null ? !eduBgInfoList.equals(resumeRes.eduBgInfoList) : resumeRes.eduBgInfoList != null)
            return false;
        if (workExp != null ? !workExp.equals(resumeRes.workExp) : resumeRes.workExp != null)
            return false;
        return assess != null ? assess.equals(resumeRes.assess) : resumeRes.assess == null;

    }

    @Override
    public int hashCode() {
        int result = persion != null ? persion.hashCode() : 0;
        result = 31 * result + (eduBgInfoList != null ? eduBgInfoList.hashCode() : 0);
        result = 31 * result + (workExp != null ? workExp.hashCode() : 0);
        result = 31 * result + (assess != null ? assess.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResumeRes{" +
                "persion=" + persion +
                ", eduBgInfoList=" + eduBgInfoList +
                ", workExp=" + workExp +
                ", assess=" + assess +
                '}';
    }
}
