/********************************************************
 * Copyright © 2014 HuJiang.com. All rights reserved.
 *
 * @Title: Transmit.java
 * @Prject: libMsgLayer
 * @Package: com.yeshj.pacman.annotation
 * @Description: packing and transcoding the classware of hujiang.com.
 *                 http://class.hujiang.com
 *
 * @author: zhangxinyu
 * @date: 2014年12月18日 下午6:10:34
 * @version: V1.0
 ********************************************************/
package com.yeshj.pacman.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to transmit field's value via JMS.
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Transmit {

	// Key of JMS entity.
	public String key() default "";
}
