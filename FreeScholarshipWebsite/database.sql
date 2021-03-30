-- Create
-- Database: `food`




-- Table structure
CREATE TABLE student_data (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) NOT NULL,
email VARCHAR(50),
password VARCHAR(255) NOT NULL,
reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE scholarship_data (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
father VARCHAR(50) NOT NULL,
mobile VARCHAR(50) NOT NULL,
email VARCHAR(30),
address VARCHAR(255) NOT NULL,
qualification VARCHAR(150) NOT NULL,
photo VARCHAR(255) NOT NULL
);


CREATE TABLE contact (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
email VARCHAR(50),
comment VARCHAR(255) NOT NULL
);


