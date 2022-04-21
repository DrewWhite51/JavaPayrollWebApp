/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  drewm
 * Created: Apr 6, 2022
 */

-- DROP TABLE Employee
-- DROP TABLE TimeCard;

-- CREATE TABLE Employee (
--   FirstName VARCHAR(50) NOT NULL,
--   LastName VARCHAR(50) NOT NULL,
--   EmployeeId INT NOT NULL,
--   SSN DOUBLE NOT NULL,
--   UserId VARCHAR(50) NOT NULL,
--   Password VARCHAR(50) NOT NULL,
--   HourlyRate Double,
--   OvertimeRate Double,
--   Salary Double,
--   
--   PRIMARY KEY(EmployeeID) 
-- );


-- INSERT INTO Employee 
--   (FirstName, LastName, EmployeeId, SSN, UserId, Password, HourlyRate, OvertimeRate, Salary)
-- VALUES 
--   ('Drew', 'White', 1, 6789, 'User4', 'user4', NULL, NULL, 100000),
--   ('Dylan', 'White', 2, 5837, 'User2', 'user2', NULL, NULL, 70000),
--   ('Rachael', 'White', 3, 3813, 'User3', 'user3', NULL, NULL, 50000),
--   ('Ali', 'Vanzanr', 4, 3795, 'User1', 'user1', 20, 30, NULL),
--   ('Deonna', 'Hunt', 5, 3859, 'User5', 'user5', 30, 50, NULL),
--   ('Rich', 'White', 6, 4810, 'User6', 'user6', 40, 60, NULL);
-- 
-- 
-- create table TimeCard(
--     TimecardDate VARCHAR(50) NOT NULL,
--     EmployeeId Double NOT NULL,
--     HoursWorked INT NOT NULL,
--     OvertimeHours INT NOT NULL
-- )



-- INSERT INTO TimeCard (
--     TimecardDate, EmployeeId, HoursWorked, OvertimeHours
-- ) VALUES
--     ('2/7/22',4,40,10),
--     ('2/7/22',4,50,10),
--     ('2/7/22',5,60,10),
--     ('2/7/22',6,70,10);

-- SELECT * FROM Employee;

-- select * from TimeCard;

select * from Employee;

