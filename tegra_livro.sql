CREATE DATABASE  IF NOT EXISTS `tegra` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tegra`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: tegra
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `livro`
--

DROP TABLE IF EXISTS `livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livro` (
  `idLivro` int DEFAULT NULL,
  `titulo` text,
  `autor` text,
  `valor` decimal(8,2) DEFAULT NULL,
  `qtdeEstoque` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livro`
--

LOCK TABLES `livro` WRITE;
/*!40000 ALTER TABLE `livro` DISABLE KEYS */;
INSERT INTO `livro` VALUES (1,'O Programador Pragmático: De Aprendiz a Mestre','Andrew Hunt, David Thomas',125.50,50),(2,'The Mythical Man-Month: Essays on Software Engineering','Frederick P. Brooks Jr.',170.19,32),(3,'Expressões Regulares - Uma Abordagem Divertida	','Aurelio Marinho Jargas	',47.20,10),(4,'Domain-Driven Design: Tackling Complexity in the Heart of Software	','Eric Evans	',251.14,32),(5,'Padrões de Arquitetura de Aplicações Corporativas	','Martin Fowler	',101.59,25),(6,'The Design of Design: Essays from a Computer Scientist	','Frederick P. Jr. Brooks	',161.75,5),(7,'Shell Script Profissional	','Aurelio Marinho Jargas	',62.35,37),(8,'NoSQL Essencial: Um Guia Conciso para o Mundo Emergente da Persistência Poliglota	','Pramod J. Sadalage, Martin Fowler	',52.00,19),(9,'Refactoring: Improving the Design of Existing Code	','Martin Fowler	',220.63,43),(10,'Clean Architecture: A Craftsman\'s Guide to Software Structure and Design	','Robert C. Martin	',148.61,1),(11,'Clean Code: A Handbook of Agile Software Craftsmanship	','Robert C. Martin	',180.04,16),(12,'Clean Agile: Back to Basics	','Robert C. Martin	',174.20,29),(13,'Building Microservices: Designing Fine-Grained Systems	','Sam Newman	',209.30,6),(14,'Designing Data-Intensive Applications: The Big Ideas Behind Reliable, Scalable, and Maintainable Systems	','Martin Kleppmann	',82.99,37);
/*!40000 ALTER TABLE `livro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-28 20:51:25
