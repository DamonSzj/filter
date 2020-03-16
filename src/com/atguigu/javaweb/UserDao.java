package com.atguigu.javaweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    //模拟数据库制造几条用户数据
    private static Map<String, User> userMap;
    private static List<Authority> authorities;

    static {
        userMap = new HashMap<>();
        authorities = new ArrayList<>();
        Authority authority1 = new Authority("Article-1", "/app/article-1.jsp");
        Authority authority2 = new Authority("Article-2", "/app/article-2.jsp");
        Authority authority3 = new Authority("Article-3", "/app/article-3.jsp");
        Authority authority4 = new Authority("Article-4", "/app/article-4.jsp");
        authorities.add(authority1);
        authorities.add(authority2);
        authorities.add(authority3);
        authorities.add(authority4);
        userMap.put("AAA", new User("AAA", authorities.subList(0, 2)));
        userMap.put("BBB", new User("BBB", authorities.subList(2, 4)));

    }

    //获取用户信息(包含该用户对应的权限信息)
    public User getUserInfo(String userName) {
        return userMap.get(userName);
    }

    //修改权限
    public void update(String userName, List<Authority> authorities) {
        userMap.get(userName).setAuthorities(authorities);
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public List<Authority> getAuthorities(String[] urls) {
        List<Authority> authorityList = new ArrayList<>();
        for (Authority authority : authorities) {
            if (urls != null) {
                for (String url : urls) {
                    if (url.equals(authority.getUrl())) {
                        authorityList.add(authority);
                    }
                }
            }
        }
        return authorityList;
    }
}
