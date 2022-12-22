insert into CATEGORIES (ID, DESCRIPTION) values (1, 'MOBILE');
insert into CATEGORIES (ID, DESCRIPTION) values (2, 'DESKTOP PC');
insert into CATEGORIES (ID, DESCRIPTION) values (3, 'MONITORS');

insert into CUSTOMERS (ID, ADDRESS, AGE, CUSTOMERCATEGORY, EMAIL, FIRSTNAME, LASTNAME) values (1, '3583 Tennessee Avenue', 48, 'BUSINESS', 'c.giannacoulis@gmail.com','Constantinos', 'Giannacoulis');
insert into CUSTOMERS (ID, ADDRESS, AGE, CUSTOMERCATEGORY, EMAIL, FIRSTNAME, LASTNAME) values (2, '221B Baker St., London', 36, 'INDIVIDUAL', 'spyros.arguroiliopoulos@gmail.com','Spyros', 'Argyroiliopoulos');
insert into CUSTOMERS (ID, ADDRESS, AGE, CUSTOMERCATEGORY, EMAIL, FIRSTNAME, LASTNAME) values (3, '1600 Pennsylvania Avenue, Washington, D.C', 38, 'INDIVIDUAL', 'chrisperis@gmail.com','Christos', 'Peristeris');

insert into PRODUCTS (ID, NAME, PRICE, SERIAL, CATEGORY_ID) values (1, 'Apple iPhone 12 Pro 5G 512GB', 1629, 'SN1000-0101', 1);
insert into PRODUCTS (ID, NAME, PRICE, SERIAL, CATEGORY_ID) values (2, 'Apple iPhone 12 Pro Max 5G 512GB', 1749, 'SN1000-0102', 1);
insert into PRODUCTS (ID, NAME, PRICE, SERIAL, CATEGORY_ID) values (3, 'Samsung Galaxy S21 Ultra', 1479.99, 'SN1100-0101', 1);
insert into PRODUCTS (ID, NAME, PRICE, SERIAL, CATEGORY_ID) values (4, 'Samsung Galaxy S20 Ultra', 1199, 'SN1100-0102', 1);


insert into ORDERS (ID, COST, PAYMENTMETHOD, SUBMITDATE, CUSTOMER_ID) values (1, 4457, 'WIRE_TRANSFER', parsedatetime('14-12-2021 18:47:52.69', 'dd-MM-yyyy HH:mm:ss.SS'), 1);
insert into ORDERS (ID, COST, PAYMENTMETHOD, SUBMITDATE, CUSTOMER_ID) values (2, 1199, 'WIRE_TRANSFER', parsedatetime('14-12-2021 20:17:32.54', 'dd-MM-yyyy HH:mm:ss.SS'), 1);
insert into ORDERS (ID, COST, PAYMENTMETHOD, SUBMITDATE, CUSTOMER_ID) values (3, 1749, 'CREDIT_CARD', parsedatetime('14-12-2021 18:47:52.32', 'dd-MM-yyyy HH:mm:ss.SS'), 2);
insert into ORDERS (ID, COST, PAYMENTMETHOD, SUBMITDATE, CUSTOMER_ID) values (4, 1479.99, 'CASH', parsedatetime ('15-12-2021 13:05:21.34', 'dd-MM-yyyy HH:mm:ss.SS'), 3);


insert into ORDER_ITEMS (ID, PRICE, QUANTITY, ORDER_ID, PRODUCT_ID) values (1, 3258, 2, 1, 1);
insert into ORDER_ITEMS (ID, PRICE, QUANTITY, ORDER_ID, PRODUCT_ID) values (2, 1199, 1, 2, 1);
insert into ORDER_ITEMS (ID, PRICE, QUANTITY, ORDER_ID, PRODUCT_ID) values (3, 1199, 1, 3, 2);
insert into ORDER_ITEMS (ID, PRICE, QUANTITY, ORDER_ID, PRODUCT_ID) values (4, 1479.99, 1, 4, 3);

