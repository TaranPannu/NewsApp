package com.example.rv1;

public class example_item {
    String text;
    String image;
    String url;
    public example_item(String T,String im,String u){
        text=T;
        image=im;
        url=u;
    }
    public String getText(){
        return text;
    }

    public String getImage() {
        return image;
    }
    public String getUrl(){
        return url;
    }
}
