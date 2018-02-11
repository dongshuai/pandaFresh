package com.pf.app.api.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.mapper.PfMassageMapper;
import com.pf.app.api.model.PfGoods;
import com.pf.app.api.model.PfMassage;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
@Service
@ReadOnly
public class MessageListService extends AbstractService<MessageVo> {
    /**
     * 日志记录
     */
    private static final Logger logger = LoggerFactory.getLogger(MessageListService.class);

    /**
     * 消息Mapper
     */
    @Resource
    private PfMassageMapper pfMassageMapper;

    @Override
    public InterfaceResponse check(MessageVo messageVo) {
        return null;
    }

    @Override
    public InterfaceResponse executor(MessageVo vo) {

        Example example = new Example(PfMassage.class);
        example.createCriteria().andEqualTo("type",new Byte("1"));
        example.or().andEqualTo("type",new Byte("2")).andEqualTo("userId",getUserId());
        example.orderBy("createTime").desc();
        Page<PfGoods> page = PageHelper.startPage(vo.getPageNum(), vo.getPageSize()).doSelectPage(() -> pfMassageMapper.selectByExample(example));
        return success(page);
    }
}
