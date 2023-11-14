DROP TABLE IF EXISTS table_user;
CREATE TABLE table_user (
   ID             INT(11) NOT NULL AUTO_INCREMENT,
   EMAIL          VARCHAR(100) NOT NULL,
   PASSWORD       VARCHAR(100) NOT NULL,
   FIRSTNAME      VARCHAR(50),
   LASTNAME       VARCHAR(50),
   PROFILE_IMAGE  VARCHAR(100),
   CONSTRAINT PK_USER PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS table_banner;
CREATE TABLE table_banner (
   ID               INT(11) NOT NULL AUTO_INCREMENT,
   BANNER_NAME      VARCHAR(150) NOT NULL,
   BANNER_IMAGE     VARCHAR(150) NOT NULL,
   DESCRIPTION      VARCHAR(200),
   CONSTRAINT PK_BANNER PRIMARY KEY (ID)
);

INSERT INTO table_banner (BANNER_NAME, BANNER_IMAGE, DESCRIPTION) VALUES
('Banner 1', 'https://nutech-integrasi.app/dummy.jpg', 'Lerem Ipsum Dolor sit amet'),
('Banner 2', 'https://nutech-integrasi.app/dummy.jpg', 'Lerem Ipsum Dolor sit amet'),
('Banner 3', 'https://nutech-integrasi.app/dummy.jpg', 'Lerem Ipsum Dolor sit amet'),
('Banner 4', 'https://nutech-integrasi.app/dummy.jpg', 'Lerem Ipsum Dolor sit amet'),
('Banner 5', 'https://nutech-integrasi.app/dummy.jpg', 'Lerem Ipsum Dolor sit amet'),
('Banner 6', 'https://nutech-integrasi.app/dummy.jpg', 'Lerem Ipsum Dolor sit amet');
