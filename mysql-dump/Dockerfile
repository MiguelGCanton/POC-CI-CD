
FROM mysql:latest
ADD ./mydump.sql /docker-entrypoint-initdb.d/mydump.sql
EXPOSE 3306
CMD ["mysql -u $(MYSQL_USER) -p $(MYSQL_DATABASE) < mydump.sql"]
