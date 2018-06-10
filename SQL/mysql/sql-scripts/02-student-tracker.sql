drop database `hb_student_tracker`;
CREATE DATABASE  IF NOT EXISTS `hb_student_tracker`;
USE `hb_student_tracker`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) not null AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO student (first_name,last_name,email) values 
("Minh","Le","lnminh58@gmail.com");

delete from student where id =3;

select * from student where email lile 'luv2code.com';

Alter table hb_student_tracker.student auto_increment=3000;
truncate hb_student_tracker.student;
