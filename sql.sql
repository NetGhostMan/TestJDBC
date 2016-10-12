CREATE TABLE `TestJDBC`.`user` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `account` INT NULL,
  `sex` INT NULL,
  PRIMARY KEY (`Id`));
  
  

  
  INSERT INTO `TestJDBC`.`user` ( `username`, `password`, `account`, `sex`) VALUES ('ZhangSan', '123456', '0', '0');
  INSERT INTO `TestJDBC`.`user` ( `username`, `password`, `account`, `sex`) VALUES ('Lisi', '123456', '0', '0');
  INSERT INTO `TestJDBC`.`user` ( `username`, `password`, `account`, `sex`) VALUES ('Wangwu', '123456', '0', '0');
  
  
  
  CREATE TABLE `Product` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `ProductName` VARCHAR(100),
  `Inventory` INT,
  PRIMARY KEY (`Id`));

  INSERT INTO `Product` ( `ProductName`, `Inventory`) VALUES ('bread','11');
  INSERT INTO `Product` ( `ProductName`, `Inventory`) VALUES ('milk','8');
  
  
  CREATE TABLE `TestJDBC`.`student` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `number` INT NULL,
  PRIMARY KEY (`Id`));
  
  INSERT INTO `TestJDBC`.`student` ( `name`, `number`) VALUES ('XiaoMing',100);
  INSERT INTO `TestJDBC`.`student` ( `name`, `number`) VALUES ('XiaoLi',101);
  INSERT INTO `TestJDBC`.`student` ( `name`, `number`) VALUES ('XiaoZhao',102);
  
  
  
  
  
  
  
  --建表语句
  
  CREATE TABLE `Product` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ProductName` VARCHAR(45) NULL,
  `Catalog` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));
  CREATE TABLE `User` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `UserName` VARCHAR(45) NULL,
  `Tel` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));
  CREATE TABLE `transaction` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `UserId` INT NOT NULL,
  `ProductId` INT NOT NULL,
  PRIMARY KEY (`ID`));
  
  --测试数据
   INSERT INTO `Product` ( `ProductName`, `Catalog`) VALUES ('shu','haowangdeshu');
   INSERT INTO `Product` ( `ProductName`, `Catalog`) VALUES ('hua','haokandehua');
   INSERT INTO `User` ( `UserName`, `Tel`) VALUES ('Zhang','123123123');
   INSERT INTO `User` ( `UserName`, `Tel`) VALUES ('Wang','234234234');
   INSERT INTO `transaction` ( `UserId`, `ProductId`) VALUES (1,2);
   INSERT INTO `transaction` ( `UserId`, `ProductId`) VALUES (1,1);
   INSERT INTO `transaction` ( `UserId`, `ProductId`) VALUES (2,1);
   INSERT INTO `transaction` ( `UserId`, `ProductId`) VALUES (2,2);
   
   
   
 SELECT u.ID AS UserId,
 
 UserName,ProductName,Tel,
 
 p.ID AS ProductId 
 
 FROM
 
 User u LEFT JOIN transaction up on u.ID = up.UserId
 
 left join 
 
 Product p on 
 
 p.ID = up.ProductId
 
 WHERE u.ID=2;
   
 
 --建表语句
 
--事务测试，建表语句：
CREATE TABLE `Inventory` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ProductName` VARCHAR(45) NULL,
  `Inventory` INT NULL,
  PRIMARY KEY (`ID`));
CREATE TABLE `Order` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `buyer` VARCHAR(45) NULL,
  `ProductName` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));
  
  --数据
  
  INSERT INTO `Inventory` ( `ProductName`, `Inventory`) VALUES ('bag',20);
  INSERT INTO `Inventory` ( `ProductName`, `Inventory`) VALUES ('watch',25);
 --业务
 SELECT `Inventory` FROM `Inventory` WHERE `ProductName` = 'bag';
 UPDATE `Inventory` SET `Inventory`=12 WHERE `ProductName` = 'bag';
 INSERT INTO `Order` ( `buyer`, `ProductName`) VALUES ('zhangshan','bag');
 
--考试题1 的建表语句：
CREATE TABLE `Course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `UserName` VARCHAR(100) NULL,
  `CourseName` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));
  
  --数据
  INSERT INTO `Course` ( `UserName`, `CourseName`) VALUES ('ZhangSan','shuxue');
  INSERT INTO `Course` ( `UserName`, `CourseName`) VALUES ('ZhangSan','yuwen');
  INSERT INTO `Course` ( `UserName`, `CourseName`) VALUES ('LiSi','yuwen');
  INSERT INTO `Course` ( `UserName`, `CourseName`) VALUES ('LiSi','yuwen');
  INSERT INTO `Course` ( `UserName`, `CourseName`) VALUES ('ZhangSan','math');
  --查询
  SELECT `CourseName` FROM `Course` WHERE `UserName` = 'ZhangSan';
  
  DELETE FROM `Course` WHERE `UserName` = 'LiSi' AND  `CourseName` = 'math';
  