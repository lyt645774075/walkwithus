package cn.walkwithus.support.constants;

import com.google.common.base.Preconditions;

/**
 * @author yangtao.lyt
 * @version $Id: Direction, v 0.1 2016-01-30 23:44 yangtao.lyt Exp $
 */
public enum Direction {

    RECEIVE(1, "收到"),

    OUTPUT(2, "支出"),

    ;

    private Integer code;

    private String label;


    Direction(Integer code, String label){
        this.code = code;
        this.label = label;
    }


    public static Direction getDirectionByCode(Integer code){

        Preconditions.checkNotNull(code);

        for(Direction direction : values()){
            if(direction.getCode().equals(code)){
                return direction;
            }
        }

        throw new IllegalArgumentException("无效的code,不能获取Direction. code=" + code);
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
