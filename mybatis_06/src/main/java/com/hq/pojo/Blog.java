package com.hq.pojo;


import java.util.Date;

public class Blog {
    private String id;
    private String title;
    private String author;
    private String content;
    private Date  createtime;
    private int views;

    public Blog() {
    }

    public Blog(String id, String title, String author, String content, Date createtime, int views) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.createtime = createtime;
        this.views = views;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", createtime=" + createtime +
                ", views=" + views +
                '}';
    }
}
