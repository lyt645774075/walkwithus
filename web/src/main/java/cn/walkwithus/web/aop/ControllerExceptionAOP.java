package cn.walkwithus.web.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yangtao.lyt
 * @version $Id: ControllerExceptionAOP, v 0.1 2016-02-09 21:21 yangtao.lyt Exp $
 */
@Aspect
public class ControllerExceptionAOP {

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionAOP.class);

    @AfterThrowing(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)", throwing = "ex")
    public void logException(Exception ex){
        logger.error("拦截到异常:", ex);
    }

}
