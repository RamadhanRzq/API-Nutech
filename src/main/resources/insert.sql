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
   BANNER_IMAGE     VARCHAR(150),
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

DROP TABLE IF EXISTS table_service;
CREATE TABLE table_service (
   ID               INT(11) NOT NULL AUTO_INCREMENT,
   SERVICE_CODE      VARCHAR(150) NOT NULL,
   SERVICE_NAME      VARCHAR(150),
   SERVICE_ICON      VARCHAR(150),
   SERVICE_TARIFF      INT(11) NOT NULL,
   CONSTRAINT PK_SERVICE PRIMARY KEY (ID)
);
INSERT INTO table_service (SERVICE_CODE, SERVICE_NAME, SERVICE_ICON, SERVICE_TARIFF) VALUES
('PAJAK', 'Pajak PBB', 'https://nutech-integrasi.app/dummy.jpg', 40000),
('PLN', 'Listrik', 'https://nutech-integrasi.app/dummy.jpg', 10000),
('PDAM', 'PDAM Berlangganan', 'https://nutech-integrasi.app/dummy.jpg', 40000),
('PULSA', 'Pulsa', 'https://nutech-integrasi.app/dummy.jpg', 40000),
('PGN', 'PGN Berlangganan', 'https://nutech-integrasi.app/dummy.jpg', 50000),
('MUSIK', 'Musik Berlangganan', 'https://nutech-integrasi.app/dummy.jpg', 50000),
('TV', 'TV Berlangganan', 'https://nutech-integrasi.app/dummy.jpg', 50000),
('PAKET_DATA', 'Paket data', 'https://nutech-integrasi.app/dummy.jpg', 50000),
('VOUCHER_GAME', 'Voucher Game', 'https://nutech-integrasi.app/dummy.jpg', 100000),
('VOUCHER_MAKANAN', 'Voucher Makanan', 'https://nutech-integrasi.app/dummy.jpg', 100000),
('QURBAN', 'Qurban', 'https://nutech-integrasi.app/dummy.jpg', 200000),
('ZAKAT', 'Zakat', 'https://nutech-integrasi.app/dummy.jpg', 300000);
