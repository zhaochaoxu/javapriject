package com.it.chaoxu.entity;

/**
 * Created by dell on 2016/6/16.
 */
public class Document {

    private Integer id;
    private String filename;
    private String savename;
    private String md5;
    private Long size;
    private String displaysize;

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", savename='" + savename + '\'' +
                ", md5='" + md5 + '\'' +
                ", size=" + size +
                ", displaysize='" + displaysize + '\'' +
                '}';
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSavename() {
        return savename;
    }

    public void setSavename(String savename) {
        this.savename = savename;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getDisplaysize() {
        return displaysize;
    }

    public void setDisplaysize(String displaysize) {
        this.displaysize = displaysize;
    }



}
