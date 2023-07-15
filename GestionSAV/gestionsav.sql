-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  sam. 15 juil. 2023 à 21:24
-- Version du serveur :  10.1.38-MariaDB
-- Version de PHP :  7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestionsav`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `Id_Cli` int(11) NOT NULL,
  `Nom_Cli` varchar(50) NOT NULL,
  `Prenom_Cli` varchar(50) NOT NULL,
  `Email_Cli` varchar(100) NOT NULL,
  `Tel_Cli` varchar(10) NOT NULL,
  `Adrs_Cli` varchar(100) NOT NULL,
  `NumFact_Cli` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`Id_Cli`, `Nom_Cli`, `Prenom_Cli`, `Email_Cli`, `Tel_Cli`, `Adrs_Cli`, `NumFact_Cli`) VALUES
(1, 'RAKOTO', 'Malala', 'scbsjd', 'dfdf', 'dfdf', 'dfdf'),
(2, 'LOLO', 'LOLA', 'JJJ', 'KKK', 'KK', '56');

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

CREATE TABLE `demande` (
  `Num_Dmd` varchar(10) NOT NULL,
  `Id_Cli` int(11) NOT NULL,
  `Cause_Dmd` varchar(200) NOT NULL,
  `Date_Dmd` varchar(20) NOT NULL,
  `Delais_Dmd` varchar(20) NOT NULL,
  `Statut_Dmd` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `demande`
--

INSERT INTO `demande` (`Num_Dmd`, `Id_Cli`, `Cause_Dmd`, `Date_Dmd`, `Delais_Dmd`, `Statut_Dmd`) VALUES
('d1', 2, 'AA', 'BB', 'BB', 'Résolue');

-- --------------------------------------------------------

--
-- Structure de la table `intervention`
--

CREATE TABLE `intervention` (
  `Id_Inter` int(11) NOT NULL,
  `Ref_Pro` varchar(10) NOT NULL,
  `Id_Tech` int(11) NOT NULL,
  `Date_Inter` varchar(20) NOT NULL,
  `DateFin_Inter` varchar(20) NOT NULL,
  `Type_Inter` varchar(20) NOT NULL,
  `Cout_Inter` varchar(10) NOT NULL,
  `Statut_Inter` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `intervention`
--

INSERT INTO `intervention` (`Id_Inter`, `Ref_Pro`, `Id_Tech`, `Date_Inter`, `DateFin_Inter`, `Type_Inter`, `Cout_Inter`, `Statut_Inter`) VALUES
(3, 'R1', 1, 'DD', 'DD', 'DD', 'DD', 'Terminé');

-- --------------------------------------------------------

--
-- Structure de la table `mail`
--

CREATE TABLE `mail` (
  `Id_Mail` int(11) NOT NULL,
  `Num_Dmd` varchar(10) NOT NULL,
  `Dest_Mail` varchar(30) NOT NULL,
  `Objet_Mail` varchar(20) NOT NULL,
  `mess_Mail` varchar(255) NOT NULL,
  `Date_Mail` varchar(10) NOT NULL,
  `Statut_Mail` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `Ref_Pro` varchar(10) NOT NULL,
  `Num_Dmd` varchar(10) NOT NULL,
  `Nom_Pro` varchar(50) NOT NULL,
  `Desc_Pro` varchar(50) NOT NULL,
  `Gar_Pro` varchar(50) NOT NULL,
  `Prix_Pro` varchar(10) NOT NULL,
  `Photo_Pro` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`Ref_Pro`, `Num_Dmd`, `Nom_Pro`, `Desc_Pro`, `Gar_Pro`, `Prix_Pro`, `Photo_Pro`) VALUES
('R1', 'd1', 'AA', 'AA', 'AA', 'AA', 'C:\\Users\\ACER\\Pictures\\foreach.png');

-- --------------------------------------------------------

--
-- Structure de la table `remise`
--

CREATE TABLE `remise` (
  `Id_Rem` int(11) NOT NULL,
  `Id_Res` int(11) NOT NULL,
  `Num_Dmd` varchar(10) NOT NULL,
  `Date_Rem` varchar(20) NOT NULL,
  `Desc_Rem` varchar(200) NOT NULL,
  `Pro_Rem` varchar(100) NOT NULL,
  `Ref_Rem` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `remise`
--

INSERT INTO `remise` (`Id_Rem`, `Id_Res`, `Num_Dmd`, `Date_Rem`, `Desc_Rem`, `Pro_Rem`, `Ref_Rem`) VALUES
(2, 1, 'd1', 'kk', 'kkll', 'kkpp', 'kok');

-- --------------------------------------------------------

--
-- Structure de la table `responsable`
--

CREATE TABLE `responsable` (
  `Id_Res` int(11) NOT NULL,
  `Nom_Res` varchar(100) NOT NULL,
  `Prenom_Res` varchar(100) NOT NULL,
  `Adrs_Res` varchar(255) NOT NULL,
  `Email_Res` varchar(100) NOT NULL,
  `Mdp_Res` varchar(8) NOT NULL,
  `Tel_Res` varchar(10) NOT NULL,
  `Type_Res` varchar(10) NOT NULL,
  `Code_Res` varchar(16) NOT NULL,
  `Photo_Res` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `responsable`
--

INSERT INTO `responsable` (`Id_Res`, `Nom_Res`, `Prenom_Res`, `Adrs_Res`, `Email_Res`, `Mdp_Res`, `Tel_Res`, `Type_Res`, `Code_Res`, `Photo_Res`) VALUES
(1, 'RAKOTOMALALA', 'Solohery Alain', 'Imandry', 'rakotomalalasoloheryalain@gmail.com', 'admin123', '0346697437', 'Principale', 'azertyuiopqsdfgh', 'E:\\s6\\Pictures\\facebook\\FB_IMG_16153987061814329.jpg'),
(3, 'RAZAFY', 'Ravelo', 'Ihosy', 'ff@gmail.com', 'azerty', '0345678900', 'Secondaire', 'azerty', 'E:\\Dossier\\HEI\\Récente 1.png'),
(4, 'SDSDSD', 'XCXC', 'XXDFDF', 'DFDF', 'DFDFDF', 'DFDF', 'Secondaire', 'DBDBDB', 'E:\\Dossier\\HEI\\Récente 2.JPG');

-- --------------------------------------------------------

--
-- Structure de la table `technicien`
--

CREATE TABLE `technicien` (
  `Id_Tech` int(11) NOT NULL,
  `Nom_Tech` varchar(50) NOT NULL,
  `Prenom_Tech` varchar(50) NOT NULL,
  `Adrs_Tech` varchar(100) NOT NULL,
  `Email_Tech` varchar(100) NOT NULL,
  `Tel_Tech` varchar(10) NOT NULL,
  `Photo_Tech` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `technicien`
--

INSERT INTO `technicien` (`Id_Tech`, `Nom_Tech`, `Prenom_Tech`, `Adrs_Tech`, `Email_Tech`, `Tel_Tech`, `Photo_Tech`) VALUES
(1, 'KKDNSD', 'CXCX', 'XCXC', 'XCXC', 'XCXC', 'C:\\Users\\ACER\\Pictures\\foreach.png');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`Id_Cli`);

--
-- Index pour la table `demande`
--
ALTER TABLE `demande`
  ADD PRIMARY KEY (`Num_Dmd`),
  ADD KEY `Id_Cli` (`Id_Cli`);

--
-- Index pour la table `intervention`
--
ALTER TABLE `intervention`
  ADD PRIMARY KEY (`Id_Inter`),
  ADD KEY `Ref_Pro` (`Ref_Pro`,`Id_Tech`),
  ADD KEY `Id_Tech` (`Id_Tech`);

--
-- Index pour la table `mail`
--
ALTER TABLE `mail`
  ADD PRIMARY KEY (`Id_Mail`),
  ADD KEY `Num_Dmd` (`Num_Dmd`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`Ref_Pro`),
  ADD KEY `Num_Dmd` (`Num_Dmd`);

--
-- Index pour la table `remise`
--
ALTER TABLE `remise`
  ADD PRIMARY KEY (`Id_Rem`),
  ADD KEY `Num_Dmd` (`Num_Dmd`),
  ADD KEY `Id_Res` (`Id_Res`);

--
-- Index pour la table `responsable`
--
ALTER TABLE `responsable`
  ADD PRIMARY KEY (`Id_Res`);

--
-- Index pour la table `technicien`
--
ALTER TABLE `technicien`
  ADD PRIMARY KEY (`Id_Tech`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `Id_Cli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `intervention`
--
ALTER TABLE `intervention`
  MODIFY `Id_Inter` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `mail`
--
ALTER TABLE `mail`
  MODIFY `Id_Mail` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `remise`
--
ALTER TABLE `remise`
  MODIFY `Id_Rem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `responsable`
--
ALTER TABLE `responsable`
  MODIFY `Id_Res` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `technicien`
--
ALTER TABLE `technicien`
  MODIFY `Id_Tech` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `demande`
--
ALTER TABLE `demande`
  ADD CONSTRAINT `demande_ibfk_1` FOREIGN KEY (`Id_Cli`) REFERENCES `client` (`Id_Cli`);

--
-- Contraintes pour la table `intervention`
--
ALTER TABLE `intervention`
  ADD CONSTRAINT `intervention_ibfk_1` FOREIGN KEY (`Id_Tech`) REFERENCES `technicien` (`Id_Tech`),
  ADD CONSTRAINT `intervention_ibfk_2` FOREIGN KEY (`Ref_Pro`) REFERENCES `produit` (`Ref_Pro`);

--
-- Contraintes pour la table `mail`
--
ALTER TABLE `mail`
  ADD CONSTRAINT `mail_ibfk_1` FOREIGN KEY (`Num_Dmd`) REFERENCES `demande` (`Num_Dmd`);

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `produit_ibfk_1` FOREIGN KEY (`Num_Dmd`) REFERENCES `demande` (`Num_Dmd`);

--
-- Contraintes pour la table `remise`
--
ALTER TABLE `remise`
  ADD CONSTRAINT `remise_ibfk_1` FOREIGN KEY (`Num_Dmd`) REFERENCES `demande` (`Num_Dmd`),
  ADD CONSTRAINT `remise_ibfk_2` FOREIGN KEY (`Id_Res`) REFERENCES `responsable` (`Id_Res`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
