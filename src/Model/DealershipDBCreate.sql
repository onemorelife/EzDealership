CONNECT 'jdbc:derby:DealershipDB;create=true';

-- drop Products table (ignore errors if it doesn't exist)
DROP TABLE Inventory;
DROP TABLE Sales;
DROP TABLE Employees;

-- create Inventory table
CREATE TABLE Inventory
(
        make VARCHAR(20), 
	model VARCHAR(20), 
	stock INT,
	price DOUBLE,
	code VARCHAR(4)
);

-- insert data into Inventory table
INSERT INTO Inventory VALUES
('Toyota', 'RAV4', 7, 26320, 'TRAV');   	

INSERT INTO Inventory VALUES
('Tesla', 'Model X', 5, 108462, 'TSLX'); 

INSERT INTO Inventory VALUES
('Nissan', 'Sentra', 8, 19800, 'NISS'); 

-- view data in Products table
SELECT * FROM Products;

-- create Employees table 
CREATE TABLE Employees 
(
	employeeName VARCHAR(24),
	phone VARCHAR(10),
	email VARCHAR(20),
	department VARCHAR(20),
	salary DOUBLE
)

--insert data into Employees table 
INSERT INTO Employees VALUES 
('John Doe', '4332125678', 'jdoe@example.com', 'Sales', 32000)

INSERT INTO Employees VALUES 
('Jane Doe', '3224785678', 'janedoe@example.com', 'Accounting', 32000)

INSERT INTO Employees VALUES 
('Bob Smith', '6167894342', 'bsmith@example.com', 'Sales', 38000)

-- view data in Employees table
SELECT * FROM Employees;

-- create Employees table 
CREATE TABLE Sales 
(
	code VARCHAR(4),
	quantity INT,
	employeeName VARCHAR(24),
	salesDate VARCHAR(8),
	lease BOOLEAN
)

--insert data into Sales table
INSERT INTO Sales VALUES
('TSLX', 1, 'Bob Smith', '12182015', 1)

INSERT INTO Sales VALUES 
('NISS', 1, 'John Doe', '03152016', 1)

--View data in Sales table 
SELECT * FROM Sales; 
DISCONNECT;