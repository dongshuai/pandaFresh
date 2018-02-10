/**
 * DoTransactional.java
 * cn.knet.keyword.cpservice.service
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   v1.0	 2014-7-15 		zzjin
 *
 * Copyright (c) 2014, 北龙中网(北京)科技有限责任公司 All Rights Reserved.
*/

package com.pf.app.api.annotation;

import java.lang.annotation.*;

/**
 * <b>ClassName:</b> DoTransactional <br>
 * <b>Reason:</b><br>
 * @version 1.0
 * @Date 2014-7-15 下午2:13:57
 * @since 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ReadOnly {
	
}

