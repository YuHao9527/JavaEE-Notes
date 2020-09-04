package com.java.bean;

/**
 * @ClassName Comment
 * @Description 评论
 * @Author 0715-YuHao
 * @Date 2020/9/4 10:11
 */
public class Comment {
    private String info;
    private String username;

    public Comment() {
    }

    public Comment(String info, String username) {
        this.info = info;
        this.username = username;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (info != null ? !info.equals(comment.info) : comment.info != null) return false;
        return username != null ? username.equals(comment.username) : comment.username == null;
    }

    @Override
    public int hashCode() {
        int result = info != null ? info.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "info='" + info + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
