package com.learn.android.base;

import java.io.Serializable;
/**
 * baseModel 实体信息封装类 所有的实体类或实体层需要继承此类
 * 实现Serializable 是为了实现 组件之间特别是activity 之间 intent传递值的时候能直接传递实体
 * @author JUN jun_dev@qq.com
 * 2015-4-23t下午2:36:52
 * @desciption
 */
public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

}
