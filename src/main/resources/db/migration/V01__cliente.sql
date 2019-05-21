CREATE TABLE `tb_cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `empregado` bit(1) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `renda` double NOT NULL,
  `risco` varchar(1) NOT NULL,
  `tipo_cadastro` varchar(1) NOT NULL,
  `valor_divida` double DEFAULT NULL,
  `valor_patrimonio` double DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
