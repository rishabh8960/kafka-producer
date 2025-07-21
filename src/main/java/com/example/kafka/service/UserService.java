package com.example.kafka.service;

import com.example.kafka.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private DynamoDbClient dynamoDbClient;
    public void saveUser(User user){
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("userId", AttributeValue.builder().s(user.getUserId()).build());
        item.put("name", AttributeValue.builder().s(user.getName()).build());
        PutItemRequest request =PutItemRequest.builder().tableName("user").item(item).build();
        dynamoDbClient.putItem(request);
    }
    public User getUser(String userId){
        GetItemRequest request = GetItemRequest.builder().tableName("user").key(Map.of("userId", AttributeValue.builder().s(userId).build())).build();
        Map<String,AttributeValue> item = dynamoDbClient.getItem(request).item();
        return null;
    }

}
