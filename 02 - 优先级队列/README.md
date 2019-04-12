# 使用手册

### 运行示例

1、启动 RabbitMQ

```
docker run -d --hostname rabbit --name rabbit -p 5672:5672 -p 15672:15672 -e RABBITMQ_DEFAULT_USER=anoyi -e RABBITMQ_DEFAULT_PASS=Passw0rd rabbitmq:3.7-management
```

2、运行 `Application` (或者执行 `mvn spring-boot:run`)


### 测试

**1、测试优先级队列**

发送优先级低的消息 100 条到 RabbitMQ
```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-direct",
	"routingKey": "direct.queue.priority",
	"priority": 1,
	"content":" hello priority queue! ",
	"count": 100
}'
```

发送优先级高的消息 5 条到 RabbitMQ
```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-direct",
	"routingKey": "direct.queue.priority",
	"priority": 10,
	"content":" >>>>>>>> hello priority queue! ",
	"count": 5
}'
```
