package com.example.multirabbit.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


@Configuration
public class MyRabbitMQCreateConfig {

    @Resource(name = "v2RabbitAdmin")
    private RabbitAdmin v2RabbitAdmin;

    @Resource(name = "v1RabbitAdmin")
    private RabbitAdmin v1RabbitAdmin;

    @PostConstruct
    public void RabbitInit() {
        v2RabbitAdmin.declareExchange(new TopicExchange("exchange.topic.example.new", true, false));
        v2RabbitAdmin.declareQueue(new Queue("queue.example.topic.new", true));
        v2RabbitAdmin.declareBinding(
                BindingBuilder
                        .bind(new Queue("queue.example.topic.new", true))        //Create the queue directly
                        .to(new TopicExchange("exchange.topic.example.new", true, false))    //Create a switch directly to establish an association relationship
                        .with("routing.key.example.new"));    //Specify routing key
    }
}