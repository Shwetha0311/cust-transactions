INSERT INTO CUSTOMER (id, name) VALUES (11, 'John');
INSERT INTO CUSTOMER (id, name) VALUES (12, 'Tom');
INSERT INTO CUSTOMER (id, name) VALUES (13, 'Wick');


INSERT INTO TRANSACTION (id, cust_id, transaction, TRAN_DATE) VALUES (11, 11, 120, '2022-09-02');
INSERT INTO TRANSACTION (id, cust_id, transaction, TRAN_DATE) VALUES (12, 12, 45, '2022-08-21');

INSERT INTO TRANSACTION (id, cust_id, transaction, TRAN_DATE) VALUES (13, 11, 80, '2022-07-21');
INSERT INTO TRANSACTION (id, cust_id, transaction, TRAN_DATE) VALUES (14, 12, 160, '2022-07-14');

INSERT INTO TRANSACTION (id, cust_id, transaction, TRAN_DATE) VALUES (15, 11, 60, '2022-07-10');
INSERT INTO TRANSACTION (id, cust_id, transaction, TRAN_DATE) VALUES (16, 12, 90, '2022-07-02');

INSERT INTO TRANSACTION (id, cust_id, transaction, TRAN_DATE) VALUES (17, 13, 101, '2022-06-10');
INSERT INTO TRANSACTION (id, cust_id, transaction, TRAN_DATE) VALUES (18, 13, 104, '2022-06-20');