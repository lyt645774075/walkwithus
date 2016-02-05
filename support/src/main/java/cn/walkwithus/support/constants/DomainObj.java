package cn.walkwithus.support.constants;

import com.google.common.base.Preconditions;

/**
 * 领域对象
 *
 * @author yangtao.lyt
 * @version $Id: DomainObj, v 0.1 2016-01-30 23:36 yangtao.lyt Exp $
 */
public enum  DomainObj {

    TEAM(1, "团队"),

    ACTIVITY(2, "活动"),

    USER(3, "用户")

    ;

    private Integer code;

    private String label;


    DomainObj(Integer code, String label){
        this.code = code;
        this.label = label;
    }


    public static DomainObj getDomainObjByCode(Integer code){

        Preconditions.checkNotNull(code);

        for(DomainObj domainObj : values()){
            if(domainObj.getCode().equals(code)){
                return domainObj;
            }
        }

        throw new IllegalArgumentException("无效的code,不能获取DomainObj. code=" + code);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
