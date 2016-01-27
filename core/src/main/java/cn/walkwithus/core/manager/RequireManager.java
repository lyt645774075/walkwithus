/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.core.manager;

import cn.walkwithus.core.domain.RequireBO;

import java.util.List;

/**
 *
 * 需求管理器
 *
 * @author yangtao.lyt
 * @version $Id: RequireManager, v 0.1 2016-01-17 14:58 yangtao.lyt Exp $
 */
public interface RequireManager {

    public List<RequireBO> queryAll();

    public void createRequire(RequireBO requireBO);


}
