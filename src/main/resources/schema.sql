CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userAge INT NOT NULL,
    userName varchar2(50) NOT NULL,
    email varchar2(50) NOT NULL
);