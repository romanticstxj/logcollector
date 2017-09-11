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
>   --deploy-mode cluster \
>   --master &lt;master&gt; \
>   --class com.madhouse.ssp.LogCollector \
>   hdfs://XX/path/to/&lt;application&gt;.jar \
>   hdfs://XX/path/to/&lt;application&gt;.conf
> </pre>

#### Config:
> <pre>
> app {
>   spark {
>     streaming {
>       kafka_max_rate_per_partition = @kafka_max_rate_per_partition@
>       slide_duration = @slide_duration@
>     }
>   }
>
>   kafka {
>     brokers = "@kafka.brokers@"
>     topic = "@kafka.topic@"
>   }
> 
>   zookeeper {
>     servers = "@zookeeper.servers@"
>     offset_base_path = "@zookeeper.offset_base_path@"
>   }
>
>   output {
>     path = "@output.path@"
>     prefix = "@outpath.prefix@"
>     suffix = "@output.suffix@"
>     rotate_interval_ms = @output.rotate_interval_ms@
>   }
>
>   log_type = "@log_type@"  // eg. MEDIABID, DSPBID, IMPRESSION, CLICK, WINNOTICE
> }
> </pre>