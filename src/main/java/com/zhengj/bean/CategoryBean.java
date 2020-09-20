package com.zhengj.bean;

public class CategoryBean extends AbstractRequestBean {

    public String name;
    public String tag;
    public String description;

    @Override
    public void validate(boolean createMode) {
        this.name = checkName(this.name);
        this.tag = checkTag(this.tag);
        this.description = checkDescription(this.description);
    }
}
