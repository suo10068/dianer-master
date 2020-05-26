package com.dianer.kafka;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-20 22:00
 **/
@Log4j2
public class KafkaUtil {

    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * @param topic
     * @param msg
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void send(String topic, String msg) throws ExecutionException, InterruptedException {
        SendResult<String, String> sendResult = kafkaTemplate.send(topic, msg).get();
        if (sendResult.getRecordMetadata() != null) {
            log.info("生产者成功发送消息到" + sendResult.getProducerRecord().topic() + "-> "
                    + sendResult.getProducerRecord().value());
        }
    }

    public void send2(String topic, String msg) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, msg);
        future.addCallback(
                result -> log.info("生产者成功发送消息到topic:{} partition:{}的消息",
                        result.getRecordMetadata().topic(), result.getRecordMetadata().partition()),
                ex -> log.error("生产者发送消失败，原因：{}", ex.getMessage()));
    }


}


