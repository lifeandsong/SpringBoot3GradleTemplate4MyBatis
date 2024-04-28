#!/bin/sh

nohup java -jar -javaagent:/home/swmaestro/scouter/scouter.agent.jar -Dscouter.config=/home/swmaestro/scouter/scouter.dev.conf -Dspring.profiles.active=dev /home/swmaestro/SpringBoot3GradleTemplate.jar 1> /dev/null 2>&1 &

echo SpringBoot3GradleTemplate has been started !
