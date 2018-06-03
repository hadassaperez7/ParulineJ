
/*!40101 SET NAMES utf8mb4 */;
DROP SCHEMA IF EXISTS paruline;
CREATE SCHEMA paruline;


USE paruline;

--
-- Base de données Paruline
--

-- =====================================================================================================================
-- TABLES


CREATE TABLE `accessories` (
  `id_products` INT(10) UNSIGNED NOT NULL,

  `description` TEXT CHARACTER SET utf8,
  `stock` INT(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `city` (
  `id_city` INT(10) UNSIGNED NOT NULL,

  `cp` varchar(5) NOT NULL ,
  `city` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `company` (
  `id_user` INT(10) UNSIGNED NOT NULL,

  `company` varchar(50) NOT NULL ,
  `type_comp` varchar(10) DEFAULT NULL,
  `lastname_contact` varchar(50) NOT NULL ,
  `firstname_contact` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `customer` (
  `id_user` INT(10) UNSIGNED NOT NULL,

  `lastname` VARCHAR(50) NOT NULL ,
  `firstname` VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `doublure` (
  `id_doublure` INT(10) UNSIGNED NOT NULL,

  `nom` VARCHAR(50) NOT NULL ,
  `prix_d` FLOAT(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `fournisseur` (
  `id_fourniss` INT(10) UNSIGNED NOT NULL,
  `id_city` INT(10) UNSIGNED NOT NULL ,

  `name_f` VARCHAR(100) NOT NULL ,
  `adresse_f` VARCHAR(100) NOT NULL,
  `phoneFour` VARCHAR(25)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `images_product` (
  `id_products` INT(10) UNSIGNED NOT NULL,

  `name_imgPr` VARCHAR(100) DEFAULT NULL,
  `type_imgPr` VARCHAR(9) DEFAULT NULL,
  `src_imgPr` VARCHAR(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE images_tissus (
  `id_typeRideaux` INT(10) UNSIGNED NOT NULL,

  `name_imgT` VARCHAR(100) DEFAULT NULL,
  `type_imgT` VARCHAR(9) DEFAULT NULL,
  `src_imgT` VARCHAR(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE image_voilages (
  `id_typeVoilages` INT(10) UNSIGNED NOT NULL,

  `name_imgV` VARCHAR(100) DEFAULT NULL,
  `type_imgV` VARCHAR(9) DEFAULT NULL,
  `src_imgV` VARCHAR(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `listorder` (
  `id_order` INT(10) UNSIGNED NOT NULL,

  `liste des produits` TEXT CHARACTER SET utf8
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `order` (
  `id_order` INT(10) UNSIGNED NOT NULL,

  `name_order` VARCHAR(100) DEFAULT NULL,
  `email` VARCHAR(200) DEFAULT NULL,
  `total` FLOAT(10,2) DEFAULT NULL,
  `src_commande` VARCHAR(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `order_items` (
  `id_order` INT(10) UNSIGNED NOT NULL,
  `id_products` INT(10) UNSIGNED NOT NULL,

  `nitems` INT(11) DEFAULT NULL,
  `totalItems` FLOAT(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `priceaccesso` (
  `id_products` INT(10) UNSIGNED NOT NULL,

  `prFournisseur` FLOAT(10,2) DEFAULT NULL,
  `prPondere` FLOAT(10,2) DEFAULT NULL,
  `coeff` FLOAT(10,2) DEFAULT NULL,
  `margeMonetaire` FLOAT(10,2) DEFAULT NULL,
  `prTotalAccess` FLOAT(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `products` (
  `id_products` INT(10) UNSIGNED NOT NULL,
  `id_fourniss` INT(10) UNSIGNED NOT NULL ,

  `ref` VARCHAR(100) DEFAULT NULL,
  `name_product` VARCHAR(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `rideaux` (
  `id_rideaux` INT(10) UNSIGNED NOT NULL,

  `catTissu` VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `tissus` (
  `id_typeRideaux` INT(10) UNSIGNED NOT NULL,
  `id_rideaux` INT(10) UNSIGNED NOT NULL,

  `nom_t` VARCHAR(100),
  `refT` VARCHAR(200),
  `largeur` INT,
  `prix_au_Metre` FLOAT(10,2),
  `coloris` VARCHAR(200),
  `compositionT` VARCHAR(255),
  `raccord` INT DEFAULT NULL,
  `rapport` INT DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `voilage` (
  `id_voilages` INT(10) NOT NULL,

  `catVoilage` VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE typeVoilage (
  `id_typeVoilages` INT(10) UNSIGNED NOT NULL,
  `id_voilages` INT(10) UNSIGNED NOT NULL,

  `nom_v` VARCHAR(100),
  `refV` VARCHAR(200),
  `hauteur` INT,
  `ourlet` BOOLEAN,
  `prix_metre` FLOAT(10,2),
  `colorisV` VARCHAR(255),
  `compositionV` VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `typeconfectionC` (
  `id_typeCC` INT(10) UNSIGNED NOT NULL,

  `nom_typeC` VARCHAR(150) DEFAULT NULL,
  `prix_typeC` FLOAT(10,2) DEFAULT NULL,
  `ampleurC` FLOAT(10,1)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `typeconfectionS` (
  `id_typeCS` INT(10) UNSIGNED NOT NULL,

  `nom_typeCS` VARCHAR(150) DEFAULT NULL,
  `prix_typeCS` FLOAT(10,2) DEFAULT NULL,
  `ampleurCS` FLOAT(10,1)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `images_confectionC` (
  `id_typeCC` INT(10) UNSIGNED NOT NULL,

  `nom_typeCC` VARCHAR(100),
  `type_typeCC` VARCHAR(9),
  `src_typeCC` VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `images_confectionS` (
  `id_typeCS` INT(10) UNSIGNED NOT NULL,

  `nom_typeCS` VARCHAR(100),
  `type_typeCS` VARCHAR(9),
  `src_typeCS` VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `entretien` (
  `id_typeRideaux` INT(10) UNSIGNED,
  `id_typeVoilages` INT(10) UNSIGNED,

  `lavage` ENUM('95', '60', '60M', '40', '40M', '40TresM', '30', '30M', '30TresM', 'Main', 'PasLavage'),
  `blanchiment` ENUM('TousTypes', 'Oxygenes', 'PasBlanchiment'),
  `sechage` ENUM('T80', 'T60', 'PasTambour', 'Fil', 'FilSansEsso', 'Plat', 'PlatSansEsso', 'FilOmbre', 'FilSansEssoOmbre', 'PlatOmbre', 'PlatSansEssoOmbre'),
  `repassage` ENUM('S200', 'S150', 'S110', 'PasRepassage'),
  `entretienPro` ENUM('SecNormal', 'SecModere', 'PasdeSec', 'EauNormal', 'EauModere', 'EauTresModere', 'Pasdeau')
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE `user` (
  `id_user` INT(10) UNSIGNED NOT NULL,
  `id_city` INT(10) UNSIGNED NOT NULL,

  `gender` ENUM('M.', 'Mme.'),
  `email` VARCHAR(255) DEFAULT NULL,
  `password` VARCHAR(255) DEFAULT NULL,
  `address` VARCHAR(100) DEFAULT NULL,
  `phone` VARCHAR(20) DEFAULT NULL,
  `type` VARCHAR(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- =====================================================================================================================
-- PRIMARY KEYS

ALTER TABLE `accessories`
  ADD PRIMARY KEY (`id_products`);

ALTER TABLE `city`
  ADD PRIMARY KEY (`id_city`),
  MODIFY `id_city` INT(10) UNSIGNED AUTO_INCREMENT;

ALTER TABLE `company`
  ADD PRIMARY KEY (`id_user`);

ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_user`);

ALTER TABLE `doublure`
  ADD PRIMARY KEY (`id_doublure`),
  MODIFY `id_doublure` INT(10) UNSIGNED AUTO_INCREMENT;

ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`id_fourniss`),
  MODIFY `id_fourniss` INT(10) UNSIGNED AUTO_INCREMENT,
  ADD KEY `id_city` (`id_city`);

ALTER TABLE `images_product`
  ADD KEY `id_products` (`id_products`);

ALTER TABLE `images_tissus`
  ADD KEY `id_typeRideaux` (`id_typeRideaux`);

ALTER TABLE `image_voilages`
  ADD KEY `id_typeVoilages` (`id_typeVoilages`);

ALTER TABLE `order`
  ADD PRIMARY KEY (`id_order`),
  MODIFY `id_order` INT(10) UNSIGNED AUTO_INCREMENT;

ALTER TABLE `order_items`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_products` (`id_products`);

ALTER TABLE `priceaccesso`
  ADD PRIMARY KEY (`id_products`);

ALTER TABLE `products`
  ADD PRIMARY KEY (`id_products`),
  MODIFY `id_products` INT(10) UNSIGNED AUTO_INCREMENT,
  ADD KEY `id_fourniss`(`id_fourniss`);

ALTER TABLE `rideaux`
  ADD PRIMARY KEY (`id_rideaux`),
  MODIFY `id_rideaux` INT(10) UNSIGNED AUTO_INCREMENT;

ALTER TABLE `tissus`
  ADD PRIMARY KEY (`id_typeRideaux`),
  MODIFY `id_rideaux` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  ADD KEY (`id_rideaux`);

ALTER TABLE `voilage`
  ADD PRIMARY KEY (`id_voilages`),
  MODIFY `id_voilages` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT;

ALTER TABLE `typeVoilage`
  ADD PRIMARY KEY (`id_typeVoilages`),
  MODIFY `id_typeVoilages` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  ADD KEY `id_voilages` (`id_voilages`);

ALTER TABLE `images_confectionC`
  ADD KEY (id_typeCC);

ALTER TABLE `images_confectionS`
  ADD KEY (id_typeCS);

ALTER TABLE `entretien`
  ADD KEY `id_typeRideaux` (`id_typeRideaux`),
  ADD KEY `id_typeVoilages` (`id_typeVoilages`);

ALTER TABLE `typeconfectionC`
  ADD PRIMARY KEY (`id_typeCC`);

ALTER TABLE `typeconfectionS`
  ADD PRIMARY KEY (`id_typeCS`);

ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  MODIFY `id_user` INT(10) UNSIGNED AUTO_INCREMENT,
  ADD KEY `id_city` (`id_city`);


-- =====================================================================================================================
-- FOREIGN KEYS

ALTER TABLE `fournisseur`
  ADD CONSTRAINT `city_fourn_fk` FOREIGN KEY (`id_city`) REFERENCES `city`(`id_city`);

ALTER TABLE `images_product`
  ADD CONSTRAINT `images_product_fk` FOREIGN KEY (`id_products`) REFERENCES `products` (`id_products`)
  ON DELETE CASCADE;

ALTER TABLE `images_tissus`
  ADD CONSTRAINT `image_rideaux_fk` FOREIGN KEY (`id_typeRideaux`) REFERENCES `tissus` (`id_typeRideaux`)
  ON DELETE CASCADE;

ALTER TABLE `image_voilages`
  ADD CONSTRAINT `image_voilages_fk` FOREIGN KEY (`id_typeVoilages`) REFERENCES `typeVoilage` (`id_typeVoilages`)
  ON DELETE CASCADE;

ALTER TABLE `images_confectionC`
  ADD CONSTRAINT `image_typeCC_fk` FOREIGN KEY (`id_typeCC`) REFERENCES `typeconfectionC`(id_typeCC)
  ON DELETE CASCADE;

ALTER TABLE `images_confectionS`
  ADD CONSTRAINT `image_typeCS_fk` FOREIGN KEY (id_typeCS) REFERENCES `typeconfectionS` (id_typeCS)
  ON DELETE CASCADE;

ALTER TABLE `order_items`
  ADD CONSTRAINT `order_items_fk1` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`)
  ON DELETE CASCADE,
  ADD CONSTRAINT `order_items_fk2` FOREIGN KEY (`id_products`) REFERENCES `products` (`id_products`)
  ON DELETE CASCADE;

ALTER TABLE `products`
  ADD CONSTRAINT `fourniss_prod_fk` FOREIGN KEY (`id_fourniss`) REFERENCES `fournisseur`(`id_fourniss`)
  ON DELETE CASCADE;

ALTER TABLE `priceaccesso`
  ADD CONSTRAINT `priceAccesso_fk` FOREIGN KEY (`id_products`) REFERENCES `products` (`id_products`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `tissus`
  ADD CONSTRAINT `tissu_fk` FOREIGN KEY (`id_rideaux`) REFERENCES `rideaux` (`id_rideaux`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `typeVoilage`
  ADD CONSTRAINT `voilage_fk` FOREIGN KEY (`id_voilages`) REFERENCES `voilage` (`id_voilages`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `entretien`
  ADD CONSTRAINT `entretien_rid_fk` FOREIGN KEY (`id_typeRideaux`) REFERENCES tissus(`id_typeRideaux`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  ADD CONSTRAINT `entretien_voil_fk` FOREIGN KEY (`id_typeVoilages`) REFERENCES typeVoilage(`id_typeVoilages`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `user`
  ADD CONSTRAINT `user_fk` FOREIGN KEY (`id_city`) REFERENCES `city` (`id_city`);


-- =====================================================================================================================
-- TRIGGERS

-- Company
DELIMITER //
CREATE TRIGGER `InsertCompany` BEFORE INSERT ON `company` FOR EACH ROW BEGIN
  DECLARE nbu, nbcus INT;

  SELECT count(*) INTO nbu FROM user WHERE id_user = NEW.id_user;

  IF nbu = 0 THEN
    SIGNAL SQLSTATE '42000' SET MESSAGE_TEXT = 'Votre compte utilisateur n''existe pas.<br>';
  END IF;

  SELECT count(*) INTO nbcus FROM customer WHERE id_user = NEW.id_user;

  IF nbcus > 0 THEN
    SIGNAL SQLSTATE '42000' SET MESSAGE_TEXT = 'Vous êtes déjà un client particulier<br>';
  END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER `UpdateCompany` AFTER UPDATE ON `company` FOR EACH ROW BEGIN
  UPDATE user SET id_user = NEW.id_user WHERE id_user = OLD.id_user;
END //
DELIMITER ;

-- Customers

DELIMITER //
CREATE TRIGGER `InsertCustomer` BEFORE INSERT ON `customer` FOR EACH ROW BEGIN
  DECLARE nbu, nbcomp INT;

  SELECT count(*) INTO nbu FROM user WHERE id_user = NEW.id_user;

  IF nbu = 0 THEN
    SIGNAL SQLSTATE '42000' SET MESSAGE_TEXT = 'Votre compte utilisateur n''existe pas <br>';
  END IF;

  SELECT count(*) INTO nbcomp FROM company WHERE id_user = NEW.id_user;

  IF nbcomp > 0 THEN
    SIGNAL SQLSTATE '42000' SET MESSAGE_TEXT = 'Vous êtes déjà un client professionnel <br>';
  END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER `UpdateCustomer` AFTER UPDATE ON `customer` FOR EACH ROW BEGIN
  UPDATE user SET id_user = NEW.id_user
  WHERE id_user = OLD.id_user;
END //
DELIMITER ;

-- User

DELIMITER //
CREATE TRIGGER `DeleteCompany` AFTER DELETE ON `user` FOR EACH ROW BEGIN
  DELETE FROM company WHERE id_user = OLD.id_user;
END //
DELIMITER ;

-- Orders

DELIMITER //
CREATE TRIGGER `SUPPLigneCom` AFTER DELETE ON `order` FOR EACH ROW BEGIN
  DECLARE qItem, qStock INT;

  SELECT stock INTO qStock FROM accessories WHERE id_order = OLD.id_order;
  SELECT nitems INTO qItem FROM order_items WHERE id_order = OLD.id_order;

  UPDATE accessories SET stock = qStock + qItem WHERE id_order = OLD.id_order;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER `MAJQuantite` AFTER INSERT ON `order_items` FOR EACH ROW BEGIN
  DECLARE qItem, qStock, existStock INT;

  SELECT count(stock)INTO existStock FROM accessories, `order` WHERE id_order = NEW.id_order;
  SELECT stock INTO qStock FROM accessories, `order` WHERE id_order = NEW.id_order;
  SELECT nitems INTO qItem FROM order_items WHERE id_order = NEW.id_order;

  IF (existStock >= 0) THEN
    UPDATE accessories SET stock = 15 WHERE id_order = NEW.id_order;
  ELSE
    SIGNAL SQLSTATE '42000' SET MESSAGE_TEXT = 'La quantité est inférieure à 0.';
  END IF ;
END //
DELIMITER ;


-- =====================================================================================================================
-- PROCEDURES

DELIMITER //
-- Vérification et connexion

CREATE PROCEDURE `connexion` (`mail` VARCHAR(255), `pwd` VARCHAR(255))
  BEGIN
    SELECT id_user, email, password, type FROM user
    WHERE email = mail AND password = pwd;
  END //

CREATE PROCEDURE `checkExistsCity` (`cit` VARCHAR(100), `cpCit` VARCHAR(5))
  BEGIN
    SELECT count(*) FROM city
    WHERE city = cit
          AND cp = cpCit;
  END //

-- Récupération

CREATE PROCEDURE `getCity` (`cit` VARCHAR(100), `cpCit` VARCHAR(5))
  BEGIN
    SELECT id_city FROM city
    WHERE city = cit
          AND cp = cpCit;
  END //

-- Rideaux

CREATE PROCEDURE `getCatCurtains` ()
  BEGIN
    SELECT id_rideaux, catTissu FROM rideaux;
  END //

CREATE PROCEDURE `getCurtains` (idrid INT)
  BEGIN
    SELECT T.id_typeRideaux, nom_t, refT, largeur, prix_au_Metre, raccord, rapport, coloris, compositionT, src_imgT FROM tissus T, images_tissus I
    WHERE id_rideaux = idrid
          AND T.id_typeRideaux = I.id_typeRideaux;
  END //

CREATE PROCEDURE `getCurConfection` ()
  BEGIN
    SELECT id_typeCC, nom_typeC, FROM typeconfectionC;
  END //

CREATE PROCEDURE `getCurConfectionDetails` (idConfC INT)
  BEGIN
    SELECT C.id_typeCC, nom_typeC, ampleurC, prix_typeC FROM typeconfectionC C, images_confectionC I
    WHERE C.id_typeCC = I.id_typeCC;
  END //

-- Voilages

CREATE PROCEDURE `getCatSheers` ()
  BEGIN
    SELECT id_voilages, catVoilage FROM voilage;
  END//

CREATE PROCEDURE `getSheers` (idshee INT)
  BEGIN
    SELECT I.id_typeVoilages, nom_v, refV, hauteur, ourlet, prix_metre, colorisV, compositionV, src_imgV FROM typeVoilage V, image_voilages I
    WHERE id_voilages = idshee
          AND V.id_typeVoilages = I.id_typeVoilages;
  END //

CREATE PROCEDURE `getSheeDetails` (idTypeVoilage INT)
  BEGIN
    SELECT id_typeVoilages, ourlet FROM typeVoilage
    WHERE id_typeVoilages = idTypeVoilage;
  END //

CREATE PROCEDURE `getSheeConfection` ()
  BEGIN
    SELECT S.id_typeCS, S.nom_typeCS, prix_typeCS, ampleurCS FROM typeconfectionS S, images_confectionS I
    WHERE S.id_typeCS = I.id_typeCS;
  END //

-- Personnes

CREATE PROCEDURE `getProviders` ()
  BEGIN
    SELECT name_f, adresse_f, phoneFour, city, cp FROM fournisseur F, city C
    WHERE F.id_city = C.id_city;
  END //

CREATE PROCEDURE `getCustomers` ()
  BEGIN
    SELECT lastname, firstname, email, address, cp, city, phone
    FROM user U, customer CUS, city CIT
    WHERE U.id_user = CUS.id_user AND U.id_city = CIT.id_city AND U.id_user > 1 AND type = 'customer';
  END //

CREATE PROCEDURE `getCustomersPro` ()
  BEGIN
    SELECT lastname_contact, firstname_contact, company, type_comp, email, address, cp, city, phone
    FROM user U, company COMP, city CIT
    WHERE U.id_user = COMP.id_user AND U.id_city = CIT.id_city AND U.id_user > 1 AND type = 'company';
  END //

-- Produits

CREATE PROCEDURE `getPriceAccesso` ()
  BEGIN
    SELECT P.id_products, name_product, ref, name_f, prFournisseur, prPondere, coeff, margeMonetaire, prTotalAccess
    FROM products P, fournisseur F, priceaccesso Pr
    WHERE P.id_products = Pr.id_products AND P.id_fourniss = F.id_fourniss;
  END //

CREATE PROCEDURE `getProductData` (`idproducts` INT)
  BEGIN
    SELECT name_product, prTotalAccess FROM products P, accessories A, priceaccesso Pr
    WHERE P.id_products = A.id_products
          AND Pr.id_products = P.id_products
          AND P.id_products = idproducts LIMIT 1;
  END //

CREATE PROCEDURE `getProducts` ()
  BEGIN
    SELECT P.id_products, A.id_products, name_product, prTotalAccess, description, src_imgPr FROM products P, accessories A, priceaccesso Pr, images_product I
    WHERE P.id_products = A.id_products
          AND Pr.id_products = P.id_products
          AND P.id_products = I.id_products
    ORDER BY name_product ASC;
  END //


-- Insertions

CREATE PROCEDURE `InsertCity` (`newCity` VARCHAR(100), `newCP` VARCHAR(5))
  BEGIN
    INSERT INTO city(city, cp) VALUES (newCity, newCP);
  END //

CREATE PROCEDURE InsertPriceAcc (
  id INT, prF FLOAT(10,2),  coefficient FLOAT(10,2)
)
  BEGIN
    -- DECLARE lastID INT;
    DECLARE prPond, coeff, marge, total FLOAT(10,2) DEFAULT 0;

    SET prPond = prF * (1.30 / 100) + prF;
    SET coeff = prPond * (coefficient / 100);
    SET total = prPond + coeff;
    SET marge = total - prPond;

    -- SELECT MAX(id_products) FROM products;

    INSERT INTO priceaccesso(id_products, prFournisseur, prPondere, coeff, margeMonetaire, prTotalAccess)
    VALUES (id, prF, prPond, coefficient, marge, total);
  END //

-- Clients

CREATE PROCEDURE `InsertCompany` (`companyCO` VARCHAR(50), `type_compCO` VARCHAR(10),
                                  `lastname_contactCO` VARCHAR(50), `firstname_contactCO` VARCHAR(50))
  BEGIN
    DECLARE iduser INT;
    SELECT MAX(id_user) INTO iduser FROM user;

    INSERT INTO company(company, type_comp, lastname_contact, firstname_contact, id_user)
    VALUES (companyCO, type_compCO, lastname_contactCO, firstname_contactCO, iduser);
  END //

CREATE PROCEDURE `InsertCustomer` (`firstnameCU` VARCHAR(50), `lastnameCU` VARCHAR(10))
  BEGIN
    DECLARE iduser INT;
    SELECT MAX(id_user) INTO iduser FROM user;

    INSERT INTO customer(firstname, lastname, id_user) VALUES (firstnameCU, lastnameCU, iduser);
  END //

CREATE PROCEDURE `InsertUser` (`idcity` VARCHAR(100), `gend` VARCHAR(4), `emailU` VARCHAR(255),
                               `passwordU` VARCHAR(255), `addressU` VARCHAR(100),
                               `phoneU` VARCHAR(20), `typeU` VARCHAR(8))
  BEGIN

    INSERT INTO user(id_city, gender, email, password, address, phone, type)
    VALUES (idcity, gend, emailU, passwordU, addressU, phoneU, typeU);

  END //


-- Mise à jour

CREATE PROCEDURE `updateConnexion` (`emailC` VARCHAR(255), `passwordC` VARCHAR(255), `iduser` INT)
  BEGIN
    UPDATE user SET email = emailC, password = passwordC
    WHERE id_user = iduser;
  END //

-- Produits

CREATE PROCEDURE UpdatePriceAcc (
  id INT,           refP VARCHAR(100),
  prF FLOAT(10,2),  coefficient FLOAT(10,2)
)
  BEGIN
    DECLARE prPond, coeff, marge, total FLOAT(10,2) DEFAULT 0;

    SET prPond = prF * (1.30 / 100) + prF;
    SET coeff = prPond * (coefficient / 100);
    SET total = prPond + coeff;
    SET marge = total - prPond;

    UPDATE priceaccesso SET prFournisseur = prF, prPondere = prPond, coeff = coefficient, margeMonetaire = marge, prTotalAccess = total
    WHERE id_products = id;

    UPDATE products SET ref = refP
    WHERE id_products = id;
  END //

CREATE PROCEDURE `updateAccessory` (`name_p` VARCHAR(150), `descriptionP` TEXT, `idproducts` INT)
  BEGIN
    UPDATE products P SET P.name_product = name_p WHERE P.id_products = idproducts;

    UPDATE accessories A SET A.description = descriptionP
    WHERE A.id_products = (SELECT P.id_products FROM products P WHERE P.id_products = idproducts);
  END //

-- Utilisateurs

CREATE PROCEDURE `updateGeneralCOMP` (IN `lastname` VARCHAR(50), IN `firstname` VARCHAR(50),
                                      IN `addressCO` VARCHAR(100), IN `phoneCO` VARCHAR(20),
                                      IN `cityCO` VARCHAR(100), IN `cpCO` VARCHAR(5),
                                      IN `iduser` INT)
  BEGIN
    DECLARE exist, idcity INT;

    SELECT count(*) INTO exist FROM city WHERE city = cityCO AND cp = cpCO;

    IF (exist = 0) THEN
      INSERT INTO city(city, cp) VALUES (cityCO, cpCO);
      SELECT MAX(id_city) INTO idcity FROM city;

      UPDATE user SET address = addressCO, phone = phoneCO, id_city = idcity
      WHERE id_user = iduser;
    ELSE
      SELECT DISTINCT(CIT.id_city) INTO idcity FROM city CIT
      WHERE CIT.city = cityCO AND CIT.cp = cpCO;

      UPDATE user U SET U.address = addressCO, U.phone = phoneCO, U.id_city = idcity
      WHERE U.id_user = iduser;

    END IF;

    UPDATE company
    SET lastname_contact = lastname, firstname_contact = firstname
    WHERE id_user = iduser;

  END //

CREATE PROCEDURE `updateGeneralCUST` (IN `lastnameCUST` VARCHAR(50), IN `firstnameCUST` VARCHAR(50),
                                      IN `addressCUST` VARCHAR(100), IN `phoneCUST` VARCHAR(20),
                                      IN `cityCUST` VARCHAR(100), IN `cpCUST` VARCHAR(5),
                                      IN `iduser` INT)
  BEGIN
    DECLARE exist, idcity INT;

    SELECT count(*) INTO exist FROM city WHERE city = cityCUST AND cp = cpCUST;

    IF (exist = 0) THEN
      INSERT INTO city(city, cp) VALUES (cityCUST, cpCUST);
      SELECT MAX(id_city) INTO idcity FROM city;

      UPDATE user
      SET address = addressCUST, phone = phoneCUST, id_city = idcity
      WHERE id_user = iduser;
    ELSE
      SELECT DISTINCT(CIT.id_city) INTO idcity FROM city CIT WHERE CIT.city = cityCUST AND CIT.cp = cpCUST;

      UPDATE user U
      SET U.address = addressCUST, U.phone = phoneCUST, U.id_city = idcity
      WHERE U.id_user = iduser;

    END IF;

    UPDATE customer
    SET lastname = lastnameCUST, firstname = firstnameCUST
    WHERE id_user = iduser;

  END //

CREATE PROCEDURE `updateCompany` (`companyCO` VARCHAR(50), `typeCO` VARCHAR(10), `iduser` INT)
  BEGIN
    UPDATE user U, company COM
    SET company = companyCO, type_comp = typeCO
    WHERE U.id_user = COM.id_user AND U.id_user = iduser;
  END //

CREATE PROCEDURE `userInfosComp` (`iduser` INT)
  BEGIN
    SELECT u.id_user, email, password, address, cp, city, phone, company, type_comp, lastname_contact, firstname_contact
    FROM user U, company COM, city CIT
    WHERE COM.id_user = U.id_user AND U.id_city = CIT.id_city AND U.id_user = iduser;
  END //

CREATE PROCEDURE `userInfosCust` (`iduser` INT)
  BEGIN
    SELECT U.id_user, email, address, cp, city, phone, lastname, firstname FROM user U, customer CUS, city CIT
    WHERE U.id_user = CUS.id_user
          AND U.id_city = CIT.id_city
          AND U.id_user = iduser;
  END //

DELIMITER ;

-- =====================================================================================================================
-- FONCTIONS

-- =====================================================================================================================
-- INSERTIONS

INSERT INTO `city` (`id_city`, `cp`, `city`) VALUES
  (1, '75001', 'Paris 1'),
  (2, '75002', 'Paris 2'),
  (3, '75003', 'Paris 3'),
  (4, '75004', 'Paris 4'),
  (5, '75005', 'Paris 5'),
  (6, '75006', 'Paris 6'),
  (7, '75007', 'Paris 7'),
  (8, '75008', 'Paris 8'),
  (9, '75009', 'Paris 9'),
  (10, '75010', 'Paris 10'),
  (11, '75011', 'Paris 11'),
  (12, '75012', 'Paris 12'),
  (13, '75013', 'Paris 13'),
  (14, '75014', 'Paris 14'),
  (15, '75015', 'Paris 15'),
  (16, '75016', 'Paris 16'),
  (17, '75017', 'Paris 17'),
  (18, '75018', 'Paris 18'),
  (19, '75019', 'Paris 19'),
  (20, '75020', 'Paris 20'),
  (21, '91850', 'Bouray-sur-Juine'),
  (22, '77288', 'Melun'),
  (23, '95426', 'Montlignon'),
  (24, '11000', 'Carcassonne');

INSERT INTO `user` (`id_user`, `id_city`, `email`, `password`, `address`, `phone`, `type`) VALUES
  (1, 21, 'paruline@wanadoo.fr', 'fdf8b466aa773e050a7e4d22869c9c531b609c19', '14 bis, rue Haute', '0619812465', 'company'),
  (2, 22, 'christophe.odec@odec.fr', '7178ebd2e6615d7a80a46544f5a955e3b2bcb628', '303, rue Pierre et Marie Curie', '0164790099', 'company');

INSERT INTO `company` (`id_user`, `company`, `type_comp`, `lastname_contact`, `firstname_contact`) VALUES
  (1, 'Paruline', 'SAS', 'Tournay', 'Olivier'),
  (2, 'Odec', 'SAS', 'Odec', 'Christophe');

INSERT INTO `fournisseur` (id_fourniss, id_city, name_f, adresse_f) VALUES
  (1, 22, 'Fournisseur 1', 'Adresse 1'),
  (2, 24, 'Fournisseur 2', 'Adresse 2'),
  (3, 11, 'Fournisseur 3', 'Adresse 3'),
  (4, 19, 'Fournisseur 4', 'Adresse 4');

INSERT INTO `products` (`id_products`, `id_fourniss`,`ref`, `name_product`) VALUES
  (1, 3, '10548', 'Tringle NOW'),
  (2, 4, '10920', 'Tringle ICON'),
  (3, 2, '10244', 'Tringle Oslo'),
  (4, 1,NULL, 'Produit n°4'),
  (5, 1,NULL, 'Produit n°5'),
  (6, 3,NULL, 'Produit n°6');

INSERT INTO `accessories` (`id_products`, `description`, `stock`) VALUES
  (1, 'Tringle complète de 200cm noire de 18x40 cm.\n 2 retours de chaque côté avec 12 anneaux et 2 crochets.', NULL),
  (2, 'Tringle complète de 160cm en bois et aluminium de 25x40cm.\n 2 retours de chaque côté avec 16 anneaux et 2 crochets.', NULL),
  (3, 'Tringle complète de 240cm (120 X2) en acier couleur Nickel Noir.\n 28mm de diamètre avec 24 anneaux et 2 crochets', NULL),
  (4, 'Description 4', NULL),
  (5, 'Description 5', NULL),
  (6, 'Description 6', NULL);

INSERT INTO `images_product`(id_products, name_imgPr, type_imgPr, src_imgPr) VALUES
  (1, 'Now', 'type/png', '../public/images/products/Now.png'),
  (2, 'Icon', 'type/png', '../public/images/products/Icon.png'),
  (3, 'Oslo', 'type/png', '../public/images/products/kit_Oslo.png'),
  (4, 'Pr 4', 'type/png', '../public/images/curtains.png'),
  (5, 'Pr 5', 'type/png', '../public/images/curtains.png'),
  (6, 'Pr 6', 'type/png', '../public/images/curtains.png');

CALL InsertPriceAcc(1, 25, 20);
CALL InsertPriceAcc(2, 5.5, 15.5);
CALL InsertPriceAcc(3, 1.99, 6.75);
CALL InsertPriceAcc(4, 35.24, 10);
CALL InsertPriceAcc(5, 75.40, 22.6);
CALL InsertPriceAcc(6, 150, 50);

INSERT INTO rideaux (catTissu) VALUES
  ('Loneta'),
  ('Moondream'),
  ('Orféo'),
  ('Vescom'),
  ('Tissu uni'),
  ('Tissu fantaisie');

INSERT INTO tissus (id_typeRideaux, id_rideaux, nom_t, refT, largeur, prix_au_Metre, raccord, rapport, coloris, compositionT) VALUES
  (1, 1, 'Gufo', 'Gufo', 150, 25.20, NULL, NULL, '401', 'nc'),
  (2, 1, 'Latinus', 'Latinus', 190, 33.45, NULL, NULL, '090', 'nc'),
  (3, 2, 'Countrybaby Nabucco Obscurississant', 'C902M', 150, 15.87, 0, NULL, '15', '100% Polyester'),
  (4, 2, 'Dune Gommettes Obscurississant', 'D900M ', 150, 42.10, 3, NULL, '8007', '100% Polyester'),
  (5, 2, 'Dune Obscurississant', '62070 ', 150, 67, 0, 2, '8007 Cendres', '100% Polyester'),
  (6, 3, 'Hendrix', '20994 ', 300, 52.70, 0, NULL, '228 Tierra', '52% Polyester, 48% Trevira CS'),
  (7, 3, 'Elvis', '20958 ', 300, 63.48, 0, NULL, '228 Tierra', '52% Polyester, 48% Trevira CS'),
  (8, 3, 'Lennon', '21013 ', 300, 58, 0, NULL, '002 Beige', '52% Polyester, 48% Trevira CS'),
  (9, 4, 'Naltar', '8034 ', 140, 58, 0, NULL, '10', '100% Trevira CS'),
  (10, 4, 'Namal', '7043 ', 150, 58, 0, NULL, '36', '100% Polyester (non feu)'),
  (11, 5, 'Ceres', 'Variable ', 300, 58, 0, NULL, 'Variable', '51% Trevira CS, 49% Polyester (non feu)'),
  (12, 6, 'Rio Outdoor', '20796 ', 140, 58, 0, 64, '885 Cosmos', '100% Acrylique (Outdoor)');

INSERT INTO images_tissus(id_typeRideaux, name_imgT, type_imgT, src_imgT) VALUES
  (1, 'Gufo', 'type/jpg', '../public/images/curtains/Loneta/Loneta_Gufo.jpg'),
  (2, 'Latinus', 'type/jpg', '../public/images/curtains/Loneta/Loneta_Latinus.jpg'),
  (3, 'Countrybaby Nabucco Obscurississant', 'type/jpg', '../public/images/curtains/Moondream/Moondream_C902M.jpg'),
  (4, 'Dune Gommettes Obscurississant', 'type/jpg', '../public/images/curtains/Moondream/Moondream_D900M.jpg'),
  (5, 'Dune Obscurississant', 'type/jpg', '../public/images/curtains/Moondream/Moondream_62070.jpg'),
  (6, 'Hendrix', 'type/jpg', '../public/images/curtains/Orfeo/Orfeo_20994.jpg'),
  (7, 'Elvis', 'type/jpg', '../public/images/curtains/Orfeo/Orfeo_20958.jpg'),
  (8, 'Lennon', 'type/jpg', '../public/images/curtains/Orfeo/Orfeo_21013.jpg'),
  (9, 'Naltar', 'type/jpg', '../public/images/curtains/Vescom/Vescom_8034.jpg'),
  (10, 'Namal', 'type/jpg', '../public/images/curtains/Vescom/Vescom_7043.jpg'),
  (11, 'Ceres', 'type/jpg', '../public/images/curtains/Tissu_uni/Ceres.jpg'),
  (12, 'Rio Outdoor', 'type/jpg', '../public/images/curtains/Tissus_Fantaisies/Rio_Outdoor.jpg');

INSERT INTO `typeconfectionC` (`id_typeCC`, `nom_typeC`, `prix_typeC`, ampleurC) VALUES
  (1, 'Galon Fronceur', 10.99, 1.5),
  (2, 'Tête Flammande', 15.27, 3),
  (3, 'Tête Fourreau', 17.94, 2.5),
  (4, 'Tête Oeillets', 25.19, 2),
  (5, 'Tête Passants Cachés', 12.45, 1.5),
  (6, 'Tête Pattes et Lacets', 13, 2.5);

INSERT INTO `images_confectionC` (id_typeCC, nom_typeCC, type_typeCC, src_typeCC) VALUES
  (1, 'Galon', 'type/jpg', '../public/images/confectionC/Galon_fronceur.jpg'),
  (2, 'Flammande', 'type/jpg', '../public/images/confectionC/Tete_flammande.jpg'),
  (3, 'Fourreau', 'type/jpg', '../public/images/confectionC/Tete_fourreau.jpg'),
  (4, 'Oeillets', 'type/png', '../public/images/confectionC/Tete_oeillet.png'),
  (5, 'Passants', 'type/png', '../public/images/confectionC/Tete_passants_caches.png'),
  (6, 'Pattes&lacets', 'type/jpg', '../public/images/confectionC/Tete_pattes_et_lacets.jpg');

INSERT INTO `typeconfectionS` (`id_typeCS`, `nom_typeCS`, `prix_typeCS`, ampleurCS) VALUES
  (1, 'Galon Fronceur', 15, 2),
  (2, 'Oeillets', 19.99, 2.5),
  (3, 'Passants Cachés', 11.75, 1.5),
  (4, 'Plissé Fixe', 10.5, 1),
  (5, 'Tête Flammande', 13, 1.5),
  (6, 'Tête Pattes', 12, 2);

INSERT INTO `images_confectionS` (id_typeCS, nom_typeCS, type_typeCS, src_typeCS) VALUES
  (1, 'Galon', 'type/jpg', '../public/images/confectionS/Galon_fronceur.jpg'),
  (2, 'Oeillets', 'type/jpg', '../public/images/confectionS/Oeillets_voilage.jpg'),
  (3, 'Passants', 'type/jpg', '../public/images/confectionS/Passants_caches.jpg'),
  (4, 'Fixe', 'type/jpg', '../public/images/confectionS/Plisse_fixe .jpg'),
  (5, 'Flammande', 'type/jpg', '../public/images/confectionS/Tete_flamande.jpg'),
  (6, 'Pattes', 'type/jpg', '../public/images/confectionS/Tete_pattes.jpg');

INSERT INTO `doublure` (`id_doublure`, `nom`, `prix_d`) VALUES
  (1, 'Satinette', 10.2),
  (2, 'Ocultant', 5);

INSERT INTO `voilage` (catVoilage) VALUES
  ('Déchelette'),
  ('Kubic'),
  ('Orféo'),
  ('Vescom'),
  ('Electra');

INSERT INTO `typeVoilage` (id_typeVoilages, id_voilages, nom_v, refV, hauteur, ourlet, prix_metre, colorisV, compositionV) VALUES
  (1, 1, 'Sablé', '05330', 300, TRUE, 5.5, '000 Blanc', '100% Polyester'),
  (2, 1, 'Voile', '05320', 300, FALSE, 7.1, '000 Blanc', '100% Polyester'),
  (3, 1, 'Sans nom Chanvre', '05341', 300, FALSE, 9.7, '25 Chanvre', '100% Polyester'),
  (4, 1, 'Étamine', '05332', 300, FALSE , 8.65, '002 Crème', '50% Polyester (non feu), 50% Polyester'),
  (5, 1, 'Polylin', '05310', 300, TRUE, 2.39, '002 Crème', '100% Polyester'),
  (6, 1, 'Sans nom Taupe', '08897', 290, TRUE, 4, '62 Taupe', '100% Polyester'),
  (7, 1, 'Sans nom Bordeaux', '08897', 290, FALSE, 6.73, '22 Bordeaux', '100% Polyester'),
  (8, 1, 'Sans nom Gris', '08897', 290, FALSE, 6.73, '29 Gris', '100% Polyester'),
  (9, 1, 'Sans nom Blanc', '08897', 290, TRUE, 6.73, '00 Blanc', '100% Polyester'),
  (10, 1, 'Sans nom Ivoire', '09254', 300, FALSE, 6.73, '54 Ivoire', '100% Polyester'),
  (11, 1, 'Sans nom Blanc 2', '09254', 300, FALSE, 6.73, '00 Blanc', '100% Polyester'),
  (12, 2, 'Kubic 1', '21448',300, FALSE, 6.73, '989 Pierra', '100% Trevira CS (non feu)'),
  (13, 2, 'Kubic 2', '21448', 300, FALSE, 6.73, '185 Maiz', '100% Trevira CS (non feu)'),
  (14, 3, 'Marley', '21030', 330, TRUE, 6.73, '000 Natur', '91% Trevira CS, 9% Lin'),
  (15, 4, 'Fogo', '8051', 300, TRUE, 6.73, '14', ' 100% Polyester (non feu)'),
  (16, 5, 'Electra', '21420', 300, TRUE, 6.73, '993 Perla // 336 Indigo // 001 Blanco', '78% Polyester, 15% Lin, 7% Laine');

INSERT INTO `image_voilages` (id_typeVoilages, name_imgV, type_imgV, src_imgV) VALUES
  (1, 'Sablé', 'type/jpg', '../public/images/sheers/Dechelette/Dechelette_05330.jpg'),
  (2, 'Voile', 'type/jpg', '../public/images/sheers/Dechelette/Dechelette_05320.jpg'),
  (3, 'SNChanvre', 'type/jpg', '../public/images/sheers/Dechelette/Dechelette_05341.jpg'),
  (4, 'Étamine', 'type/jpg', '../public/images/sheers/Dechelette/Dechelette_05332.jpg'),
  (5, 'Polylin', 'type/jpg', '../public/images/sheers/Dechelette/Dechelette_05310.jpg'),
  (6, 'SNTaupe', 'type/jpg', '../public/images/sheers/Dechelette/Dechelette_08897_T.jpg'),
  (7, 'SNBordeaux', 'type/jpg', '../public/images/sheers/Dechelette/Dechelette_08897_B.jpg'),
  (8, 'SNGris', 'type/jpg', '../public/images/sheers/Dechelette/Dechelette_08897_G.jpg'),
  (9, 'SNBlanc', 'type/jpg', '../public/images/sheers/Dechelette/Dechelette_08897_Blanc.jpg'),
  (10, 'SNIvoire', 'type/jpg', '../public/images/sheers/Dechelette/Dechelette_09254_I.jpg'),
  (11, 'SNBlanc2', 'type/jpg', '../public/images/sheers/Dechelette/Dechelette_09254_B.jpg'),
  (12, 'Kubic1', 'type/jpg', '../public/images/sheers/Kubic/Kubic_989.jpg'),
  (13, 'Kubic2', 'type/jpg', '../public/images/sheers/Kubic/Kubic_185.jpg'),
  (14, 'Marley', 'type/jpg', '../public/images/sheers/Orfeo/Orfeo_21030.jpg'),
  (15, 'Fogo', 'type/jpg', '../public/images/sheers/Vescom/Vescom_8051.jpg'),
  (16, 'Electra', 'type/jpg', '../public/images/sheers/Electra/Electra.jpg');

COMMIT;