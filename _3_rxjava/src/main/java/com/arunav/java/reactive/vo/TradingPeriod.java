
package com.arunav.java.reactive.vo;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class TradingPeriod {

    @Expose
    private Long end;
    @Expose
    private Long gmtoffset;
    @Expose
    private Long start;
    @Expose
    private String timezone;

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public Long getGmtoffset() {
        return gmtoffset;
    }

    public void setGmtoffset(Long gmtoffset) {
        this.gmtoffset = gmtoffset;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

}
