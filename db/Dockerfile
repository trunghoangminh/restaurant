FROM mysql:5.7

ADD dbstart.sh /dbstart.sh
RUN chmod +x /dbstart.sh

ENTRYPOINT ["/dbstart.sh"]
