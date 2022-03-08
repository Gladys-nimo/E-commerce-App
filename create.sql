CREATE DATABASE ecommerce_app;
\c ecommerce_app


CREATE TABLE customers (id SERIAL PRIMARY KEY, name VARCHAR, type VARCHAR, phone_number VARCHAR, order_number VARCHAR);
CREATE TABLE order (id SERIAL PRIMARY KEY, type VARCHAR);
CREATE TABLE product (id SERIAL PRIMARY KEY, type VARCHAR);
CREATE DATABASE ecommerce_app_test WITH TEMPLATE ecommerce_app;
\q