## Kafka 日志收集器

#### Compile: 
> #####  sbt clean assembly

#### Run: 
> <pre> 
> path/to/spark/bin/spark-submit \
>   --executor-memory Xg \
>   --driver-memory Xg
>   --total-executor-cores X \
>   --executor-cores X \
>   --deploy-mode cluster
>   --conf spark.driver.maxResultSize=Xg \
>   --conf spark.kryoserializer.buffer.max=128m
>   --class path/to/&lt;application-jar&gt; \
>   &lt;hadoop-env&gt; e.g. develop beta production \
>   &lt;application-config-path&gt;
> </pre>

#### Config:
> <pre>
> app {
>   spark {
>     streaming {
>       kafka_max_rate_per_partition = 128
>       slide_duration = 60
>     }
>   }
>
>   kafka {
>     brokers = "10.10.16.25.27:9092,10.10.16.25.28:9092,10.10.16.25.29:9092"
>     topic = "topic_mediabid"
>   }
>
>   zookeeper {
>     servers = "172.16.25.27:2181,172.16.25.28:2181,172.16.25.29:2181"
>     offset_base_path = "/offsets/log_collector/topics"
>   }
>   
>   output {
>     path = "/madssp/bidlogs/media_bid"
>     prefix = "madssp.media_bid"
>     suffix = "log.avro"
>     rotate_interval_ms = 120000
>   }
> 
>   log_type = "MEDIABID"  // eg. MEDIABID, DSPBID, IMPRESSION, CLICK, WINNOTICE
> }
> </pre>