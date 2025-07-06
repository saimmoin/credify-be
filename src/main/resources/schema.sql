create database credify;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    national_id VARCHAR(30) UNIQUE,
    date_of_birth DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE financial_profiles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    employment_status ENUM('EMPLOYED', 'SELF_EMPLOYED', 'UNEMPLOYED', 'STUDENT', 'RETIRED'),
    monthly_income DECIMAL(10,2),
    monthly_expenses DECIMAL(10,2),
    current_debt DECIMAL(10,2),
    assets_value DECIMAL(10,2),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE credit_scores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    score INT CHECK (score BETWEEN 300 AND 850),
    risk_level ENUM('LOW', 'MEDIUM', 'HIGH'),
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE loan_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    loan_type VARCHAR(50),
    loan_amount DECIMAL(10,2),
    start_date DATE,
    end_date DATE,
    status ENUM('PAID', 'DEFAULTED', 'ACTIVE'),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE payment_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    payment_date DATE,
    amount_paid DECIMAL(10,2),
    payment_type ENUM('LOAN', 'CREDIT_CARD', 'UTILITY', 'OTHER'),
    was_late BOOLEAN,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE credit_card_usage (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    card_limit DECIMAL(10,2),
    current_balance DECIMAL(10,2),
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

INSERT INTO users (name, email, phone, national_id, date_of_birth)
VALUES 
('Ali Raza', 'ali.raza@example.com', '03121234567', '42101-1234567-1', '1992-06-15'),
('Fatima Khan', 'fatima.khan@example.com', '03221234567', '42201-7654321-2', '1989-03-22');

INSERT INTO financial_profiles (user_id, employment_status, monthly_income, monthly_expenses, current_debt, assets_value)
VALUES 
(1, 'EMPLOYED', 120000, 50000, 30000, 1000000),
(2, 'SELF_EMPLOYED', 180000, 70000, 100000, 2000000);

INSERT INTO credit_scores (user_id, score, risk_level)
VALUES 
(1, 720, 'LOW'),
(2, 580, 'MEDIUM');

INSERT INTO loan_history (user_id, loan_type, loan_amount, start_date, end_date, status)
VALUES 
(1, 'Car Loan', 800000, '2021-01-01', '2024-01-01', 'PAID'),
(1, 'Home Loan', 3000000, '2023-03-01', '2028-03-01', 'ACTIVE'),
(2, 'Business Loan', 1000000, '2022-07-01', '2025-07-01', 'DEFAULTED');

INSERT INTO payment_history (user_id, payment_date, amount_paid, payment_type, was_late)
VALUES 
(1, '2024-06-01', 15000, 'LOAN', FALSE),
(1, '2024-05-01', 15000, 'LOAN', TRUE),
(2, '2024-06-01', 5000, 'UTILITY', FALSE),
(2, '2024-05-01', 5000, 'UTILITY', FALSE);


INSERT INTO credit_card_usage (user_id, card_limit, current_balance)
VALUES 
(1, 200000, 50000),
(2, 150000, 120000);



