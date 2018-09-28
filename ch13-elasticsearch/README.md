书中的例子，供参考

~~~
curl -XPOST 'localhost:9200/product/book/1?pretty' -H 'Content-Type: application/json' -d'
{
    "name" : "北京100种小吃",
    "type":"food",
    "postDate" : "2009-11-15",
    "message" : "介绍了北京小吃，如炸酱面，卤煮，驴打滚等"
}
'
~~~

~~~
curl -XGET 'localhost:9200/product/book/1?pretty'
~~~


~~~
curl -XPUT 'localhost:9200/product/book/1?pretty' -H 'Content-Type: application/json' -d'
{
    "name" : "北京108种小吃",
    "type":"food",
    "postDate" : "2009-11-15T14:12:12",
    "message" : "介绍了北京小吃，如炸酱面，卤煮，驴打滚等"
}
'
~~~

~~~
curl -XPOST 'localhost:9200/product/book/1/_update?pretty' -H 'Content-Type: application/json' -d'
{
   "doc":{   
   	 "message" : "介绍了北京小吃，如炸酱面，卤煮，驴打滚，还有胶圈等!!!"
    }
}
'
~~~

~~~
curl -XDELETE 'localhost:9200/product/book/1?pretty'
~~~


~~~
curl -XPOST 'localhost:9200/product/book/_search?pretty' -H 'Content-Type: application/json' -d'
{
    "query" : {
        "match": { "message" : "驴打滚"}
    }
}
'
~~~


~~~
curl -XGET 'localhost:9200/product/book/_search?pretty' -H 'Content-Type: application/json' -d'
{
  "query" : {
    "term": { "type" : "food"}
  }
}
'
~~~
