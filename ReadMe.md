# RedMansion_NLP数据分析

## ================================

## Introduction

**commonredis** is a fast and lightweight proxy for accessing data center.

## Build

$ git clone https://g.hz.netease.com/kaolaad/common-redis.git

$ cd commonredis

$ mvn clean compile

$ mvn -DskipTests clean package

## Quick Start

$ tar -zxvf common-redis-0.0.1-SNAPSHOT-bin.tar.gz

$ cd common-redis-0.0.1-SNAPSHOT

$ ./script/preLogHandler.sh

$ hadoop fs -copyToLocal $REMOTE_HDFS_PATH $LOCAL_PATH

$ mv $LOCAL_PATH input.dir

$ mkdir -p output.dir

$ ./bin/run.sh

## License

Copyright 2016 rainness individual.

Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
