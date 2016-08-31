CREATE TABLE `TestServlet`.`user` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `account` INT NULL,
  `sex` INT NULL,
  PRIMARY KEY (`Id`));

  
  INSERT INTO `TestServlet`.`user` ( `username`, `password`, `account`, `sex`) VALUES ('ZhangSan', '123456', '0', '0');