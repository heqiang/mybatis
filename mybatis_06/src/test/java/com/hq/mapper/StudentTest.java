package com.hq.mapper;


import com.hq.pojo.Blog;
import com.hq.utils.IDUtils;
import com.hq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class StudentTest {
    @Test
    public void getAllTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMAapper blogMAapper = sqlSession.getMapper(BlogMAapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("犬夜叉");
        blog.setAuthor("hq");
        blog.setContent("测试内容");
        blog.setCreatetime(new Date());
        blog.setViews(22);
        blogMAapper.addBlog(blog);

        Blog blog1 = new Blog();
        blog1.setId(IDUtils.getId());
        blog1.setTitle("骑士十万里");
        blog1.setAuthor("hq");
        blog1.setContent("测试内容");
        blog1.setCreatetime(new Date());
        blog1.setViews(22);
        blogMAapper.addBlog(blog1);

        Blog blog2 = new Blog();
        blog2.setId(IDUtils.getId());
        blog2.setTitle("月亮六便士");
        blog2.setAuthor("hq");
        blog2.setContent("测试内容");
        blog2.setCreatetime(new Date());
        blog2.setViews(22);
        blogMAapper.addBlog(blog2);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void getBlogList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMAapper mapper = sqlSession.getMapper(BlogMAapper.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("author", "hq");
        List<Blog> blogs = mapper.blogList(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

    }

}
