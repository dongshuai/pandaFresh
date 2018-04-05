package com.pf.app.api.mapper;

import com.pf.app.api.model.PfOrder;
import com.pf.app.api.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PfOrderMapper extends MyMapper<PfOrder> {


    List<PfOrder> selectOderList(@Param("status") Integer status);
}