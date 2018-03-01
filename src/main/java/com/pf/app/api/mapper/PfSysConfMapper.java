package com.pf.app.api.mapper;

import com.pf.app.api.model.PfSysConf;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.cache.decorators.LruCache;
import tk.mybatis.mapper.common.Mapper;
@CacheNamespace(
        size=100,eviction=LruCache.class,implementation=org.mybatis.caches.ehcache.EhcacheCache.class)
public interface PfSysConfMapper extends Mapper<PfSysConf> {
}