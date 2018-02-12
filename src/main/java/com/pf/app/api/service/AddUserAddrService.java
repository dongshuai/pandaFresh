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
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
@ReadOnly
public class AddUserAddrService extends AbstractService<AddrVo> {

    @Resource
    private PfUserAddrMapper pfUserAddrMapper;

    @Override
    public InterfaceResponse check(AddrVo vo) {

        if (!StringUtils.isNotBlank(vo.getCity())) {
            return error(1020, "所在城市不能为空");
        }
        if (!StringUtils.isNotBlank(vo.getHouseNumber())) {
            return error(1020, "门牌号不能为空");
        }
        if (!StringUtils.isNotBlank(vo.getReceiveAddr())) {
            return error(1020, "收货地址不能为空");
        }
        int type = vo.getType().intValue();
        if (!(type == 1 || type == 2)) {
            return error(1020, "收货地址类型错误");
        }

        if (!StringUtils.isNotBlank(vo.getReceiver())) {
            return error(1020, "收货人不能为空");
        }
        if (!ValidatorUtil.isMobile(vo.getPhoneNumber())) {
            return error(1020, "手机号码错误");
        }

        return null;
    }

    @Override
    public InterfaceResponse executor(AddrVo vo) {

        Long userId = getUserId();
        PfUserAddr pfUserAddr = new PfUserAddr();
        BeanUtils.copyProperties(vo, pfUserAddr);

        PfUserAddr addr = new PfUserAddr();
        addr.setUserId(userId);
        long count = pfUserAddrMapper.selectCount(addr);

        if (vo.getDefaultFlag() && count > 0) {
            logger.debug("添加默认地址,用户有多个地址，将其他地址修改为非默认");
            PfUserAddr entity = new PfUserAddr();
            entity.setDefaultFlag(false);
            Example example = new Example(PfUserAddr.class);
            example.createCriteria().andEqualTo("userId", userId);
            pfUserAddrMapper.updateByExampleSelective(entity, example);
        } else {
            logger.debug("第一次添加地址，设置为默认地址");
            pfUserAddr.setDefaultFlag(true);
        }

        pfUserAddr.setId(IdWorkerFactory.getIdWorker().nextId());
        pfUserAddr.setUserId(userId);
        pfUserAddrMapper.insertSelective(pfUserAddr);
        return success();
}
}
