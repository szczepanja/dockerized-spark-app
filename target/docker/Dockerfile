FROM spark:v3.2.1
ADD 0/dockerized-spark-app_2.12-0.1.0-SNAPSHOT.jar /opt/spark/jars/dockerized-spark-app_2.12-0.1.0-SNAPSHOT.jar
USER root
ENTRYPOINT ["\/opt\/spark\/bin\/spark-submit", "--conf", "spark.jars.ivy=\/tmp\/.ivy", "\/opt\/spark\/jars\/dockerized-spark-app_2.12-0.1.0-SNAPSHOT.jar"]