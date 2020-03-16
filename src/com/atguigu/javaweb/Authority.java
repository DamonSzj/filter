package com.atguigu.javaweb;

import java.util.Objects;

public class Authority {
    //显示到页面上的权限上的名字
    private String displayName;
    //权限对应的URL地址：一权限对应着一个URL，例如 Article_1 -> /app_4/article1.jsp
    private String url;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Authority(String displayName, String url) {
        this.displayName = displayName;
        this.url = url;
    }

    public Authority() {
    }

    @Override
    public String toString() {
        return "Authority{" +
                "displayName='" + displayName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority = (Authority) o;
        return Objects.equals(url, authority.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
