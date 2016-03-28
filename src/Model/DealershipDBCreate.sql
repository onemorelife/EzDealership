CONNECT 'jdbc:derby:DealershipDB;create=true';

-- drop Products table (ignore errors if it doesn't exist)
DROP TABLE Inventory;
DROP TABLE Sales;
DROP TABLE Employees;

-- create Inventory table
CREATE TABLE Inventory
(
    Make VARCHAR(20), 
	Model VARCHAR(20), 
	Stock INT,
	Price DOUBLE,
	Code VARCHAR(4)
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
	EmployeeName VARCHAR(24),
	Phone VARCHAR(10),
	Email VARCHAR(20),
	Department VARCHAR(20),
	Salary DOUBLE
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
	Code VARCHAR(4),
	Quantity INT,
	EmployeeName VARCHAR(24),
	SalesDate VARCHAR(8),
	Lease BOOLEAN
)

--insert data into Sales table
INSERT INTO Sales VALUES
('TSLX', 1, 'Bob Smith', '12182015', 1)

INSERT INTO Sales VALUES 
('NISS', 1, 'John Doe', '03152016', 1)

--View data in Sales table 
SELECT * FROM Sales; 
DISCONNECT;