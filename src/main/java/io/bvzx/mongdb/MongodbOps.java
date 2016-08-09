package io.bvzx.mongdb;

import com.mongodb.CommandResult;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: MongodbOps
 * @date 2016年06月21日 09:13
 * @Copyright (c) 2015-2020 by caitu99
 */
@Component
public class MongodbOps implements MongodbDao {

    @Autowired
    MongoTemplate mongoTemplate;

    public CommandResult executeCommand(String jsonCommand) {
        return mongoTemplate.executeCommand(jsonCommand);
    }

    public <T> T findOne(Query query, Class<T> entityClass) {
        return mongoTemplate.findOne(query, entityClass);
    }

    public <T> T findOne(Query query, Class<T> entityClass, String collectionName) {
        return mongoTemplate.findOne(query, entityClass, collectionName);
    }

    public boolean exists(Query query, Class<?> entityClass) {
        return mongoTemplate.exists(query, entityClass);
    }

    public boolean exists(Query query, String collectionName) {
        return mongoTemplate.exists(query, collectionName);
    }

    public boolean exists(Query query, Class<?> entityClass, String collectionName) {
        return mongoTemplate.exists(query, entityClass, collectionName);
    }

    public <T> List<T> find(Query query, Class<T> entityClass) {
        return mongoTemplate.find(query, entityClass);
    }

    public <T> List<T> find(Query query, Class<T> entityClass, String collectionName) {
        return mongoTemplate.find(query, entityClass, collectionName);
    }

    public <T> T findById(Object id, Class<T> entityClass) {
        return mongoTemplate.findById(id, entityClass);
    }

    public <T> T findById(Object id, Class<T> entityClass, String collectionName) {
        return mongoTemplate.findById(id, entityClass, collectionName);
    }

    public long count(Query query, Class<?> entityClass) {
        return mongoTemplate.count(query, entityClass);
    }

    public long count(Query query, String collectionName) {
        return mongoTemplate.count(query, collectionName);
    }

    public long count(Query query, Class<?> entityClass, String collectionName) {
        return mongoTemplate.count(query, entityClass, collectionName);
    }

    public void insert(Object objectToSave) {
        mongoTemplate.insert(objectToSave);
    }

    public void insertAll(Collection<? extends Object> objectsToSave) {
        mongoTemplate.insertAll(objectsToSave);
    }

    public void insert(Collection<? extends Object> batchToSave, String collectionName) {
        mongoTemplate.insert(batchToSave, collectionName);
    }

    public void insert(Collection<? extends Object> batchToSave, Class<?> entityClass) {
        mongoTemplate.insert(batchToSave, entityClass);
    }

    public void insert(Object objectToSave, String collectionName) {
        mongoTemplate.insert(objectToSave, collectionName);
    }

    public void save(Object objectToSave) {
        mongoTemplate.save(objectToSave);
    }

    public void save(Object objectToSave, String collectionName) {
        mongoTemplate.save(objectToSave, collectionName);
    }

    public WriteResult remove(Object object) {
        return mongoTemplate.remove(object);
    }

    public WriteResult remove(Object object, String collection) {
        return mongoTemplate.remove(object, collection);
    }

    public WriteResult remove(Query query, String collectionName) {
        return mongoTemplate.remove(query, collectionName);
    }

    public WriteResult remove(Query query, Class<?> entityClass) {
        return mongoTemplate.remove(query, entityClass);
    }

    public WriteResult remove(Query query, Class<?> entityClass, String collectionName) {
        return mongoTemplate.remove(query, entityClass, collectionName);
    }
}
