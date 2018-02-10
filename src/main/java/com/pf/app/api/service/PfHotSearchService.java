package com.pf.app.api.service;

import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.vo.HotSearchVo;
import org.apache.commons.lang3.StringUtils;

public class PfHotSearchService extends AbstractService<HotSearchVo> {
    @Override
    public InterfaceResponse check(HotSearchVo hotSearchVo) {
        StringUtils.isBlank(hotSearchVo.getWord());
        return null;
    }

    @Override
    public InterfaceResponse executor(HotSearchVo hotSearchVo) {
        return null;
    }
}
