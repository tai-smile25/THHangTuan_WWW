CREATE DATABASE IF NOT EXISTS `quanlydienthoai` ;
USE `quanlydienthoai`;

CREATE TABLE IF NOT EXISTS `dienthoai` (
  `maDT` int(11) NOT NULL AUTO_INCREMENT,
  `tenDT` varchar(50) DEFAULT NULL,
  `namSanXuat` int(11) DEFAULT NULL,
  `cauHinh` varchar(50) DEFAULT NULL,
  `maNCC` int(11) DEFAULT NULL,
  `hinhAnh` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`maDT`),
  KEY `FK_dienthoai_nhacungcap` (`maNCC`),
  CONSTRAINT `FK_dienthoai_nhacungcap` FOREIGN KEY (`maNCC`) REFERENCES `nhacungcap` (`maNCC`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `dienthoai` (`maDT`, `tenDT`, `namSanXuat`, `cauHinh`, `maNCC`, `hinhAnh`) VALUES
	(3, 'NokiaLumia', 2023, 'V', 1, 'nokialumia.jpeg'),
	(5, 'HTC', 2023, 'V', 1, 'HTC.jpeg'),
	(6, 'Nokia', 2002, 'A', 1, 'nokialumia.jpeg');

CREATE TABLE IF NOT EXISTS `nhacungcap` (
  `maNCC` int(11) NOT NULL AUTO_INCREMENT,
  `tenNhaCC` varchar(50) NOT NULL DEFAULT '',
  `diaChi` varchar(50) NOT NULL DEFAULT '',
  `soDienThoai` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`maNCC`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `nhacungcap` (`maNCC`, `tenNhaCC`, `diaChi`, `soDienThoai`) VALUES
	(1, 'Nhà cung cấp a', 'A', '03768495720'),
	(2, 'Nhà cung cấp B', 'B', '03967581232');
