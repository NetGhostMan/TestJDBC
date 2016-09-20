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
  
  
  
  
  
  
  
  
  
  
  
  
  