package com.itheima.cfg;

/**
 * 用于封装执行的SQL语句和结果类型的全限定类名
 */
public class Mapper {
    private String queryString;//SQL
    private String resultType;//实体类的全限定类名

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getQueryString() {
        return queryString;
    }

    public String getResultType() {
        return resultType;
    }
}
