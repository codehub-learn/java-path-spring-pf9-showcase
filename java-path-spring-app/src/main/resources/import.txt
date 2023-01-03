insert into CATEGORIES (ID, DESCRIPTION) values (1001, 'MOBILE');
insert into CATEGORIES (ID, DESCRIPTION) values (1002, 'DESKTOP PC');
insert into CATEGORIES (ID, DESCRIPTION) values (1003, 'MONITORS');

insert into CUSTOMERS (ID, ADDRESS, AGE, CUSTOMERCATEGORY, EMAIL, FIRSTNAME, LASTNAME) values (1001, '3583 Tennessee Avenue', 48, 'BUSINESS', 'c.giannacoulis@gmail.com','Constantinos', 'Giannacoulis');
insert into CUSTOMERS (ID, ADDRESS, AGE, CUSTOMERCATEGORY, EMAIL, FIRSTNAME, LASTNAME) values (1002, '221B Baker St., London', 36, 'INDIVIDUAL', 'spyros.arguroiliopoulos@gmail.com','Spyros', 'Argyroiliopoulos');
insert into CUSTOMERS (ID, ADDRESS, AGE, CUSTOMERCATEGORY, EMAIL, FIRSTNAME, LASTNAME) values (1003, '1600 Pennsylvania Avenue, Washington, D.C', 38, 'INDIVIDUAL', 'chrisperis@gmail.com','Christos', 'Peristeris');

insert into PRODUCTS (ID, NAME, PRICE, SERIAL, CATEGORY_ID) values (1001, 'Apple iPhone 12 Pro 5G 512GB', 1629, 'SN1000-0101', 1001);
insert into PRODUCTS (ID, NAME, PRICE, SERIAL, CATEGORY_ID) values (1002, 'Apple iPhone 12 Pro Max 5G 512GB', 1749, 'SN1000-0102', 1001);
insert into PRODUCTS (ID, NAME, PRICE, SERIAL, CATEGORY_ID) values (1003, 'Samsung Galaxy S21 Ultra', 1479.99, 'SN1100-0101', 1001);
insert into PRODUCTS (ID, NAME, PRICE, SERIAL, CATEGORY_ID) values (1004, 'Samsung Galaxy S20 Ultra', 1199, 'SN1100-0102', 1001);


insert into ORDERS (ID, COST, PAYMENTMETHOD, SUBMITDATE, CUSTOMER_ID) values (1001, 4457, 'WIRE_TRANSFER', parsedatetime('14-12-2021 18:47:52.690', 'dd-MM-yyyy HH:mm:ss.SSS'), 1001);
insert into ORDERS (ID, COST, PAYMENTMETHOD, SUBMITDATE, CUSTOMER_ID) values (1002, 1199, 'WIRE_TRANSFER', parsedatetime('14-12-2021 20:17:32.540', 'dd-MM-yyyy HH:mm:ss.SSS'), 1001);
insert into ORDERS (ID, COST, PAYMENTMETHOD, SUBMITDATE, CUSTOMER_ID) values (1003, 1749, 'CREDIT_CARD', parsedatetime('14-12-2021 18:47:52.320', 'dd-MM-yyyy HH:mm:ss.SSS'), 1002);
insert into ORDERS (ID, COST, PAYMENTMETHOD, SUBMITDATE, CUSTOMER_ID) values (1004, 1479.99, 'CASH', parsedatetime('15-12-2021 13:05:21.340', 'dd-MM-yyyy HH:mm:ss.SSS'), 1003);


insert into ORDER_ITEMS (ID, PRICE, QUANTITY, ORDER_ID, PRODUCT_ID) values (1001, 3258, 2, 1001, 1001);
insert into ORDER_ITEMS (ID, PRICE, QUANTITY, ORDER_ID, PRODUCT_ID) values (1002, 1199, 1, 1002, 1001);
insert into ORDER_ITEMS (ID, PRICE, QUANTITY, ORDER_ID, PRODUCT_ID) values (1003, 1199, 1, 1003, 1002);
insert into ORDER_ITEMS (ID, PRICE, QUANTITY, ORDER_ID, PRODUCT_ID) values (1004, 1479.99, 1, 1004, 1003);

