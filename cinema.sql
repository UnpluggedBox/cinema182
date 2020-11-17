-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 04, 2019 at 10:10 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cinema`
--

-- --------------------------------------------------------

--
-- Table structure for table `films`
--

CREATE TABLE `films` (
  `filmid` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `duration` varchar(3) NOT NULL,
  `releasedate` date NOT NULL,
  `filmimageloc` varchar(1000) NOT NULL,
  `trailerurl` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `films`
--

INSERT INTO `films` (`filmid`, `title`, `description`, `duration`, `releasedate`, `filmimageloc`, `trailerurl`) VALUES
(1, 'Joker', 'Forever alone in a crowd, failed comedian Arthur Fleck seeks connection as he walks the streets of Gotham City. Arthur wears two masks -- the one he paints for his day job as a clown, and the guise he projects in a futile attempt to feel like he\'s part of the world around him. Isolated, bullied and disregarded by society, Fleck begins a slow descent into madness as he transforms into the criminal mastermind known as the Joker.', '122', '2019-10-22', '/films/JOKER.jpg', 'https://www.youtube.com/embed/zAGVQLHvwOY'),
(2, 'John Wick 3', 'After gunning down a member of the High Table -- the shadowy international assassin\'s guild -- legendary hit man John Wick finds himself stripped of the organization\'s protective services. Now stuck with a $14 million bounty on his head, Wick must fight his way through the streets of New York as he becomes the target of the world\'s most ruthless killers.', '130', '2019-05-17', '/films/JOHN3.jpg', 'https://www.youtube.com/embed/M7XM597XO94'),
(3, 'La La Land', 'Sebastian (Ryan Gosling) and Mia (Emma Stone) are drawn together by their common desire to do what they love. But as success mounts they are faced with decisions that begin to fray the fragile fabric of their love affair, and the dreams they worked so hard to maintain in each other threaten to rip them apart.', '128', '2019-11-09', '/films/LALAND.jpg', 'https://www.youtube.com/embed/0pdqf4P9MB8'),
(4, 'The Dark Knight', 'After Gordon, Dent and Batman begin an assault on Gotham\'s organised crime, the mobs hire the Joker, a psychopathic criminal mastermind, who wants to bring all the heroes down to his level.', '152', '2019-07-18', '/films/TDK.jpg', 'https://www.youtube.com/embed/EXeTwQWrcwY'),
(5, 'Baby Driver', 'Doc forces Baby, a former getaway driver, to partake in a heist, threatening to hurt his girlfriend if he refuses. The plan goes awry when their arms dealers turn out to be undercover officers.', '113', '2019-08-24', '/films/BABY.jpg', 'https://www.youtube.com/embed/z2z857RSfhk'),
(6, 'The Shawshank Redemption', 'Andy Dufresne, a successful banker, is arrested for the murders of his wife and her lover, and is sentenced to life imprisonment at the Shawshank prison. He becomes the most unconventional prisoner.', '142', '2019-09-22', '/films/SHAWSHANK.jpg', 'https://www.youtube.com/embed/6hB3S9bIaco'),
(7, 'Snatch', 'A caper involving a boxing promoter who is introduced to match fixing by a ruthless, pig-breeding gangster. Thrust into the fray are a street fighting gypsy and his family, and a vicious pitbull.', '104', '2019-08-23', '/films/SNATCH.jpg', 'https://www.youtube.com/embed/9Jar2XkBboo'),
(8, 'The Man from U.N.C.L.E', 'Napoleon Solo, a CIA agent, and Illya Kuryakin, a KGB operative, must set aside their differences and work together to thwart the plans of a criminal organization that wants to use nuclear weapons.', '116', '2019-08-26', '/films/UNCLE.png', 'https://www.youtube.com/embed/4K4Iv_N9Nno'),
(13, 'Ad Astra', 'Thirty years ago, Clifford McBride led a voyage into deep space, but the ship and crew were never heard from again. Now his son -- a fearless astronaut -- must embark on a daring mission to Neptune to uncover the truth about his missing father and a mysterious power surge that threatens the stability of the universe.', '124', '2019-09-24', '/films/ADASTRA.jpg', 'https://www.youtube.com/embed/P6AaSMfXHbA');

-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

CREATE TABLE `reservations` (
  `reservationid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `filmid` int(11) NOT NULL,
  `theatreid` int(11) NOT NULL,
  `filmtitle` varchar(1000) NOT NULL,
  `filmdate` date NOT NULL,
  `seatid` int(11) NOT NULL,
  `person` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `seats`
--

CREATE TABLE `seats` (
  `seatid` int(11) NOT NULL,
  `row` varchar(1) NOT NULL,
  `seat` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `seats`
--

INSERT INTO `seats` (`seatid`, `row`, `seat`) VALUES
(1, 'A', '1'),
(2, 'A', '2'),
(3, 'A', '3'),
(4, 'A', '4'),
(5, 'A', '5'),
(6, 'A', '6'),
(7, 'B', '1'),
(8, 'B', '2'),
(9, 'B', '3'),
(10, 'B', '4'),
(11, 'B', '5'),
(12, 'B', '6'),
(13, 'C', '1'),
(14, 'C', '2'),
(15, 'C', '3'),
(16, 'C', '4'),
(17, 'C', '5'),
(18, 'C', '6'),
(19, 'D', '1'),
(26, 'D', '2'),
(27, 'D', '3'),
(28, 'D', '4'),
(29, 'D', '5'),
(30, 'D', '6'),
(31, 'E', '1'),
(32, 'E', '2'),
(33, 'E', '3'),
(34, 'E', '4'),
(35, 'E', '5'),
(36, 'E', '6');

-- --------------------------------------------------------

--
-- Table structure for table `theatres`
--

CREATE TABLE `theatres` (
  `theatreid` int(11) NOT NULL,
  `studioname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `theatres`
--

INSERT INTO `theatres` (`theatreid`, `studioname`) VALUES
(1, 'Studio Anggrek');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userid` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `role` varchar(10) NOT NULL DEFAULT 'User'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userid`, `email`, `password`, `fname`, `lname`, `role`) VALUES
(1, 'rubin.535180123@stu.untar.ac.id', 'rubin123', 'Rubin', 'Salim', 'Admin'),
(2, 'rubin@gmail.com', 'rubin', 'Rubin', 'Salim', 'User'),
(4, 'devin@gmail.com', 'abc', 'Devin', 'Abi', 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `films`
--
ALTER TABLE `films`
  ADD PRIMARY KEY (`filmid`);

--
-- Indexes for table `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`reservationid`),
  ADD KEY `filmid` (`filmid`),
  ADD KEY `userid` (`userid`),
  ADD KEY `seatid` (`seatid`),
  ADD KEY `theatreid` (`theatreid`);

--
-- Indexes for table `seats`
--
ALTER TABLE `seats`
  ADD PRIMARY KEY (`seatid`);

--
-- Indexes for table `theatres`
--
ALTER TABLE `theatres`
  ADD PRIMARY KEY (`theatreid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `films`
--
ALTER TABLE `films`
  MODIFY `filmid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `reservations`
--
ALTER TABLE `reservations`
  MODIFY `reservationid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `seats`
--
ALTER TABLE `seats`
  MODIFY `seatid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `theatres`
--
ALTER TABLE `theatres`
  MODIFY `theatreid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `fk_filmid` FOREIGN KEY (`filmid`) REFERENCES `films` (`filmid`),
  ADD CONSTRAINT `fk_seatid` FOREIGN KEY (`seatid`) REFERENCES `seats` (`seatid`),
  ADD CONSTRAINT `fk_theatreid` FOREIGN KEY (`theatreid`) REFERENCES `theatres` (`theatreid`),
  ADD CONSTRAINT `fk_userid` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
