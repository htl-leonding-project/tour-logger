#!/usr/bin/env bash
docker compose stop
docker container prune -f
docker image prune -f
docker rmi -f $(docker images -aq)
