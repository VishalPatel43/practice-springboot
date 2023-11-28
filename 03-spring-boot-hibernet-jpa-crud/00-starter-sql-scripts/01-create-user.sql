-- Drop user first if they exist
DROP USER IF EXISTS 'springstudent'@'127.0.0.1';

-- Now create user with proper privileges
CREATE USER 'springstudent'@'127.0.0.1' IDENTIFIED BY 'springstudent';

-- Grant necessary privileges
GRANT ALL PRIVILEGES ON *.* TO 'springstudent'@'127.0.0.1';
