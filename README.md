# To Run

- An instance of ElasticSearch is needed

```
docker run -p 9200:9200 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.10.0
```

- Link to postman collection https://www.getpostman.com/collections/4ebc2994c6ccbe2833bb