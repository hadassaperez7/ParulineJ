
/*!40101 SET NAMES utf8mb4 */;
DROP SCHEMA paruline;
CREATE SCHEMA paruline;

USE paruline;

--
-- Base de données Paruline
--

-- ===================================================================
-- TABLES


CREATE TABLE `accessories` (
  `id_products` INT(10) UNSIGNED NOT NULL,

  `description` TEXT CHARACTER SET utf8,
  `stock` INT(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `city` (
  `id_city` INT(10) UNSIGNED NOT NULL,

  `cp` varchar(5) NOT NULL ,
  `city` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `company` (
  `id_user` INT(10) UNSIGNED NOT NULL,

  `company` varchar(50) NOT NULL ,
  `type_comp` varchar(10) DEFAULT NULL,
  `lastname_contact` varchar(50) NOT NULL ,
  `firstname_contact` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `customer` (
  `id_user` INT(10) UNSIGNED NOT NULL,

  `lastname` VARCHAR(50) NOT NULL ,
  `firstname` VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `doublure` (
  `id_doublure` INT(10) UNSIGNED NOT NULL,

  `nom` VARCHAR(50) NOT NULL ,
  `prix_d` FLOAT(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `fournisseur` (
  `id_fourniss` INT(10) UNSIGNED NOT NULL,
  `id_city` INT(10) UNSIGNED NOT NULL ,

  `name_f` VARCHAR(100) NOT NULL ,
  `adresse_f` VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `images_product` (
  `id_products` INT(10) UNSIGNED NOT NULL,

  `name_imgPr` VARCHAR(100) DEFAULT NULL,
  `type_imgPr` VARCHAR(5) DEFAULT NULL,
  `src_imgPr` VARCHAR(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE images_tissus (
  `id_rideaux` INT(10) UNSIGNED NOT NULL,

  `name_imgT` VARCHAR(100) DEFAULT NULL,
  `type_imgT` VARCHAR(5) DEFAULT NULL,
  `src_imgT` VARCHAR(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE image_voilages (
  `id_voilages` INT(10) UNSIGNED NOT NULL,

  `name_imgT` VARCHAR(100) DEFAULT NULL,
  `type_imgT` VARCHAR(5) DEFAULT NULL,
  `src_imgT` VARCHAR(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `listorder` (
  `id_order` INT(10) UNSIGNED NOT NULL,

  `liste des produits` TEXT CHARACTER SET utf8
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `order` (
  `id_order` INT(10) UNSIGNED NOT NULL,

  `name_order` VARCHAR(100) DEFAULT NULL,
  `email` VARCHAR(200) DEFAULT NULL,
  `total` FLOAT(10,2) DEFAULT NULL,
  `src_commande` VARCHAR(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `order_items` (
  `id_order` INT(10) UNSIGNED NOT NULL,
  `id_products` INT(10) UNSIGNED NOT NULL,

  `nitems` INT(11) DEFAULT NULL,
  `totalItems` FLOAT(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `priceaccesso` (
  `id_products` INT(10) UNSIGNED NOT NULL,

  `prFournisseur` FLOAT(10,2) DEFAULT NULL,
  `prPondere` FLOAT(10,2) DEFAULT NULL,
  `coeff` FLOAT(10,2) DEFAULT NULL,
  `margeMonetaire` FLOAT(10,2) DEFAULT NULL,
  `prTotalAccess` FLOAT(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `products` (
  `id_products` INT(10) UNSIGNED NOT NULL,
  `id_fourniss` INT(10) UNSIGNED NOT NULL ,

  `ref` VARCHAR(100) DEFAULT NULL,
  `name_product` VARCHAR(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `rideaux` (
  `id_rideaux` INT(10) UNSIGNED NOT NULL,

  `catTissu` VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `tissus` (
  `id_typeRideaux` INT(10) UNSIGNED NOT NULL,
  `id_rideaux` INT(10) UNSIGNED NOT NULL,

  `nom_t` VARCHAR(100) DEFAULT NULL,
  `largeur` FLOAT(10,2),
  `prix_au_Metre` FLOAT(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `voilage` (
  `id_voilages` INT(10) NOT NULL,

  `catVoilage` VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- -------------------------------------------------------

CREATE TABLE typeVoilage (
  `id_typeVoilages` INT(10) UNSIGNED NOT NULL,
  `id_voilages` INT(10) UNSIGNED NOT NULL,

  `nom_v` VARCHAR(100),
  `prix_metre` FLOAT(10,2)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `typeconfection` (
  `id_typeC` INT(10) UNSIGNED NOT NULL,

  `nom_typeC` VARCHAR(150) DEFAULT NULL,
  `prix_typeC` FLOAT(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

CREATE TABLE `entretien` (
  `id_typeRideaux` INT(10) UNSIGNED,
  `id_typeVoilages` INT(10) UNSIGNED,

  `lavage` ENUM('95', '60', '60M', '40', '40M', '40TresM', '30', '30M', '30TresM', 'Main', 'PasLavage'),
  `blanchiment` ENUM('TousTypes', 'Oxygenes', 'PasBlanchiment'),
  `sechage` ENUM('T80', 'T60', 'PasTambour', 'Fil', 'FilSansEsso', 'Plat', 'PlatSansEsso', 'FilOmbre', 'FilSansEssoOmbre', 'PlatOmbre', 'PlatSansEssoOmbre'),
  `repassage` ENUM('S200', 'S150', 'S110', 'PasRepassage'),
  `entretienPro` ENUM('SecNormal', 'SecModere', 'PasdeSec', 'EauNormal', 'EauModere', 'EauTresModere', 'Pasdeau')
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

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


-- ===================================================================
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
  ADD KEY `id_rideaux` (`id_rideaux`);

ALTER TABLE `image_voilages`
  ADD KEY `id_voilages` (`id_voilages`);

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

ALTER TABLE `entretien`
  ADD KEY `id_typeRideaux` (`id_typeRideaux`),
  ADD KEY `id_typeVoilages` (`id_typeVoilages`);

ALTER TABLE `typeconfection`
  ADD PRIMARY KEY (`id_typeC`);

ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  MODIFY `id_user` INT(10) UNSIGNED AUTO_INCREMENT,
  ADD KEY `id_city` (`id_city`);


-- ===================================================================
-- FOREIGN KEYS

ALTER TABLE `fournisseur`
  ADD CONSTRAINT `city_fourn_fk` FOREIGN KEY (`id_city`) REFERENCES `city`(`id_city`);

ALTER TABLE `images_product`
  ADD CONSTRAINT `images_product_fk` FOREIGN KEY (`id_products`) REFERENCES `products` (`id_products`);

ALTER TABLE `images_tissus`
  ADD CONSTRAINT `image_rideaux_fk` FOREIGN KEY (`id_rideaux`) REFERENCES `rideaux` (`id_rideaux`);

ALTER TABLE `image_voilages`
  ADD CONSTRAINT `image_voilages_fk` FOREIGN KEY (`id_voilages`) REFERENCES `voilage` (`id_voilages`);

ALTER TABLE `order_items`
  ADD CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`),
  ADD CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`id_products`) REFERENCES `products` (`id_products`);

ALTER TABLE `products`
  ADD CONSTRAINT `fourniss_prod_fk_` FOREIGN KEY (`id_fourniss`) REFERENCES `fournisseur`(`id_fourniss`);

ALTER TABLE `priceaccesso`
  ADD CONSTRAINT `priceAccesso_fk` FOREIGN KEY (`id_products`) REFERENCES `products` (`id_products`);

ALTER TABLE `tissus`
  ADD CONSTRAINT `tissu_fk` FOREIGN KEY (`id_rideaux`) REFERENCES `rideaux` (`id_rideaux`);

ALTER TABLE `typeVoilage`
  ADD CONSTRAINT `voilage_fk` FOREIGN KEY (`id_voilages`) REFERENCES `voilage` (`id_voilages`);

ALTER TABLE `entretien`
  ADD CONSTRAINT `entretien_rid_fk` FOREIGN KEY (`id_typeRideaux`) REFERENCES tissus(`id_typeRideaux`),
  ADD CONSTRAINT `entretien_voil_fk` FOREIGN KEY (`id_typeVoilages`) REFERENCES typeVoilage(`id_typeVoilages`);

ALTER TABLE `user`
  ADD CONSTRAINT `user_fk` FOREIGN KEY (`id_city`) REFERENCES `city` (`id_city`);


-- ===================================================================
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


-- ===================================================================
-- PROCEDURES

DELIMITER //
-- Vérification

CREATE PROCEDURE `checkExistsCity` (`cit` VARCHAR(100), `cpCit` VARCHAR(5))
  BEGIN
    SELECT count(*) FROM city WHERE city = cit AND cp = cpCit;
  END //

-- Récupération

CREATE PROCEDURE `getCity` (`cit` VARCHAR(100), `cpCit` VARCHAR(5))
  BEGIN
    SELECT id_city FROM city WHERE city = cit AND cp = cpCit;
  END //

-- Rideaux

CREATE PROCEDURE `getCatCurtains` ()
  BEGIN
    SELECT id_rideaux, catTissu FROM rideaux;
  END //

-- Personnes

CREATE PROCEDURE `getProviders` ()
  BEGIN
    SELECT name_f, adresse_f FROM fournisseur;
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
    WHERE P.id_products = A.id_products AND Pr.id_products = P.id_products AND P.id_products = idproducts LIMIT 1;
  END //

CREATE PROCEDURE `getProducts` ()
  BEGIN
    SELECT P.id_products, A.id_products, name_product, prTotalAccess, description FROM products P, accessories A, priceaccesso Pr
    WHERE P.id_products = A.id_products AND Pr.id_products = P.id_products ORDER BY name_product ASC;
  END //

CREATE PROCEDURE `getCurtains`(idrid INT)
  BEGIN
    SELECT nom_t, largeur, prix_au_Metre FROM tissus WHERE id_rideaux = idrid;
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

    INSERT INTO company(company, type_comp, lastname_contact, firstname_contact, id_user) VALUES (companyCO, type_compCO, lastname_contactCO, firstname_contactCO, iduser);
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

    INSERT INTO user(id_city, gender, email, password, address, phone, type) VALUES (idcity, gend, emailU, passwordU, addressU, phoneU, typeU);

  END //


-- Mise à jour

CREATE PROCEDURE `updateConnexion` (`emailC` VARCHAR(255), `passwordC` VARCHAR(255), `iduser` INT)
  BEGIN
    UPDATE user SET email = emailC, password = passwordC WHERE id_user = iduser;
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

    UPDATE accessories A SET A.description = descriptionP  WHERE A.id_products = (SELECT P.id_products FROM products P WHERE P.id_products = idproducts);
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

      UPDATE user SET address = addressCO, phone = phoneCO, id_city = idcity WHERE id_user = iduser;
    ELSE
      SELECT DISTINCT(CIT.id_city) INTO idcity FROM city CIT WHERE CIT.city = cityCO AND CIT.cp = cpCO;

      UPDATE user U SET U.address = addressCO, U.phone = phoneCO, U.id_city = idcity WHERE U.id_user = iduser;

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

      UPDATE user SET address = addressCUST, phone = phoneCUST, id_city = idcity WHERE id_user = iduser;
    ELSE
      SELECT DISTINCT(CIT.id_city) INTO idcity FROM city CIT WHERE CIT.city = cityCUST AND CIT.cp = cpCUST;

      UPDATE user U SET U.address = addressCUST, U.phone = phoneCUST, U.id_city = idcity WHERE U.id_user = iduser;

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
    WHERE U.id_user = CUS.id_user AND U.id_city = CIT.id_city AND U.id_user = iduser;
  END //

DELIMITER ;

-- ==================================================================
-- FONCTIONS

-- ===================================================================
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
  (1, 3,NULL, 'Produit N°1'),
  (2, 4,NULL, 'Produit n°2'),
  (3, 2,NULL, 'Produit n°3'),
  (4, 1,NULL, 'Produit n°4'),
  (5, 1,NULL, 'Produit n°5');

INSERT INTO `accessories` (`id_products`, `description`, `stock`) VALUES
  (1, 'Description 1', NULL),
  (2, 'Description 2', NULL),
  (3, 'Description 3', NULL),
  (4, 'Description 4', NULL),
  (5, 'Description 5', NULL);

CALL InsertPriceAcc(1, 25, 20);
CALL InsertPriceAcc(2, 5.5, 15.5);
CALL InsertPriceAcc(3, 1.99, 6.75);
CALL InsertPriceAcc(4, 35.24, 10);
CALL InsertPriceAcc(5, 75.40, 22.6);

INSERT INTO rideaux (catTissu) VALUES
  ('Tissu Uni'),
  ('Tissu à motif');

INSERT INTO tissus (id_typeRideaux, id_rideaux, nom_t, largeur, prix_au_Metre) VALUES
  (1, 1, 'Bleu', 180, 25.20),
  (2, 1, 'Gris', 200, 33.45),
  (3, 1, 'Rouge', 150, 15.87),
  (4, 1, 'Violet', 220, 42.10),
  (5, 2, 'Cerises', 250, 67),
  (6, 2, 'Gouttes', 190, 52.70),
  (7, 2, 'Pétales', 220, 63.48),
  (8, 2, 'Vagues', 200, 58);

INSERT INTO `typeconfection` (`id_typeC`, `nom_typeC`, `prix_typeC`) VALUES
  (1, 'Tête Flamande', NULL),
  (2, 'Tête Oeillets', NULL);

INSERT INTO `doublure` (`id_doublure`, `nom`, `prix_d`) VALUES
  (1, 'Satinette', 10.2),
  (2, 'Ocultant', 5);


COMMIT;