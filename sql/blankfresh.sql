CREATE DATABASE  IF NOT EXISTS `beatifydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `beatifydb`;
-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: localhost    Database: beatifydb
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `album` (
  `album_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date_created` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `artist_id` int(11) NOT NULL,
  `album_cover` mediumblob,
  PRIMARY KEY (`album_id`),
  UNIQUE KEY `album_id_UNIQUE` (`album_id`),
  KEY `artistIDAlbum_idx` (`artist_id`),
  CONSTRAINT `artistIDAlbum` FOREIGN KEY (`artist_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `album_contents`
--

DROP TABLE IF EXISTS `album_contents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `album_contents` (
  `album_id` int(11) NOT NULL,
  `song_id` int(11) NOT NULL,
  PRIMARY KEY (`album_id`,`song_id`),
  KEY `songIDOfAlbum_idx` (`song_id`),
  CONSTRAINT `albumIDMapping` FOREIGN KEY (`album_id`) REFERENCES `album` (`album_id`) ON DELETE CASCADE,
  CONSTRAINT `songIDOfAlbum` FOREIGN KEY (`song_id`) REFERENCES `song` (`song_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album_contents`
--

LOCK TABLES `album_contents` WRITE;
/*!40000 ALTER TABLE `album_contents` DISABLE KEYS */;
/*!40000 ALTER TABLE `album_contents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `followed_album`
--

DROP TABLE IF EXISTS `followed_album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `followed_album` (
  `album_id` int(11) NOT NULL,
  `follower_id` int(11) NOT NULL,
  PRIMARY KEY (`album_id`,`follower_id`),
  KEY `followerIDAlbum_idx` (`follower_id`),
  CONSTRAINT `albumIDFollowed` FOREIGN KEY (`album_id`) REFERENCES `album` (`album_id`) ON DELETE CASCADE,
  CONSTRAINT `followerIDAlbum` FOREIGN KEY (`follower_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `followed_album`
--

LOCK TABLES `followed_album` WRITE;
/*!40000 ALTER TABLE `followed_album` DISABLE KEYS */;
/*!40000 ALTER TABLE `followed_album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `followed_playlist`
--

DROP TABLE IF EXISTS `followed_playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `followed_playlist` (
  `playlist_id` int(11) NOT NULL,
  `follower_id` int(11) NOT NULL,
  PRIMARY KEY (`playlist_id`,`follower_id`),
  KEY `followerIDPlaylist_idx` (`follower_id`),
  CONSTRAINT `followerIDPlaylist` FOREIGN KEY (`follower_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `playlistIDFollowed` FOREIGN KEY (`playlist_id`) REFERENCES `playlist` (`playlist_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `followed_playlist`
--

LOCK TABLES `followed_playlist` WRITE;
/*!40000 ALTER TABLE `followed_playlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `followed_playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follower_mapping`
--

DROP TABLE IF EXISTS `follower_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `follower_mapping` (
  `user_id` int(11) NOT NULL,
  `follower_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`follower_id`),
  KEY `followerID_idx` (`follower_id`),
  CONSTRAINT `userIDFollowed` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follower_mapping`
--

LOCK TABLES `follower_mapping` WRITE;
/*!40000 ALTER TABLE `follower_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `follower_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `liked_mapping`
--

DROP TABLE IF EXISTS `liked_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `liked_mapping` (
  `user_id` int(11) NOT NULL,
  `song_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`song_id`),
  KEY `songIDLiked_idx` (`song_id`),
  CONSTRAINT `songIDLiked` FOREIGN KEY (`song_id`) REFERENCES `song` (`song_id`) ON DELETE CASCADE,
  CONSTRAINT `userLikedMapping` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liked_mapping`
--

LOCK TABLES `liked_mapping` WRITE;
/*!40000 ALTER TABLE `liked_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `liked_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notif_mapping`
--

DROP TABLE IF EXISTS `notif_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `notif_mapping` (
  `notif_id` int(11) NOT NULL,
  `follower_id` int(11) NOT NULL,
  `is_viewed` int(1) DEFAULT NULL,
  PRIMARY KEY (`notif_id`,`follower_id`),
  KEY `followerIDNotif_idx` (`follower_id`),
  CONSTRAINT `followerIDNotif` FOREIGN KEY (`follower_id`) REFERENCES `follower_mapping` (`follower_id`) ON DELETE CASCADE,
  CONSTRAINT `notifIDMapping` FOREIGN KEY (`notif_id`) REFERENCES `notification` (`notif_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notif_mapping`
--

LOCK TABLES `notif_mapping` WRITE;
/*!40000 ALTER TABLE `notif_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `notif_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `notification` (
  `notif_id` int(11) NOT NULL AUTO_INCREMENT,
  `notification` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `date_created` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`notif_id`),
  KEY `notifByUserID_idx` (`user_id`),
  CONSTRAINT `notifByUserID` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `playlist` (
  `playlist_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_public` int(1) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`playlist_id`),
  UNIQUE KEY `playlist_id_UNIQUE` (`playlist_id`),
  KEY `playlist_owner_idx` (`user_id`),
  CONSTRAINT `playlist_owner` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist_contents`
--

DROP TABLE IF EXISTS `playlist_contents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `playlist_contents` (
  `playlist_id` int(11) NOT NULL,
  `song_id` int(11) NOT NULL,
  PRIMARY KEY (`playlist_id`,`song_id`),
  KEY `songIDOfPlaylist_idx` (`song_id`),
  CONSTRAINT `playlistIDMapping` FOREIGN KEY (`playlist_id`) REFERENCES `playlist` (`playlist_id`) ON DELETE CASCADE,
  CONSTRAINT `songIDOfPlaylist` FOREIGN KEY (`song_id`) REFERENCES `song` (`song_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist_contents`
--

LOCK TABLES `playlist_contents` WRITE;
/*!40000 ALTER TABLE `playlist_contents` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlist_contents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `song` (
  `song_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `genre` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date_uploaded` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `artist_id` int(11) NOT NULL,
  `file` mediumblob NOT NULL,
  PRIMARY KEY (`song_id`),
  UNIQUE KEY `song_id_UNIQUE` (`song_id`),
  KEY `artistIdSong_idx` (`artist_id`),
  CONSTRAINT `artistIdSong` FOREIGN KEY (`artist_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_artist` int(1) NOT NULL,
  `avatar` mediumblob,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-10 13:57:09
