#!/bin/bash
set -e

OMS_DB_NAME="yf_oms_db"
PMS_DB_NAME="yf_pms_db"
SMS_DB_NAME="yf_sms_db"
UMS_DB_NAME="yf_ums_db"
WMS_DB_NAME="yf_wms_db"

OMS_DB_USER="oms"
PMS_DB_USER="pms"
SMS_DB_USER="sms"
UMS_DB_USER="ums"
WMS_DB_USER="wms"
DB_PASSWORD="yf123456"

mysql -uroot -p"$MYSQL_ROOT_PASSWORD" <<-EOSQL
      CREATE database if NOT EXISTS ${OMS_DB_NAME} default character set utf8mb4 collate utf8mb4_unicode_ci;
      CREATE USER ${OMS_DB_USER}@'%' IDENTIFIED BY '${DB_PASSWORD}';
      flush privileges;
      grant all privileges on ${OMS_DB_NAME}.* to ${OMS_DB_USER}@'%' identified by '${DB_PASSWORD}';
      flush privileges;
      USE ${OMS_DB_NAME};
      SOURCE /sql/yf-mall-oms.sql

      CREATE database if NOT EXISTS ${PMS_DB_NAME} default character set utf8mb4 collate utf8mb4_unicode_ci;
      CREATE USER ${PMS_DB_USER}@'%' IDENTIFIED BY '${DB_PASSWORD}';
      flush privileges;
      grant all privileges on ${PMS_DB_NAME}.* to ${PMS_DB_USER}@'%' identified by '${DB_PASSWORD}';
      flush privileges;
      USE ${PMS_DB_NAME};
      SOURCE /sql/yf-mall-pms.sql

      CREATE database if NOT EXISTS ${SMS_DB_NAME} default character set utf8mb4 collate utf8mb4_unicode_ci;
      CREATE USER ${SMS_DB_USER}@'%' IDENTIFIED BY '${DB_PASSWORD}';
      flush privileges;
      grant all privileges on ${SMS_DB_NAME}.* to ${SMS_DB_USER}@'%' identified by '${DB_PASSWORD}';
      flush privileges;
      USE ${SMS_DB_NAME};
      SOURCE /sql/yf-mall-sms.sql

      CREATE database if NOT EXISTS ${UMS_DB_NAME} default character set utf8mb4 collate utf8mb4_unicode_ci;
      CREATE USER ${UMS_DB_USER}@'%' IDENTIFIED BY '${DB_PASSWORD}';
      flush privileges;
      grant all privileges on ${UMS_DB_NAME}.* to ${UMS_DB_USER}@'%' identified by '${DB_PASSWORD}';
      flush privileges;
      USE ${UMS_DB_NAME};
      SOURCE /sql/yf-mall-ums.sql

      CREATE database if NOT EXISTS ${WMS_DB_NAME} default character set utf8mb4 collate utf8mb4_unicode_ci;
      CREATE USER ${WMS_DB_USER}@'%' IDENTIFIED BY '${DB_PASSWORD}';
      flush privileges;
      grant all privileges on ${WMS_DB_NAME}.* to ${WMS_DB_USER}@'%' identified by '${DB_PASSWORD}';
      flush privileges;
      USE ${WMS_DB_NAME};
      SOURCE /sql/yf-mall-wms.sql
EOSQL