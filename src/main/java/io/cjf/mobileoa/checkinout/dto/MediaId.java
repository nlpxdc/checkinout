package io.cjf.mobileoa.checkinout.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class MediaId {
    private String mediaId;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "MediaId")
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
