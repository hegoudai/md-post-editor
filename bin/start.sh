#!/bin/bash
PWD="$(pwd)"
MPECFGDIR="${PWD}/../conf/,classpath:application.yml"
STATICDIR="file:${PWD}/../static/"
MPEMAIN=com.goudai.mpe.MpeApplication
java -cp "../lib/*" ${MPEMAIN} --spring.config.location=${MPECFGDIR} --spring.resou rces.static-locations=${STATICDIR}