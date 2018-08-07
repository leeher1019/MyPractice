package com.mypractice.rpc;

import java.io.Serializable;

/**
 * ���ݴ���ģ��
 */

public class TransportModel implements Serializable {
    private static final long serialVersionUID = -1L;

    // ���ؽ��
    private Object result;

    // ����
    private Object object;

    // ������
    private String methodName;

    // ��������
    private Class<?>[] paramTypes;

    // ����
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
