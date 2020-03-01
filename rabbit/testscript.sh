#!/bin/bash

JSON= $(cat config.json)
echo $JSON
curl -v -H "content-type:application/json" -XPOST -d '{"rabbit_version":"3.8.2", "queues": {"name":"ChickenFire","vhost":"/","durable":true}}' http://guest:guest@localhost:15672/api/definitions
