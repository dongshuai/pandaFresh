package com.pf.app.api.mapper;

import com.pf.app.api.model.PfUserAddr;
import com.pf.app.api.util.MyMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.cache.decorators.LruCache;

@CacheNamespace(
        size=100,eviction=LruCache.class,implementation=org.mybatis.caches.ehcache.EhcacheCache.class)
public interface PfUserAddrMapper extends MyMapper<PfUserAddr> {
}