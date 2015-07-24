package com.chen.controllers.myforum;

import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Model;

import com.chen.bean.Bean;

@Path("")
public class ForumController {

    @Get("topic")
    public String getTopics() {
        //显示主帖列表
        return "topiclist";
    }

    @Get("topic/{topicId:[0-9]+}")
    public String showTopic(@Param("topicId") int topicId) {
        //显示单个主帖和它的跟贴
        return "topic";
    }

    @Get("topic/{topicId:[0-9]+}/comment/{commentId:[0-9]+}")
    public String showComment(Model model, @Param("topicId") int topicId, @Param("commentId") int commentId) {
        //显示单个跟贴
        model.add("name", "郭德纲");
        model.add("commentContent", "今天来人不少，我很欣慰啊！");
        return "comment";
    }

    @Post("topic")
    public String createTopic(){
        //创建一个主帖
        return "topic";
    }

    @Post("topic/{topicId:[0-9]+}/comment")
    public String createComment(@Param("topicId") int topicId){
        //创建一个跟贴
        return "comment";
    }
    
    @Get("test")
    public String test(Model model) {
        Bean bean = new Bean();
        bean.setBeanValue("this_is_a_bean");
        model.add("mybean", bean);
        return "test";
    }
    
    @Get("testArray")
    public String testArray(Model model) {
        String[] array = {"111","222","333"};
        model.add("array", array);
        return "test";
    }
}
