package com.clientui.beans;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;


 public class BookBean {
    private long id;
    private String name;
    private String author;
    private String coverUrl;

    @JsonProperty("copies")
    private Collection<CopyBean> copiesBean;

     public BookBean() {

     }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Collection<CopyBean> getCopiesBean() {
        return copiesBean;
    }

    public void setCopiesBean(Collection<CopyBean> copiesBean) {
        this.copiesBean = copiesBean;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", copiesBean=" + copiesBean +
                '}';
    }
}
