CREATE SCHEMA `shotgun` ;

-- START CREATE THE TABLES
CREATE TABLE `shotgun`.`event` (
  `idevent` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `type` INT NULL DEFAULT 0,
  `startdt` DATETIME NULL,
  `enddt` DATETIME NULL,
  PRIMARY KEY (`idevent`),
  UNIQUE INDEX `idevent_UNIQUE` (`idevent` ASC));

  CREATE TABLE `shotgun`.`performer` (
  `idperformer` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `type` INT NULL DEFAULT 0,
  PRIMARY KEY (`idperformer`),
  UNIQUE INDEX `idperformer_UNIQUE` (`idperformer` ASC));

  CREATE TABLE `shotgun`.`actor` (
  `idactor` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `idinstrument` INT NULL,
  PRIMARY KEY (`idactor`),
  UNIQUE INDEX `idactor_UNIQUE` (`idactor` ASC));

  CREATE TABLE `shotgun`.`instrument` (
  `idinstrument` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `category` VARCHAR(200) NULL,
  PRIMARY KEY (`idinstrument`),
  UNIQUE INDEX `idinstrument_UNIQUE` (`idinstrument` ASC));

  ALTER TABLE `shotgun`.`actor` 
ADD INDEX `idinstrument_idx` (`idinstrument` ASC);
ALTER TABLE `shotgun`.`actor` 
ADD CONSTRAINT `idinstrument`
  FOREIGN KEY (`idinstrument`)
  REFERENCES `shotgun`.`instrument` (`idinstrument`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE;

  CREATE TABLE `shotgun`.`sponsor` (
  `idsponsor` INT ZEROFILL NOT NULL,
  `name` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idsponsor`),
  UNIQUE INDEX `idsponsor_UNIQUE` (`idsponsor` ASC));

  CREATE TABLE `shotgun`.`ticket` (
  `idticket` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type` INT NULL,
  PRIMARY KEY (`idticket`),
  UNIQUE INDEX `idticket_UNIQUE` (`idticket` ASC));

  CREATE TABLE `shotgun`.`release` (
  `idrelease` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `date` DATETIME NULL,
  PRIMARY KEY (`idrelease`),
  UNIQUE INDEX `idrelease_UNIQUE` (`idrelease` ASC));

  CREATE TABLE `shotgun`.`location` (
  `idlocation` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `country` VARCHAR(200) NULL,
  `address` VARCHAR(200) NULL,
  PRIMARY KEY (`idlocation`),
  UNIQUE INDEX `idlocation_UNIQUE` (`idlocation` ASC));

  CREATE TABLE `shotgun`.`performer_event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idevent` INT NOT NULL,
  `idperformer` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `id_event_idx` (`idevent` ASC),
  INDEX `idperformer_idx` (`idperformer` ASC),
  CONSTRAINT `idevent`
    FOREIGN KEY (`idevent`)
    REFERENCES `shotgun`.`event` (`idevent`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `idperformer`
    FOREIGN KEY (`idperformer`)
    REFERENCES `shotgun`.`performer` (`idperformer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

	CREATE TABLE `shotgun`.`actor_instrument` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idactor` INT NOT NULL,
  `idinstrument` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `idactor_idx` (`idactor` ASC),
  INDEX `idinstrument_idx` (`idinstrument` ASC),
  CONSTRAINT `idactor`
    FOREIGN KEY (`idactor`)
    REFERENCES `shotgun`.`actor` (`idactor`)
    ON DELETE NO ACTION
    ON UPDATE RESTRICT,
  CONSTRAINT `idinstrument`
    FOREIGN KEY (`idinstrument`)
    REFERENCES `shotgun`.`instrument` (`idinstrument`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

	ALTER TABLE `shotgun`.`actor_instrument` 
DROP FOREIGN KEY `idactor`;
ALTER TABLE `shotgun`.`actor_instrument` 
ADD INDEX `fk_ai_idinstrument_idx` (`idinstrument` ASC);
ALTER TABLE `shotgun`.`actor_instrument` 
ADD CONSTRAINT `f_ai_idactor`
  FOREIGN KEY (`idactor`)
  REFERENCES `shotgun`.`actor` (`idactor`)
  ON DELETE NO ACTION,
ADD CONSTRAINT `fk_ai_idinstrument`
  FOREIGN KEY (`idinstrument`)
  REFERENCES `shotgun`.`instrument` (`idinstrument`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE;

  ALTER TABLE `shotgun`.`performer_event` 
DROP FOREIGN KEY `idevent`,
DROP FOREIGN KEY `idperformer`;
ALTER TABLE `shotgun`.`performer_event` 
ADD CONSTRAINT `fk_pe_idevent`
  FOREIGN KEY (`idevent`)
  REFERENCES `shotgun`.`event` (`idevent`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_pe_idperformer`
  FOREIGN KEY (`idperformer`)
  REFERENCES `shotgun`.`performer` (`idperformer`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  CREATE TABLE `shotgun`.`performer_actor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idactor` INT NOT NULL,
  `idperformer` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_pa_idperformer_idx` (`idperformer` ASC),
  INDEX `fk_pa_idactor_idx` (`idactor` ASC),
  CONSTRAINT `fk_pa_idperformer`
    FOREIGN KEY (`idperformer`)
    REFERENCES `shotgun`.`performer` (`idperformer`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_pa_idactor`
    FOREIGN KEY (`idactor`)
    REFERENCES `shotgun`.`actor` (`idactor`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

	ALTER TABLE `shotgun`.`sponsor` 
CHANGE COLUMN `idsponsor` `idsponsor` INT(11) NOT NULL AUTO_INCREMENT ;

	CREATE TABLE `shotgun`.`event_sponsor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idevent` INT NOT NULL,
  `idsponsor` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_es_idevent_idx` (`idevent` ASC),
  CONSTRAINT `fk_es_idevent`
    FOREIGN KEY (`idevent`)
    REFERENCES `shotgun`.`event` (`idevent`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
	CONSTRAINT `fk_es_idsponsor`
    FOREIGN KEY (`idsponsor`)
    REFERENCES `shotgun`.`sponsor` (`idsponsor`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

	CREATE TABLE `shotgun`.`event_ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idevent` INT NOT NULL,
  `idticket` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_et_idevent_idx` (`idevent` ASC),
  INDEX `fk_et_idticket_idx` (`idticket` ASC),
  CONSTRAINT `fk_et_idevent`
    FOREIGN KEY (`idevent`)
    REFERENCES `shotgun`.`event` (`idevent`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_et_idticket`
    FOREIGN KEY (`idticket`)
    REFERENCES `shotgun`.`ticket` (`idticket`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

	CREATE TABLE `shotgun`.`performer_release` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idperformer` INT NOT NULL,
  `idrelease` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_pr_idperformer_idx` (`idperformer` ASC),
  INDEX `fk_pr_idrelease_idx` (`idrelease` ASC),
  CONSTRAINT `fk_pr_idperformer`
    FOREIGN KEY (`idperformer`)
    REFERENCES `shotgun`.`performer` (`idperformer`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_pr_idrelease`
    FOREIGN KEY (`idrelease`)
    REFERENCES `shotgun`.`release` (`idrelease`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

	CREATE TABLE `shotgun`.`event_locaiton` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idevent` INT NOT NULL,
  `idlocation` INT NOT NULL,
  `startdt` DATETIME NULL,
  `enddt` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_el_idevent_idx` (`idevent` ASC),
  INDEX `fk_el_idlocation_idx` (`idlocation` ASC),
  CONSTRAINT `fk_el_idevent`
    FOREIGN KEY (`idevent`)
    REFERENCES `shotgun`.`event` (`idevent`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_el_idlocation`
    FOREIGN KEY (`idlocation`)
    REFERENCES `shotgun`.`location` (`idlocation`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

-------------------------------------------------
ALTER TABLE `shotgun`.`location` 
ADD COLUMN `gpscoords` VARCHAR(100) NULL AFTER `address`;

----------------------------------------------


