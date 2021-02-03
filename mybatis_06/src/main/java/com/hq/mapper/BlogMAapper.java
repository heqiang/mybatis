package com.hq.mapper;

import com.hq.pojo.Blog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

public interface BlogMAapper {

    int addBlog(Blog blog);

    List<Blog> blogList(Map<String, String> map);
}
