package com.pf.app.api.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.mapper.PfUserVoucherMapper;
import com.pf.app.api.mapper.PfUserVoucherRecordMapper;
import com.pf.app.api.model.PfUserRedbagRecord;
import com.pf.app.api.model.PfUserVoucher;
import com.pf.app.api.model.PfUserVoucherRecord;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.vo.VoucherVo;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

@Service
@ReadOnly
public class VoucherListService extends AbstractService<VoucherVo> {
    /**
     * 日志记录
     */
    private static final Logger logger = LoggerFactory.getLogger(VoucherListService.class);
    /**
     * 用户优惠券mapper
     */
    @Resource
    private PfUserVoucherRecordMapper pfUserVoucherRecordMapper;


    @Override
    public InterfaceResponse check(VoucherVo vo) {
        return null;
    }

    @Override
    public InterfaceResponse executor(VoucherVo vo) {

        logger.info("查询用户卡券信息开始");
        Long userId = getUserId();
        Example example = new Example(PfUserVoucherRecord.class);
        example.createCriteria().andEqualTo("userId");
        Page<PfUserVoucherRecord> page = PageHelper.startPage(vo.getPageNum(), vo.getPageSize()).doSelectPage(() -> pfUserVoucherRecordMapper.selectByExample(example));

        Date now = DateUtils.ceiling(new Date(),Calendar.DATE);

        for(PfUserVoucherRecord record:page){
            if (record.getValidEndTime().getTime()>now.getTime()){
                record.setOverdue(true);
            }else {
                record.setOverdue(false);
            }
        }
        logger.info("查询用户卡券信息结束");
        return success(page);
    }
}
