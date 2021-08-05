#!/usr/bin/env bash
ROOT_DIR=$(cd .. && pwd)
docker-compose up -d
DCK_CASSANDRA=$(docker-compose ps | grep cassandra1 | awk '{print $1}')
echo "################################################"
echo $DCK_CASSANDRA

while [[ $(docker exec -it $DCK_CASSANDRA sh -c "cqlsh --username=cassandra --password=cassandra -e \"DESC KEYSPACES;\"" | grep -c system) -eq 0 ]]
do
    printf '-'
    sleep 3
done

#docker exec -it $DCK_CASSANDRA sh -c "cqlsh -e \"DROP KEYSPACE blogdb;\""
docker exec -it $DCK_CASSANDRA sh -c "cqlsh --username=cassandra --password=cassandra -e \"CREATE KEYSPACE blogdb WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };\""
docker exec -it $DCK_CASSANDRA sh -c "cqlsh --username=cassandra --password=cassandra -e \"DESC KEYSPACES;\""
docker exec -it $DCK_CASSANDRA sh -c "rm -rf /tmp/*"

cd $ROOT_DIR/db/migrations/
for file in *.cql
do
	echo " --- migrate ${file} --- "
	docker cp $file $DCK_CASSANDRA:/tmp/${file}
	docker exec -it $DCK_CASSANDRA sh -c "cqlsh --username=cassandra --password=cassandra -k blogdb -f '/tmp/${file}'"
done
docker exec -it $DCK_CASSANDRA sh -c "rm -rf /tmp/*"
