
package com.arunav.java.reactive.vo;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CurrentTradingPeriod {

    @Expose
    private Post post;
    @Expose
    private Pre pre;
    @Expose
    private Regular regular;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Pre getPre() {
        return pre;
    }

    public void setPre(Pre pre) {
        this.pre = pre;
    }

    public Regular getRegular() {
        return regular;
    }

    public void setRegular(Regular regular) {
        this.regular = regular;
    }

}
