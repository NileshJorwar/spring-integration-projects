#!/bin/bash
echo "Hi nilesh"
echo "Bi"


## Create Exchange
curl -i -u guest:guest -H "content-type:application/json" -XPUT -d'{"type":"direct","durable":true}' http://localhost:15672/api/exchanges/%2F/testexchange

## Access the API of RabbitMQ
curl -i -u guest:guest http://localhost:15672/api

## Vhost
curl -i -u guest:guest http://localhost:15672/api/vhosts

curl -i -u guest:guest "http://localhost:15672/api/channels?sort=message_stats.publish_details.rate&sort_reverse=true&columns=name,message_stats.publish_details.rate,message_stats.deliver_get_details.rate"

## Create testHost in localhost rabbitmq

curl -i -u guest:guest -H "content-type:application/json" -XPUT http://localhost:15672/api/vhosts/testhost

## List the Queues
curl -i -u guest:guest http://localhost:15672/api/queues

## List the Exchanges
curl -i -u guest:guest http://localhost:15672/api/exchanges

## Create the Exchanges
curl -i -u guest:guest -H "content-type:application/json" -XPUT -d'{"type":"direct","durable":true}' http://localhost:15672/api/exchanges/%2F/testexchange

## Delete the Exchange

curl -i -u guest:guest -H "content-type:application/json" -XDELETE http://localhost:15672/api/exchanges/%2F/testexchange

## Delete the QUeue
curl -i -u guest:guest -H "content-type:application/json" -XDELETE http://localhost:15672/api/queues/%2F/testqueue

## Get the Overview
curl -i -u guest:guest t -XGET http://localhost:15672/api/overview

## Get the nodes
curl -i -u guest:guest t -XGET http://localhost:15672/api/nodes

## get the server definitions -- exchanges, queues, bindings, users, virtual hosts, permissions, topic permissions, and parameters
curl -i -u guest:guest t -XGET http://localhost:15672/api/definitions
curl -i -X GET http://guest:guest@localhost:15672/api/definitions
curl -i GET http://guest:guest@localhost:15672/api/definitions
curl -v -H "content-type:application/json" -X POST -d "${}" http://guest:guest@localhost:15672/api/definitions
