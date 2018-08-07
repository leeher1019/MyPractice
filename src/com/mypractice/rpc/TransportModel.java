package com.mypractice.rpc;

import java.io.Serializable;

/**
 * 数据传输模型
 */

public class TransportModel implements Serializable {
    private static final long serialVersionUID = -1L;

    // 返回结果
    private Object result;

    // 对象
    private Object object;

    // 方法名
    private String methodName;

    // 参数类型
    private Class<?>[] paramTypes;

    // 参数
    private Object[] params;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
