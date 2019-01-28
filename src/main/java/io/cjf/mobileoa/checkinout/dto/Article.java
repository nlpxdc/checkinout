package io.cjf.mobileoa.checkinout.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class Article {
    private String Title;
    private String Description;
    private String PicUrl;
    private String Url;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Title")
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Description")
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "PicUrl")
    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Url")
    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
