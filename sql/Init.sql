//sql scripts for creating tables for MonthLimit and ExpenseTransaction

CREATE DATABASE solva;
GRANT ALL PRIVILEGES ON DATABASE  "solva" TO postgres;

CREATE TABLE month_limit(
    m_limit_id SERIAL PRIMARY KEY,
    month_limit NUMERIC,
    currency ENUM('RUB', 'USD', 'EUR')
);

CREATE TABLE expense_transaction(
    e_tran_id SERIAL PRIMARY KEY,
    currency ENUM('RUB', 'USD', 'EUR'),
    name VARCHAR

);