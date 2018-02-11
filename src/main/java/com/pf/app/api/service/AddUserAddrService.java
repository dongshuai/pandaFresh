package com.pf.app.api.service;

import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.mapper.PfUserAddrMapper;
import com.pf.app.api.model.PfUserAddr;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.util.IdWorkerFactory;
import com.pf.app.api.util.ValidatorUtil;
import com.pf.app.api.vo.AddrVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@ReadOnly
public class AddUserAddrService extends AbstractService<AddrVo> {

    @Resource
    private PfUserAddrMapper pfUserAddrMapper;
    @Override
    public InterfaceResponse check(AddrVo vo) {

        if(!StringUtils.isNotBlank(vo.getCity())){
            return error(1020,"所在城市不能为空");
        }
        if(!StringUtils.isNotBlank(vo.getHouseNumber())){
            return error(1020,"门牌号不能为空");
        }
        if(!StringUtils.isNotBlank(vo.getReceiveAddr())){
            return error(1020,"收货地址不能为空");
        }
        int type = vo.getType().intValue();
        if(!(type==1 || type ==2)  ){
            return error(1020,"收货地址类型错误");
        }

        if(!StringUtils.isNotBlank(vo.getReceiver())){
            return error(1020,"收货人不能为空");
        }
        if(!ValidatorUtil.isMobile(vo.getPhoneNumber())){
            return error(1020,"手机号码错误");
        }

        return null;
    }

    @Override
    public InterfaceResponse executor(AddrVo vo) {

        PfUserAddr pfUserAddr = new PfUserAddr();
        BeanUtils.copyProperties(vo,pfUserAddr);
        pfUserAddr.setId(IdWorkerFactory.getIdWorker().nextId());
        pfUserAddr.setUserId(getUserId());
        pfUserAddrMapper.insertSelective(pfUserAddr);
        return success();
    }
}
