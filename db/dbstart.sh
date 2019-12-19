#!/bin/bash
service mysql start

mysql -u root -e "create user 'admin'@'localhost' identified by 'admin';"
mysql -u root -e "create user 'admin'@'%' identified by 'admin';"
mysql -u root -e "grant all privileges on *.* to 'admin'@'localhost' with grant option;"
mysql -u root -e "grant all privileges on *.* to 'admin'@'%' with grant option;"
mysql -u root -e "set password for 'admin'@'localhost' = PASSWORD('admin');"
mysql -u root -e "set password for 'admin'@'%' = PASSWORD('admin');"
mysql -u root -e "create database restaurant;"

# wating forever
tail -F -n0 /etc/hosts
